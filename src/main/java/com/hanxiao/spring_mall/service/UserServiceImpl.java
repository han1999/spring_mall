package com.hanxiao.spring_mall.service;

import com.github.pagehelper.PageHelper;
import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.bean.User;
import com.hanxiao.spring_mall.bean.UserExample;
import com.hanxiao.spring_mall.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/26
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public BasePageData list(String username, String mobile, BaseParam baseParam) {
        PageHelper.startPage(baseParam.getPage(), baseParam.getLimit());

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        if (!StringUtils.isEmpty(mobile)) {
            criteria.andMobileEqualTo(mobile);
        }
        example.setOrderByClause(baseParam.getSort() + " " + baseParam.getOrder());
        List<User> users = userMapper.selectByExample(example);

        return BasePageData.ok(users);
    }
}
