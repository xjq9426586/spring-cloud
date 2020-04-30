package com.xjq.feigna;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: xujunqian
 * @Date: 2020/4/29 0029 14:40
 * @Description:
 */
@RestController
@Service("FeignAApi")
public class FeignAApiImpl implements FeignAApi{

    @Override
    public String file(@RequestPart("file")  MultipartFile file) {

        return "123";
    }
}
