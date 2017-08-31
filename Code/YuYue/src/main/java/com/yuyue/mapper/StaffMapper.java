package com.yuyue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuyue.model.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
    List<Staff> selectByShopId(@Param("shopId")long shopId);
}