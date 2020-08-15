package edu.bit.board.transaction;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bit.board.service.TransactionTestService;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardTransactionTest2 {
	

	
	@Inject
	private TransactionTestService service;
	
	public void testTrasction() {
		service.transionTest1();
	}
	
	

}
