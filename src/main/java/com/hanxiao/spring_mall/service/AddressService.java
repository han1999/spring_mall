package com.hanxiao.spring_mall.service;

import com.hanxiao.spring_mall.bean.Address;
import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/

public interface AddressService {
    BasePageData<Address> list(Integer userId, String name, BaseParam baseParam);
}
