package org.meeting.pro.Controllers;

import org.meeting.pro.Entity.Users;
import org.meeting.pro.Services.Wrapper.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	userservice userservice;
	

	@RequestMapping(value="/getuser/{uid}")
	public ResponseEntity<Users> getUser(@PathVariable("uid") Integer id){
		
		ResponseEntity<Users> ru = userservice.getUser(id);
		return ru;
	}
	
	@RequestMapping(value="/newuser" , method= RequestMethod.POST)
	public ResponseEntity<Users> createUser(@RequestBody Users user )
	{
		
		ResponseEntity<Users> rs = userservice.createUser(user);
		return rs;
		
	}
	
	@RequestMapping(value="/updateuser" , method= RequestMethod.PUT)
	public ResponseEntity<Users> updateUser(@RequestBody Users user )
	{
		
		ResponseEntity<Users> rs = userservice.updateUser(user);
		return rs;
		
	}
	@RequestMapping(value="/deleteuser/{uid}")
	public ResponseEntity<Users> deleteUser(@PathVariable("uid") Integer id){

		ResponseEntity<Users> ru = userservice.deleteUser(id);
		return ru;
	}
	
}
