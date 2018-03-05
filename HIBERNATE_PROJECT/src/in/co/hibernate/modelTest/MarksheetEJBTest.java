package in.co.hibernate.modelTest;

import in.co.hibernate.MarksheetEJB;
import in.co.hibernate.Check.RollCheck;
import in.co.hibernate.model.MarksheetModel;

public class MarksheetEJBTest {
	public static MarksheetEJB ejb = new MarksheetEJB();
	public static MarksheetModel model = new MarksheetModel();

	public static void main(String[] args) {
		 //testAdd();
		//testMeritList();
		// testDelete();
		// testGet();
		 testGetAllMarksheet();
		// testUpdate();
		//testFindByRollNo();
           //testGetId();
	}

	 

	private static void testGetId() {
	 model.get(9);
	}



	private static void testFindByRollNo() {
		ejb.setRollno("1857");
		ejb.setRollno(ejb.getRollno());
		model.FindByRollNo(ejb);
	}



	private static void testUpdate() {
		ejb.setId(10);
		ejb.setRollno("1859");
		ejb.setFirstName("JOHN");
		ejb.setLastName("ABRAHAM");
		ejb.setPhysics(50);
		ejb.setChemistry(45);
		ejb.setMaths(40);
		model.update(ejb);
	}

	private static void testGetAllMarksheet() {
		model.getAllMarksheet(ejb);

	}

	private static void testGet() {
		ejb.setRollno("1850");
		model.getMarksheet(ejb);

	}

	private static void testDelete() {
		ejb.setId(10);
		model.delete(ejb);

	}

	private static void testMeritList() {

		model.getMeritList();
	}

	private static void testAdd() {
		 
		ejb.setRollno("1856");
		ejb.setFirstName("ROBIN");
		ejb.setLastName("SHERGILL");
		ejb.setPhysics(80);
		ejb.setMaths(95);
		ejb.setChemistry(90);
		model.add(ejb);
	}

}
