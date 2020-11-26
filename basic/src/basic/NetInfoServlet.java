package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NetInfoServlet
 */
@WebServlet("/Network")
public class NetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>Request 정보</title></head>");
		out.print("<body><h3>네트워크 정보</h3><ul>");
		out.printf("<li>Request Scheme : %s</li>", request.getScheme());
		out.printf("<li>Server Name : %s</li>", request.getServerName());
		out.printf("<li>Server Address : %s</li>", request.getLocalAddr());
		out.printf("<li>Server Port : %s</li>", request.getServerPort());
		out.printf("<li>Client Address : %s</li>", request.getRemoteAddr());
		out.printf("<li>Client Host : %s</li>", request.getRemoteHost());
		out.printf("<li>Client Port : %s</li>", request.getRemotePort());
		out.printf("<li>Client user-Agent : %s</li>", request.getHeader("user-agent"));
		
		out.print("</body></html>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
