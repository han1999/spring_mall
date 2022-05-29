package com.hanxiao.spring_mall.service;

import com.hanxiao.spring_mall.bean.Address;
import com.hanxiao.spring_mall.bean.AddressExample;
import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.mapper.AddressMapper;
import com.hanxiao.spring_mall.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;
    @Override
    public BasePageData<Address> list(Integer userId, String name, BaseParam baseParam) {
        PageUtils.startPage(baseParam);
        AddressExample example = new AddressExample();
        AddressExample.Criteria criteria = example.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        //if userId==null and name is empty(including null), then where clause is nothing
        example.setOrderByClause(baseParam.getSort() + " " + baseParam.getOrder());
        List<Address> addressList = addressMapper.selectByExample(example);

        BasePageData<Address> basePageData = BasePageData.ok(addressList);
        return basePageData;
    }
}
