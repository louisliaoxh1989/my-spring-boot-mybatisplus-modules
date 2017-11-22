package com.lxh.db.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lxh.entity.Role;

/**
 * <p>
  * 角色表 Mapper 接口
 * </p>
 *
 * @since 2017-09-07
 */
@Mapper
@Component
public interface RoleMapper extends BaseMapper<Role> {

}
