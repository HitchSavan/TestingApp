package com.hitchsavan.testapp.payload.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class JwtResponse {
    @Getter @Setter private String accessToken;
	@Getter @Setter private String type = "Bearer";
	@Getter @Setter private Long id;
	@Getter @Setter private String username;
	@Getter @Setter private String email;
	@Getter private List<String> roles;

	public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
		this.accessToken = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
}
