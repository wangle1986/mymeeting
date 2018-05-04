package com.zst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zst.mapper.SysPermissionMapper;
import com.zst.mapper.SysUserMapper;
import com.zst.model.SysUser;

@Service
public class PermissionService {
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysPermissionMapper sysPermissionMapper;
	
	public SysUser findByUserEmail(String email){
		return sysUserMapper.findByUserEmail(email);
	}
	
	public List<String> getPermissionsName(Integer roleId){
		return sysPermissionMapper.getPermissionsName(roleId);
	}
}
