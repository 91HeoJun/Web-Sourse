package service;

import domain.MemberVO;

public interface MemberService {
	// crud
	
	public MemberVO islogin(String userid, String password);
	public boolean isjoin(MemberVO member);
	public boolean ismodify(String password, String userid);
	public boolean isTerminate(String userid, String password);

	
}
