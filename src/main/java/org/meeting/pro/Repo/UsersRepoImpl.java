package org.meeting.pro.Repo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.meeting.pro.Entity.Rooms;
import org.meeting.pro.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@Repository
public class UsersRepoImpl implements UsersRepo{

		@Autowired
		private SessionFactory sessionFactory;
		
		
		public Session getSession(){
			Session s=sessionFactory.openSession();
			return s;
		}
		
		public ResponseEntity<Users> updateUser(Users r ){
			Session ss = getSession();
			ss.beginTransaction();
			
			Users temp=ss.get(Users.class,r.getUid());
			if(temp==null) {
				ss.merge(r);
				r.setUid(r.getUid());
				ss.getTransaction().commit();
				ss.close();
				return new ResponseEntity<Users>(r,HttpStatus.CREATED);
				
				
			}
			 ss.merge(r);
			 ss.getTransaction().commit();
			 ss.close();
			return new ResponseEntity<Users>(r, HttpStatus.OK);
		}

		public ResponseEntity<Users> createUser(Users u) {
			// TODO Auto-generated method stub
			Session session=getSession();
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
			session.close();
			return new ResponseEntity<Users>(u,HttpStatus.OK);
		}

		public ResponseEntity<Users> getUser(Integer id) {
			// TODO Auto-generated method stub
			Session session=getSession();
			session.beginTransaction();
			Users user=session.get(Users.class, id);
			if(user==null) {
				return new ResponseEntity<Users>(user,HttpStatus.NOT_FOUND);
			}
			session.getTransaction().commit();
			session.close();
			
			
			return new ResponseEntity<Users>(user,HttpStatus.OK);
		}

		public ResponseEntity<Users> deleteUser(Integer id) {
			// TODO Auto-generated method stub
			
			Session session=getSession();
			session.beginTransaction();
			Users user=session.get(Users.class, id);
			if(user==null) {
				return new ResponseEntity<Users>(user,HttpStatus.NOT_FOUND);
			}
			session.delete(user);
			session.getTransaction().commit();
			session.close();
			return new ResponseEntity<Users>(user,HttpStatus.OK);
			
		}
}
