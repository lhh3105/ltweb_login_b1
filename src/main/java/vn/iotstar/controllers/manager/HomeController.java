package vn.iotstar.controllers.manager;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;

@WebServlet(urlPatterns={"/manager/home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		UserModel u=(UserModel) session.getAttribute("account");
		req.setAttribute("username", u.getUsername());
		req.getRequestDispatcher("/views/manager/home.jsp").forward(req, resp);
	}
	

	
	
	

}
