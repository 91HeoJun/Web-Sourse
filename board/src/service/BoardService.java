package service;

import java.util.List;

import domain.BoardVO;

public interface BoardService {

	// CRUD
	public boolean insertArticle(BoardVO vo);
	public boolean updateArticle(BoardVO vo);
	public boolean deleteArticle(int bno, String password);

	// 조회(전체 / 개별)
	public List<BoardVO> getList();
	public BoardVO getRow(int bno);
	
	// 조회수 업데이트
	public boolean hitUpdate(int bno);

}