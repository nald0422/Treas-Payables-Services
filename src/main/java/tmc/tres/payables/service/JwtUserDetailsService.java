//package tmc.tres.payables.service;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import tmc.tres.payables.dao.UserDao;
//import tmc.tres.payables.model.DAOUser;
//import tmc.tres.payables.model.UserDTO;
//
//@Service
//public class JwtUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private UserDao userDao;
//
//	@Autowired
//	private PasswordEncoder bcryptEncoder;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		System.out.println("Username : " + username);
//		
//		DAOUser user = userDao.findByUsername(username);
//		
//		System.out.println("TEST");
//		
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		
//		System.out.println("Username : " + user.getUsername() + " Password: " +user.getPassword());
//		
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//				new ArrayList<>());
//	}
//
//	public DAOUser save(UserDTO user) {
//		DAOUser newUser = new DAOUser();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		return userDao.save(newUser);
//	}
//
//}
