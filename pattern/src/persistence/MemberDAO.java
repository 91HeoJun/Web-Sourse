package persistence;

public class MemberDAO {

	public int insert(String name) {
		System.out.println("MemberDAO Insert :" +name);
		return 1;
	}
	public int delete(String name) {
		System.out.println("MemberDAO Delete :" +name);
		return 1;
	}
	
}
