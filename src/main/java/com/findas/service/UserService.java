package com.findas.service;

import com.findas.entity.User;

public interface UserService {

	public User saveUser(User user);

	public void removeSessionMessage();

}
