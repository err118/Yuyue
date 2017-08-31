package com.yuyue.service;

import java.util.List;

import com.yuyue.model.Staff;

public interface StaffService {
	int addStaff(Staff staff);

	int deleteStaff(long id);

	List<Staff> getStaff(long shopId);
}
