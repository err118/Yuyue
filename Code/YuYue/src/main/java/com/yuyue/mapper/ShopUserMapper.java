package com.yuyue.mapper;

import org.apache.ibatis.annotations.Param;

import com.yuyue.model.ShopUser;

public interface ShopUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopUser record);

    int insertSelective(ShopUser record);

    ShopUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopUser record);

    int updateByPrimaryKey(ShopUser record);
//    删除自由员工
    int deleteStaff(@Param("userId")long userId, @Param("shopId")long shopId);
}