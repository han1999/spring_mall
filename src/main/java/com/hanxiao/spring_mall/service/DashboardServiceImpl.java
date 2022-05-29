package com.hanxiao.spring_mall.service;

import com.hanxiao.spring_mall.bean.DashboardData;
import com.hanxiao.spring_mall.mapper.GoodsMapper;
import com.hanxiao.spring_mall.mapper.OrderMapper;
import com.hanxiao.spring_mall.mapper.ProductMapper;
import com.hanxiao.spring_mall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/
@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    UserMapper userMapper;


    @Override

    public DashboardData dashboard() {
        DashboardData dashboardData = new DashboardData();
        Integer goodsTotal = Math.toIntExact(goodsMapper.countByExample(null));
        dashboardData.setGoodsTotal(goodsTotal);
        Integer orderTotal = Math.toIntExact(orderMapper.countByExample(null));
        dashboardData.setOrderTotal(orderTotal);

        Integer productTotal = Math.toIntExact(productMapper.countByExample(null));
        dashboardData.setProductTotal(productTotal);

        Integer userTotal = Math.toIntExact(userMapper.countByExample(null));
        dashboardData.setUserTotal(userTotal);

        return dashboardData;
    }
}
