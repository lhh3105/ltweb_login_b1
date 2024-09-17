package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate(); // xoa sesstion neu ton tai

        // Xóa cookie bằng cách đặt thời gian tồn tại là 0
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("sessionId")) {  // Thay "sessionId" bằng tên cookie bạn sử dụng
                    cookie.setMaxAge(0);  // Đặt thời gian tồn tại của cookie là 0
                    cookie.setPath("/");  // Đảm bảo cookie được xóa trên toàn bộ ứng dụng
                    resp.addCookie(cookie);  // Gửi cookie đã xóa đến client
                }
            }
        }

        // Chuyển hướng người dùng đến trang login hoặc trang chính
        resp.sendRedirect("/ltweb4/login");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
