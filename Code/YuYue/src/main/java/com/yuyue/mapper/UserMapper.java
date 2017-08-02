package com.yuyue.mapper;

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
    int joinShop(@Param("tokenId")String tokenId, @Param("shopId")int shopId);
}