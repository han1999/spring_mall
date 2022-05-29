package com.hanxiao.spring_mall.bean;

import lombok.Data;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/26
 **/
@Data
public class BaseParam {
    private Integer page;
    private Integer limit;
    private String sort;
    private String order;
}
