package com.lxh.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lxh.db.mapper.RoleMapper;
import com.lxh.entity.Role;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @since 2017-09-07
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {
    private static final Log log = LogFactory.get();

    @Autowired
    private RoleMapper rmsRoleMapper;
}
