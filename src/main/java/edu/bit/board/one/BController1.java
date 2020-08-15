package edu.bit.board.one;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/*
1.interface IBDao를  XML namespac에 매핑 <mapper namespace="edu.bit.ex.board1.IBDao"> 
2.sqlSession.getMapper(IBDao.class)를 이용.
* 
* 
* */
@Controller
public class BController1 {

	@Inject
	BService1 bservice;
	
	@RequestMapping("/list1")
	public String list(Model model) throws Exception{
		System.out.println("list1()");	
		
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
