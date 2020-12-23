package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardListAction implements Action {

	private String path;
	
	public BoardListAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardService service = new BoardServiceImpl();
		List<BoardVO> list = service.getList();
		
		request.setAttribute("list", list);
		return new ActionForward(path, false);
	}

}
