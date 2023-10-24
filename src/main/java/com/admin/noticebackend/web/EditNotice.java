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



@WebServlet("/EditNotice")
public class EditNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			editform(request,response);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void editform(HttpServletRequest request, HttpServletResponse response)
			throws SQLException,ServletException,IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(request.getParameter("id"));
		NoticeDao noticedao = new NoticeDao();
		Notice existinNotice = noticedao.selectNotice(id);
		System.out.println(existinNotice);
		RequestDispatcher dispatcher = request.getRequestDispatcher("notice.jsp");
		request.setAttribute("existnotice", existinNotice);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
