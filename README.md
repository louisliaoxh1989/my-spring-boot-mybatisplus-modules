# spring-boot-mybatisplus
使用spring-boot mybatisplus shiro redis 的基础框架 使用多模块方式

```
运行:
mvn package
java -jar myservice/target/myservice-0.0.1-SNAPSHOT.jar

使用get 访问 http://localhost:8888/logindo?account=412241262@qq.com&password=111111 进行登陆
使用get方式 访问 http://localhost:8888/rms/user 查看所有用户
使用get方式 访问 http://localhost:8888/rms/user/del/1 就会跳到没有权限的提示页面
```


模块db时使用mybatis的数据库独立模块，其他模块可以直接引用，可参考myservice模块。


