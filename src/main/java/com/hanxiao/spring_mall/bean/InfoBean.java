package com.hanxiao.spring_mall.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/15
 **/

@NoArgsConstructor
@Data
public class InfoBean {
    @JsonProperty("roles")
    private List<String> roles;
    @JsonProperty("name")
    private String name;
    @JsonProperty("perms")
    private List<String> perms;
    @JsonProperty("avatar")
    private String avatar;

}
