package com.xjq.app.controller;

import com.xjq.feigna.FeignAApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: xujunqian
 * @Date: 2020/4/29 0029 14:46
 * @Description:
 */
@RestController
public class FileController {

    @Autowired
    private FeignAApi feignAApi;

    @GetMapping("/fileUpload")
    public void fileUpload(@RequestParam("file") MultipartFile file){
        feignAApi.file(file);
    }
}
