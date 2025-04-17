package com.basil.wx.utils;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PredictUtil {
    private static final RestTemplate restTemplate = new RestTemplate();
    public static Map<String, Object> predict(MultipartFile file,String flaskUrl) {
        // 处理上传文件
        try {
            // 发送文件到 Flask 端点
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            // 构造请求
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", file.getResource());
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
            // 调用 Flask Web服务
            ResponseEntity<Map> response = restTemplate.postForEntity(flaskUrl, requestEntity, Map.class);
            Map<String, Object> responseBody = response.getBody();
            return responseBody;
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> ErrorMap = new HashMap<>();
            ErrorMap.put("code", Result.ERROR);
            return ErrorMap;
        }
    }
}
