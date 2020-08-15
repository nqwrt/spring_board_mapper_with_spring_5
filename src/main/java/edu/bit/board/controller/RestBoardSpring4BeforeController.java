package edu.bit.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.board.service.BoardService;
import edu.bit.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//spring v4.0 �씠�쟾 踰꾩쟾 (@Controller + @ResponseBody )
@Log4j
@AllArgsConstructor
@Controller
public class RestBoardSpring4BeforeController {
	 

	 private BoardService boardService;

	 // home.jsp 
/*	 @RequestMapping(value = "/", method = RequestMethod.GET) 
	 public String home() { 
		 return "home"; 
	 }*/
	 
	 //before.json �쑝濡� �젒�냽�떆, josn�쑝濡� �몴�떆�맖
	 @ResponseBody 
	 @RequestMapping("/rest/before")
	 public List<BoardVO> before() {	
		 
		 log.info("/rest/before");		 
		 List<BoardVO> list = boardService.getList();		
		 
		 return list;
	 }	 
}
