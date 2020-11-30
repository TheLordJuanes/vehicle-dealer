package model;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import exceptions.LackOfLandException;

class CompanyTest {

	private Company dealership;
	//private List<Vehicle> vehicles;
	//private List<Person> people;

	public void setupScenario1() {
		try {
			dealership = new Company("Dealership S.A.S.®", "23445-98478", 0, 0);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Test
	public void testImportData() {
		try {
			setupScenario1();
			assertEquals("", dealership.importData("data/gasolineCars.csv", 3));
			setupScenario1();
			assertEquals("", dealership.importData("data/electricCars.csv", 4));
			setupScenario1();
			assertEquals("", dealership.importData("data/hybridCars.csv", 5));
			setupScenario1();
			assertEquals("", dealership.importData("data/motorcycles.csv", 6));
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (LackOfLandException lole) {
			lole.printStackTrace();
		}
	}
}