package com.hanxiao.spring_mall.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/29
 **/

@NoArgsConstructor
@Data
public class DashboardData {

    @JsonProperty("goodsTotal")
    private Integer goodsTotal;
    @JsonProperty("userTotal")
    private Integer userTotal;
    @JsonProperty("productTotal")
    private Integer productTotal;
    @JsonProperty("orderTotal")
    private Integer orderTotal;
}
