package service;

import java.sql.Connection;

import domain.MemberVO;
import persistence.MemberDAO;
import static persistence.JDBCUtil.*;

public class MemberServiceImpl implements MemberService {

	Connection con;
	MemberDAO dao;

	public MemberServiceImpl() {
		con = getConnection();
		dao = new MemberDAO(con);

	}

	@Override
	public MemberVO islogin(String userid, String password) {
		MemberVO member = dao.isLogin(userid, password);
		close(con);
		return member;
	}

	@Override
	public boolean isjoin(MemberVO member) {
		boolean joinFlag = false;
		
		int result = dao.isJoin(member);

		if (result > 0) {
			joinFlag = true;
			commit(con);
			
		} else {
			rollback(con);
		}
		close(con);
		return joinFlag;
	}

	@Override
	public boolean ismodify(String password, String userid) {
		boolean updateFlag = false;

		int result = dao.isModify(password, userid);
		if (result > 0) {
			updateFlag = true;
			commit(con);
		} else {
			rollback(con);
		}

		return updateFlag;
	}

	@Override
	public boolean isTerminate(String userid, String password) {
		int result = dao.isTerminate(userid, password);
		boolean leaveFlag = false;

		if (result > 0) {
			leaveFlag = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return leaveFlag;
	}

	@Override
	public boolean isCheck(String userid) {
		boolean result = dao.checkID(userid);
		close(con);
		
		return result;
	}

}
