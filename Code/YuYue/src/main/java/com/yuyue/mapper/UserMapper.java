package com.yuyue.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuyue.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
//    新增
    User selectByWxId(String wxId);
    int joinShop(@Param("userId")long userId, @Param("shopId")long shopId);
    int leaveShop(@Param("tokenId")String tokenId);
    User selectByToken(@Param("tokenId")String tokenId);
    List<User> selectStaffs(@Param("shopId")Long shopId);
}