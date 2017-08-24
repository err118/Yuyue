package com.yuyue.mapper;

import com.yuyue.model.ShopStaff;

public interface ShopStaffMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopStaff record);

    int insertSelective(ShopStaff record);

    ShopStaff selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopStaff record);

    int updateByPrimaryKey(ShopStaff record);
}