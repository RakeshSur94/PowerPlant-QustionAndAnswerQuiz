package com.pp.dto;

import java.util.HashSet;
import java.util.Set;

import com.pp.entity.Role;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	private Integer userId;
	private String userName;	
	private String password;	
	private String firstName;	
	private  String lastName;	
	private String address;	
	private String email;	
	private String phoneNumber;	
	private String about;
	private Boolean enabled=true;
	private String profile;
	
	private Set<Role>userRoles=new HashSet<>();

}
