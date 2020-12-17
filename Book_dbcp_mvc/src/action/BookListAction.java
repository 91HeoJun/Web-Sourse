package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import sevice.BookService;
import sevice.BookServiceImpl;

public class BookListAction implements Action {

	private String path;
	
	public BookListAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BookService service = new BookServiceImpl();
		List<BookVO> list = service.getlList();
		
		request.setAttribute("list", list);
		
		return new ActionForward(path, false);
	}

}
