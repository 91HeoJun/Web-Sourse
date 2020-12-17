package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sevice.BookService;
import sevice.BookServiceImpl;

public class BookDeleteAction implements Action {
	
	private String path;

	public BookDeleteAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int code = Integer.parseInt(request.getParameter("code"));

		BookService service = new BookServiceImpl();
		boolean flag = service.deleteBook(code);
		
		if (!flag) {
			path = "index.jsp";
		}
		return new ActionForward(path, true);
	}

}
