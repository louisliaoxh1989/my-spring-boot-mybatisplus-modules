# spring-boot-mybatisplus-modules

**使用spring-boot mybatisplus shiro redis 的基础框架 使用多模块方式**
## 功能
```
集成mybatisplus,mysql,分页
集成Redis做数据的缓存
集成shiro认证(salt md5 散列2次md5(md5(""))),权限控制访问
自定义404,500等异常处理页面
自定义无权限页面(解决shiro配置setUnauthorizedUrl(403)无用的情况)
```

## 运行:
```bash
mvn package
java -jar myservice/target/myservice-0.0.1-SNAPSHOT.jar
```


>>使用get 访问 http://localhost:8888/logindo?account=412241262@qq.com&password=111111 进行登陆
>>使用get方式 访问 http://localhost:8888/rms/user?showCount=2&currentPage=1 查看所有用户<后面的参数可以不带>
>>使用get方式 访问 http://localhost:8888/rms/user/del/1 就会跳到没有权限的提示页面


### 国际化测试

```
访问 http://localhost:8888/langtest  # 第一次访问会根据浏览器设置的语言来显示
访问 http://localhost:8888/langtest?lang=zh_CN #切换为中文
再次访问 http://localhost:8888/langtest #可以发现已经为中文了
访问 http://localhost:8888/langtest?lang=en_US #切换为英文
访问 http://localhost:8888/changeLanauage?lang=zh # 设置为中文
再次访问 http://localhost:8888/langtest #可以发现已经为中文了
访问 http://localhost:8888/changeLanauage?lang=en # 设置为英文
再次访问 http://localhost:8888/langtest #可以发现已经为英文了
```

模块db是使用mybatis的数据库独立模块，其他模块可以直接引用，可参考myservice模块。



# 参考


[国际化](https://github.com/hendisantika/spring-boot-i18n)

[spring-boot国际化配置](https://github.com/zl736732419/spring-boot-i18n)

[Spring-boot Shiro](https://github.com/xuezhijian/Spring-Demo-Repository/tree/master/shiroDemo)

[springboot整合shiro-登录认证和权限管理](http://www.importnew.com/26055.html)

[Spring Boot 静态资源处理](http://blog.csdn.net/isea533/article/details/50412212)

[spring-boot-oauth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
