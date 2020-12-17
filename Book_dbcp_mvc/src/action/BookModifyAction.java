package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import sevice.BookService;
import sevice.BookServiceImpl;

public class BookModifyAction implements Action {

	private String path;
	
	public BookModifyAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BookVO vo = new BookVO();
		
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setCode(Integer.parseInt(request.getParameter("code")));
		
		BookService service = new BookServiceImpl();
		boolean flag = service.updateBook(vo);
		
		if (!flag) {
			path = "";
		}
		
		return new ActionForward(path, true);
	}

}
