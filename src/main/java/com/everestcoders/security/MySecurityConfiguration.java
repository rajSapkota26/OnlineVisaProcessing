package com.everestcoders.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {

	MyUserDetail myUserDetail = new MyUserDetail();

	public MyUserDetail getMyUserDetail() {
		return myUserDetail;
	}

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getpasswordEncoder());
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**")
				.hasRole("USER").antMatchers("/hr/**").hasRole("HR").antMatchers("/**").permitAll().and().formLogin()
				.loginPage("/login").loginProcessingUrl("/dologin").successHandler(new MySuccessHandler()).permitAll()
				.and().logout();
		
	}

	@Bean
	public BCryptPasswordEncoder getpasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
