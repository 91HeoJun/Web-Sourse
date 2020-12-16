package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserInsertAction implements Action {

	private String path;
	
	public UserInsertAction(String path) {
		this.path = path;
	}
	
	@Override
	public Actionforward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//add.jsp에서 사용자 입력값 가져오기
		String username = request.getParameter("username");
		String birthyear = request.getParameter("birthyear");
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");
		
		// Service에게 일 시키기
		UserService service = new UserServiceImpl();
		boolean insertFlag = service.insertUser(username, birthyear, addr, mobile);
		
		if (!insertFlag) {
			path = "add.jsp";
		}
		
		// 작업 결과에 따라 페이지 이동방식 결정 - sendRedirect(true)
		
		return new Actionforward(path, true);
	}

}
