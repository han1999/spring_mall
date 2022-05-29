package com.hanxiao.spring_mall.controller;

import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.bean.vo.BaseRespVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/
@RestController
@RequestMapping("admin/address")
public class AddressController {

    @RequestMapping("list")
    public BaseRespVo list(BaseParam baseParam) {

    }

}
