package com.admin.noticebackend.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.noticebackend.bean.Notice;
import com.admin.noticebackend.dao.NoticeDao;

/**
 * Servlet implementation class updateNotice
 */
@WebServlet("/updateNotice")
public class updateNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Updatenotice(request,response);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listNotice");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//try {
		//	Updatenotice(request,response);
		//}catch (SQLException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//} catch (IOException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//response.sendRedirect("listNotice");
	}
	
	private void Updatenotice(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String details = request.getParameter("details");
		
		System.out.println(id);
		System.out.println(title);
		
		//System.out.println(title);
		System.out.println(date);
		System.out.println(details);
		
		Notice notice = new Notice(id,title,date,details);
		
		System.out.println(notice);
		NoticeDao noticedao = new NoticeDao();
		noticedao.updateNotice(notice);
	}

}
