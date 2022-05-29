package com.hanxiao.spring_mall.controller;

import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.bean.BaseRespVo;
import com.hanxiao.spring_mall.bean.User;
import com.hanxiao.spring_mall.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/26
 **/
@RestController
@RequestMapping("admin/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequiresPermissions(value = {"admin:user:list","hanxiao:user"},logical = Logical.OR)
    @RequestMapping("list")
    public BaseRespVo list(String username, String mobile, BaseParam baseParam) {
        BasePageData<User> basePageData = userService.list(username, mobile, baseParam);
        return BaseRespVo.ok(basePageData);
    }
}
