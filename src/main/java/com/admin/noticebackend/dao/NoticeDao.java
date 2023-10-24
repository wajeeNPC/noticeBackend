package com.admin.noticebackend.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.admin.noticebackend.bean.Notice;

public class NoticeDao {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/notice?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "1234";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	
	
	private static final String INSERT_NOTICE_SQL = "INSERT INTO notice_det" + "(title,not_date,description)VALUES" + "(?,?,?);";
	private static final String SELECT_ALL_NOTICE = "SELECT * FROM notice_det";
	private static final String DELETE_NOTICE_SQL = "DELETE FROM notice_det WHERE id=?;";
	private static final String UPDATE_NOTICE_SQL = "UPDATE notice_det SET title=?,not_date=?,description=? WHERE id=?;";
	private static final String SELECT_NOTICE_BY_ID = "SELECT id,title,not_date,description FROM notice_det WHERE id=?;";
	
	
	protected Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertNotice(Notice notice) throws SQLException {
		System.out.println(INSERT_NOTICE_SQL);
		
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NOTICE_SQL)) {
			preparedStatement.setString(1,notice.getTitle());
			preparedStatement.setString(2,notice.getDate());
			preparedStatement.setString(3,notice.getDescription());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public List<Notice> selectallnotice() {
		List<Notice> notices = new ArrayList<>();
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NOTICE);
				ResultSet rs = preparedStatement.executeQuery();){
			System.out.println(preparedStatement);
			
			//ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String date = rs.getString("not_date");
				String details = rs.getString("description");
				notices.add(new Notice(id,title,date,details));
			}
		}catch (SQLException e) {
			printSQLException(e);
		}
		return notices;
	}
	
	public boolean deleteNotice(int id) throws SQLException {
		boolean rowDeleted;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_NOTICE_SQL);){
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public Notice selectNotice(int id) throws SQLException{
		Notice notice = null;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(SELECT_NOTICE_BY_ID);){
			statement.setInt(1,id);
			System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()){
				String title = rs.getString("title");
				String date = rs.getString("not_date");
				String details = rs.getString("description");
				notice = new Notice(id,title,date,details);
				//System.out.println(id);
				//System.out.println(title);
				//System.out.println(date);
				//System.out.println(details);
			}
		}catch (SQLException e) {
			printSQLException(e);
		}
		return notice;
	}
	
	public boolean updateNotice(Notice notice) throws SQLException{
		boolean rowUpdated;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_NOTICE_SQL); ){
			statement.setString(1,notice.getTitle());
			statement.setString(2,notice.getDate());
			statement.setString(3,notice.getDescription());
			statement.setInt(4,notice.getId());
			
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}

}
