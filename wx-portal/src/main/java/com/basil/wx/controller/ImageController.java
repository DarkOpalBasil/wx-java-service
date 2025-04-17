package com.basil.wx.controller;

import com.basil.wx.pojo.Image;
import com.basil.wx.pojo.Users;
import com.basil.wx.service.IimageService;
import com.basil.wx.service.IuserService;
import com.basil.wx.utils.AliOSSUtil;
import com.basil.wx.utils.PredictUtil;
import com.basil.wx.utils.Result;
import com.basil.wx.utils.UUIDUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private IimageService imageService;
    @Autowired
    private IuserService userService;

    // 从配置文件中获取上传文件保存到本地的目录
    @Value("${upload.dir}")
    private String uploadDir;

    // 从配置文件中获取Flask Web服务地址
    @Value("${flask.url}")
    private String flaskUrl;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("uploadType") Byte uploadType,
            @RequestParam("openId") String openId) {
        if (file.isEmpty() || uploadType != 0 && uploadType != 1 && uploadType != 2) {
            return Result.error("文件为空或未指定参数");
        }
        // 处理上传文件
        try {
            Image image = new Image();
            image.setUploadType(uploadType); // 保存上传类型信息
            image.setOpenId(openId); // 保存用户openId信息

            // 1、发送至flask Web应用识别数据
            // 使用工具类
            Map<String, Object> responseBody = PredictUtil.predict(file, flaskUrl);
            if ((Integer) responseBody.get("code") == Result.ERROR) {
                return Result.error("识别失败");
            }
            // 获取识别结果
            Integer disease = (Integer) responseBody.get("class_id");
            image.setDisease(disease);//设置识别信息（关键）
            // 额外信息
            String class_name = (String) responseBody.get("class_name");
            String probability = (String) responseBody.get("result_image_url");
            System.out.println("识别结果：" + disease + "-" + class_name + "-" + "http://localhost:5000/"+probability);

            // 2、封装Image类并保存数据库
            // 保存文件
            // 方案1、文件保存到本地
            /*File directory = new File(uploadDir);
            if (!directory.exists()) { directory.mkdirs(); }// 没有则创建目录
            String url = UUIDUtil.getUUID(file);
            File destFile = new File(directory, url);
            file.transferTo(destFile); // 保存文件到指定路径 */

            // 方案2、文件保存到OSS
            String url = AliOSSUtil.uploadFile(UUIDUtil.getUUID(file), file.getInputStream());
            String subUrl = url.substring(url.lastIndexOf('/') + 1);
            image.setImage(subUrl); // 保存文件UUID_name的路径
            // 插入数据库数据
            imageService.insert(image);
            // 返回成功结果
            return Result.ok("上传成功");
        } catch (Exception e) {
            return Result.error("上传失败: " + e.getMessage());
        }
    }

    @RequestMapping("/selectByUser")
    public Result selectByUser(@RequestBody String openId) {
        System.out.println("openId: " + openId);
        Users user = userService.login(openId);
        if (user == null) {
            return Result.error("用户信息错误，清空缓存后重试！");
        }
        return Result.ok(imageService.selectByUser(openId));
    }

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public Result selectAll() {
        return Result.ok(imageService.selectAll());
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Result deleteById(@RequestParam("id") Integer id) {
        System.out.println("id: " + id);
        imageService.deleteById(id);
        return Result.ok("删除成功");
    }

    @RequestMapping("/selectById")
    public Result selectById(Integer id) {
        return Result.ok(imageService.selectById(id));
    }

    @RequestMapping("/selectByDiseaseId")
    public Result selectByDiseaseId(Integer diseaseId) {
        return Result.ok(imageService.selectByDiseaseId(diseaseId));
    }
}
