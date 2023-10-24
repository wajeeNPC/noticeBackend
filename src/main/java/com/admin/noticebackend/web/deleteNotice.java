package com.admin.noticebackend.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.noticebackend.dao.NoticeDao;

/**
 * Servlet implementation class deleteNotice
 */
@WebServlet("/deleteNotice")
public class deleteNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			deletenotice(request,response);
		}catch(SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void deletenotice(HttpServletRequest request, HttpServletResponse response)
				throws SQLException,IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		NoticeDao noticedao = new NoticeDao();
		noticedao.deleteNotice(id);
		response.sendRedirect("listNotice");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
