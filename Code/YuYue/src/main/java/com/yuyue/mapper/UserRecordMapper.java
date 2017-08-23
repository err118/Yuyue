package com.yuyue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuyue.model.UserRecord;

public interface UserRecordMapper {
	int deleteByPrimaryKey(Long id);

	int insert(UserRecord record);

	int insertSelective(UserRecord record);

	UserRecord selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UserRecord record);

	int updateByPrimaryKey(UserRecord record);

	// 以下为新增
	List<UserRecord> selectByUserId(@Param("userId") long userId);
}