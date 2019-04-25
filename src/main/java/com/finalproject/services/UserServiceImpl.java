package com.finalproject.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalproject.dao.RoleDao;
import com.finalproject.dao.UserDao;
import com.finalproject.pojo.Role;
import com.finalproject.pojo.User;
import com.finalproject.users.Admin;
import com.finalproject.users.Customer;
import com.finalproject.users.RestaurantManager;

@Service
@Transactional

public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
		
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleDao roleDao;
	

	
	@Transactional
	public User findByUserName(String userName) {
		
		return userDao.findByUserName(userName);
	}
	
	

	@Transactional
	public void save(Customer customer) {
		User user = new User();
		
		user.setUserName(customer.getUserName());
		user.setPassword(passwordEncoder.encode(customer.getPassword()));
		user.setFirstName(customer.getFirstName());
		user.setLastName(customer.getLastName());
		user.setEmail(customer.getEmail());
	
		
		user.setRoles(Arrays.asList(new Role("ROLE_CUSTOMER")));
	
		
		userDao.save(user);
		
	}
	
	
	
	@Transactional
	public void saveManager(RestaurantManager manager) {
		User user = new User();
		
		user.setUserName(manager.getUserName());
		user.setPassword(passwordEncoder.encode(manager.getPassword()));
	//	user.setFirstName(manager.getFirstName());
	//	user.setLastName(manager.getLastName());
		user.setEmail(manager.getEmail());
		user.setRoles(Arrays.asList(new Role("ROLE_RestaurantManager")));
	
		
		userDao.save(user);
		
	}
	
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
		
		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}



	public List<User> findAllCustomers() {
		List<User> results = userDao.findAllCustomers();
		return results;
	}



	@Override
	public void saveEmployee(Admin adm) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setRoles(Arrays.asList(new Role("ROLE_Admin")));
	}



	@Override
	public User findbyUuid(long userId) {
		// TODO Auto-generated method stub
		return userDao.findbyUuid(userId);
	}

}
