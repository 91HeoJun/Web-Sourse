package action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ActionForward {

	private String path; 	  // 어디로 갈것인가?
	private boolean redirect; // 어떤 방식(forward/sendRedirect)으로 갈것인가
	// boolean 타입은 get올 가져올 수 없음!
}
