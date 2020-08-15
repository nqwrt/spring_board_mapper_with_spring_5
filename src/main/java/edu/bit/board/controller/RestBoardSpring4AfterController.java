package edu.bit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//spring v4.0 에서 부터 @RestController라는 어노테이션을 추가해서 해당 Controller의 모든 메서드의 리턴타입을 기존과 다르게 처리한다는것을 명시
@Log4j
@AllArgsConstructor
@RestController
@Controller
public class RestBoardSpring4AfterController {

	private BoardService boardService;

	@RequestMapping("/rest/after")
	public List<BoardVO> after() {

		log.info("/rest/after");
		List<BoardVO> list = boardService.getList();

		return list;
	}
	
    @RequestMapping(value = "/rest/delete/{bId}", method = RequestMethod.DELETE)
	public int restDelete(@PathVariable("bId") int bId) {
    	
    	log.info("restDelete");
		return  boardService.remove(bId);
	}
	


}
