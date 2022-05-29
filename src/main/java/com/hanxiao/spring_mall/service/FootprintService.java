package com.hanxiao.spring_mall.service;

import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.bean.Footprint;

/**
 * @description:
 * @author: hanxiao
 * @date: 2022/5/29
 **/
public interface FootprintService {

    BasePageData<Footprint> list(Integer userId, Integer goodsId, BaseParam baseParam);

}
