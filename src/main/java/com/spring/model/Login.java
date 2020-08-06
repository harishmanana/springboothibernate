package com.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Login")
public class Login {
	@Id
    private String username;
	
	@Column
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserAddress adress;

	@OneToMany(fetch=FetchType.EAGER, targetEntity=Mobile.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "user", referencedColumnName="username")
	private Set<Mobile> mobile;
	
	public Login() {
		
	}
	
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Login(String username, String password, UserAddress userAddress) {
		this.username = username;
		this.password = password;
		setAdress(userAddress);
	}

	public Login(String username, String password, UserAddress userAddress, Set<Mobile> mobile) {
		this.username = username;
		this.password = password;
		setAdress(userAddress);
		setMobile(mobile);
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
	
	public UserAddress getAdress() {
		return adress;
	}

	public void setAdress(UserAddress adress) {
		this.adress = adress;
	}
	
	public Set<Mobile> getMobile() {
		return mobile;
	}

	public void setMobile(Set<Mobile> mobile) {
		this.mobile = mobile;
	}

	public String toString() {
		return "Username: " + getUsername() + "\tPassword: " + getPassword();
	}
}
