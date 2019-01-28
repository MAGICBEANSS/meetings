package org.meeting.pro.Services.Wrapper;

import org.meeting.pro.Entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface userservice {
	 abstract ResponseEntity<Users> updateUser(Users u );
	 abstract ResponseEntity<Users> createUser(Users u );
	 abstract ResponseEntity<Users> getUser(Integer id );
	 abstract ResponseEntity<Users> deleteUser(Integer id );
}
