package edu.bit.board.page;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PagingTest {
	
	@Inject
	BoardMapper boardMapper;
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		list.forEach(board->log.info(board.getbId()));
		
		
		cri.setPageNum(2);
		cri.setAmount(10);
		
		list = boardMapper.getListWithPaging(cri);
		list.forEach(board->log.info(board.getbId()));
		
		cri.setPageNum(1);
		cri.setAmount(10);
		
		list = boardMapper.getListWithPaging(cri);
		list.forEach(board->log.info(board.getbId()));
	}

}
