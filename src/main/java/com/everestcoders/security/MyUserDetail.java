package com.everestcoders.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.everestcoders.model.User;

public class MyUserDetail implements UserDetails {

	private static final long serialVersionUID = 1L;
	String username;
    String password;
    private List<GrantedAuthority> authorityList;

    public MyUserDetail(User user) {
     this.username=user.getEmail();
     this.password=user.getPassword();
     this.authorityList= Arrays.stream(user.getRole().split(","))
             .map(SimpleGrantedAuthority::new)
             .collect(Collectors.toList());
    }

    public MyUserDetail() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
