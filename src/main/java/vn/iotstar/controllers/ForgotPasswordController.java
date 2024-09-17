package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.services.impl.UserService;

@WebServlet("/forgot_pass")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService ser = new UserService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgot_pass.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String alertMsg = "";
		if (ser.Update_pass(username,password )) {
			alertMsg  = "Successfully!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgot_pass.jsp").forward(req, resp);
		}
		else {
			alertMsg  = "Incorrect username!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgot_pass.jsp").forward(req, resp);
		}
	}
	
}
