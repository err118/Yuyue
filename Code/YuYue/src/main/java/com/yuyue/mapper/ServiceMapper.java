package com.yuyue.mapper;

import com.yuyue.model.Service;
import com.yuyue.model.ServiceWithUserInfo;

public interface ServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Service record);

    int insertSelective(Service record);

    Service selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);
//    以下为新增部分
    ServiceWithUserInfo selectIndexServiceWithUser();
}