package service;

import java.sql.Connection;
import java.util.List;

import domain.UserVO;
import persistence.UserDAO;
import static persistence.JDBCUtil.*;

public class UserServiceImpl implements UserService {

	Connection con;
	UserDAO dao;

	public UserServiceImpl() {
		con = getConnection();
		dao = new UserDAO(con);
	}

	@Override
	public boolean insertUser(String username, String birthyear, String addr, String mobile) {
		int result = dao.inset(username, birthyear, addr, mobile);

		// DB작업 결과를 action에게 보내기 - commit, rollback
		boolean insertFlag = false;
		
		if (result > 0) {
			insertFlag = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return insertFlag;
	}

	@Override
	public boolean updateUser(String addr, String mobile, int no) {
		int result = dao.updateUser(addr, mobile, no);
		
		boolean updateFlag = false;
		
		if (result > 0) {
			updateFlag = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return updateFlag;
	}

	@Override
	public boolean deleteUser(int no) {
		boolean deleteFlag = false;
		int result = dao.deleteUser(no);
		
		if (result > 0) {
			deleteFlag = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return deleteFlag;
	}

	@Override
	public UserVO getUser(int no) {
		UserVO user = dao.getUser(no);
		close(con);
		return user;
	}

	@Override
	public List<UserVO> getUserList() {
		List<UserVO> list = dao.select();
		close(con);
		return list;
	}

}
