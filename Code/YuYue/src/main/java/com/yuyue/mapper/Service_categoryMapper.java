package com.yuyue.mapper;

import com.yuyue.model.Service_category;

public interface Service_categoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Service_category record);

    int insertSelective(Service_category record);

    Service_category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Service_category record);

    int updateByPrimaryKey(Service_category record);
}