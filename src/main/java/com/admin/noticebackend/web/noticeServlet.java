package com.admin.noticebackend.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.noticebackend.bean.Notice;
import com.admin.noticebackend.dao.NoticeDao;


@WebServlet("/insert")
public class noticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  
		try {
			insertNotice(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String redirectURL = "listNotice";
		response.sendRedirect(redirectURL);
	  	
	}

	
	private void insertNotice(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String details = request.getParameter("details");
		
		if (title != null && date !=null && details!=null) {
			
			Notice newnotice = new Notice(title, date, details);
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.insertNotice(newnotice);
		};
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
