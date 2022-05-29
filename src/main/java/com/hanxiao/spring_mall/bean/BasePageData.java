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
      BasePageData<T> basePageData = new BasePageData();//这里不需要用泛型来定义吗？不用竟然也可以
      //但是规范起见，还是用泛型比较好
      basePageData.setTotal((int) PageInfo.getTotal());
      basePageData.setPages(PageInfo.getPages());
      basePageData.setPage(PageInfo.getPageNum());
      basePageData.setList(list);
      basePageData.setLimit(PageInfo.getPageSize());
      return basePageData;
   }
}
