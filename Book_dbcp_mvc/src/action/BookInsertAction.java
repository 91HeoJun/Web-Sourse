package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import sevice.BookService;
import sevice.BookServiceImpl;

public class BookInsertAction implements Action {

	private String path;
	
	public BookInsertAction(String path) {
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BookVO vo = new BookVO();
		vo.setCode(Integer.parseInt(request.getParameter("code")));
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		
		BookService service = new BookServiceImpl();
		boolean flag = service.insertBook(vo);
		
		if (!flag) {
			path = "index.jsp";
		}
		
		return new ActionForward(path, true);
	}

}
