package com.lxh;

import org.apache.shiro.crypto.hash.Md5Hash;
/**
* 密码md5生成测试类
*/
public class Md5HashTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String password_md5_sale_2 = new Md5Hash("111111", "eteokues", 2).toString();
		System.out.println(password_md5_sale_2);
	}

}
