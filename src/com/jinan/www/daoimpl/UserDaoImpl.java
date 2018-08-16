package com.jinan.www.daoimpl;


import java.sql.*;
import java.util.UUID;

import com.jinan.www.dao.UserDao;
import com.jinan.www.entity.User;

public class UserDaoImpl  implements UserDao{

	@Override
	public User findByUsernameAndPassword(String username,String password) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String url ="jdbc:oracle:thin:@localhost:1521:ORCL?useUnicode=true&characterEncoding=gbk&useSSL=true ;";
		String url ="jdbc:oracle:thin:@localhost:1521:ORCL";
		String name = "sdtest";
		String psd= "dreamsoft";
		Connection connection = DriverManager.getConnection(url,name,psd);
		
		if(connection!=null) {
//			System.out.println("success");
		}
		
		String sql  ="select t.name,t.password from g_userinfo t where t.name=? and password= ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,username);
		preparedStatement.setString(2, password);
		
		User user=null;
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			user = new User();
			user.setUsername(resultSet.getString("name"));
			user.setPassword(resultSet.getString("password"));
//			System.out.println(user.toString());
			return user;
		}
//		System.out.println(user.toString());
		
		return user;
	}

	@Override
	public int registerByUsernameAndPassword(String username, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String url ="jdbc:oracle:thin:@localhost:1521:ORCL?useUnicode=true&characterEncoding=gbk&useSSL=true ;";
		String url ="jdbc:oracle:thin:@localhost:1521:ORCL";
		String name = "sdtest";
		String psd= "dreamsoft";
		Connection connection = DriverManager.getConnection(url,name,psd);
		connection.setAutoCommit(false);
		if(connection!=null) {
			System.out.println("connect success");
		}
		
//		Integer  id=Integer.parseInt(UUID.randomUUID().toString().replace("-", "").toLowerCase());
		int id=20180816;
		String sql  ="insert into g_userinfo(id,name,password) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2,username);
		preparedStatement.setString(3,password);
		int  result = preparedStatement.executeUpdate();
		connection.commit();
		if(result>0) {
			System.out.println("插入成功");
		}
//		System.out.println(user.toString());
		
		return result;
	}

	
}
