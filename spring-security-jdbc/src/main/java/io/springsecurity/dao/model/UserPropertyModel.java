package io.springsecurity.dao.model;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.stereotype.Component;

@Component
public class UserPropertyModel {

	@JsonIgnore
    private BigDecimal id;
    @JsonIgnore
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String active;
    @JsonIgnore
    private String roles;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

    
}
