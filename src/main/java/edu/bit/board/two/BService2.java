package edu.bit.board.two;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import edu.bit.board.vo.BoardVO;


@Service
public class BService2 {
	
	@Inject
	SqlSession sqlSession;
	
    public List<BoardVO> selectBoardList()throws Exception {
		return sqlSession.selectList("board.selectBoardList");
    }
}
