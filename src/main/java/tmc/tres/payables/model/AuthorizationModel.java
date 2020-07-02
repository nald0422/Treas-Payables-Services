package tmc.tres.payables.model;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthorizationModel {

	private UserDetails user;
	private AuthenticationResponse token;

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

	public AuthenticationResponse getToken() {
		return token;
	}

	public void setToken(AuthenticationResponse authenticationResponse) {
		this.token = authenticationResponse;
	}

	@Override
	public String toString() {
		return "AuthorizationModel [token=" + token + "]";
	}

}
