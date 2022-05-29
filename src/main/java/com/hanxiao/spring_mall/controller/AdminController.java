package com.hanxiao.spring_mall.controller;

import com.hanxiao.spring_mall.bean.Admin;
import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.bean.BaseRespVo;
import com.hanxiao.spring_mall.service.AdminService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/27
 **/
@RestController
@RequestMapping("admin/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequiresPermissions("admin:admin:list")
    @RequestMapping("list")
    public BaseRespVo list(String username, BaseParam baseParam) {
        BasePageData<Admin> basePageData = adminService.list(username, baseParam);
        return BaseRespVo.ok(basePageData);
    }
}
