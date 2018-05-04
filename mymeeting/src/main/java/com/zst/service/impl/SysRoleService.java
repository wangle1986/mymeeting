package com.zst.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zst.mapper.SysRoleMapper;
import com.zst.model.SysRole;

@Service
public class SysRoleService {
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	public Set<String> getRolesName(Integer userId){
		Set<String> s =  sysRoleMapper.getRolesName(userId);
		return s;
	}
	
	public List<SysRole> getRoleList(Integer userId){
		return sysRoleMapper.getRoleList(userId);
	}
    
}
