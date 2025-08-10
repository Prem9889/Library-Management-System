package com.cdac.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	public Optional<User> findByUsernameAndPassword(String username, String Password);
}