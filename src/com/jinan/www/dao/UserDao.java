package com.jinan.www.dao;

import java.sql.SQLException;

import com.jinan.www.entity.User;

public interface UserDao  {
	User  findByUsernameAndPassword(String username,String password) throws ClassNotFoundException, SQLException;
	int  registerByUsernameAndPassword(String username,String password) throws ClassNotFoundException, SQLException;
}
