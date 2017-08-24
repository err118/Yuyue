package com.yuyue.service;

import com.yuyue.model.Services;

import java.util.List;

import com.yuyue.model.ServiceWithUserInfo;

public interface ServiceService {
	List<ServiceWithUserInfo> getIndexUser();

	int publishService(Services service);

	int deleteService(long serviceId, long userId);

	Services getService(long serviceId);
}
