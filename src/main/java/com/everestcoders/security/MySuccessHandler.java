package com.everestcoders.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MySuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String name = authentication.getName();
		boolean isAdmin = false;
		boolean ishr = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_HR")) {
				ishr = true;
			}
			if (grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_ADMIN")) {
				isAdmin = true;
			}
		}
		if (isAdmin) {
			response.sendRedirect("/admin/index");

		} else if (ishr) {
			response.sendRedirect("/hr/index");

		} else {
			response.sendRedirect("/user/index");
		}

		System.out.println(name);

	}

}
