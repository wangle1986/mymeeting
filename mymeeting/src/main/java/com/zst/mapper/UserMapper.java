package com.zst.mapper;

import java.util.List;

import com.zst.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //�����ʽ���Լ��ӵ�
    List<User> selectAllUser();
}