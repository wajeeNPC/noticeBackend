package com.admin.noticebackend.web;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.noticebackend.bean.Notice;
import com.admin.noticebackend.dao.NoticeDao;

/**
 * Servlet implementation class listNotice
 */
@WebServlet("/listNotice")
public class listNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			listNotice(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void listNotice(HttpServletRequest request, HttpServletResponse response)
			throws SQLException,IOException,ServletException{
		try {
		NoticeDao noticeDao = new NoticeDao();
		List<Notice> notices = noticeDao.selectallnotice();
		System.out.print(notices);
		request.setAttribute("listnotices", notices);
		RequestDispatcher dispatcher = request.getRequestDispatcher("noticelist.jsp");
		dispatcher.forward(request, response);
		}catch(ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
