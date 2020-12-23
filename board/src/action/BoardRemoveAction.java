package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardRemoveAction implements Action {

	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String password = request.getParameter("password");

		BoardService service = new BoardServiceImpl();
		boolean flag = service.deleteArticle(bno, password);

		if (!flag) path = "../qna_board_pwdCheck.jsp";
		return new ActionForward(path, true);
	}
}