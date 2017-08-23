package com.yuyue.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuyue.mapper.UserRecordMapper;
import com.yuyue.model.UserRecord;
import com.yuyue.service.RecordService;

@Service
public class RecordServiceImp implements RecordService {
	@Autowired
	UserRecordMapper userRecordMapper;

	@Override
	public List<UserRecord> getUserRecord(long userId) {
		// TODO Auto-generated method stub
		return userRecordMapper.selectByUserId(userId);
	}

	@Override
	public int addUserRecord(UserRecord userRecord) {
		// TODO Auto-generated method stub
		return userRecordMapper.insert(userRecord);
	}

}
