package service;

import java.util.List;

import domain.BoardVO;
import domain.SearchVO;

public interface BoardService {

	// CRUD
	public boolean insertArticle(BoardVO vo);
	public boolean updateArticle(BoardVO vo);
	public boolean deleteArticle(int bno, String password);

	// 조회(전체+검색)
	public List<BoardVO> getList(SearchVO searchVO);

	// 조회(개별)
	public BoardVO getRow(int bno);
	
	// 조회수 업데이트
	public boolean hitUpdate(int bno);
	
	// 댓글
	public boolean articleReply(BoardVO vo);
	
	// 게시글 전체 행 수
	public int getRows(String criteria, String keyword);

	// 검색
//	public List<BoardVO> searchList(SearchVO search);

}