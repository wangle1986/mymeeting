package com.zst.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zst.mapper.SysUserMapper;

@Service
public class SysUserService {
	@Autowired
	private SysUserMapper userMapper;
	
	
}
