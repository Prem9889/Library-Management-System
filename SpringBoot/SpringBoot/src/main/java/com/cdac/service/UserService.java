package com.cdac.service;

import java.util.List;
import com.cdac.dto.UserDTO;
import com.cdac.entity.User;

public interface UserService {
	public boolean addUser(UserDTO userDTO);
	public boolean deleteUser(String userName);
	public String updateUser(UserDTO userDTO);
	public boolean getUser(String userName, String password);
	public List<User> getUsers(int pageNo, int pageSize);
	public List<User> getAllUser();
}