package in.co.hiberante.JUnit;

import static org.junit.Assert.*;
import in.co.hibernate.MarksheetEJB;
import in.co.hibernate.model.MarksheetModel;

import org.junit.Ignore;
import org.junit.Test;

public class JUNIT_TEST {
	public static MarksheetEJB ejb = new MarksheetEJB();
	public static MarksheetModel model = new MarksheetModel();

	@Ignore
	public void testAdd() {
		ejb.setFirstName("TARUN");
		ejb.setLastName("JADHAV");
		ejb.setRollno("1861");
		ejb.setMaths(50);
		ejb.setChemistry(50);
		ejb.setPhysics(50);

		model.add(ejb);
		ejb = model.get(12);
		if (ejb == null) {
			fail("NOT ADDED");
		}

	}

	@Test
	public void testDelete() {
		ejb.setId(11);
		model.delete(ejb);

		assertNotNull("DELETE OPERATION FALIED", ejb);

	}
}