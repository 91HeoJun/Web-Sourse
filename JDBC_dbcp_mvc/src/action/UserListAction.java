package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.UserVO;
import service.UserService;
import service.UserServiceImpl;

public class UserListAction implements Action {

	private String path;
	public UserListAction(String path) {
		this.path = path;
	}
	
	@Override
	public Actionforward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.getParamete -> X
		// service에 일 토스
		
		UserService service = new UserServiceImpl();
		List<UserVO> list = service.getUserList();
		
		// 이동방식 결정한 후 ActionForward 객체생성
		request.setAttribute("list", list); 
		return new Actionforward(path, false);
	}

}
