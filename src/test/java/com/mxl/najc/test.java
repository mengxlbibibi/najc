package com.mxl.najc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 作者: @author mxl <br>
 * 时间: 2019年3月8日 下午9:39:32<br>
 * 描述: test.java <br>
 */
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test tt=new test();
		tt.getConnection();
	}
	 public Connection getConnection(){
		 Connection conn=null;
		 try {
			 try{
				 Class.forName("com.mysql.cj.jdbc.Driver");
			 }catch (ClassNotFoundException ex){
				 System.out.println("加载驱动程序有错误");
			 }
			 String url = "jdbc:mysql://106.14.191.40:3306/my_db?user=meng&password=Mengxl123..&useUnicode=true&characterEncoding=gb2312";
			 conn = DriverManager.getConnection(url);
			 System.out.println("成功连接数据库！！");
		 }catch (SQLException ex1){
			 System.out.print("取得连接的时候有错误，请核对用户名和密码");
		 }
		 return conn;
	 }
}
