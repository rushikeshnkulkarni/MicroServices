package com.UserService.entity;

import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "micro_user")
public class User {

	@Id
	private String UserId;
	
	private String Name;
	
	private String email;
	
	@Transient
	private  List<rating> rating = new ArrayList<>();
	
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<rating> getRating() {
		return rating;
	}
	public void setRating(List<rating> rating) {
		this.rating = rating;
	}

	
}
