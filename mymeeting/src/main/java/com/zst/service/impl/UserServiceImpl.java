package com.zst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zst.mapper.UserMapper;
import com.zst.model.User;
import com.zst.service.UserService;

/**
 * Created by Administrator on 2017/8/16.
 */

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//����ᱨ�����ǲ�����Ӱ��

    
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    /*
    * ����������õ������ǿ�ͷ���������ķ�ҳ���pagehelper
    * �ܼ򵥣�ֻ��Ҫ��service�㴫�������Ȼ�󽫲������ݸ�һ�������һ����̬�������ɣ�
    * pageNum ��ʼҳ��
    * pageSize ÿҳ��ʾ����������
    * */
   
    public List<User> findAllUser(int pageNum, int pageSize) {
        //������������������Ϳ���ʵ�������ҳ�ˣ��ǳ��򵥡�
       // PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }
}
