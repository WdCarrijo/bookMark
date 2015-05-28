package br.gov.serpro.bookmark.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class Credentials implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
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
	
	public void clear(){
		this.username = null;
		this.password = null;
	}

}
