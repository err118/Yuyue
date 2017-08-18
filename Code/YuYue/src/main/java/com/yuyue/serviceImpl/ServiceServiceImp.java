package com.yuyue.serviceImpl;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuyue.mapper.ServicesMapper;
import com.yuyue.model.Services;
import com.yuyue.model.ServiceWithUserInfo;
import com.yuyue.service.ServiceService;

@Service
public class ServiceServiceImp implements ServiceService {
	
	final static Logger logger = LoggerFactory.getLogger(ServiceServiceImp.class);
	@Autowired
	private ServicesMapper serviceMapper;
	@Override
	public ServiceWithUserInfo getIndexUser() {
		// TODO Auto-generated method stub
		return serviceMapper.selectIndexServiceWithUser();
	}
	
	@Override
	public int publishService(Services service) {
		// TODO Auto-generated method stub
		int status = serviceMapper.insert(service);
		return status;
	}

	@Override
	public int deleteService(long serviceId, long userId) {
		// TODO Auto-generated method stub
		return serviceMapper.deleteByUserId(userId,serviceId);
	}

	@Override
	public Services getService(long serviceId) {
		// TODO Auto-generated method stub
		return serviceMapper.selectByPrimaryKey(serviceId);
	}
}
