package com.hanxiao.spring_mall.controller;

import com.hanxiao.spring_mall.bean.BaseRespVo;
import com.hanxiao.spring_mall.bean.DataInAuthRespVo;
import com.hanxiao.spring_mall.bean.InfoBean;
import com.hanxiao.spring_mall.bean.LoginUserBo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/15
 **/
@RestController
public class AuthController {

    @RequestMapping("admin/auth/login")
    public BaseRespVo login(@RequestBody LoginUserBo loginUser) {
        DataInAuthRespVo dataInAuthRespVo = new DataInAuthRespVo();
        dataInAuthRespVo.setToken("20667db2-dd38-4665-b19b-cf3b4d3aea85");
        DataInAuthRespVo.AdminInfoDTO adminInfoDTO = new DataInAuthRespVo.AdminInfoDTO();
        adminInfoDTO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        adminInfoDTO.setNickName("admin123");
        dataInAuthRespVo.setAdminInfo(adminInfoDTO);
        return BaseRespVo.ok(dataInAuthRespVo);
    }

    @RequestMapping("admin/auth/info")
    public BaseRespVo info(String token) {
        InfoBean infoBean = new InfoBean();
        infoBean.setAvatar("https://cdn.yaoruanwen.com/wp-content/uploads/2021/07/2021071760215223817.jpg");
        infoBean.setName("admin123");
        ArrayList<String> perms = new ArrayList<>();
        perms.add("*");
        infoBean.setPerms(perms);
        ArrayList<String> roles = new ArrayList<>();
        roles.add("超级管理员");
        infoBean.setRoles(roles);
        return BaseRespVo.ok(infoBean);
    }
}