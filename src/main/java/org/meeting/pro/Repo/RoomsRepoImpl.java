package org.meeting.pro.Repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.meeting.pro.Entity.Rooms;
import org.meeting.pro.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoomsRepoImpl implements RoomsRepo {

	 @Autowired
	 private SessionFactory sessionFactory;
	
	 
	 
	public Session getSession() {
		Session s = sessionFactory.openSession();
		return s;
	}


	public ResponseEntity<Rooms> createRoom(Rooms r) {
		// TODO Auto-generated method stub
		Session ss = getSession();
		ss.beginTransaction();
		 ss.save(r);
		 ss.getTransaction().commit();
		 ss.close();
		return new ResponseEntity<Rooms>(r, HttpStatus.OK);
	}


	public ResponseEntity<Rooms> updateRoom(Rooms r) {
		// TODO Auto-generated method stub
		Session ss = getSession();
		ss.beginTransaction();
		
		Rooms temp=ss.get(Rooms.class,r.getR_id());
		if(temp==null) {
			ss.save(r);
			r.setR_id(r.getR_id());
			ss.getTransaction().commit();
			ss.close();
			return new ResponseEntity<Rooms>(r,HttpStatus.CREATED);
		
		}
		 ss.merge(r);
		 ss.getTransaction().commit();
		 ss.close();
		return new ResponseEntity<Rooms>(r, HttpStatus.OK);
	}


	public ResponseEntity<Rooms> deleteRoom(String rid) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		Rooms room=session.get(Rooms.class, rid);
		if(room==null) {
			return new ResponseEntity<Rooms>(room,HttpStatus.NOT_FOUND);
		}
		session.getTransaction().commit();
		session.close();
		
		
		return new ResponseEntity<Rooms>(room,HttpStatus.OK);
	}


	public ResponseEntity<Rooms> getRoom(String rid) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		Rooms room=session.get(Rooms.class, rid);
		if(room==null) {
			return new ResponseEntity<Rooms>(room,HttpStatus.NOT_FOUND);
		}
		session.delete(room);
		session.getTransaction().commit();
		session.close();
		
		
		return new ResponseEntity<Rooms>(room,HttpStatus.OK);
	}

}
