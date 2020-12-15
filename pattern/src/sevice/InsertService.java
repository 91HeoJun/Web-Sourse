package sevice;

import persistence.MemberDAO;

public class InsertService {
	public void insertMember(String name) {
		System.out.println("insert_Service : " + name);
		
		// DB작업
		MemberDAO dao = new MemberDAO();
		dao.insert(name);
	}
	
}
