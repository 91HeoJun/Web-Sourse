package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import service.UserServiceImpl;

public class UserModifyAction implements Action {

	private String path;
	
	public UserModifyAction(String path) {
		this.path = path;
	}

	@Override
	public Actionforward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		String addr = request.getParameter("addr");
		String mobile = request.getParameter("mobile");
		
		UserService service = new UserServiceImpl();
		boolean flag =  service.updateUser(addr, mobile, no);
		
		if (!flag) { // 수정페이지
			path = "update.do";
		}
		
		return new Actionforward(path, true);
	}

}
