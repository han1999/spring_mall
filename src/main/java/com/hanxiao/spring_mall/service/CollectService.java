package com.hanxiao.spring_mall.service;

import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.bean.Collect;

/**
 * @description:
 * @author: hanxiao
 * @date: 2022/5/29
 **/

public interface CollectService {

    BasePageData<Collect> list(Integer userId, Integer valueId, BaseParam baseParam);
}
