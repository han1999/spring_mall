package com.hanxiao.spring_mall.service;

import com.hanxiao.spring_mall.bean.Admin;
import com.hanxiao.spring_mall.bean.AdminExample;
import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.mapper.AdminMapper;
import com.hanxiao.spring_mall.utils.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/27
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public BasePageData<Admin> list(String username, BaseParam baseParam) {
        PageUtils.startPage(baseParam);
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        example.setOrderByClause(baseParam.getSort() + " " + baseParam.getOrder());
        List<Admin> admins = adminMapper.selectByExample(example);
        return BasePageData.ok(admins);
    }
}
