package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//생성자, 게터세터, tostring => 롬복
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

	private int no;
	private String username;
	private int birthyear;
	private String addr;
	private String mobile;
	
}
