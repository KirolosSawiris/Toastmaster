package com.app.entity.web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.entity.dao.DAOfactory;
import com.app.entity.model.Meeting;
import com.app.entity.model.User;


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOfactory factory;
	boolean login = false;
	User ruser;
	
	
	public void init() {
		factory = new DAOfactory();
		//ruser = factory.validateUser(remail, rpassword);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/register":
				registerUser(request, response);
				break;
			case"/logout":
				logoutUser(request, response);
				break;
			case"/meeting":
				meetinginfo(request, response);
				break;
			case"/search":
				meetingSearch(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void logoutUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		ruser = null;
		request.getSession().invalidate();
		//RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		//dispatcher.forward(request, response);
		response.sendRedirect("list");
	}
	private void meetinginfo(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		
		
	}
	private void meetingSearch(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		if(ruser == null) {
			String remail = request.getParameter("email");
			String rpassword = request.getParameter("password");
			ruser = factory.validateUser(remail, rpassword);
			if (ruser == null)
			{
				request.setAttribute("status", "failed");
				System.out.println("faild login");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
			}
			if(ruser != null) {
				List<Meeting> allMeetings = factory.selectallmeetings();
				List<Meeting> listMeeting = new ArrayList<>();
				String search = request.getParameter("search");
				for (Meeting meeting : allMeetings)
				{
					if(meeting.getName().contains(search)) {
						listMeeting.add(meeting);
					}
				}
				request.setAttribute("listMeeting", listMeeting);
				request.setAttribute("username", ruser.getName());
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
				dispatcher.forward(request, response);
			}
		
	}
	
	private void registerUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("re_pass");
		System.out.println(pass);
		if (pass.equals(repass))
		{
			User user = new User(name,email,pass);
			factory.insertUser(user);
			response.sendRedirect("list");
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
			request.setAttribute("status", "failed");
			//response.sendRedirect("register");
		}
		
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		//List<User> listUser = factory.selectAllUsers();
		if(ruser == null) {
		String remail = request.getParameter("email");
		String rpassword = request.getParameter("password");
		ruser = factory.validateUser(remail, rpassword);
		if (ruser == null)
		{
			request.setAttribute("status", "failed");
			System.out.println("faild login");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		}
		if(ruser != null) {
			List<Meeting> listMeeting = factory.selectallmeetings();
			request.setAttribute("listMeeting", listMeeting);
			request.setAttribute("username", ruser.getName());
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("username", ruser.getName());
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		request.setAttribute("username", ruser.getName());
		int id = Integer.parseInt(request.getParameter("id"));
		Meeting existingMeeting = factory.selectMeeting(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("meeting", existingMeeting);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String date = request.getParameter("date");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		Meeting newMeeting = new Meeting(name, location, date, start, end);
		factory.insertMeeting(newMeeting);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String date = request.getParameter("date");
		String start = request.getParameter("start");
		String end = request.getParameter("end");

		Meeting meeting = new Meeting(id, name, location, date, start, end);
		factory.updateMeeting(meeting);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		factory.deleteMeeting(id);
		response.sendRedirect("list");

	}

}