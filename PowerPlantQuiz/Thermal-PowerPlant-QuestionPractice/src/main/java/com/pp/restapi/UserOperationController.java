package com.pp.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pp.dto.UserDto;
import com.pp.service.IUserService;

@RestController
@RequestMapping("/user-api")
public class UserOperationController {
	@Autowired
	private IUserService userService;

	@PostMapping("/register") 
	public ResponseEntity<?> registerUser(@RequestBody	  UserDto userDto) {
	 
	 return new ResponseEntity<UserDto>(this.userService.createUser(userDto), HttpStatus.CREATED); 
	 
	}
	@GetMapping("/")
	public ResponseEntity<?>  fetchAllUser(){
		List<UserDto> listOfUser=this.userService.getallUser();
		return new ResponseEntity<List<UserDto>>(listOfUser, HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<?>  updateUser(@RequestBody UserDto userDto){
		UserDto updateUser=this.userService.updateUser(userDto);
		return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);
	}
	@GetMapping("/findBy/{userName}")
	public ResponseEntity<?>  getUserByUserName(@PathVariable String userName){
		UserDto user=this.userService.fetchUserByUserName(userName);
		return new ResponseEntity<UserDto>(user, HttpStatus.OK);
	}
	

}
