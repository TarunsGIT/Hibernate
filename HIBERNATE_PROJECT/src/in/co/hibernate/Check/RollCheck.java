package in.co.hibernate.Check;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import in.co.hibernate.MarksheetEJB;

public  class  RollCheck {


	public static boolean Check(String rollno){
		 MarksheetEJB ejb=new MarksheetEJB();		
		boolean status=false;
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session s=sessionFactory.openSession();
		Query q=s.createQuery("from MarksheetEJB where rollno=?");
		q.setString(0, ejb.getRollno());
		List list=q.list();
		if(list.size()==1){
			status=!true;
			ejb=(MarksheetEJB)list.get(0);
			
		}
		
		return status;
	}
}
