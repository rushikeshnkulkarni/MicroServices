package com.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserService.entity.User;

public interface userRepository  extends JpaRepository<User,String>{

}
