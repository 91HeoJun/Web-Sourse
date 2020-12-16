package sevice;

import java.sql.Connection;
import java.util.List;

import domain.MemberVO;
import persistence.MemberDAO;

import static persistence.JDBCUtil.*;

public class MemberServiceImpl implements MemberService {
	
	private Connection con;
	private MemberDAO dao;
	
	public MemberServiceImpl() {
		con = getConnection();
		// DB작업
		dao = new MemberDAO(con);
	}

	@Override
	public boolean insertMember(String name) {
		System.out.println("insert_Service : " + name);
		
		boolean insertFlag = false;
		if (dao.insert(name)>0) {
			insertFlag = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return insertFlag;
	}

	@Override
	public boolean updateMember(String name) {
		System.out.println("Delete Service : " + name);
		return dao.delete(name)>0?true:false;
		
	}

	@Override
	public boolean deleteMember(String name) {

		return false;
	}

	@Override
	public MemberVO getMember(String name) {

		return null;
	}

	@Override
	public List<MemberVO> getList() {

		return null;
	}

}
