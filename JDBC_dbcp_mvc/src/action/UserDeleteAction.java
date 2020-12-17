package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserDeleteAction implements Action {

	private String path;
	
	public UserDeleteAction(String path) {
		this.path = path;
	}
	
	@Override
	public Actionforward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		
		UserService service = new UserServiceImpl();
		boolean flag = service.deleteUser(no); 
		
		if (!flag) {
			path = "select.do";
		}
		return new Actionforward(path, true);
	}

}
