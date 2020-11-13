package com.xjq.feigna;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author: xujunqian
 * @Date: 2020/4/29 0029 14:40
 * @Description:
 */
@Slf4j
@RestController
@Service("FeignAApi")
public class FeignAApiImpl implements FeignAApi{

    @Override
    public String file(@RequestPart("file") MultipartFile file, @RequestParam Map<String, Object> params) {
        log.info("文件服务接口");
        return "123";
    }
}
