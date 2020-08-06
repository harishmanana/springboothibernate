package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.LoginDao;
import com.spring.model.Login;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public void saveLogin(Login loginDetails) {
		loginDao.saveLogin(loginDetails);
		
	}

	@Override
	public List<Login> findAllLogins() {
		return loginDao.findAllLogins();
	}

	@Override
	public void deleteLoginByUsername(String username) {
		loginDao.deleteLoginByUsername(username);
	}

	@Override
	public Login findByUsername(String username) {
		return loginDao.findByUsername(username);
	}

	@Override
	public void updateLogin(Login loginDetails) {
		loginDao.updateLogin(loginDetails);
	}
}
