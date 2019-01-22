package custom;

import java.io.Serializable;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.meeting.pro.Entity.Rooms;

public class RoomIDGenerator implements IdentifierGenerator {
	static int y=1;
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		String prefix = "ROOM_";
		//Query q =  session.createNamedQuery("current_count");
	//	Integer count = (Integer) q.uniqueResult();
		Rooms current = (Rooms)object;
		if(current.getR_id()!= null)
		{
			return current.getR_id();
		}
		prefix= prefix+y;
		y++;
		System.out.println("returning "+prefix);
		return prefix;
	}

}
