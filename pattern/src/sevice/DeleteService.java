package sevice;

import persistence.MemberDAO;

public class DeleteService {
	public void deleteMember(String name) {
		System.out.println("Delete Service : " + name);
		
		MemberDAO dao = new MemberDAO();
		dao.delete(name);
	}
	
}
