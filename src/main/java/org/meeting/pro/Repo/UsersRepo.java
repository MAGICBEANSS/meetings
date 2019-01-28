package org.meeting.pro.Repo;

import org.meeting.pro.Entity.Users;
import org.springframework.http.ResponseEntity;

public interface UsersRepo {
	abstract ResponseEntity<Users> updateUser(Users u );
	abstract ResponseEntity<Users> createUser(Users u );
	abstract ResponseEntity<Users> getUser(Integer id );
	abstract ResponseEntity<Users> deleteUser(Integer id );
}
