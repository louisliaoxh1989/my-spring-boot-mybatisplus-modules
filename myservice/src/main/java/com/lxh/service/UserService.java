package com.lxh.service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lxh.core.exception.RmsException;
import com.lxh.core.exception.RmsExceptionEnum;
import com.lxh.db.mapper.UserMapper;
import com.lxh.entity.User;
import com.lxh.entity.vo.UserVo;
import com.lxh.enums.RmsUserSexEnum;
import com.lxh.enums.RmsUserStatusEnum;
import com.lxh.utils.BlankUtil;
import com.lxh.utils.TimeUtil;
import com.xiaoleilu.hutool.date.DatePattern;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @since 2017-09-07
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    private static final Log log = LogFactory.get();

    @Autowired
    private UserMapper userMapper;



    @Autowired
    private SqlSessionFactory factory;

    /**
     * 查询用户信息
     */
    public Page<Map<String, Object>> selectUserList(Integer currentPage, Integer showCount) {
        Page<Map<String, Object>> page = new Page<>(currentPage, showCount);
        List<Map<String, Object>> rmsUserList = new ArrayList<>();
        for (UserVo rmsUserVo : userMapper.selectUserList(page)) {
            Map<String, Object> ruv = new HashMap(16);
            ruv.put("id", rmsUserVo.getId());
            ruv.put("name", rmsUserVo.getName());
            ruv.put("account", rmsUserVo.getAccount());
            ruv.put("password", rmsUserVo.getPassword());
            ruv.put("phone", rmsUserVo.getPhone());
            ruv.put("birthday", rmsUserVo.getBirthday());
            ruv.put("sex", RmsUserSexEnum.getByStatus(rmsUserVo.getSex()).getRemark());
            ruv.put("status", RmsUserStatusEnum.getByStatus(rmsUserVo.getStatus()).getRemark());
            ruv.put("createTime", TimeUtil.getDateByTimestamp(rmsUserVo.getCreateTime(), DatePattern.NORM_DATETIME_PATTERN));
            ruv.put("createUserName", rmsUserVo.getCreateUserName());
            ruv.put("deptName", rmsUserVo.getDeptName());
            ruv.put("roleName", rmsUserVo.getRoleName());
            rmsUserList.add(ruv);
        }
        page.setRecords(rmsUserList);
        return page;

    }

    /**
     * 添加/修改用户
     */
    public void addOrUpdateUser(User rmsUser) {
        // 添加
        if (BlankUtil.isBlank(rmsUser.getId())) {
            // 判断账号是否重复
            User theUser = selectOne(new EntityWrapper().where("account = {0}", rmsUser.getAccount()));
            if (!BlankUtil.isBlank(theUser)) {
                throw new RmsException(RmsExceptionEnum.USER_ALREADY_REG);
            } else {
                rmsUser.setCreateTime(TimeUtil.getSecondTimestamp());
                rmsUser.setStatus(RmsUserStatusEnum.OPEN.getStatus());
                insert(rmsUser);
            }
        } else { //修改
            updateById(rmsUser);
        }
    }

    /**
     * mybatis的一级进行测试，只查询了一次
     * @param id
     * @return
     */
    public UserVo selectUserById(Integer id) {
        // 自动提交事务
        SqlSession sqlSession = factory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> paramsMap = new HashMap<>(16);
        paramsMap.put("id",id);
        UserVo rmsUser = userMapper.selectOneUser(paramsMap);
        userMapper.selectOneUser(paramsMap);
        userMapper.selectOneUser(paramsMap);
        userMapper.selectOneUser(paramsMap);
        return rmsUser;
//        return cacheService.selectUserById(id);
    }
}














