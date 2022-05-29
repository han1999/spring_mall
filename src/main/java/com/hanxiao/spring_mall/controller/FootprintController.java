package com.hanxiao.spring_mall.controller;

import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.bean.Footprint;
import com.hanxiao.spring_mall.bean.vo.BaseRespVo;
import com.hanxiao.spring_mall.service.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/

@RestController
@RequestMapping("admin/footprint")
public class FootprintController {
    @Autowired
    FootprintService footprintService;

    @RequestMapping("list")
    public BaseRespVo list(Integer userId, Integer goodsId, BaseParam baseParam) {
        BasePageData<Footprint> data = footprintService.list(userId, goodsId, baseParam);
        return BaseRespVo.ok(data);
    }
}
