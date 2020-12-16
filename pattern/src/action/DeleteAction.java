package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sevice.MemberService;
import sevice.MemberServiceImpl;


public class DeleteAction implements Action {
	
	private String path;
	
	public DeleteAction(String path) {
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParameter
		
		String name = request.getParameter("name");
		System.out.println("Delete Action : " + name);
		
		MemberService service = new MemberServiceImpl();
		service.deleteMember(name); //true OR false
		
		// 어디로 갈것인지?(~~.jsp OR ~~.do), 어떤 방식으로 갈 것인지?(forward OR sendRedirect)
		// ActionForward에 상기 내용을 넣음
		
		return new ActionForward(path, true);
	}
}
