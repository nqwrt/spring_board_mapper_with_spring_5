package edu.bit.board.transaction;

import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardTransactionTest {
	
	@Inject
	BoardMapper mapper;
	
/*	@Inject
	private TransactionTestService service;
	
	public void testTrasction() {
		service.transionTest1();
	}*/
	
	@Transactional
	@Rollback(false)
	@Test
	public void testTrasction() {
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");
		
		mapper.insertBoard(boardVO);
		
		
		boardVO.setbContent("Ʈ�����2");
		boardVO.setbName("Ʈ�����2");
		boardVO.setbTitle("Ʈ�����2");
		
		boardVO = null;
		mapper.insertBoard(boardVO);
		
	}
	
	//uncheckedExeption
	@Transactional
	@Rollback(false)
	@Test
	public void testTrasctionUnCheckedException() {
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����3");
		boardVO.setbName("Ʈ�����3");
		boardVO.setbTitle("Ʈ�����3");
		
		mapper.insertBoard(boardVO);
		
		throw new RuntimeException("RuntimeException for rollback");
	}
	
	//CheckedExeption �׽�Ʈ
	@Transactional
	@Rollback(false)
	@Test
	public void testTrasctionCheckedException() throws SQLException  {
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����4");
		boardVO.setbName("Ʈ�����4");
		boardVO.setbTitle("Ʈ�����4");
		
		mapper.insertBoard(boardVO);
		
		throw new SQLException("RuntimeException for rollback");
	}

}
