package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sevice.MemberService;
import sevice.MemberServiceImpl;

public class InsertAction implements Action {
	// 생성자는 객체 생성시 필요 => new 할떄 무조건 호출
	// 생성자 오버로딩  -> 전제조건 : 매개변수가 달라야함
	// public InsertAction(){} => default 생성자
	// public InsertAction(String name){}
	// public InsertAction(String name, int age){}
	// 클래스 안에 생성자가 하나도 없을 경우 컴파일러가 default 생성자를 자동으로 생성해준다.
	
		private String path;
		
		public InsertAction(String path) {
			this.path = path;
		}

		@Override
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			// ~Pro.jsp에서 했던 작업
			// request.getParameter()
			String name = request.getParameter("name");
			System.out.println("insert_Action name : " + name);
			
			// DB 작업을 InsertService에 부탁
			MemberService service = new MemberServiceImpl();
			service.insertMember(name);
			
			// session에 담으면 => sendRedirect를 사용하고 sendRedirect로 이동 시에는 true로
			// request에 담으면 => forward를 사용하고 forward로 이동 시에는 false로
			return new ActionForward(path, true);
		}
}
