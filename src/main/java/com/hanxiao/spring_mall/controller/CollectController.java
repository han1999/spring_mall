package com.hanxiao.spring_mall.controller;

import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.bean.Collect;
import com.hanxiao.spring_mall.bean.vo.BaseRespVo;
import com.hanxiao.spring_mall.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/
@RestController
@RequestMapping("admin/collect")
public class CollectController {
    @Autowired
    CollectService collectService;

    @RequestMapping("list")
    public BaseRespVo list(Integer userId, Integer valueId, BaseParam baseParam) {
        BasePageData<Collect> data = collectService.list(userId, valueId, baseParam);
        return BaseRespVo.ok(data);
    }
}
