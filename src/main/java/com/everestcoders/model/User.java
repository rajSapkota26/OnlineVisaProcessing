package com.everestcoders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id  
    private String id;
//    @NotNull
//    @Size(min = 6,max = 12)
    private String name;
//    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid email")
//	@Column(unique = true)
    private  String email;
//    @NotNull
//    @Size(min = 6,max = 12)
    private String password;
    private String role;
    private boolean activity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActivity() {
		return activity;
	}
	public void setActivity(boolean activity) {
		this.activity = activity;
	}
    
    
}
