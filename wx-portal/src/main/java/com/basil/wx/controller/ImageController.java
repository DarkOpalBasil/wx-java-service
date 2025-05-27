package com.basil.wx.controller;

import com.basil.wx.pojo.Image;
import com.basil.wx.pojo.Softmax;
import com.basil.wx.pojo.Users;
import com.basil.wx.service.IimageService;
import com.basil.wx.service.IsoftmaxService;
import com.basil.wx.service.IuserService;
import com.basil.wx.utils.AliOSSUtil;
import com.basil.wx.utils.PredictUtil;
import com.basil.wx.utils.Result;
import com.basil.wx.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private IimageService imageService;
    @Autowired
    private IuserService userService;
    @Autowired
    private IsoftmaxService softmaxService;

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
        System.out.println("Flask 服务地址：" + flaskUrl);
        if (file.isEmpty() || uploadType != 0 && uploadType != 1 && uploadType != 2) {
            return Result.error("文件为空或未指定参数");
        }
        if (openId == null || "".equals(openId)) {
            return Result.error("用户信息错误，请登录后重试！");
        }
        // 处理上传文件
        try {
            Image image = new Image();
            Softmax softmax = new Softmax();
            softmax.setStatus((byte) 1);
            softmax.setIsDeleted((byte) 0);
            softmax.setUpdateTime(new Date());
            softmax.setCreateTime(new Date());
            image.setUploadType(uploadType); // 保存上传类型信息
            image.setOpenId(openId); // 保存用户openId信息

            // 1、发送至flask Web应用识别数据
            // 使用工具类
            Map<String, Object> responseBody = PredictUtil.predict(file, flaskUrl);
            // 获取识别结果
            Integer disease = (Integer) responseBody.get("class_id");
            image.setDisease(disease);//设置识别信息（关键）
            softmax.setDiseases(disease);
            // 额外信息
            String class_name = (String) responseBody.get("class_name");
            String probability = (String) responseBody.get("result_image_url");
            // 取出 softmax_list
            List<?> softmaxListRaw = (List<?>) responseBody.get("softmax_list");

            // 转换为 BigDecimal 并赋值
            if (softmaxListRaw != null) {
                if (softmaxListRaw.size() > 0) softmax.setDiseases1(new BigDecimal(softmaxListRaw.get(0).toString()));
                if (softmaxListRaw.size() > 1) softmax.setDiseases2(new BigDecimal(softmaxListRaw.get(1).toString()));
                if (softmaxListRaw.size() > 2) softmax.setDiseases3(new BigDecimal(softmaxListRaw.get(2).toString()));
                if (softmaxListRaw.size() > 3) softmax.setDiseases4(new BigDecimal(softmaxListRaw.get(3).toString()));
                if (softmaxListRaw.size() > 4) softmax.setDiseases5(new BigDecimal(softmaxListRaw.get(4).toString()));
                if (softmaxListRaw.size() > 5) softmax.setDiseases6(new BigDecimal(softmaxListRaw.get(5).toString()));
                if (softmaxListRaw.size() > 6) softmax.setDiseases7(new BigDecimal(softmaxListRaw.get(6).toString()));
            }
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
            softmax.setImage(subUrl);
            // 插入数据库数据
            imageService.insert(image);
            softmaxService.insert(softmax);
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
