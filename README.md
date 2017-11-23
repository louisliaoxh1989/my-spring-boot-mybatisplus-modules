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



模块db是使用mybatis的数据库独立模块，其他模块可以直接引用，可参考myservice模块。


