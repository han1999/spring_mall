package com.hanxiao.spring_mall.bean.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/15
 **/

@NoArgsConstructor
@Data
public class BaseRespVo {

    @JsonProperty("errno")
    private Integer errno;
    @JsonProperty("data")
    private Object data;
    @JsonProperty("errmsg")
    private String errmsg;

    public BaseRespVo(Integer errno, Object data, String errmsg) {
        this.errno = errno;
        this.data = data;
        this.errmsg = errmsg;
    }

    public static BaseRespVo ok(Object data) {
        return new BaseRespVo(0, data, "成功");
    }

    public static BaseRespVo ok() {
        return BaseRespVo.ok(null);
    }

}
