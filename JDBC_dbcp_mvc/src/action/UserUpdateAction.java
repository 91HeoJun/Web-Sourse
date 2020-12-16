package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserServiceImpl;

public class UserUpdateAction implements Action {
	
	private String path;

	public UserUpdateAction(String path) {
		this.path = path;
	}



	@Override
	public Actionforward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		
		UserService service = new UserServiceImpl();
		UserVO vo = service.getUser(no);
		
		request.setAttribute("vo", vo);
		
		return new Actionforward(path, false);
	}

}
