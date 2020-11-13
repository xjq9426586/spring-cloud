package com.xjq.feigna;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient("feigna")
public interface FeignAApi {
    @PostMapping("/file")
    String file(@RequestPart("file") MultipartFile file, @RequestParam Map<String, Object> params);

}
