package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

/**
 * Servlet implementation class FrontContrller
 */
@WebServlet("*.do") // select.do, insert.do, modify.do ~~ 전부 다 받음
public class FrontContrller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8080/pattern/update.do
		// http://localhost:8080/pattern/select.do
		// http://localhost:8080/pattern/delete.do
		// http://localhost:8080/pattern/insert.do
		
		request.setCharacterEncoding("utf-8");
		
		String requestURI = request.getRequestURI();			 // 결과 -> /pattern/update.do
		String contextPath = request.getContextPath(); 			 // 결과 -> /pattern
		String cmd = requestURI.substring(contextPath.length()); // 결과 -> /update.do
		
		ActionFactory factory = ActionFactory.getInstance();
		Action action = factory.action(cmd);

		
		ActionForward af = null;
		
		try {
			af = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (af.isRedirect()) { // true => sendRedirect
			response.sendRedirect(af.getPath());
		} else { // false => forward
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
