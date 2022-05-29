package com.hanxiao.spring_mall.controller;

import com.hanxiao.spring_mall.bean.Address;
import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.bean.vo.BaseRespVo;
import com.hanxiao.spring_mall.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    AddressService addressService;

    @RequestMapping("list")
    public BaseRespVo list(Integer userId, String name, BaseParam baseParam) {
        BasePageData<Address> data = addressService.list(userId, name, baseParam);
        return BaseRespVo.ok(data);
    }

}
