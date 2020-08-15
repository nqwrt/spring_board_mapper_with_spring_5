package edu.bit.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.bit.board.vo.UserVO;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardInterceptor extends HandlerInterceptorAdapter{

	// preHandle() : ��Ʈ�ѷ����� ���� ����Ǵ� �޼���
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	    throws Exception {
		System.out.println("preHandle ����");
		// session ��ü�� ������
        HttpSession session = request.getSession();
        
        // loginó���� ����ϴ� ����� ������ ��� �ִ� ��ü�� ������
        UserVO user = (UserVO) session.getAttribute("user");
          
        if ( user == null ){
        	log.info("user�� null");
            // �α����� �ȵǾ� �ִ� �����̹Ƿ� �α��� ������ �ٽ� ��������(redirect)
            response.sendRedirect(request.getContextPath());

            return false; // ���̻� ��Ʈ�ѷ� ��û���� ���� �ʵ��� false�� ��ȯ��
        }
          
        // preHandle�� return�� ��Ʈ�ѷ� ��û uri�� ���� �ǳ� �ȵǳĸ� �㰡�ϴ� �ǹ���
        // ���� true���ϸ� ��Ʈ�ѷ� uri�� ���� ��.
        return true;        
	}

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
		 	super.postHandle(request, response, handler, modelAndView);
		 	System.out.println("postHandle ����");
	}

}
