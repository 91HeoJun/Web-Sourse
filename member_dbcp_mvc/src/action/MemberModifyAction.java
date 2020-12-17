package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

public class MemberModifyAction implements Action {

	private String path;

	public MemberModifyAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String current_password = request.getParameter("current_password");
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");

		MemberService service = new MemberServiceImpl();
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO)session.getAttribute("login");
		
		// 1. 현재 비번이 맞는지
		MemberVO Info =  service.islogin(vo.getUserid(), current_password);
		
		// 2. 일치하면 변경하고 세션 해제
		if (Info != null) {
			MemberService service1 = new MemberServiceImpl();
			boolean result = service1.ismodify(new_password, vo.getUserid());
			if (result) {
				session.invalidate();
			}
			
		} else {
			path ="view/modifyFrom.jsp";
		}

		return new ActionForward(path, true);
	}

}
