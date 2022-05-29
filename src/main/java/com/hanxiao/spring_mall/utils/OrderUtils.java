package com.hanxiao.spring_mall.utils;

import com.hanxiao.spring_mall.bean.BaseParam;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/

public class OrderUtils {
    public static String getOrder(BaseParam baseParam) {
        return baseParam.getSort() + " " + baseParam.getOrder();
    }
}
