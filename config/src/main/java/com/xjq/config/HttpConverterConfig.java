package com.xjq.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class HttpConverterConfig {

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        HttpMessageConverter<?> converter = createFastJsonHttpMessageConvert();
        // 5.返回HttpMessageConverters对象
        return new HttpMessageConverters(converter);
    }

    /**
     * 对http请求的返回结果进行转换，以fastjon、编码格式application/json;charset=UTF-8进行转换，转换器
     * @return
     */
    private FastJsonHttpMessageConverter createFastJsonHttpMessageConvert() {
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.QuoteFieldNames,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        MediaType jsonUtf8 = MediaType.APPLICATION_JSON_UTF8;
        List<MediaType> medias = new ArrayList<>();
        medias.add(jsonUtf8);
        fastConverter.setSupportedMediaTypes(medias);
        return fastConverter;
    }
}