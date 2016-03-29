package com.ensi.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.ensi.Dao.UserDao;
import com.ensi.Model.Role;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
   
		com.ensi.Model.User u = userDao.findByUsername(username);
		return (UserDetails) buildUserFromUserEntity(u);
	}

		@Transactional(readOnly = true)
	 public User buildUserFromUserEntity(com.ensi.Model.User op) {
	    String username = op.getUsername();
	    String password = op.getPassword();
	    System.out.println(password);

	    boolean enabled = true;
	    boolean accountNonExpired = true;
	    boolean credentialsNonExpired = true;
	    boolean accountNonLocked = true;
	    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    List<Role> roles = op.getRoles();
	    
	    for (Role role: roles) {
	    	authorities.add(new GrantedAuthorityImpl(role.getName()));
	    	
	    }
	    
	    User user = new User(username, password, enabled,
	      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	    
	    return user;
	  }
	
	public UserDao getUserDao() {
		return userDao;
	}



	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
