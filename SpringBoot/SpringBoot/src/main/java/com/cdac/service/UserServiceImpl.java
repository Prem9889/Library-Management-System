package com.cdac.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.cdac.dto.UserDTO;
import com.cdac.entity.User;
import com.cdac.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean addUser(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		try{
			userRepository.save(user);
		}catch(Exception e) {
			return false;
		}
		return true; 
	}

	@Override
	public boolean deleteUser(String userName) {
		if (userRepository.existsById(userName)) {
            try {
                userRepository.deleteById(userName); 
                
                return true; 
            } catch (Exception e) {
                return false;
            }
        } else {
            
            
            return false;
        }
	}

	@Override
	public String updateUser(UserDTO userDTO) {
		if(userRepository.existsById(userDTO.getUsername())) {
			User user = new User();
			BeanUtils.copyProperties(userDTO, user);
			try{
				userRepository.save(user);
				return "User saved successfully !!!";
			}catch(Exception e) {
				return "User could'nt be saved !!!";
			}
		}
		return "User does'nt exist !!";
	}

	@Override
	public boolean getUser(String username, String password) {
		return userRepository.findByUsernameAndPassword(username,password).isEmpty() ? false : true;
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getUsers(int pageNo, int pageSize) {
		Pageable page = PageRequest.of(pageNo, pageSize);
		return userRepository.findAll(page).toList();
	}
}