package com.hanxiao.spring_mall.utils;

import com.github.pagehelper.PageHelper;
import com.hanxiao.spring_mall.bean.BaseParam;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/27
 **/

public class PageUtils {
    public static void startPage(BaseParam baseParam) {
        PageHelper.startPage(baseParam.getPage(), baseParam.getLimit());
    }
}
