package in.co.hibernate.model;

import java.util.Iterator;
import java.util.List;

import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import in.co.hibernate.MarksheetEJB;

public class MarksheetModel {

	public static void add(MarksheetEJB ejb) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(ejb);// ADD
		tx.commit();
		s.close();
		System.out.println("\n\t" + "MARKSHEET SUCCESSFULLY ADDED AT "
				+ ejb.getId());
	}

	public static void update(MarksheetEJB ejb) {
		ejb.setId(ejb.getId());
		ejb.setRollno(ejb.getRollno());
		ejb.setFirstName(ejb.getFirstName());
		ejb.setLastName(ejb.getLastName());
		ejb.setPhysics(ejb.getPhysics());
		ejb.setChemistry(ejb.getChemistry());
		ejb.setMaths(ejb.getMaths());
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.update(ejb);
		tx.commit();
		s.close();
		System.out.println("\t" + "RECORD UPDATED SUCCESSFULLY AT "
				+ ejb.getId());

	}

	public static void delete(MarksheetEJB ejb) {
		ejb.setId(ejb.getId());
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		s.delete(ejb);
		tx.commit();
		s.close();
		System.out.println("\t" + "RECORD DELETED SUCCESSFULLY AT ID "
				+ ejb.getId());

	}

	public static void getMarksheet(MarksheetEJB ejb) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session s = sessionFactory.openSession();
		System.out
				.println("ROLL_NO FIRST_NAME LAST_NAME PHYSCICS CHEMISTRY MATHS");
		Criteria ct = s.createCriteria(MarksheetEJB.class);
		ct.add(Restrictions.eq("rollno", ejb.getRollno()));
		List list = ct.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			ejb = (MarksheetEJB) it.next();
			System.out.print("\n" + ejb.getRollno());
			System.out.print("\t" + ejb.getFirstName());
			System.out.print("\t\t" + ejb.getLastName());
			System.out.print("\t" + ejb.getPhysics());
			System.out.print("\t" + ejb.getChemistry());
			System.out.print("\t" + ejb.getMaths());
			System.out.print("\n"
					+ "________________________________________________");
			s.close();
		}
	}

	public static void getMeritList() {
		MarksheetEJB ejb = new MarksheetEJB();
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session s = sessionFactory.openSession();
		org.hibernate.Query q = s
				.createQuery("from MarksheetEJB where (physics+maths+chemistry)>0 order by (physics+maths+chemistry) desc");
		List list = q.list();
		Iterator it = list.iterator();
		System.out
				.println("ROLL_NO\tFIRST_NAME LAST_NAME PHYSCICS CHEMISTRY MATHS TOTAL");
		while (it.hasNext()) {
			ejb = (MarksheetEJB) it.next();
			int total = ejb.getPhysics() + ejb.getChemistry() + ejb.getMaths();
			System.out.print("\n" + ejb.getRollno());
			System.out.print("\t" + ejb.getFirstName());
			System.out.print("\t\t" + ejb.getLastName());
			System.out.print("\t" + ejb.getPhysics());
			System.out.print("\t" + ejb.getChemistry());
			System.out.print("\t" + ejb.getMaths());
			System.out.print("\t" + total);
			System.out.print("\n\t"
					+ "------------------------------------------------------");

		}
	}

	public static void getAllMarksheet(MarksheetEJB ejb) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session s = sessionFactory.openSession();
		Criteria ct = s.createCriteria(MarksheetModel.class);
		ct.addOrder(Order.desc("id"));
		org.hibernate.Query q = s.createQuery("from MarksheetEJB");

		List list = q.list();

		Iterator it = list.iterator();
		System.out
				.println("ROLL_NO\tFIRST_NAME LAST_NAME PHYSCICS CHEMISTRY MATHS TOTAL");
		while (it.hasNext()) {
			ejb = (MarksheetEJB) it.next();
			int total = ejb.getMaths() + ejb.getChemistry() + ejb.getMaths();
			System.out.print("\n" + ejb.getRollno());
			System.out.print("\t" + ejb.getFirstName());
			System.out.print("\t\t" + ejb.getLastName());
			System.out.print("\t" + ejb.getPhysics());
			System.out.print("\t" + ejb.getChemistry());
			System.out.print("\t" + ejb.getMaths());
			System.out.println("\t" + total);
			System.out.print("\n\t"
					+ "------------------------------------------------------");
		}
	}

	public static MarksheetEJB FindByRollNo(MarksheetEJB ejb) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session s = sessionFactory.openSession();
		org.hibernate.Query q = s
				.createQuery("from MarksheetEJB where rollno=?");
		String roll = ejb.getRollno();
		ejb.setRollno(roll);
		q.setString(0, roll);
		List list = q.list();
		Iterator it = list.iterator();
		System.out
				.println("ROLL_NO\tFIRST_NAME LAST_NAME PHYSCICS CHEMISTRY MATHS");
		while (it.hasNext()) {
			ejb = (MarksheetEJB) it.next();
			System.out.print("\n" + ejb.getRollno());
			System.out.print("\t" + ejb.getFirstName());
			System.out.print("\t\t" + ejb.getLastName());
			System.out.print("\t" + ejb.getPhysics());
			System.out.print("\t" + ejb.getChemistry());
			System.out.print("\t" + ejb.getMaths());
			System.out.print("\n\t"
					+ "------------------------------------------------------");
		}
		return ejb;

	}

	public static MarksheetEJB get(int id) {
		MarksheetEJB ejb = new MarksheetEJB();
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session s = sessionFactory.openSession();
		org.hibernate.Query q = s.createQuery("from MarksheetEJB where Id=?");
		int Id = id;
		ejb.setId(Id);
		q.setInteger(0, Id);
		List list = q.list();
		Iterator it = list.iterator();
		System.out
				.println("ROLL_NO\tFIRST_NAME LAST_NAME PHYSCICS CHEMISTRY MATHS");
		while (it.hasNext()) {
			ejb = (MarksheetEJB) it.next();
			System.out.print("\n" + ejb.getRollno());
			System.out.print("\t" + ejb.getFirstName());
			System.out.print("\t\t" + ejb.getLastName());
			System.out.print("\t" + ejb.getPhysics());
			System.out.print("\t" + ejb.getChemistry());
			System.out.print("\t" + ejb.getMaths());
			System.out.print("\n\t"
					+ "------------------------------------------------------");
		}
		return ejb;
	}

}
