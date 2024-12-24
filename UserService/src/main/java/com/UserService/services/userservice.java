package com.UserService.services;

import java.util.List;

import com.UserService.entity.User;

public interface userservice {
	
	User saveuUser(User user);
	
	List<User> users();
	
	User getUser(String userId);

}
