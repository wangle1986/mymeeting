package com.zst.mapper;

import java.util.List;
import java.util.Set;

import com.zst.model.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
    Set<String> getRolesName(Integer userId);
    List<SysRole> getRoleList(Integer userId);
    
}