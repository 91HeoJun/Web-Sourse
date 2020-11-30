package test_Jun;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test_Jun
 */
@WebServlet("/test_Jun")
public class test_Jun extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String pwc= request.getParameter("pwc");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head>");
		out.print("<title> 사용자 입력 정보</title>");
		out.print("</head>");
		out.print("<body><h1>사용자 정보</h1>");
		out.print("<ul>");
		out.print("<li>아이디 : "+id+"</li>");
		out.print("<li>비밀번호 : "+pw+"</li>");
		out.print("<li>비밀번호확인 : "+pwc+"</li>");
		out.print("<li>이름 : "+name+"</li>");
		out.print("<li>성별 : "+gender+"</li>");
		out.print("<li>이메일 : "+email+"</li>");
		out.print("</ul></body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
