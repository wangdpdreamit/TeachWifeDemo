package com.jinan.www.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jinan.www.daoimpl.UserDaoImpl;
import com.jinan.www.entity.User;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(name = "loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message;
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	public LoginServlet() {
		super();
//		System.out.println("---");
	}

	@Override
	public void init() throws ServletException {
		  // 执行必需的初始化
	      message = "Hello World";
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String str = request.getParameter("str");
		switch (str) {
		case "1":
			doLogin(request,response);
			break;
		case "2":
			doRegister(request,response);
			break;

		default:
			break;
		}
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	protected void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username =  request.getParameter("username");
		String password =  request.getParameter("password");
//		int password_r = Integer.valueOf(request.getParameter("password"));
		
		/*
		// BASE64编码
		String s = "111111";
		BASE64Encoder encoder = new BASE64Encoder();
		s = encoder.encode(s.getBytes("UTF-8"));
		System.out.println(s);

		// BASE64解码
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = decoder.decodeBuffer("MTExMTEx");
		System.out.println(new String(bytes, "UTF-8"));
		}
		*/
		// BASE64编码
		
		BASE64Encoder encoder = new BASE64Encoder();
		password = encoder.encode(password.getBytes("UTF-8"));
	
		
		User user=null;
		try {
//			System.out.println( username +"---"+password);
			user = userDaoImpl.findByUsernameAndPassword(username, password);
//			System.out.println("==========");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(user!=null) {
			request.setAttribute("loginUser",user);
			
			request.setAttribute("t", "12345");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			String errorMsg = "对不起，帐号密码不匹配，查无此用户";
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
			
		}
	
		
	}
	protected void doRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username =  request.getParameter("username");
		String password =  request.getParameter("password");
		
		BASE64Encoder encoder = new BASE64Encoder();
		password = encoder.encode(password.getBytes("UTF-8"));
		
		int resultType=0;
		try {
			resultType=userDaoImpl.registerByUsernameAndPassword(username, password);
			System.out.println("resultType="+resultType);
			if(resultType>0) {
				User user  = new User(username, password);
				request.setAttribute("loginUser",user);
				System.out.println("9999999999999");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return ;
			}else {
				String errorMsg = "对不起，注册失败";
				request.setAttribute("errorMsg", errorMsg);
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request,response);
				return ;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
	
	}
}
