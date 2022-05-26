package com.hanxiao.spring_mall.bean;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/26
 **/

@Data
public class BasePageData {
   private Integer total;
   private Integer pages;
   private Integer limit;
   private Integer page;
   private List<User> list;

   public static BasePageData ok(List<User> users) {
      PageInfo<User> userPageInfo = new PageInfo<>(users);
      BasePageData basePageData = new BasePageData();
      basePageData.setTotal((int) userPageInfo.getTotal());
      basePageData.setPages(userPageInfo.getPages());
      basePageData.setPage(userPageInfo.getPageNum());
      basePageData.setList(users);
      basePageData.setLimit(userPageInfo.getPageSize());
      return basePageData;
   }
}
