package org.meeting.pro.Controllers;

import org.meeting.pro.Entity.Rooms;
import org.meeting.pro.Services.Wrapper.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;

@RestController
@RequestMapping("/admin")
public class AdminController {
@Autowired
RoomService rs;
	
	@RequestMapping(value = "/createRoom" , method = RequestMethod.POST)
	public ResponseEntity<Rooms> createaRoom(@RequestBody Rooms newroom) {
		System.out.println("Receivedreques is => "+newroom);
		return rs.createRoom(newroom);
		//ResponseEntity<Rooms> rt = new ResponseEntity<Rooms>(newroom,HttpStatus.OK);
		// return rt;
		
		
	}
	
	@RequestMapping(value = "/check" , method = RequestMethod.GET)
	public ResponseEntity<String> checkmate() {
		
		return new ResponseEntity<String>("ABC",HttpStatus.ACCEPTED);
		//ResponseEntity<Rooms> rt = new ResponseEntity<Rooms>(newroom,HttpStatus.OK);
		// return rt;
		
		
	}
}
