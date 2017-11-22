package com.lxh.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lxh.db.mapper.RoleMenuMapper;
import com.lxh.entity.RoleMenu;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

/**
 * <p>
 * 角色权限表 服务实现类
 * </p>
 *
 * @since 2017-09-07
 */
@Service
public class RoleMenuService extends ServiceImpl<RoleMenuMapper, RoleMenu> {
    private static final Log log = LogFactory.get();

    @Autowired
    private RoleMenuMapper rmsRoleMenuMapper;
}
