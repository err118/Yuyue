package com.yuyue.mapper;

import com.yuyue.model.Admin;
import com.yuyue.model.User;

public interface AdminMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Admin record);

	int insertSelective(Admin record);

	Admin selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Admin record);

	int updateByPrimaryKey(Admin record);

	// 新增
	Admin selectByWxId(String wxId);
}