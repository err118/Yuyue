package com.yuyue.mapper;

import com.yuyue.model.ShopservicesStaff;

public interface ShopservicesStaffMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopservicesStaff record);

    int insertSelective(ShopservicesStaff record);

    ShopservicesStaff selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopservicesStaff record);

    int updateByPrimaryKey(ShopservicesStaff record);
}