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
public class DataInAuthRespVo {
    @JsonProperty("adminInfo")
    private AdminInfoDTO adminInfo;
    @JsonProperty("token")
    private String token;

    @NoArgsConstructor
    @Data
    public static class AdminInfoDTO {
        @JsonProperty("nickName")
        private String nickName;
        @JsonProperty("avatar")
        private String avatar;
    }
}
