package com.alankin.ucenter.dao;

import com.alankin.common.util.MybatisGeneratorUtil;
import com.alankin.common.util.PropertiesFileUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 代码生成类
 * Created by alankin on 2017/4/26.
 */
public class Generator {

	// 根据命名规范，只修改此常量值即可
	private static String MODULE = "yunyun-ucenter";
	private static String DATABASE = "mydb";
	private static String TABLE_PREFIX = "sys_";
	private static String PACKAGE_NAME = "com.alankin.ucenter";
	private static String JDBC_DRIVER = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.driver");
	private static String JDBC_URL = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.url");
	private static String JDBC_USERNAME = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.username");
	private static String JDBC_PASSWORD = PropertiesFileUtil.getInstance("generator").get("generator.jdbc.password");
	// 需要insert后返回主键的表配置，key:表名,value:主键名
	private static Map<String, String> LAST_INSERT_ID_TABLES = new HashMap<>();
	static {

	}

	/**
	 * 自动代码生成
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
//		MybatisGeneratorUtil.generator(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD, MODULE, DATABASE, TABLE_PREFIX, PACKAGE_NAME, LAST_INSERT_ID_TABLES);
//		String[] tables={"channel","loan_receipt","channel_log","apply_order"};
//		String[] tables={"user_sys_user","sys_role_user","sys_module","sys_role","sys_role_modle_permission"};
//		String[] tables={"sys_module"};
//		String[] tables={"sys_user_auth","sys_user_base","user_auth","user_base"};
//		String[] tables={"user_other_acount","user_emergency_contact"};
		String[] tables={"loan_receipt"};
		MybatisGeneratorUtil.generatorByAppoint(JDBC_DRIVER, JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD, MODULE, DATABASE, tables, PACKAGE_NAME, LAST_INSERT_ID_TABLES);

//		int i = new Random().nextInt(2);
//		System.out.println(">>>>>>>>>>>>>>>>>>>>> "+i);
	}

}
