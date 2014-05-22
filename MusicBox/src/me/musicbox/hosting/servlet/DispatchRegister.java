package me.musicbox.hosting.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.musicbox.hosting.dao.Role;
import me.musicbox.hosting.dao.User;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

import test.dob;

public class DispatchRegister extends BaseServlet {
	private static final long serialVersionUID = 1L;
    
    public DispatchRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProccess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProccess(request, response);
	}
	
	private void requestProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// Get PrintWriter to write back to client
		PrintWriter out = response.getWriter();
		
		String form = getPageName(request.getRequestURI());
		
		// Get contextPath for any external files such as css, js path
		String contextPath = getContextPath(); 
		
		// retrieve number of current user online
		int count = getNumberUserOnline(request);
		
		
		STGroup templates = getSTGroup();
		ST page = templates.getInstanceOf("temp");
		
		String login = "login";
		String loginLabel = "Log In";
		String username = request.getRemoteUser();
		if (username != null){
			login = "logout";
			loginLabel = "Log Out";
		}
		
		page.add("loginOrOut", login);
		page.add("loginOrOutLabel", loginLabel);
		page.add("username", username);
		page.add("contextPath", contextPath);
		page.add("title", "Register");
		page.add("onlineUsers", count);
		
		ST body;
		
		if (form.equalsIgnoreCase("registerform")){
			List<dob> month = new ArrayList<dob>();
			month.add(new dob("month"));
			for (int i = 1; i <= 12; i++)
				month.add(new dob(""+i));
			
			List<dob> day = new ArrayList<dob>();
			day.add(new dob("day"));
			for (int i = 1; i <= 31; i++)
				day.add(new dob(""+i));
			
			List<dob> year = new ArrayList<dob>();
			year.add(new dob("year"));
			for (int i = 2014; i >= 1950; i--)
				year.add(new dob(""+i));
			
			body = templates.getInstanceOf("register");
			body.add("contextPath", contextPath);
			body.add("month", month);
			body.add("day", day);
			body.add("year", year);
			page.add("body", body.render());
		}else{
			String userName = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String gender = request.getParameter("gender");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String year = request.getParameter("year");
			
			Date dob = null;
			Date createdDate = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
			String today = sdf.format(new Date());
			
			try {
				createdDate = sdf.parse(today);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				dob = new SimpleDateFormat("yyyy/mm/dd").parse(year+"/"+month+"/"+day);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// create newUser and set its' value
			User newUser = new User();
			newUser.setUsername(userName);
			newUser.setEmail(email);
			newUser.setPass(password);
			newUser.setFirstName(firstName);
			newUser.setLastName(lastName);
			newUser.setGender(gender);
			newUser.setDob(dob);
			newUser.setCreateDate(createdDate);
			Role role = service.getRoleByType("user");
			
			newUser.setRole(role);
			
			// add newUser to database
			service.addUser(newUser);
			
			
			page.add("body", "register success!");
		}
		out.println(page.render());
		out.flush();
	}
	
	private String getPageName(String url){
		int beginIndex = url.lastIndexOf('/') + 1;
		int endIndex = url.lastIndexOf('.');
		endIndex = endIndex < 0 ? url.length() : endIndex;
		String page = url.substring(beginIndex,endIndex);
		
		return page;
	}
}
