package com.ensi.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.UserDao;
import com.ensi.Model.User;
import com.ensi.Model.Role;

import com.ensi.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService,Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserDao userDao;
	
	public void saveUser(User u) {
		userDao.saveUser(u);	
		
	}
	public List<User> getAllUsers(){
		
		return userDao.getAllUsers();
		
	}
	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		userDao.updateUser(u);
	}
	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		userDao.deleteUser(u);
	}
	
}