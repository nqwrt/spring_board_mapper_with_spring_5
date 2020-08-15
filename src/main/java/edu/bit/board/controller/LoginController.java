package edu.bit.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.bit.board.service.LoginService;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class LoginController {

	private LoginService loginService;

	@GetMapping("/")
	public String home() {
		log.info("home");
		return "login";
	}

	// �α���
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest req, RedirectAttributes rttr) throws Exception {

		log.info("post login");

		// Session ó���� ���� Session ��ü HttpServletRequest �ȿ� ����
		HttpSession session = req.getSession();

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		UserVO login = loginService.loginUser(id, pw);

		if (login == null) {
			session.setAttribute("user", null);
			/*
			 * Spring3 ���� �����ϴ� RedirectAttributes�� ����ϸ� redirect post ������ �����մϴ�.
			 * 
			 * ������ ��ȸ���Դϴ�. ���ΰ�ħ�ϸ� ���󰡴� �������̹Ƿ� �������� ���� ���/�Ұ��� �Ǵ��� �� �ϼž� �Ұ� �����ϴ�.
			 */
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("user", login);
		}
		return "redirect:/";
	}

	// �α׾ƿ�
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception {
		log.info("/member/logout");

		session.invalidate();

		return "redirect:/";
	}

}
