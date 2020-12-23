package action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.FileUploadUtil;
import domain.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardWriteAction implements Action {

	private String path;
	
	public BoardWriteAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParameter();

		FileUploadUtil utils = new FileUploadUtil();
		Map<String, String> map = utils.uploadFile(request);
		
		BoardVO board = new BoardVO();
		
		// map에 들어있는 폼 요소들 VO에 옮겨주기
		board.setName(map.get("name"));
		board.setTitle(map.get("title"));
		board.setContent(map.get("content"));
		board.setPassword(map.get("password"));
		
		if (map.containsKey("attach"))
			board.setAttach(map.get("attach"));
		
		// service 호출
		BoardService service = new BoardServiceImpl();
		boolean flag = service.insertArticle(board);
		
		if (!flag) {
			path = "view/qna_board_write.jsp";
		}
		
		return new ActionForward(path, true);
	}

}