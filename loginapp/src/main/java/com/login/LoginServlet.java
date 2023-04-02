package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=null;
		try {
			out = response.getWriter();
			String uname=request.getParameter("uname");
			String upass=request.getParameter("upass");
			if(uname.equalsIgnoreCase(upass)) {
//				out.println("Login SUCCESS....");
				response.sendRedirect("loginSuccess.jsp");
			}
			else {
//				out.println("INCORRECT USERNAME AND PASSWORD, TRY AGAIN");
				response.sendRedirect("loginFailure.jsp");
			}
		} catch (Exception e) {
			out.println("Exception: "+e.getMessage());
		}
	}

}
