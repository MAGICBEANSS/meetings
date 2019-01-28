package org.meeting.pro.Services.Impl;

import org.meeting.pro.Entity.Rooms;
import org.meeting.pro.Repo.RoomsRepo;
import org.meeting.pro.Services.Wrapper.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomsRepo rooms;
	public ResponseEntity<Rooms> createRoom(Rooms r) {
		// TODO Auto-generated method stub
		return rooms.createRoom(r);
		// return null;
	}
	public ResponseEntity<Rooms> updateRoom(Rooms r) {
		// TODO Auto-generated method stub
		return rooms.updateRoom(r);
	}
	public ResponseEntity<Rooms> deleteRoom(String rid) {
		// TODO Auto-generated method stub
		return rooms.deleteRoom(rid);
	}
	public ResponseEntity<Rooms> getRoom(String rid) {
		// TODO Auto-generated method stub
		return rooms.getRoom(rid);
	}

}
