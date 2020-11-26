package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dogServlet
 */
@WebServlet("/DogServlet")
public class DogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자의 선택 값 가져오기
		request.setCharacterEncoding("utf-8");
		String[] dog = request.getParameterValues("dog");
//		System.out.println(Arrays.toString(dog));
		
		// 화면출력
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>선택한 강아지</title><head>");
		out.print("<body><h2>선택 결과</h2>");
		out.print("<ul>");
		for (String s:dog) {
			out.print("<li>"+s+"</li>");
	}
		out.print("</ul></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
