package sevice;

import java.util.List;

import domain.MemberVO;

public interface MemberService { // 인터페이스에 있는 메소드는 추상메소드(구현부분'{}'이 없는것)
	// DAO와 연동할 클래스 - CRUD
	public boolean insertMember(String name);
	public boolean updateMember(String name);
	public boolean deleteMember(String name);
	
	public MemberVO getMember(String name);
	public List<MemberVO> getList();
	

}
