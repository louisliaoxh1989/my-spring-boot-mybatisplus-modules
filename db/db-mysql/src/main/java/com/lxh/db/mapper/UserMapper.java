package com.lxh.db.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.lxh.entity.User;
import com.lxh.entity.vo.UserVo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
  * 用户表 Mapper 接口
 * </p>
 *
 * @since 2017-09-07
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
    /**
     * 分页查询用户列表
     * @param page
     * @return
     */
    List<UserVo> selectUserList(Pagination page);

    /**
     * 根据条件查询用户
     * @param paramMap
     * @return
     */
    UserVo selectOneUser(Map<String,Object> paramMap);
}
