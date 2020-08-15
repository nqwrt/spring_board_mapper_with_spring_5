package edu.bit.board.two;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/*
1. interface는 필요가 없음 
2. sqlSession에서 제공하는 함수(selectList,selectOne)를 이용함
3. 쿼리구현을 위한 XML이 필요. 해당 XML의 namespace는  개발자가가 정함
* 
* */

@Controller
public class BController2 {

	@Inject
	BService2 bservice;
	
	@RequestMapping("/list2")
	public String list(Model model) throws Exception{
		System.out.println("list2()");	
		
		model.addAttribute("list", bservice.selectBoardList());			
		return "list";		
	}
	
	/*
	 * @RequestMapping("/write_view") public String write_view(Model model) {
	 * System.out.println("write_view()");
	 * 
	 * return "write_view"; }
	 * 
	 * @RequestMapping("/content_view") public String
	 * content_view(HttpServletRequest request, Model model){
	 * System.out.println("content_view()");
	 * 
	 * String bid = request.getParameter("bId");
	 * 
	 * IBDao dao = sqlSession.getMapper(IBDao.class);
	 * model.addAttribute("content_view", dao.ContentDao(bid));
	 * 
	 * 
	 * return "content_view"; }
	 * 
	 * @RequestMapping("/delete") public String delete(HttpServletRequest request,
	 * Model model){ System.out.println("delete()");
	 * 
	 * String bId = request.getParameter("bId");
	 * 
	 * IBDao dao = sqlSession.getMapper(IBDao.class);
	 * 
	 * int num = Integer.parseInt(bId);
	 * 
	 * dao.deleteDao(num);
	 * 
	 * 
	 * return "redirect:list"; }
	 * 
	 * @RequestMapping(value="/modify", method=RequestMethod.POST ) public String
	 * modify(BDto bDto, Model model){ System.out.println("modify()");
	 * 
	 * 
	 * IBDao dao = sqlSession.getMapper(IBDao.class); dao.updateDao(bDto);
	 * 
	 * return "redirect:list"; }
	 */
}
