package com.yuyue.service;

import java.util.List;

import com.yuyue.model.UserRecord;

public interface RecordService {
	List<UserRecord> getUserRecord(long userId);

	int addUserRecord(UserRecord userRecord);
}
