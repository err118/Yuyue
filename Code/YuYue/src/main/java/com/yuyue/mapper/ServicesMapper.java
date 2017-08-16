package com.yuyue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuyue.model.ServiceWithUserInfo;
import com.yuyue.model.Services;

public interface ServicesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Services record);

    int insertSelective(Services record);

    Services selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Services record);

    int updateByPrimaryKey(Services record);
//  以下为新增部分
  ServiceWithUserInfo selectIndexServiceWithUser();
  List<Services> selectServiceByUserId(int userId);
  int deleteByUserId(@Param("id")long id,@Param("userId")long userId);
}