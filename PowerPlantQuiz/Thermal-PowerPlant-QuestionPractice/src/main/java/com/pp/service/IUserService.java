package com.pp.service;

import java.util.List;
import java.util.Optional;

import com.pp.dto.UserDto;

public interface IUserService {
	
	public UserDto createUser(UserDto useDto);
	public List<UserDto> getallUser();
	public UserDto updateUser(UserDto userDto);
	public UserDto fetchUserByUserName(String userName);
	public void deleteUser(int userId);

}
