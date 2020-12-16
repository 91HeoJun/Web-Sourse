package service;

import java.util.List;

import domain.UserVO;

public interface UserService {
	
	// CRUD 서비스를 할 수 있도록 메소드 구성
	public boolean insertUser(String username, String birthyear, String addr, String mobile);
	public boolean updateUser(String addr, String mobile, int no);
	public boolean deleteUser(int no);
	
	public UserVO getUser(int no);
	public List<UserVO> getUserList();

}
