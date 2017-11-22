package com.lxh.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lxh.db.mapper.DeptMapper;
import com.lxh.entity.Dept;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @since 2017-09-07
 */
@Service
public class DeptService extends ServiceImpl<DeptMapper, Dept> {
    private static final Log log = LogFactory.get();

    @Autowired
    private DeptMapper deptMapper;
}
