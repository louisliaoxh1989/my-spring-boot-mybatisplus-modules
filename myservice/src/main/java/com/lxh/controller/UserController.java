package com.lxh.controller;


import com.lxh.constant.ApiConstant;
import com.lxh.entity.User;
import com.lxh.result.ResultBody;
import com.lxh.service.UserService;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @since 2017-09-07
 */
@RestController
@RequestMapping(ApiConstant.RMS_USER)
public class UserController {
    private static final Log log = LogFactory.get();

    @Autowired
    private UserService userService;



    /**
     * 添加用户
     */
    @PostMapping(value = "", produces = "application/json;charset=UTF-8")
    public String addUser(@Valid User rmsUser, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return ResultBody.error(bindingResult.getFieldError().getDefaultMessage());
        }
        userService.addOrUpdateUser(rmsUser);
        return ResultBody.success();
    }

    /**
     * 获取用户列表
     */
    @GetMapping(value = "", produces = "application/json;charset=UTF-8")
    @RequiresPermissions("user:list")
    public String findAllUser(
            @RequestParam(value = "showCount", required = false, defaultValue = "10") Integer showCount,
            @RequestParam(value = "currentPage", required = false, defaultValue = "1") Integer currentPage) throws Exception {
        return ResultBody.success(userService.selectUserList(currentPage, showCount));
    }

    /**
     * 修改用户
     */
    @PutMapping(value = "", produces = "application/json;charset=UTF-8")
    public String updateUserById(@Valid @RequestBody User rmsUser, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return ResultBody.error(bindingResult.getFieldError().getDefaultMessage());
        }
        userService.addOrUpdateUser(rmsUser);
        return ResultBody.success();
    }

  

 
    /**
     * 删除用户
     */
    @GetMapping(value = "/del/{id}", produces = "application/json;charset=UTF-8")
    @RequiresPermissions("user:del")
    public String deleteUserById(@PathVariable("id") Integer id)  {
        if (userService.deleteById(id)) {
            return ResultBody.success();
        }
        return ResultBody.error();
    }
}
