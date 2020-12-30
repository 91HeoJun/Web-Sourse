package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import service.MemberService;
import service.MemberServiceImpl;


@AllArgsConstructor
public class MemeberCheckIdAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		String userid = request.getParameter("userid");
		MemberService service = new MemberServiceImpl();

		boolean dupID = service.isCheck(userid);
		
		if (dupID) { // 사용할 수 없음
			request.setAttribute("dupID", "false");
		} else {
			request.setAttribute("dupID", "ture");
		}
		
		return new ActionForward(path, false);
	}
}