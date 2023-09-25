package com.pp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.dto.UserDto;
import com.pp.entity.Role;
import com.pp.entity.User;
import com.pp.exception.ResourceNotFoundException;
import com.pp.repo.IRoleRepository;
import com.pp.repo.IUserRepository;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		Role role = this.roleRepository.findByRoleId(600).get();
		user.getRole().add(role);
		User save = this.userRepository.save(user);
		return mapper.map(save, UserDto.class);

	}

	@Override
	public List<UserDto> getallUser() {
		List<User> listOfUser = this.userRepository.findAll();
		List<UserDto> collectUser = listOfUser.stream().map(list -> mapper.map(list, UserDto.class))
				.collect(Collectors.toList());
		return collectUser;
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		User user = mapper.map(userDto, User.class);
		Optional<User> optional = this.userRepository.findById(user.getUserId());
		if (optional.isPresent()) {
			User save = this.userRepository.save(user);
			return mapper.map(save, UserDto.class);
		} else {
			throw new ResourceNotFoundException("USER", "USER ID", user.getUserId());
		}

	}

	@Override
	public UserDto fetchUserByUserName(String userName) {
		Optional<User> user=this.userRepository.findByUserName(userName);
		if(user.isPresent()) {
			 User fetchUser = user.get();
			 return mapper.map(fetchUser, UserDto.class);
		}
		 else {
				throw new ResourceNotFoundException("UserName not found!!!!!!!");
			}
	}

	@Override
	public void deleteUser(int userId) {
		Optional<User> optional = this.userRepository.findById(userId);
		if(optional.isPresent()) {
			this.userRepository.deleteById(userId);
		}
		else {
			throw new ResourceNotFoundException("USER", "USER ID", userId);
		}

	}

}
