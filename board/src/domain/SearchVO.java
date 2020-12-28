package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchVO {

	private String criteria; // 검색조건
	private String keyword;	 // 검색어
	
	// 페이지 나누기를 위한 변수
	private int page;	// 현재 페이지 번호
	private int amount;	// 페이지당 게시물 수
	
}
