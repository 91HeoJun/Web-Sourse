package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FourServlet
 */
@WebServlet("/FourServlet")
public class FourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사직연산 결과
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("op");
		
		int result = 0;
		
		switch (op) {

		case "+":
			result = num1 + num2;

			break;
		case "-":
			result = num1 - num2;

			break;
		case "*":
			result = num1 * num2;

			break;
		case "/":
			result = num1 / num2;

			break;
						
		default:
			break;
		}
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title> 사칙연산 프로그램 </title></head>");
		out.print("<body><h2> 연산 결과 </h2><h3>");
		out.printf("%d %s %d = %d", num1, op, num2, result);
		out.print("</h3></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
