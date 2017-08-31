package com.yuyue.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuyue.mapper.StaffMapper;
import com.yuyue.model.Staff;
import com.yuyue.service.StaffService;

@Service
public class StaffServceImp implements StaffService {
	@Autowired
	StaffMapper staffMapper;
	@Override
	public int addStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffMapper.insertSelective(staff);
	}
	
	@Override
	public int deleteStaff(long id) {
		// TODO Auto-generated method stub
		return staffMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Staff> getStaff(long shopId) {
		// TODO Auto-generated method stub
		return staffMapper.selectByShopId(shopId);
	}

}
