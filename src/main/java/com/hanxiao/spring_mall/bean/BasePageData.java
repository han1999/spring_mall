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
public class BasePageData<T> {
   private Integer total;
   private Integer pages;
   private Integer limit;
   private Integer page;
   private List<T> list;

   public static <T> BasePageData ok(List<T> list) {
      PageInfo<T> PageInfo = new PageInfo<>(list);
      BasePageData basePageData = new BasePageData();
      basePageData.setTotal((int) PageInfo.getTotal());
      basePageData.setPages(PageInfo.getPages());
      basePageData.setPage(PageInfo.getPageNum());
      basePageData.setList(list);
      basePageData.setLimit(PageInfo.getPageSize());
      return basePageData;
   }
}
