package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
// HTML의 action과 WebServlet은 동일하게 맞춰야함.
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//post 방식에서 깨지는 한글 보완
		request.setCharacterEncoding("utf-8");
		
		// 사용자가 보낸 값 가져오기
		String username = request.getParameter("username");
		String age = request.getParameter("age");

		// 사용자가 보낸 값 확인 -> 화면 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title> 결과 값 확인 </title></head>");
		out.print("<body><h2>결과 값 확인하기</h2>");
		out.print("<ul><li>username : "+username+"</li>");
		out.print("<li>age : "+age+"</li></ul>");
		out.print("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
