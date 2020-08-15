package edu.bit.board.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/security/*") 
public class SecuritySampleController {

	  @GetMapping("/all")
	  public void doAll() {	    
	    log.info("do all can access everybody");
	  }
	  
	  @GetMapping("/member")
	  public void doMember() {
	    
	    log.info("logined member");
	  }
	  
	  @GetMapping("/admin")
	  public void doAdmin() {
	    
	    log.info("admin only");
	  }  

	  @GetMapping("/annoMember")
	  public void doMember2() {
	    
	    log.info("logined annotation member");
	  }  
	  
	  @GetMapping("/annoAdmin")
	  public void doAdmin2() {

	    log.info("admin annotaion only");
	  }
	  
	  @GetMapping("/accessError")
	  public void accessError(Authentication auth,Model model) {
		  log.info("accessd denied" + auth);
		  model.addAttribute("msg","Access Denied");
	  }
	  
	  @GetMapping("/login/loginForm")
	  public void loginForm(Authentication auth,Model model) {
		  log.info("loginForm ...");		  
	  }
	  
/*	  @GetMapping("/index")
	  public void index() {
		  log.info("index ...");		  
	  }*/

}
