package com.hanxiao.spring_mall.service;

import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.bean.Footprint;
import com.hanxiao.spring_mall.bean.FootprintExample;
import com.hanxiao.spring_mall.mapper.FootprintMapper;
import com.hanxiao.spring_mall.utils.OrderUtils;
import com.hanxiao.spring_mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/
@Service
public class
FootprintServiceImpl implements FootprintService {
    @Autowired
    FootprintMapper footprintMapper;
    @Override
    public BasePageData<Footprint> list(Integer userId, Integer goodsId, BaseParam baseParam) {

        PageUtils.startPage(baseParam);


        FootprintExample example = new FootprintExample();
        FootprintExample.Criteria criteria = example.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (goodsId != null) {
            criteria.andGoodsIdEqualTo(goodsId);
        }
        example.setOrderByClause(OrderUtils.getOrder(baseParam));
        return BasePageData.ok(footprintMapper.selectByExample(example));
    }
}
