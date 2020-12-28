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
			
		} else {
			// 작성 성공 시 DAO에서 isEmpty를 걸었으므로 그냥 qWrite.do로 보낼 시 nullPoint가 뜸. 따로 불러올 내용은 없으므로, page를 1로 보내고 criteria, keyword는 비워서 처리할 것.
			path += "?page=1&criteria=&keyword=";
		}
		
		return new ActionForward(path, true);
	}

}