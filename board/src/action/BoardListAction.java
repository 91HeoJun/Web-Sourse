package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BoardVO;
import domain.PageVO;
import domain.SearchVO;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardListAction implements Action {

	private String path;	
	public BoardListAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 페이지 나누기
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int amount = 10;	// 한 페이지 당 보여줄 게시물 수
		
		String criteria = request.getParameter("criteria");
		String keyword = request.getParameter("keyword");

		// 검색기능 + 페이지 나누기
		SearchVO searchVO = new SearchVO();
		searchVO.setCriteria(criteria);
		searchVO.setKeyword(keyword);
		searchVO.setPage(page);
		searchVO.setAmount(amount);
		
		// 서비스 요청
		BoardService service = new BoardServiceImpl();
		List<BoardVO> list = service.getList(searchVO);
		
		// 전체 행 수 가져오기
		service = new BoardServiceImpl();
		int totalRow = service.getRows(criteria, keyword);
		
		PageVO info = new PageVO(totalRow, searchVO);
		
		// 요청받은 결과 담기
		request.setAttribute("info", info); // searchVO 포함된 상태
		// 검색결과
		request.setAttribute("list", list);
		
		return new ActionForward(path, false);
	}
}