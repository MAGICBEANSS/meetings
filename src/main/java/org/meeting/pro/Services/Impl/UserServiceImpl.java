package org.meeting.pro.Services.Impl;


import org.meeting.pro.Entity.Users;
import org.meeting.pro.Repo.UsersRepo;
import org.meeting.pro.Services.Wrapper.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements userservice{

	@Autowired
	UsersRepo u;
	
	public ResponseEntity<Users> updateUser(Users r) {
		// TODO Auto-generated method stub
		return u.updateUser(r);
		// return null;
	}

	public ResponseEntity<Users> createUser(Users r) {
		// TODO Auto-generated method stub
		return u.createUser(r);
	}

	public ResponseEntity<Users> getUser(Integer id) {
		// TODO Auto-generated method stub
		return u.getUser(id);
	}

	public ResponseEntity<Users> deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return u.deleteUser(id);
	}

	
}
