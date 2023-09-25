package com.pp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pp.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByUserName(String username);

	

}
