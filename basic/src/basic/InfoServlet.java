package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String ID = request.getParameter("ID");
		String PW = request.getParameter("PW");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");

		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html><head>");
		out.print("<title>사용자 정보</title>");
		out.print("<style> li{ list-style-type: none } </style> ");
		out.print("</head>");
		out.print("<body><h1>사용자 정보</h1>");
		out.print("<ul>");
//		for (String userinfo : user) {
			out.print("<li>이름 : "+name+"</li>");
			out.print("<li>아이디 : "+ID+"</li>");
			out.print("<li>비밀번호 : "+PW+"</li>");
			out.print("<li>성별 : "+gender+"</li>");
			out.print("<li>직업 : "+job+"</li>");
			
//		}
		out.print("</ul></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
