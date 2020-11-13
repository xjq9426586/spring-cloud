package com.xjq.app.controller;

import com.xjq.feigna.FeignAApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xujunqian
 * @Date: 2020/4/29 0029 14:46
 * @Description:
 */
@Slf4j
@RestController
public class FileController {

    @Autowired
    private FeignAApi feignAApi;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/fileUpload")
    public void fileUpload(@RequestPart("file") MultipartFile file, @RequestParam Map<String, Object> params){
        log.info("调用文件服务接口");
        feignAApi.file(file, params);
    }

    @GetMapping("/getMap")
    public String getMap(@RequestParam Map<String, Object> param){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType("application/json;charset=UTF-8"));
        Object paramsJson = null;
        HttpEntity requestEntity = new HttpEntity(paramsJson, httpHeaders);
       String s = (String)restTemplate.postForObject("http://172.19.70.8:30920/tansun-tcp-app/workflowEditor/findUsersList",
                requestEntity,
                String.class, new Object[0]);
       return s;
    }
}
