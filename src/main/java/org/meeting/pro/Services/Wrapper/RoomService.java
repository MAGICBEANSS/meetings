package org.meeting.pro.Services.Wrapper;

import org.meeting.pro.Entity.Rooms;
import org.springframework.http.ResponseEntity;

public interface RoomService {
	abstract public ResponseEntity<Rooms> createRoom(Rooms r);
	abstract public ResponseEntity<Rooms> updateRoom(Rooms r);
	abstract public ResponseEntity<Rooms> deleteRoom(String rid);
	abstract public ResponseEntity<Rooms> getRoom(String rid);
}
