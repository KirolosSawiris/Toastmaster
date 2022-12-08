package com.app.entity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.entity.model.Meeting;
import com.app.entity.model.User;



public class DAOfactory {
	private String jdbcURL = "jdbc:mysql://localhost:3306/toastmasters?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "(name, email, password) VALUES "+ " (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select id,name,email,password from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, password =? where id = ?;";
	private static final String VALIDATE_USER = "select * from users where email = ? and password = ?";
	
	private static final String INSERT_MEETING = "INSERT INTO meetings" + "(name, location, date, start, end) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_MEETING_BY_ID = "SELECT * FROM meetings WHERE id = ?;";
	private static final String SELECT_MEETING_BY_User = "SELECT * FROM meetings WHERE speaker = ? or toastmaster = ? or ahCounter = ? or grammarian = ? or evaluator = ? or timer = ?;";
	private static final String SELECT_ALL_MEETINGS = "SELECT * FROM meetings;";
	private static final String DELETE_MEETING = "DELETE FROM meetings WHERE id = ?;";
	private static final String UPDATE_MEETING = "update meetings set name = ?, location = ?, date = ?, start = ?, end = ? where id = ?;";
	private static final String INSERT_SPEAKER = "update meetings set speaker = ? where id = ?;";
	private static final String INSERT_TOASTMASTER = "update meetings set toastmaster = ? where id = ?;";
	private static final String INSERT_TIMER = "update meetings set timer = ? where id = ?;";
	private static final String INSERT_EVALUATOR = "update meetings set evaluator = ? where id = ?;";
	private static final String INSERT_AHCOUNTER = "update meetings set ahCounter = ? where id = ?;";
	private static final String INSERT_GRAMMARIAN = "update meetings set grammarian = ? where id = ?;";
	private static final String DELETE_SPEAKER = "update meetings set speaker = NULL where id = ? and speaker = ?;";
	private static final String DELETE_TOASTMASTER = "update meetings set toastmaster = NULL where id = ? and toastmaster = ?;";
	private static final String DELETE_TIMER = "update meetings set timer = NULL where id = ? and timer = ?;";
	private static final String DELETE_EVALUATOR = "update meetings set evaluator = NULL where id = ? and evaluator = ?;";
	private static final String DELETE_AHCOUNTER = "update meetings set ahCounter = NULL where id = ? and ahCounter = ?;";
	private static final String DELETE_GRAMMARIAN = "update meetings set grammarian = NULL where id = ? and grammarian = ?;";
	
	

	public DAOfactory() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertMeeting(Meeting meeting) throws SQLException
	{
		System.out.println(INSERT_MEETING);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MEETING);) {
			preparedStatement.setString(1, meeting.getName());
			preparedStatement.setString(2, meeting.getLocation());
			preparedStatement.setString(3, meeting.getDate());
			preparedStatement.setString(4, meeting.getStart());
			preparedStatement.setString(5, meeting.getEnd());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
	}
	
	public void dropUser(int id, String user) throws SQLException
	{
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement1 = connection.prepareStatement(DELETE_SPEAKER);) {
			preparedStatement1.setInt(1, id);
			preparedStatement1.setString(2, user);
			System.out.println(preparedStatement1);
			preparedStatement1.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement2 = connection.prepareStatement(DELETE_TOASTMASTER);) {
			preparedStatement2.setInt(1, id);
			preparedStatement2.setString(2, user);
			System.out.println(preparedStatement2);
			preparedStatement2.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement3 = connection.prepareStatement(DELETE_TIMER);) {
			preparedStatement3.setInt(1, id);
			preparedStatement3.setString(2, user);
			System.out.println(preparedStatement3);
			preparedStatement3.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement4 = connection.prepareStatement(DELETE_EVALUATOR);) {
			preparedStatement4.setInt(1, id);
			preparedStatement4.setString(2, user);
			System.out.println(preparedStatement4);
			preparedStatement4.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement5 = connection.prepareStatement(DELETE_AHCOUNTER);) {
			preparedStatement5.setInt(1, id);
			preparedStatement5.setString(2, user);
			System.out.println(preparedStatement5);
			preparedStatement5.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement6 = connection.prepareStatement(DELETE_GRAMMARIAN);) {
			preparedStatement6.setInt(1, id);
			preparedStatement6.setString(2, user);
			System.out.println(preparedStatement6);
			preparedStatement6.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
	}
	public Meeting selectMeeting(int id) throws SQLException
	{
		Meeting meeting = null;
		System.out.println(SELECT_MEETING_BY_ID);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MEETING_BY_ID);) {
			
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String location = rs.getString("location");
				String date = rs.getString("date");
				String start = rs.getString("start");
				String end = rs.getString("end");
				String toastmaster = rs.getString("toastmaster");
				String ahCounter = rs.getString("ahCounter");
				String grammarian = rs.getString("grammarian");
				String evaluator = rs.getString("evaluator");
				String timer = rs.getString("timer");
				String speaker = rs.getString("speaker");
				meeting = new Meeting(id, name, location, date, start, end);
				meeting.setAhCounter(ahCounter);
				meeting.setGrammarian(grammarian);
				meeting.setSpeaker(speaker);
				meeting.setTimer(timer);
				meeting.setEvaluator(evaluator);
				meeting.setToastmaster(toastmaster);
			}
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		return meeting;
	}
	public List<Meeting> selectMeetingbyUser(String user) throws SQLException
	{
		List<Meeting> meetings = new ArrayList<>();
		System.out.println(SELECT_MEETING_BY_User);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MEETING_BY_User);) {
			
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, user);
			preparedStatement.setString(3, user);
			preparedStatement.setString(4, user);
			preparedStatement.setString(5, user);
			preparedStatement.setString(6, user);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String location = rs.getString("location");
				String date = rs.getString("date");
				String start = rs.getString("start");
				String end = rs.getString("end");
				String toastmaster = rs.getString("toastmaster");
				String ahCounter = rs.getString("ahCounter");
				String grammarian = rs.getString("grammarian");
				String evaluator = rs.getString("evaluator");
				String timer = rs.getString("timer");
				String speaker = rs.getString("speaker");
				Meeting meeting = new Meeting(id, name, location, date, start, end);
				meeting.setAhCounter(ahCounter);
				meeting.setGrammarian(grammarian);
				meeting.setSpeaker(speaker);
				meeting.setTimer(timer);
				meeting.setEvaluator(evaluator);
				meeting.setToastmaster(toastmaster);
				meetings.add(meeting);
			}
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		return meetings;
	}
	public List<Meeting> selectallmeetings() throws SQLException
	{
		List<Meeting> meetings = new ArrayList<>();
		System.out.println(SELECT_ALL_MEETINGS);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MEETINGS);) {
			
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String location = rs.getString("location");
				String date = rs.getString("date");
				String start = rs.getString("start");
				String end = rs.getString("end");
				String toastmaster = rs.getString("toastmaster");
				String ahCounter = rs.getString("ahCounter");
				String grammarian = rs.getString("grammarian");
				String evaluator = rs.getString("evaluator");
				String timer = rs.getString("timer");
				String speaker = rs.getString("speaker");
				Meeting meeting = new Meeting(id, name, location, date, start, end);
				meeting.setAhCounter(ahCounter);
				meeting.setGrammarian(grammarian);
				meeting.setSpeaker(speaker);
				meeting.setTimer(timer);
				meeting.setEvaluator(evaluator);
				meeting.setToastmaster(toastmaster);
				meetings.add(meeting);
			}
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		return meetings;
	}
	
	public boolean deleteMeeting (int id) throws SQLException
	{
		boolean rowDeleted;
		System.out.println(DELETE_MEETING);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MEETING);) {
			preparedStatement.setInt(1, id);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean updateMeeting(Meeting meeting) throws SQLException
	{
		boolean rowUpdated;
		System.out.println(UPDATE_MEETING);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MEETING);) {
			preparedStatement.setString(1, meeting.getName());
			preparedStatement.setString(2, meeting.getLocation());
			preparedStatement.setString(3, meeting.getDate());
			preparedStatement.setString(4, meeting.getStart());
			preparedStatement.setString(5, meeting.getEnd());
			preparedStatement.setInt(6, meeting.getId());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	public boolean insertSpeaker(int id, String speaker) throws SQLException
	{
		boolean rowInserted;
		System.out.println(INSERT_SPEAKER);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SPEAKER);) {
			preparedStatement.setString(1, speaker);
			preparedStatement.setInt(2, id);
			rowInserted = preparedStatement.executeUpdate() > 0;
			
		}
		return rowInserted;
	}
	public boolean insertTimer(int id, String timer) throws SQLException
	{
		boolean rowInserted;
		System.out.println(INSERT_TIMER);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TIMER);) {
		
			preparedStatement.setString(1, timer);
			preparedStatement.setInt(2, id);
			rowInserted = preparedStatement.executeUpdate() > 0;
			
		}
		return rowInserted;
		
	}
	public boolean insertToasmaster(int id, String toastmaster) throws SQLException
	{
		boolean rowInserted;
		System.out.println(INSERT_TOASTMASTER);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TOASTMASTER);) {
			preparedStatement.setString(1, toastmaster);
			preparedStatement.setInt(2, id);
			rowInserted = preparedStatement.executeUpdate() > 0;
			
		}
		return rowInserted;
	}
	public boolean insertAhCounter(int id, String ahcounter) throws SQLException
	{
		boolean rowInserted;
		System.out.println(INSERT_AHCOUNTER);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AHCOUNTER);) {
			
			preparedStatement.setString(1, ahcounter);
			preparedStatement.setInt(2, id);
			rowInserted = preparedStatement.executeUpdate() > 0;
			
		}
		return rowInserted;
	}
	public boolean insertEvaluator(int id, String evaluator) throws SQLException
	{
		boolean rowInserted;
		System.out.println(INSERT_EVALUATOR);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EVALUATOR);) {
			
			preparedStatement.setString(1, evaluator);
			preparedStatement.setInt(2, id);
			rowInserted = preparedStatement.executeUpdate() > 0;
			
		}
		return rowInserted;
	}
	public boolean insertGrammarian(int id, String grammarian) throws SQLException
	{
		boolean rowInserted;
		System.out.println(INSERT_GRAMMARIAN);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GRAMMARIAN);) {
			
			preparedStatement.setString(1, grammarian);
			preparedStatement.setInt(2, id);
			rowInserted = preparedStatement.executeUpdate() > 0;
			
		}
		return rowInserted;
	}

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				user = new User(id, name, email, password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	
	public User validateUser(String uemail, String upassword) {
		User user = null;
		System.out.println(VALIDATE_USER);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(VALIDATE_USER);) {
			preparedStatement.setString(1, uemail);
			preparedStatement.setString(2, upassword);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				user = new User(id, name, email, password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}


	public List<User> selectAllUsers() {

		List<User> users = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				users.add(new User(id, name, email, password));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			System.out.println("updated USer:"+statement);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}