package com.hanxiao.spring_mall.service;

import com.hanxiao.spring_mall.bean.Admin;
import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;

/**
 * @description:
 * @author: hanxiao
 * @date: 2022/5/27
 **/
public interface AdminService {

    BasePageData<Admin> list(String username, BaseParam baseParam);
}
