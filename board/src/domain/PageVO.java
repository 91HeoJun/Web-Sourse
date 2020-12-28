package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageVO {
	
	// 페이지 나누기 정보를 담을 객체
	
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private SearchVO search;
	private int totalRow;
	
	public PageVO(int totalRow, SearchVO search) {
		this.totalRow = totalRow;
		this.search = search;
		
		// 현재 화면의 마지막 페이지 수
		// 3 => 10
		endPage = (int)(Math.ceil(search.getPage()/10.0))*10;
		// 현재 화면의 시작 페이지 수
		startPage = endPage-9;
		
		
		// 끝나는 페이지가 10개가 안되는 경우 다시 계산
		int realEnd = (int)(Math.ceil((totalRow/1.0)/search.getAmount()));

		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
	}

}
