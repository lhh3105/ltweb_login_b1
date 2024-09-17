package vn.iotstar.controllers;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.services.impl.UserService;


@WebServlet("/register")
public class RegisterController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	UserService service = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String username = req.getParameter("username");
		
		String alertMsg = "";
		if (service.FindByEmail(email)!=null) {
			alertMsg = "Email is existed!";
			req.setAttribute("alertMsg", alertMsg );
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}
		
		if (service.FindByUserName(username)!=null) {
			alertMsg = "Username is existed!";
			req.setAttribute("alertMsg", alertMsg );
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}
		
		if (service.Insert(email, username, password)) {
			alertMsg = "Successfully!";
			req.setAttribute("alertMsg", alertMsg );
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}
		
		
	}

}
