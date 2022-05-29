package com.hanxiao.spring_mall.service;

import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/26
 **/

public interface UserService {

    BasePageData list(String username, String mobile, BaseParam baseParam);
}
