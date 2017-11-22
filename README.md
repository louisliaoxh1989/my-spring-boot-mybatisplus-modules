# spring-boot-mybatisplus
使用spring-boot mybatisplus shiro redis 的基础框架 使用多模块方式

```
运行:
mvn package
java -jar myservice/target/myservice-0.0.1-SNAPSHOT.jar

使用post 访问 http://localhost:8888/login?account=412241262@qq.com&password=111111 进行登陆
使用get方式 访问 http://localhost:8888/rms/user 查看所有用户
使用delete 方式 访问 http://localhost:8888/rms/use/1 就会报没有权限的错误 Subject does not have permission [user:del]
```


模块db时使用mybatis的数据库独立模块，其他模块可以直接引用，可参考myservice模块。


