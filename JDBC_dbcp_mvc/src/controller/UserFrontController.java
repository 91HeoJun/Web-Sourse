package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.Actionforward;

/**
 * Servlet implementation class UserFrontController
 */
@WebServlet("*.do")
public class UserFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 어디서 왔는지, 어디로 보낼껀지
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd =  requestURI.substring(contextPath.length());
		
		// 요청에 맞는 Action 생성하기 => UserActionFactory
		UserActionFactory factory = UserActionFactory.getInstance();
		Action action = factory.action(cmd);
		
		// 생성된 action에게 일 시키기
		Actionforward af = null;
		try {
			af = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 이동 방식에 따라 페이지 이동
		if (af.isRedirect()) { // sendRedirect(true)
			response.sendRedirect(af.getPath());
		} else { // forward(false)
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
