package edu.bit.board.service;

import org.springframework.stereotype.Service;

import edu.bit.board.mapper.LogInMapper;
import edu.bit.board.vo.UserVO;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class LoginService {	

	LogInMapper logInMapper;
	
	public UserVO loginUser(String id,String pw)  {
		return logInMapper.logInUser(id,pw) ;
	}

}
