package com.yuyue.mapper;

import com.yuyue.model.ShopAdmin;

public interface ShopAdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopAdmin record);

    int insertSelective(ShopAdmin record);

    ShopAdmin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopAdmin record);

    int updateByPrimaryKey(ShopAdmin record);
}