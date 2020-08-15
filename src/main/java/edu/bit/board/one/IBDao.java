package edu.bit.board.one;

import java.util.List;

import edu.bit.board.vo.BoardVO;

public interface IBDao {
	
	public List<BoardVO> listDao();
/*	public BDto ContentDao(String bId);
	public void deleteDao(int bId);
	
	public void modifyDao(@Param("bId") int bId,
			@Param("bName") String bName,
			@Param("bTitle") String bTitle,
			@Param("bContent") String bContent);
	
	public void updateDao(BDto bdto);*/
}
