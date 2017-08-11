package com.yuyue.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuyue.mapper.ServiceMapper;
import com.yuyue.mapper.UserMapper;
import com.yuyue.model.ServiceWithUserInfo;
import com.yuyue.service.ServiceService;
@Service
public class ServiceServiceImp implements ServiceService {
	
	final static Logger logger = LoggerFactory.getLogger(ServiceServiceImp.class);
	@Autowired
	private ServiceMapper serviceMapper;
	@Override
	public ServiceWithUserInfo getIndexUser() {
		// TODO Auto-generated method stub
		return serviceMapper.selectIndexServiceWithUser();
	}

}
