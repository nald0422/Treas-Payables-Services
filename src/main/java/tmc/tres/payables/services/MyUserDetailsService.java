package tmc.tres.payables.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tmc.tres.payables.dao.UserRepository;
import tmc.tres.payables.model.MyUserDetails;
import tmc.tres.payables.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(userName);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

		return user.map(MyUserDetails::new).get();
	}

	public List<UserDetails> getUserDetails() {

		List<User> users = userRepository.findAll();
		List<UserDetails> userDetails = new ArrayList<UserDetails>();

		for (User user : users) {
			Optional<User> userObj = userRepository.findByUserName(user.getUserName());
			userDetails.add(userObj.map(MyUserDetails::new).get());
		}

		return userDetails;

	}

	public User save(User user) {
		User newUser = new User();
		newUser.setUserName(user.getUserName());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setActive(true);
		newUser.setRoles(user.getRoles());
		return userRepository.save(newUser);
	}
	
	public void update(User user) {
		
		Optional<User> userObj = userRepository.findByUserName(user.getUserName());

		userObj.orElseThrow(() -> new UsernameNotFoundException("Not found: " + user.getUserName()));
		
		User user_temp = userRepository.findById(userObj.get().getId());
		
		user_temp.setUserName(user.getUserName());
		user_temp.setActive(user.isActive());
		
		if(user.getRoles().equalsIgnoreCase(" ")) {
			user_temp.setRoles("default");
		} else {
			user_temp.setRoles(user.getRoles());
		}
		
		user_temp.setPassword(user.getPassword());
		
		userRepository.save(user_temp);
	}
}