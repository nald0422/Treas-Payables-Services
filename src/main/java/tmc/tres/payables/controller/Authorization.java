package tmc.tres.payables.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tmc.tres.payables.model.AuthenticationRequest;
import tmc.tres.payables.model.AuthenticationResponse;
import tmc.tres.payables.model.AuthorizationModel;
import tmc.tres.payables.model.User;
import tmc.tres.payables.services.MyUserDetailsService;
import tmc.tres.payables.util.JwtUtil;

@RestController
public class Authorization {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public AuthorizationModel createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		AuthorizationModel authMod = new AuthorizationModel();
		
		authMod.setUser(userDetails);
		authMod.setToken(ResponseEntity.ok(new AuthenticationResponse(jwt)).getBody());

		return authMod;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public List<UserDetails> getUsers() {
		return userDetailsService.getUserDetails();
	}
	
	@RequestMapping(value = "/updateAccount", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user) throws Exception {
		userDetailsService.update(user);
	}

}
