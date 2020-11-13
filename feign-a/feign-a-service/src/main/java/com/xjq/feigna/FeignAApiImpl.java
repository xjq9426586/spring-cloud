package com.xjq.feigna;

import com.xjq.trace.TraceThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xujunqian
 * @Date: 2020/4/29 0029 14:40
 * @Description:
 */
@Slf4j
@RestController
@Service("FeignAApi")
public class FeignAApiImpl implements FeignAApi{
    public static final TraceThreadPoolExecutor threadPool = new TraceThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));

    @Override
    public String file(@RequestPart("file") MultipartFile file, @RequestParam Map<String, Object> params) {
        log.info("文件服务接口");
        this.sendMsgBySpring();
        this.sendMsgByThreadPool();
        return "123";
    }

    @Async
    public void sendMsgBySpring() {
        log.info("send msg by spring success");
    }

    public void sendMsgByThreadPool() {
        threadPool.execute(()->log.info("send msg by thread pool success"));
    }

}
