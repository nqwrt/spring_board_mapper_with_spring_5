package edu.bit.board.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.board.mapper.BoardMapper;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class TransactionTestService {
	private BoardMapper mapper;

	@Transactional
	public void transionTest1() {

		log.info("transionTest1()�׽�Ʈ ");
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");

		mapper.insertBoard(boardVO);

		boardVO.setbContent("Ʈ�����2");
		boardVO.setbName("Ʈ�����2");
		boardVO.setbTitle("Ʈ�����2");

		mapper.insertBoard(boardVO);
	}

	public void transionTest2() {

		log.info("transionTest2()�׽�Ʈ ");
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");

		mapper.insertBoard(boardVO);

		boardVO.setbContent("Ʈ�����2");
		boardVO.setbName("Ʈ�����2");
		boardVO.setbTitle("Ʈ�����2");

		// �Ϻη� Ʈ������� ���� ��
		boardVO = null;
		mapper.insertBoard(boardVO);
	}

	@Transactional
	public void transionTest3() {

		log.info("transionTest3()�׽�Ʈ ");
		BoardVO boardVO = new BoardVO();

		boardVO.setbContent("Ʈ�����1");
		boardVO.setbName("Ʈ�����1");
		boardVO.setbTitle("Ʈ�����1");

		mapper.insertBoard(boardVO);

		boardVO.setbContent("Ʈ�����2");
		boardVO.setbName("Ʈ�����2");
		boardVO.setbTitle("Ʈ�����2");

		// �Ϻη� ������ ���� �� //Ʈ������� ���� ��
		boardVO = null;
		mapper.insertBoard(boardVO);
	}

	//uncheckedExeption(�ѹ� ��)
	@Transactional
	public void transionTest4() {
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����4");
		boardVO.setbName("Ʈ�����4");
		boardVO.setbTitle("Ʈ�����4");

		mapper.insertBoard(boardVO);

		throw new RuntimeException("RuntimeException for rollback");
	}

	//CheckedExeption �׽�Ʈ(�ѹ� ����)
	@Transactional
	public void transionTest5() throws SQLException {
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����5");
		boardVO.setbName("Ʈ�����5");
		boardVO.setbTitle("Ʈ�����5");

		mapper.insertBoard(boardVO);

		throw new SQLException("SQLException for rollback");
	}
	
	//@Transactional�� rollbackFor �ɼ��� �̿��ϸ� Rollback�� �Ǵ� Ŭ������ ����������.
	// Exception���ܷ� �ѹ��� �Ϸ��� ������ ���� �����ϸ�˴ϴ�. @Transactional(rollbackFor = Exception.class) 
	// �������� ���ܸ� ������ ���� �ֽ��ϴ�. @Transactional(rollbackFro = {RuntimeException.class, Exception.class})
	@Transactional(rollbackFor = Exception.class) 
	public void transionTest6() throws SQLException {
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����6");
		boardVO.setbName("Ʈ�����6");
		boardVO.setbTitle("Ʈ�����6");

		mapper.insertBoard(boardVO);

		throw new SQLException("SQLException for rollback");
	}
	
	@Transactional(rollbackFor = SQLException.class) 
	public void transionTest7() throws SQLException {
		BoardVO boardVO = new BoardVO();
		boardVO.setbContent("Ʈ�����7");
		boardVO.setbName("Ʈ�����7");
		boardVO.setbTitle("Ʈ�����7");

		mapper.insertBoard(boardVO);

		throw new SQLException("SQLException for rollback");
	}

}
