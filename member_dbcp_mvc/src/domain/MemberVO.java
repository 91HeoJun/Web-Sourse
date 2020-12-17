package domain;

import lombok.Data;

@Data
// @Data = getter, setter, equals, default constructor, hashCode, toString

public class MemberVO {
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
}
