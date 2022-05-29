package com.hanxiao.spring_mall.service;

import com.hanxiao.spring_mall.bean.BasePageData;
import com.hanxiao.spring_mall.bean.BaseParam;
import com.hanxiao.spring_mall.bean.Collect;
import com.hanxiao.spring_mall.bean.CollectExample;
import com.hanxiao.spring_mall.mapper.CollectMapper;
import com.hanxiao.spring_mall.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    @Override
    public BasePageData<Collect> list(Integer userId, Integer valueId, BaseParam baseParam) {
        PageUtils.startPage(baseParam);
        CollectExample example = new CollectExample();
        CollectExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (valueId != null) {
            criteria.andValueIdEqualTo(valueId);
        }
        example.setOrderByClause(baseParam.getSort() + " " + baseParam.getOrder());
        List<Collect> collects = collectMapper.selectByExample(example);

        BasePageData basePageData = BasePageData.ok(collects);
        return basePageData;
    }
}
