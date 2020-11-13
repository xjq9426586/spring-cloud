package com.xjq.app.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @Author: xujunqian
 * @Date: 2020/6/5 0005 15:49
 * @Description:
 */
@Data
@AllArgsConstructor
public class User {
    String name;
    Integer age;
    List order;

}
