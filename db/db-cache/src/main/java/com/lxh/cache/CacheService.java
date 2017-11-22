package com.lxh.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lxh.db.mapper.UserMapper;
import com.lxh.entity.vo.UserVo;

/**
 * Created by Ason on 2017/9/27.
 */
@Service
public class CacheService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(value = "usercache", key = "'selectUserById:id_'+#id")
    public UserVo selectUserById(Integer id) {
        Map<String,Object> paramsMap = new HashMap<>(5);
        paramsMap.put("id",id);
        UserVo rmsUser = userMapper.selectOneUser(paramsMap);
        return rmsUser;
    }

    @Cacheable(value = "usercache", key = "'selectUserByAccout:account_'+#account")
    public UserVo selectUserByAccout(String account) {
        Map<String,Object> paramsMap = new HashMap<>(5);
        paramsMap.put("account",account);
        UserVo rmsUser = userMapper.selectOneUser(paramsMap);
        return rmsUser;
    }
}
