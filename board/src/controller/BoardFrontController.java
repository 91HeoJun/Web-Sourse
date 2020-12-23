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

@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");

		// 요청판별
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());

		// 요청따라 Action 생성
		BoardActionFactory factory = BoardActionFactory.getInstance();
		Action action = factory.action(cmd);

		// 생성된 Action에 일 시기키
		ActionForward af = null;
		try {
			af = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 리턴 결과따라 지정방식으로 이동
		if (af.isRedirect()) {
			response.sendRedirect(af.getPath());
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(af.getPath());
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
