package com.pp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pp.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer>{
	public Optional<Role> findByRoleId(int id);
	

}
