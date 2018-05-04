package com.zst.mapper;

import java.util.List;

import com.zst.model.SysPermission;
import com.zst.model.SysUser;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
    
    public SysUser findByUserEmail(String email);
    
    List<String> getPermissionsName(Integer roleId);
}