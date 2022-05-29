package com.hanxiao.spring_mall.controller;

import com.hanxiao.spring_mall.bean.vo.BaseRespVo;
import com.hanxiao.spring_mall.bean.vo.DataInAuthRespVo;
import com.hanxiao.spring_mall.bean.InfoBean;
import com.hanxiao.spring_mall.bean.bo.LoginUserBo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/15
 **/
@RestController
@RequestMapping("admin/auth")
public class AuthController {

//    @RequestMapping("admin/auth/login")
//    public BaseRespVo login(@RequestBody LoginUserBo loginUser) {
//        DataInAuthRespVo dataInAuthRespVo = new DataInAuthRespVo();
//        dataInAuthRespVo.setToken("20667db2-dd38-4665-b19b-cf3b4d3aea85");
//        DataInAuthRespVo.AdminInfoDTO adminInfoDTO = new DataInAuthRespVo.AdminInfoDTO();
//        adminInfoDTO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//        adminInfoDTO.setNickName("admin123");
//        dataInAuthRespVo.setAdminInfo(adminInfoDTO);
//        return BaseRespVo.ok(dataInAuthRespVo);
//    }

    @RequestMapping("info")
    public BaseRespVo info(String token) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Serializable id = session.getId();
        System.out.println("info请求的sessionId = " + id);

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

    @RequestMapping("login")
    public BaseRespVo login(@RequestBody LoginUserBo loginUser) {
        Subject subject = SecurityUtils.getSubject();
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        UsernamePasswordToken authenticationToken = new UsernamePasswordToken(username, password);
        subject.login(authenticationToken);
        boolean authenticated = subject.isAuthenticated();
        Object primaryPrincipal = subject.getPrincipals().getPrimaryPrincipal();


        DataInAuthRespVo dataInAuthRespVo = new DataInAuthRespVo();
        dataInAuthRespVo.setToken((String) subject.getSession().getId());
        System.out.println("login请求：subject.getSession().getId() = " + subject.getSession().getId());

        DataInAuthRespVo.AdminInfoDTO adminInfoDTO = new DataInAuthRespVo.AdminInfoDTO();
        adminInfoDTO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        adminInfoDTO.setNickName("admin123");
        dataInAuthRespVo.setAdminInfo(adminInfoDTO);
        return BaseRespVo.ok(dataInAuthRespVo);
    }
}
