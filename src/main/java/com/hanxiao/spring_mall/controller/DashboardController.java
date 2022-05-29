package com.hanxiao.spring_mall.controller;

import com.hanxiao.spring_mall.bean.DashboardData;
import com.hanxiao.spring_mall.bean.vo.BaseRespVo;
import com.hanxiao.spring_mall.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/
@RestController
@RequestMapping("admin/dashboard")
public class DashboardController {
    @Autowired
    DashboardService dashboardService;

    @RequestMapping()
    public BaseRespVo dashboard() {
        DashboardData data = dashboardService.dashboard();
        return BaseRespVo.ok(data);
    }
}
