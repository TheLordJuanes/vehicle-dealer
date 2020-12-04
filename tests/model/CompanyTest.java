package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import exceptions.FavoriteVehicleException;
import exceptions.LackOfLandException;
import exceptions.WorkloadException;

class CompanyTest {

	private Company dealer;

	public void setup1() {
		try {
			dealer = new Company();
			dealer.addEmployee("Carlos", "Quintero", "11-22", 0);
			dealer.addClient("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com", false, false);
			dealer.addEmployee("Sara", "Martinez", "22-11", 0);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void setup2() {
		try {
			dealer = new Company();
			dealer.addClient("Sofia", "Gutierrez", "8734", "(+57) 316 366-8955", "sara@gmail.com", false, false);
			dealer.addEmployee("Carlos", "Quintero", "11-22", 0);
			dealer.addClient("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com",
					false, false);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void setup3() {
		dealer = new Company();
		try {
			dealer.addVehicle("des", 2020, 65329, 9868, 'U', "87439-23", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236,
					544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("th", 2020, 8922, 9868, 'U', "9887-54", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556,
					2019, 2019, "67545287", "236565", 905680, 98989);
			dealer.addVehicle("sdc", 2020, 1212, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 0, 0,
					"", "", 905680, 0);
			dealer.addVehicle("rgf", 2018, 3223, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 0, 0,
					"", "", 905680, 0);
			dealer.addVehicle("yui", 2019, 4532, 0, 'N', "", 0, 5784, 'S', 4, true, 'F', 7634, 0, 121236, 544556, 0, 0,
					"", "", 905680, 0);
			dealer.addVehicle("ngb", 2017, 6542, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0, 121236,
					544556, 0, 0, "", "", 905680, 0);
			dealer.addVehicle("mns", 2020, 2311, 0, 'N', "", 0, 5784, 'O', 32, 0, 121236, 544556, 0, 0, "", "", 905680,
					0);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (LackOfLandException lole) {
			lole.printStackTrace();
		}
	}

	public void setup4() {
		dealer = new Company();
		try {
			dealer.addVehicle("des", 2020, 65329, 9868, 'U', "329843", 0, 5784, 'S', 4, true, 'F', 7634, 0, 121236,
					544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("th", 2020, 8922, 9868, 'U', "98346", 0, 5784, 'S', 4, true, 'F', 7634, 0, 121236, 544556,
					2019, 2019, "67545287", "236565", 905680, 98989);
			dealer.addVehicle("sdc", 2020, 231, 0, 'N', "", 0, 5784, 'S', 4, true, 'F', 7634, 0, 121236, 544556, 0, 0,
					"", "", 905680, 0);
			dealer.addVehicle("rgf", 2018, 654, 0, 'N', "", 0, 5784, 'S', 4, true, 'F', 7634, 0, 121236, 544556, 0, 0,
					"", "", 905680, 0);
			dealer.addVehicle("yui", 2019, 3265, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 0, 0,
					"", "", 905680, 0);
			dealer.addVehicle("ngb", 2017, 6754, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0, 121236,
					544556, 0, 0, "", "", 905680, 0);
			dealer.addVehicle("mns", 2020, 34214, 0, 'N', "", 0, 5784, 'O', 32, 0, 121236, 544556, 0, 0, "", "", 905680,
					0);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (LackOfLandException lole) {
			lole.printStackTrace();
		}
	}

	public void setup5() {
		dealer = new Company();
		try {
			dealer.addVehicle("des", 2020, 65329, 9868, 'U', "329843", 0, 5784, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0,
					121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("th", 2020, 8922, 9868, 'U', "98346", 0, 5784, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0,
					121236, 544556, 2019, 2019, "67545287", "236565", 905680, 98989);
			dealer.addVehicle("sdc", 2020, 231, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0, 121236,
					544556, 0, 0, "", "", 905680, 0);
			dealer.addVehicle("rgf", 2018, 654, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0, 121236,
					544556, 0, 0, "", "", 905680, 0);
			dealer.addVehicle("yui", 2019, 3265, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 0, 0,
					"", "", 905680, 0);
			dealer.addVehicle("ngb", 2017, 6754, 0, 'N', "", 0, 5784, 'S', 4, true, 'F', 7634, 0, 121236, 544556, 0, 0,
					"", "", 905680, 0);
			dealer.addVehicle("mns", 2020, 34214, 0, 'N', "", 0, 5784, 'O', 32, 0, 121236, 544556, 0, 0, "", "", 905680,
					0);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (LackOfLandException lole) {
			lole.printStackTrace();
		}
	}

	public void setup6() {
		dealer = new Company();
		try {
			dealer.addVehicle("des", 2020, 65329, 9868, 'U', "329843", 0, 5784, 'D', 32, 0, 121236, 544556, 2019, 2019,
					"47983432", "76542235", 905680, 98989);
			dealer.addVehicle("th", 2020, 8922, 9868, 'U', "98346", 0, 5784, 'D', 32, 0, 121236, 544556, 2019, 2019,
					"67545287", "236565", 905680, 98989);
			dealer.addVehicle("sdc", 2020, 231, 0, 'N', "", 0, 5784, 'D', 32, 0, 121236, 544556, 0, 0, "", "", 905680,
					0);
			dealer.addVehicle("rgf", 2018, 654, 0, 'N', "", 0, 5784, 'D', 32, 0, 121236, 544556, 0, 0, "", "", 905680,
					0);
			dealer.addVehicle("yui", 2019, 3265, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 0, 0,
					"", "", 905680, 0);
			dealer.addVehicle("ngb", 2017, 6754, 0, 'N', "", 0, 5784, 'S', 4, true, 'F', 7634, 0, 121236, 544556, 0, 0,
					"", "", 905680, 0);
			dealer.addVehicle("mns", 2020, 34214, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0, 121236,
					544556, 0, 0, "", "", 905680, 0);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (LackOfLandException lole) {
			lole.printStackTrace();
		}
	}

	public void setup7() {
		dealer = new Company();
	}

	public void setup8() {
		dealer = new Company();
		try {
			dealer.addVehicle("des", 2020, 65329, 9868, 'U', "329843", 0, 5784, 'D', 32, 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addClient("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com", false, false);
			dealer.addEmployee("Carlos", "Quintero", "11-22", 0);
			dealer.toAssignClient("397368-45456", "11-22", "(+57) 318 302-4309");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (WorkloadException we) {
			we.printStackTrace();
		}
	}

	public void setup9() {
		dealer = new Company();
		try {
			dealer.addVehicle("des", 2020, 65329, 9868, 'U', "329843", 0, 5784, 'D', 32, 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addClient("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com", false, false);
			dealer.addEmployee("Carlos", "Quintero", "11-22", 0);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void setup10() {
		dealer = new Company();
		try {
			dealer.addVehicle("des", 2020, 65329, 9868, 'U', "329843", 0, 5784, 'D', 32, 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addEmployee("Carlos", "Quintero", "11-22", 0);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void setup11() {
		dealer = new Company();
		try {
			dealer.addVehicle("des", 2020, 65329, 9868, 'U', "329843", 0, 5784, 'D', 32, 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addClient("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com", false, false);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void setup12() {
		dealer = new Company();
		try {
			dealer.addClient("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com", false, false);
			dealer.addEmployee("Carlos", "Quintero", "11-22", 0);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void setup13() {
		dealer = new Company();
		try {
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "87439-23", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("th", 2013, 8922, 9868, 'U', "9887-54", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "67545287", "236565", 905680, 98989);
			dealer.addVehicle("des", 2012, 65329, 9868, 'U', "329843", 0, 5784, 'S', 4, true, 'F', 7634, 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("th", 2011, 8922, 9868, 'U', "98346", 0, 5784, 'S', 4, true, 'F', 7634, 0, 121236, 544556, 2019, 2019, "67545287", "236565", 905680, 98989);
			dealer.addVehicle("des", 2010, 65329, 9868, 'U', "5665", 0, 5784, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("th", 2009, 8922, 9868, 'U', "8989", 0, 5784, 'S', 4, true, 32, 'O', 0, 'F', 7634, 0, 121236, 544556, 2019, 2019, "67545287", "236565", 905680, 98989);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (LackOfLandException lole) {
			lole.printStackTrace();
		}
	}

	@Test
	public void testShowEmployeesByTotalSalesAndID() {
		setup1();
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Carlos", "Quintero", "11-22", 0, new BSTClientsInCharge()));
		employees.add(new Employee("Sara", "Martinez", "22-11", 0, new BSTClientsInCharge()));
		Collections.sort(employees);
		assertEquals(employees.size(), dealer.showEmployeesByLastNameAndName().size());
		for (int i = 0; i < employees.size(); i++)
			assertEquals(employees.get(i).getId(), dealer.showEmployeesByTotalSalesAndID().get(i).getId());
	}

	@Test
	public void testShowEmployeesByLastNameAndName() {
		setup1();
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Sara", "Martinez", "22-11", 0, new BSTClientsInCharge()));
		employees.add(new Employee("Carlos", "Quintero", "11-22", 0, new BSTClientsInCharge()));
		assertEquals(employees.size(), dealer.showEmployeesByLastNameAndName().size());
		for (int i = 0; i < employees.size(); i++)
			assertEquals(employees.get(i).getId(), dealer.showEmployeesByLastNameAndName().get(i).getId());
	}

	@Test
	public void testShowClientsByLastNameAndPhone() {
		setup2();
		List<Client> clients = new ArrayList<Client>();
		clients.add(new Client("Sara", "Martinez", "8734", "(+57) 316 366-8955", "sara@gmail.com", false, false,
				new BSTFavoriteVehicles()));
		clients.add(new Client("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com",
				false, false, new BSTFavoriteVehicles()));
		assertEquals(clients.size(), dealer.showClientsByLastNameAndPhone().size());
		for (int i = 0; i < clients.size(); i++)
			assertEquals(clients.get(i).getId(), dealer.showClientsByLastNameAndPhone().get(i).getId());
	}

	@Test
	public void testShowClientsByNameAndEmail() {
		setup2();
		List<Client> clients = new ArrayList<Client>();
		clients.add(new Client("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com",
				false, false, new BSTFavoriteVehicles()));
		clients.add(new Client("Sara", "Martinez", "8734", "(+57) 316 366-8955", "sara@gmail.com", false, false,
				new BSTFavoriteVehicles()));
		assertEquals(clients.size(), dealer.showClientsByNameAndEmail().size());
		for (int i = 0; i < clients.size(); i++)
			assertEquals(clients.get(i).getId(), dealer.showClientsByNameAndEmail().get(i).getId());
	}

	@Test
	public void testShowCarsGasoline() {
		setup3();
		List<Gasoline> gasolineCars = new ArrayList<Gasoline>();
		Document documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		Document documents2 = new Document();
		documents2.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents2.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		gasolineCars.add(new Gasoline(0, 5784, "des", 2020, 65329, 9868, 'U', "87439-23", "", documents, 'S', 4, true,
				32, 'O', 0));
		gasolineCars.add(new Gasoline(0, 5784, "th", 2020, 8922, 9868, 'U', "9887-54", "", documents2, 'S', 4, true, 32,
				'O', 0));
		assertEquals(gasolineCars.size(), dealer.showCarsGasoline('U').size());
		for (int i = 0; i < gasolineCars.size(); i++) {
			assertEquals(gasolineCars.get(i).getLicensePlate(), dealer.showCarsGasoline('U').get(i).getLicensePlate());
		}
		gasolineCars = new ArrayList<Gasoline>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "", 0));
		documents2 = new Document();
		documents2.setFirst(new Soat(121236, 0, "", 905680));
		documents2.getFirst().setNext(new Review(544556, 0, "", 0));
		gasolineCars.add(new Gasoline(0, 5784, "sdc", 2020, 1212, 0, 'N', "", "", documents, 'S', 4, true, 32, 'O', 0));
		gasolineCars
				.add(new Gasoline(0, 5784, "rgf", 2018, 3223, 0, 'N', "", "", documents2, 'S', 4, true, 32, 'O', 0));
		assertEquals(gasolineCars.size(), dealer.showCarsGasoline('U').size());
		for (int i = 0; i < gasolineCars.size(); i++) {
			assertEquals(gasolineCars.get(i).getBrand(), dealer.showCarsGasoline('N').get(i).getBrand());
			assertEquals(gasolineCars.get(i).getModel(), dealer.showCarsGasoline('N').get(i).getModel());
			assertEquals(gasolineCars.get(i).getCylinder(), dealer.showCarsGasoline('N').get(i).getCylinder());
		}
		gasolineCars = new ArrayList<Gasoline>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		documents2 = new Document();
		documents2.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents2.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		Document documents3 = new Document();
		documents3.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents3.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		Document documents4 = new Document();
		documents4.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents4.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		gasolineCars.add(new Gasoline(0, 5784, "des", 2020, 65329, 9868, 'U', "87439-23", "", documents, 'S', 4, true,
				32, 'O', 0));
		gasolineCars.add(new Gasoline(0, 5784, "th", 2020, 8922, 9868, 'U', "9887-54", "", documents2, 'S', 4, true, 32,
				'O', 0));
		gasolineCars
				.add(new Gasoline(0, 5784, "sdc", 2020, 1212, 0, 'N', "", "", documents3, 'S', 4, true, 32, 'O', 0));
		gasolineCars
				.add(new Gasoline(0, 5784, "rgf", 2018, 3223, 0, 'N', "", "", documents4, 'S', 4, true, 32, 'O', 0));
		assertEquals(gasolineCars.size(), dealer.showCarsGasoline('B').size());
		assertEquals(gasolineCars.get(0).getLicensePlate(), dealer.showCarsGasoline('B').get(0).getLicensePlate());
		assertEquals(gasolineCars.get(1).getLicensePlate(), dealer.showCarsGasoline('B').get(1).getLicensePlate());
		assertEquals(gasolineCars.get(2).getBrand(), dealer.showCarsGasoline('B').get(2).getBrand());
		assertEquals(gasolineCars.get(2).getModel(), dealer.showCarsGasoline('B').get(2).getModel());
		assertEquals(gasolineCars.get(2).getCylinder(), dealer.showCarsGasoline('B').get(2).getCylinder());
		assertEquals(gasolineCars.get(3).getBrand(), dealer.showCarsGasoline('B').get(3).getBrand());
		assertEquals(gasolineCars.get(3).getModel(), dealer.showCarsGasoline('B').get(3).getModel());
		assertEquals(gasolineCars.get(3).getCylinder(), dealer.showCarsGasoline('B').get(3).getCylinder());
	}

	@Test
	public void testShowCarsElectric() {
		setup4();
		List<Electric> electricCars = new ArrayList<Electric>();
		Document documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		Document documents2 = new Document();
		documents2.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents2.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		electricCars.add(new Electric(0, 5784, "des", 2020, 65329, 9868, 'U', "329843", "", documents, 'S', 4, true,
				'F', 7634, 0));
		electricCars.add(new Electric(0, 5784, "th", 2020, 8922, 9868, 'U', "98346", "", documents2, 'S', 4, true, 'F',
				7634, 0));
		assertEquals(electricCars.size(), dealer.showCarsElectric('U').size());
		for (int i = 0; i < electricCars.size(); i++) {
			assertEquals(electricCars.get(i).getLicensePlate(), dealer.showCarsElectric('U').get(i).getLicensePlate());
		}
		electricCars = new ArrayList<Electric>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "", 0));
		documents2 = new Document();
		documents2.setFirst(new Soat(121236, 0, "", 905680));
		documents2.getFirst().setNext(new Review(544556, 0, "", 0));
		electricCars
				.add(new Electric(0, 5784, "sdc", 2020, 231, 0, 'N', "", "", documents, 'S', 4, true, 'F', 7634, 0));
		electricCars
				.add(new Electric(0, 5784, "rgf", 2018, 654, 0, 'N', "", "", documents2, 'S', 4, true, 'F', 7634, 0));
		assertEquals(electricCars.size(), dealer.showCarsElectric('U').size());
		for (int i = 0; i < electricCars.size(); i++) {
			assertEquals(electricCars.get(i).getBrand(), dealer.showCarsElectric('N').get(i).getBrand());
			assertEquals(electricCars.get(i).getModel(), dealer.showCarsElectric('N').get(i).getModel());
			assertEquals(electricCars.get(i).getCylinder(), dealer.showCarsElectric('N').get(i).getCylinder());
		}
		electricCars = new ArrayList<Electric>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		documents2 = new Document();
		documents2.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents2.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		Document documents3 = new Document();
		documents3.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents3.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		Document documents4 = new Document();
		documents4.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents4.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		electricCars.add(new Electric(0, 5784, "des", 2020, 65329, 9868, 'U', "329843", "", documents, 'S', 4, true,
				'F', 7634, 0));
		electricCars.add(new Electric(0, 5784, "th", 2020, 8922, 9868, 'U', "98346", "", documents2, 'S', 4, true, 'F',
				7634, 0));
		electricCars
				.add(new Electric(0, 5784, "sdc", 2020, 231, 0, 'N', "", "", documents3, 'S', 4, true, 'F', 7634, 0));
		electricCars
				.add(new Electric(0, 5784, "rgf", 2018, 654, 0, 'N', "", "", documents4, 'S', 4, true, 'F', 7634, 0));
		assertEquals(electricCars.size(), dealer.showCarsElectric('B').size());
		assertEquals(electricCars.get(0).getLicensePlate(), dealer.showCarsElectric('B').get(0).getLicensePlate());
		assertEquals(electricCars.get(1).getLicensePlate(), dealer.showCarsElectric('B').get(1).getLicensePlate());
		assertEquals(electricCars.get(2).getBrand(), dealer.showCarsElectric('B').get(2).getBrand());
		assertEquals(electricCars.get(2).getModel(), dealer.showCarsElectric('B').get(2).getModel());
		assertEquals(electricCars.get(2).getCylinder(), dealer.showCarsElectric('B').get(2).getCylinder());
		assertEquals(electricCars.get(3).getBrand(), dealer.showCarsElectric('B').get(3).getBrand());
		assertEquals(electricCars.get(3).getModel(), dealer.showCarsElectric('B').get(3).getModel());
		assertEquals(electricCars.get(3).getCylinder(), dealer.showCarsElectric('B').get(3).getCylinder());
	}

	@Test
	public void testShowCarsHybrid() {
		setup5();
		List<Hybrid> hybridCars = new ArrayList<Hybrid>();
		Document documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		Document documents2 = new Document();
		documents2.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents2.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		hybridCars.add(new Hybrid(0, 5784, "des", 2020, 65329, 9868, 'U', "329843", "", documents, 'S', 4, true, 32,
				'O', 0, 'F', 7634, 0));
		hybridCars.add(new Hybrid(0, 5784, "th", 2020, 8922, 9868, 'U', "98346", "", documents2, 'S', 4, true, 32, 'O',
				0, 'F', 7634, 0));
		assertEquals(hybridCars.size(), dealer.showCarsHybrid('U').size());
		for (int i = 0; i < hybridCars.size(); i++) {
			assertEquals(hybridCars.get(i).getLicensePlate(), dealer.showCarsHybrid('U').get(i).getLicensePlate());
		}
		hybridCars = new ArrayList<Hybrid>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "", 0));
		documents2 = new Document();
		documents2.setFirst(new Soat(121236, 0, "", 905680));
		documents2.getFirst().setNext(new Review(544556, 0, "", 0));
		hybridCars.add(new Hybrid(0, 5784, "sdc", 2020, 231, 0, 'N', "", "", documents, 'S', 4, true, 32, 'O', 0, 'F',
				7634, 0));
		hybridCars.add(new Hybrid(0, 5784, "rgf", 2018, 654, 0, 'N', "", "", documents2, 'S', 4, true, 32, 'O', 0, 'F',
				7634, 0));
		assertEquals(hybridCars.size(), dealer.showCarsHybrid('U').size());
		for (int i = 0; i < hybridCars.size(); i++) {
			assertEquals(hybridCars.get(i).getBrand(), dealer.showCarsHybrid('N').get(i).getBrand());
			assertEquals(hybridCars.get(i).getModel(), dealer.showCarsHybrid('N').get(i).getModel());
			assertEquals(hybridCars.get(i).getCylinder(), dealer.showCarsHybrid('N').get(i).getCylinder());
		}
		hybridCars = new ArrayList<Hybrid>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		documents2 = new Document();
		documents2.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents2.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		Document documents3 = new Document();
		documents3.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents3.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		Document documents4 = new Document();
		documents4.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents4.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		hybridCars.add(new Hybrid(0, 5784, "des", 2020, 65329, 9868, 'U', "329843", "", documents, 'S', 4, true, 32,
				'O', 0, 'F', 7634, 0));
		hybridCars.add(new Hybrid(0, 5784, "th", 2020, 8922, 9868, 'U', "98346", "", documents2, 'S', 4, true, 32, 'O',
				0, 'F', 7634, 0));
		hybridCars.add(new Hybrid(0, 5784, "sdc", 2020, 231, 0, 'N', "", "", documents3, 'S', 4, true, 32, 'O', 0, 'F',
				7634, 0));
		hybridCars.add(new Hybrid(0, 5784, "rgf", 2018, 654, 0, 'N', "", "", documents4, 'S', 4, true, 32, 'O', 0, 'F',
				7634, 0));
		assertEquals(hybridCars.size(), dealer.showCarsHybrid('B').size());
		assertEquals(hybridCars.get(0).getLicensePlate(), dealer.showCarsHybrid('B').get(0).getLicensePlate());
		assertEquals(hybridCars.get(1).getLicensePlate(), dealer.showCarsHybrid('B').get(1).getLicensePlate());
		assertEquals(hybridCars.get(2).getBrand(), dealer.showCarsHybrid('B').get(2).getBrand());
		assertEquals(hybridCars.get(2).getModel(), dealer.showCarsHybrid('B').get(2).getModel());
		assertEquals(hybridCars.get(2).getCylinder(), dealer.showCarsHybrid('B').get(2).getCylinder());
		assertEquals(hybridCars.get(3).getBrand(), dealer.showCarsHybrid('B').get(3).getBrand());
		assertEquals(hybridCars.get(3).getModel(), dealer.showCarsHybrid('B').get(3).getModel());
		assertEquals(hybridCars.get(3).getCylinder(), dealer.showCarsHybrid('B').get(3).getCylinder());
	}

	@Test
	public void testShowMotorcycles() {
		setup6();
		List<Motorcycle> motorcycles = new ArrayList<Motorcycle>();
		Document documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		Document documents2 = new Document();
		documents2.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents2.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		motorcycles.add(new Motorcycle(0, 5784, "des", 2020, 65329, 9868, 'U', "329843", "", documents, 'D', 32, 0));
		motorcycles.add(new Motorcycle(0, 5784, "th", 2020, 8922, 9868, 'U', "98346", "", documents2, 'D', 32, 0));
		assertEquals(motorcycles.size(), dealer.showMotorcycles('U').size());
		for (int i = 0; i < motorcycles.size(); i++) {
			assertEquals(motorcycles.get(i).getLicensePlate(), dealer.showMotorcycles('U').get(i).getLicensePlate());
		}
		motorcycles = new ArrayList<Motorcycle>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "", 0));
		documents2 = new Document();
		documents2.setFirst(new Soat(121236, 0, "", 905680));
		documents2.getFirst().setNext(new Review(544556, 0, "", 0));
		motorcycles.add(new Motorcycle(0, 5784, "sdc", 2020, 231, 0, 'N', "", "", documents, 'D', 32, 0));
		motorcycles.add(new Motorcycle(0, 5784, "rgf", 2018, 654, 0, 'N', "", "", documents2, 'D', 32, 0));
		assertEquals(motorcycles.size(), dealer.showMotorcycles('U').size());
		for (int i = 0; i < motorcycles.size(); i++) {
			assertEquals(motorcycles.get(i).getBrand(), dealer.showMotorcycles('N').get(i).getBrand());
			assertEquals(motorcycles.get(i).getModel(), dealer.showMotorcycles('N').get(i).getModel());
			assertEquals(motorcycles.get(i).getCylinder(), dealer.showMotorcycles('N').get(i).getCylinder());
		}
		motorcycles = new ArrayList<Motorcycle>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		documents2 = new Document();
		documents2.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents2.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		Document documents3 = new Document();
		documents3.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents3.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		Document documents4 = new Document();
		documents4.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents4.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		motorcycles.add(new Motorcycle(0, 5784, "des", 2020, 65329, 9868, 'U', "329843", "", documents, 'D', 32, 0));
		motorcycles.add(new Motorcycle(0, 5784, "th", 2020, 8922, 9868, 'U', "98346", "", documents2, 'D', 32, 0));
		motorcycles.add(new Motorcycle(0, 5784, "sdc", 2020, 231, 0, 'N', "", "", documents3, 'D', 32, 0));
		motorcycles.add(new Motorcycle(0, 5784, "rgf", 2018, 654, 0, 'N', "", "", documents4, 'D', 32, 0));
		assertEquals(motorcycles.size(), dealer.showMotorcycles('B').size());
		assertEquals(motorcycles.get(0).getLicensePlate(), dealer.showMotorcycles('B').get(0).getLicensePlate());
		assertEquals(motorcycles.get(1).getLicensePlate(), dealer.showMotorcycles('B').get(1).getLicensePlate());
		assertEquals(motorcycles.get(2).getBrand(), dealer.showMotorcycles('B').get(2).getBrand());
		assertEquals(motorcycles.get(2).getModel(), dealer.showMotorcycles('B').get(2).getModel());
		assertEquals(motorcycles.get(2).getCylinder(), dealer.showMotorcycles('B').get(2).getCylinder());
		assertEquals(motorcycles.get(3).getBrand(), dealer.showMotorcycles('B').get(3).getBrand());
		assertEquals(motorcycles.get(3).getModel(), dealer.showMotorcycles('B').get(3).getModel());
		assertEquals(motorcycles.get(3).getCylinder(), dealer.showMotorcycles('B').get(3).getCylinder());
	}

	@Test
	public void testRemovePerson() {
		try {
			setup1();
			assertTrue(dealer.removePerson("22-11"));
			assertEquals(2, dealer.getPeople().size());
			setup1();
			assertFalse(dealer.removePerson("857-243"));
			assertEquals(3, dealer.getPeople().size());
		} catch (IOException ioe) {
			fail("IOException not expected.");
		}
	}

	@Test
	public void testRemoveVehicleWithLicensePlate() {
		try {
			setup3();
			assertEquals("Vehicle with license plate 87439-23 successfully removed from the system.", dealer.removeVehicleWithLicensePlate("87439-23"));
			assertEquals(6, dealer.getVehicles().size());
			setup7();
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "293823", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			assertEquals("Used 2014 model gasoline car present in the parking, so it has been removed from it.\n\nVehicle with license plate 293823 successfully removed from the system.", dealer.removeVehicleWithLicensePlate("293823"));
			setup3();
			assertEquals("This vehicle is not registered in the system with that license plate.", dealer.removeVehicleWithLicensePlate("857-243"));
			assertEquals(7, dealer.getVehicles().size());
		} catch (IOException ioe) {
			fail("IOException not expected.");
		} catch (LackOfLandException lole) {
			fail("LackOfLandException not expected.");
		}
	}

	@Test
	public void testRemoveVehicleWithoutLicensePlate() {
		try {
			setup3();
			assertEquals(
					"The vehicle with brand sdc, model 2020, and cylinder 1212.0 has been removed successfully from the system.",
					dealer.removeVehicleWithoutLicensePlate("sdc", 2020, 1212));
			assertEquals(6, dealer.getVehicles().size());
			setup3();
			assertEquals("This vehicle is not registered in the system with that brand, model and cylinder.",
					dealer.removeVehicleWithoutLicensePlate("hjg", 2011, 34431));
			assertEquals(7, dealer.getVehicles().size());
		} catch (IOException ioe) {
			fail("IOException not expected.");
		}
	}

	@Test
	public void testAddEmployee() {
		try {
			setup1();
			assertEquals("New employee successfully registered.", dealer.addEmployee("Gabriel", "Mejía", "398-231", 0));
			assertEquals(4, dealer.getPeople().size());
			setup1();
			assertEquals("Another employee is already registered in the system with that id.",
					dealer.addEmployee("Gabriel", "Mejía", "11-22", 0));
			assertEquals(3, dealer.getPeople().size());
		} catch (IOException ioe) {
			fail("IOException not expected.");
		}
	}

	@Test
	public void testAddClient() {
		try {
			setup1();
			assertEquals("New client successfully registered.",
					dealer.addClient("Raul", "Suarez", "398-231", "5479-5432", "gabriel@gmail.com", false, false));
			assertEquals(4, dealer.getPeople().size());
			setup1();
			assertEquals("Another client is already registered in the system with that id.",
					dealer.addClient("Raul", "Suarez", "397368-45456", "5479-5432", "gabriel@gmail.com", false, false));
			assertEquals(3, dealer.getPeople().size());
		} catch (IOException ioe) {
			fail("IOException not expected.");
		}
	}

	@Test
	public void testAddVehicle() {
		try {
			setup3();
			assertEquals("Used gasoline car successfully registered.", dealer.addVehicle("des", 2020, 65329, 9868, 'U', "5454", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989));
			assertEquals(8, dealer.getVehicles().size());
			setup3();
			assertEquals("This vehicle was already added to the system before with that license plate.",
					dealer.addVehicle("des", 2020, 65329, 9868, 'U', "87439-23", 0, 5784, 'S', 4, true, 32, 'O', 0,
							121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989));
			assertEquals(7, dealer.getVehicles().size());
			setup3();
			assertEquals("New gasoline car successfully registered.", dealer.addVehicle("ewx", 2018, 65, 0, 'N', "", 0,
					5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 0, 0, "", "", 905680, 0));
			assertEquals(8, dealer.getVehicles().size());
			setup3();
			assertEquals("This vehicle was already added to the system before with those characteristics.",
					dealer.addVehicle("sdc", 2020, 1212, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556,
							0, 0, "", "", 905680, 0));
			assertEquals(7, dealer.getVehicles().size());
		} catch (IOException ioe) {
			fail("IOException not expected.");
		} catch (LackOfLandException lole) {
			fail("LackOfLandException not expected.");
		}
		setup7();
		try {
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "10929", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "2387", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "67564", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "12342", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "765888", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "45356", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "98797", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "347687", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "459823", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "38271", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.addVehicle("des", 2014, 65329, 9868, 'U', "9812", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			fail("LackOfLandException expected.");
		} catch (IOException ioe) {
			fail("IOException not expected.");
		} catch (LackOfLandException lole) {
			for (int i = 0; i < dealer.getParking().length; i++)
				assertNotNull(dealer.getParking()[i][0]);
		}
	}

	@Test
	public void testLookCarsParking() {
		setup13();
		List<Car> carsModel = new ArrayList<Car>();
		Document documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		carsModel.add(new Gasoline(0, 5784, "des", 2014, 65329, 9868, 'U', "87439-23", "", documents, 'S', 4, true, 32,
				'O', 0));
		assertEquals(carsModel.size(), dealer.lookCarsParking(0).size());
		for (int i = 0; i < carsModel.size(); i++) {
			assertEquals(carsModel.get(i).getModel(), dealer.lookCarsParking(0).get(i).getModel());
		}
		carsModel = new ArrayList<Car>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		carsModel.add(
				new Gasoline(0, 5784, "th", 2013, 8922, 9868, 'U', "9887-54", "", documents, 'S', 4, true, 32, 'O', 0));
		assertEquals(carsModel.size(), dealer.lookCarsParking(1).size());
		for (int i = 0; i < carsModel.size(); i++) {
			assertEquals(carsModel.get(i).getModel(), dealer.lookCarsParking(1).get(i).getModel());
		}
		carsModel = new ArrayList<Car>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		carsModel.add(new Gasoline(0, 5784, "des", 2012, 65329, 9868, 'U', "329843", "", documents, 'S', 4, true, 32,
				'O', 0));
		assertEquals(carsModel.size(), dealer.lookCarsParking(2).size());
		for (int i = 0; i < carsModel.size(); i++) {
			assertEquals(carsModel.get(i).getModel(), dealer.lookCarsParking(2).get(i).getModel());
		}
		carsModel = new ArrayList<Car>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		carsModel.add(
				new Gasoline(0, 5784, "th", 2011, 8922, 9868, 'U', "98346", "", documents, 'S', 4, true, 32, 'O', 0));
		assertEquals(carsModel.size(), dealer.lookCarsParking(3).size());
		for (int i = 0; i < carsModel.size(); i++) {
			assertEquals(carsModel.get(i).getModel(), dealer.lookCarsParking(3).get(i).getModel());
		}
		carsModel = new ArrayList<Car>();
		documents = new Document();
		documents.setFirst(new Soat(121236, 2019, "47983432", 905680));
		documents.getFirst().setNext(new Review(544556, 2019, "76542235", 98989));
		Document documents2 = new Document();
		documents2.setFirst(new Soat(121236, 2019, "67545287", 905680));
		documents2.getFirst().setNext(new Review(544556, 2019, "236565", 98989));
		carsModel.add(
				new Gasoline(0, 5784, "des", 2010, 65329, 9868, 'U', "5665", "", documents, 'S', 4, true, 32, 'O', 0));
		carsModel.add(
				new Gasoline(0, 5784, "th", 2009, 8922, 9868, 'U', "8989", "", documents2, 'S', 4, true, 32, 'O', 0));
		assertEquals(carsModel.size(), dealer.lookCarsParking(4).size());
		assertEquals(carsModel.get(0).getModel(), dealer.lookCarsParking(4).get(0).getModel());
		assertEquals(carsModel.get(1).getModel(), dealer.lookCarsParking(4).get(1).getModel());
	}

	@Test
	public void testToAssignClient() {
		try {
			setup7();
			dealer.addClient("hgf", "wss", "1293-543", "8977-111", "78ujn", false, false);
			dealer.addEmployee("Gabriel", "Mejía", "398-231", 0);
			assertEquals("The employee with ID 398-231 is now in charge of the client with ID 1293-543.", dealer.toAssignClient("1293-543", "398-231", "8977-111"));
			assertEquals("The client with ID 1293-543 is already being attended by the employee with ID 398-231.", dealer.toAssignClient("1293-543", "398-231", "8977-111"));
			setup7();
			dealer.addClient("hgf", "wss", "1293-543", "8977-111", "78ujn", false, false);
			assertEquals("Error. You may have one (or all) of these problems:\n(1) This employee is not in the system. Register it.\n(2) This client is not in the system. Register it.", dealer.toAssignClient("1293-543", "398-231", "8977-111"));
			setup7();
			dealer.addEmployee("Gabriel", "Mejía", "398-231", 0);
			assertEquals("Error. You may have one (or all) of these problems:\n(1) This employee is not in the system. Register it.\n(2) This client is not in the system. Register it.", dealer.toAssignClient("1293-543", "398-231", "8977-111"));
		} catch (IOException ioe) {
			fail("IOException not expected.");
		} catch (WorkloadException we) {
			fail("WorkloadException not expected.");
		}
		setup7();
		try {
			dealer.addClient("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 502-4309", "juan@gmail.com", false, false);
			dealer.addClient("Ernesto", "Velez", "49583-72328", "(+57) 301 332-9878", "ernesto@yahoo.com", false, false);
			dealer.addClient("Pablo", "Contreras", "76534-12234", "(+57) 300 988-6754", "pablo@outlook.com", false, false);
			dealer.addClient("Marco", "Silva", "56787-65342", "(+57) 312 286-7232", "marco@hotmail.com", false, false);
			dealer.addClient("Ivan", "Vasquez", "89832-43231", "(+57) 316 789-1293", "ivan@hotmail.com", false, false);
			dealer.addClient("hgf", "wss", "1293-543", "8977-111", "78ujn", false, false);
			dealer.addEmployee("Gabriel", "Mejía", "398-231", 0);
			dealer.toAssignClient("397368-45456", "398-231", "(+57) 318 502-4309");
			dealer.toAssignClient("49583-72328", "398-231", "(+57) 301 332-9878");
			dealer.toAssignClient("76534-12234", "398-231", "(+57) 300 988-6754");
			dealer.toAssignClient("56787-65342", "398-231", "(+57) 312 286-7232");
			dealer.toAssignClient("89832-43231", "398-231", "(+57) 316 789-1293");
			dealer.toAssignClient("1293-543", "398-231", "8977-111");
			fail("WorkloadException expected.");
		} catch (IOException ioe) {
			fail("IOException not expected.");
		} catch (WorkloadException we) {
			for (int i = 0; i < dealer.getPeople().size(); i++) {
				if (dealer.getPeople().get(i) != null) {
					if (dealer.getPeople().get(i).getId().equals("398-231")) {
						if (dealer.getPeople().get(i) instanceof Employee) {
							Employee emp = (Employee) dealer.getPeople().get(i);
							assertEquals(5, emp.getClientsInCharge().getSize());
						}
					}
				}
			}
		}
	}

	@Test
	public void testToAssignVehicleNew() {
		try {
			setup7();
			dealer.addClient("hgf", "wss", "1293-543", "8977-111", "78ujn", false, false);
			dealer.addVehicle("sdc", 2020, 1212, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 0, 0, "", "", 905680, 0);
			assertEquals("The new vehicle with cylinder 1212.0 has been added to the list of vehicles of interest of the client with ID 1293-543.", dealer.toAssignVehicleNew("1293-543", "sdc", 2020, 1212));
			setup7();
			dealer.addClient("hgf", "wss", "1293-543", "8977-111", "78ujn", false, false);
			assertEquals("Error. You may have one or more (or all) of these problems:\n(1). This client is not in the system. Register it.\n(2). This type new vehicle isn't registered in the system with that brand, that model and that cylinder.", dealer.toAssignVehicleNew("1293-543", "sdc", 2020, 1212));
			setup7();
			dealer.addVehicle("sdc", 2020, 1212, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 0, 0, "", "", 905680, 0);
			assertEquals("Error. You may have one or more (or all) of these problems:\n(1). This client is not in the system. Register it.\n(2). This type new vehicle isn't registered in the system with that brand, that model and that cylinder.", dealer.toAssignVehicleNew("1293-543", "sdc", 2020, 1212));
		} catch (IOException ioe) {
			fail("IOException not expected.");
		} catch (LackOfLandException lole) {
			fail("LackOfLandException not expected.");
		} catch (FavoriteVehicleException fve) {
			fail("FavoriteVehicleException not expected.");
		}
		setup7();
		try {
			dealer.addClient("hgf", "wss", "1293-543", "8977-111", "78ujn", false, false);
			dealer.addVehicle("sdc", 2020, 1212, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 0, 0, "", "", 905680, 0);
			dealer.toAssignVehicleNew("1293-543", "sdc", 2020, 1212);
			assertEquals("Error. The new vehicle with cylinder 1212.0 is already in the list of vehicles of interest of the client with ID 1293-543.", dealer.toAssignVehicleNew("1293-543", "sdc", 2020, 1212));
			fail("FavoriteVehicleException expected.");
		} catch (IOException ioe) {
			fail("IOException not expected.");
		} catch (LackOfLandException lole) {
			fail("LackOfLandException not expected.");
		} catch (FavoriteVehicleException fve) {
			for (int i = 0; i < dealer.getPeople().size(); i++) {
				if (dealer.getPeople().get(i) != null) {
					if (dealer.getPeople().get(i).getId().equals("1293-543")) {
						if (dealer.getPeople().get(i) instanceof Client) {
							Client cl = (Client) dealer.getPeople().get(i);
							assertNotNull(cl.getVehiclesOfInterest().searchFavoriteVehicle(1212));
						}
					}
				}
			}
		}
	}

	@Test
	public void testToAssignVehicleUsed() {
		try {
			setup7();
			dealer.addClient("hgf", "wss", "1293-543", "8977-111", "78ujn", false, false);
			dealer.addVehicle("des", 2020, 65329, 9868, 'U', "87439-23", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			assertEquals("The used vehicle with cylinder 65329.0 has been added to the list of vehicles of interest of the client with ID 1293-543.", dealer.toAssignVehicleUsed("1293-543", "87439-23", 65329));
			setup7();
			dealer.addClient("hgf", "wss", "1293-543", "8977-111", "78ujn", false, false);
			assertEquals("Error. You may have one or more (or all) of these problems:\n(1). This client is not in the system.\n(2). This used vehicle isn't registered in the system with that license plate.", dealer.toAssignVehicleUsed("1293-543", "87439-23", 65329));
			setup7();
			dealer.addVehicle("sdc", 2020, 1212, 0, 'N', "", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 0, 0, "", "", 905680, 0);
			assertEquals("Error. You may have one or more (or all) of these problems:\n(1). This client is not in the system.\n(2). This used vehicle isn't registered in the system with that license plate.", dealer.toAssignVehicleUsed("1293-543", "87439-23", 65329));
		} catch (IOException ioe) {
			fail("IOException not expected.");
		} catch (LackOfLandException lole) {
			fail("LackOfLandException not expected.");
		} catch (FavoriteVehicleException fve) {
			fail("FavoriteVehicleException not expected.");
		}
		setup7();
		try {
			dealer.addClient("hgf", "wss", "1293-543", "8977-111", "78ujn", false, false);
			dealer.addVehicle("des", 2020, 65329, 9868, 'U', "87439-23", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.toAssignVehicleUsed("1293-543", "87439-23", 65329);
			assertEquals("The used vehicle with cylinder 65329.0 is already in the list of vehicles of interest of the client with ID 1293-543.", dealer.toAssignVehicleUsed("1293-543", "87439-23", 65329));
			fail("FavoriteVehicleException expected.");
		} catch (IOException ioe) {
			fail("IOException not expected.");
		} catch (LackOfLandException lole) {
			fail("LackOfLandException not expected.");
		} catch (FavoriteVehicleException fve) {
			for (int i = 0; i < dealer.getPeople().size(); i++) {
				if (dealer.getPeople().get(i) != null) {
					if (dealer.getPeople().get(i).getId().equals("1293-543")) {
						if (dealer.getPeople().get(i) instanceof Client) {
							Client cl = (Client) dealer.getPeople().get(i);
							assertNotNull(cl.getVehiclesOfInterest().searchFavoriteVehicle(65329));
						}
					}
				}
			}
		}
	}

	@Test
	public void testExportDataVehicles() {
		try {
			setup7();
			dealer.addVehicle("des", 2020, 65329, 9868, 'U', "87439-23", 0, 5784, 'S', 4, true, 32, 'O', 0, 121236, 544556, 2019, 2019, "47983432", "76542235", 905680, 98989);
			dealer.exportDataVehicles("data/gasolineCarsTest.csv", ";", 'G');
			assertTrue(new File("data/gasolineCarsTest.csv").exists());
			assertTrue(new File("data/gasolineCarsTest.csv").isFile());
			BufferedReader br = new BufferedReader(new FileReader("data/gasolineCarsTest.csv"));
			assertEquals("Vehicle brand;Vehicle model;Vehicle type;Vehicle base price;Vehicle license plate;Vehicle cylinder;Vehicle mileage;Owner ID;SOAT document code;SOAT document price;SOAT document year;SOAT coverage amount;Mechanical Technical Review document code;Mechanical Technical Review document price;Mechanical Technical Review document year;Gas level released;Car type;Doors number;Polarized Windows;Gasoline type;Gasoline capacity;Gasoline consume;Total selling price", br.readLine());
			assertEquals("des;2020;U;5784.0;87439-23;65329.0;9868.0;NONE;47983432;121236.0;2019;905680.0;76542235;544556.0;2019;98989.0;S;4;true;O;32.0;20905.28;948976.5600000002", br.readLine());
			br.close();
		} catch (IOException ioe) {
			fail("IOException not expected.");
		} catch (LackOfLandException lole) {
			fail("LackOfLandException not expected.");
		}
	}

	@Test
	public void testImportData() {
		try {
			setup7();
			dealer.addVehicle("th", 2020, 8922, 9868, 'U', "98346", 0, 5784, 'S', 4, true, 'F', 7634, 0, 121236, 544556, 2019, 2019, "67545287", "236565", 905680, 98989);
			assertEquals(1, dealer.getVehicles().size());
			dealer.exportDataVehicles("data/electricCarsTest.csv", ";", 'E');
			dealer.removeVehicleWithLicensePlate("98346");
			assertEquals(0, dealer.getVehicles().size());
			dealer.importData("data/electricCarsTest.csv", 4);
			assertEquals(1, dealer.getVehicles().size());
			assertTrue(dealer.getVehicles().get(0) instanceof Electric);
			assertEquals("98346", dealer.getVehicles().get(0).getLicensePlate());
			assertEquals("\nThe electric car with license plate 98346 was already registered in the system.\n", dealer.importData("data/electricCarsTest.csv", 4));
			assertEquals(1, dealer.getVehicles().size());
			dealer.importData("data/gasolineCars.csv", 3);
			assertEquals(2, dealer.getVehicles().size());
			dealer.importData("data/hybridCars.csv", 5);
			assertEquals(3, dealer.getVehicles().size());
			dealer.importData("data/motorcycles.csv", 6);
			assertEquals(4, dealer.getVehicles().size());
		} catch (IOException ioe) {
			fail("IOException not expected.");
		} catch (LackOfLandException lole) {
			fail("LackOfLandException not expected.");
		}
	}

	@Test
	public void testSellAVehicle() {
		try {
			setup8();
			assertEquals("The used motorcycle with the license plate 329843 has been sold to the client with ID 397368-45456.", dealer.sellAVehicle("329843", "11-22", "397368-45456", 4, 'U', "des", 2020, 65329, "(+57) 318 302-4309"));
			setup9();
			assertEquals("Error. The employee with ID 11-22 is not in charge of the client with ID 397368-45456.", dealer.sellAVehicle("329843", "11-22", "397368-45456", 4, 'U', "des", 2020, 65329, "(+57) 318 302-4309"));
			setup10();
			assertEquals("Error. You may have one or more (or all) of these problems:\n(1) This employee is not in the system. Register it.\n(2) This client is not in the system. Register it.\n(3) This vehicle is not in the system. Add it.", dealer.sellAVehicle("329843", "11-22", "397368-45456", 4, 'U', "des", 2020, 65329, "(+57) 318 302-4309"));
			setup11();
			assertEquals("Error. You may have one or more (or all) of these problems:\n(1) This employee is not in the system. Register it.\n(2) This client is not in the system. Register it.\n(3) This vehicle is not in the system. Add it.", dealer.sellAVehicle("329843", "11-22", "397368-45456", 4, 'U', "des", 2020, 65329, "(+57) 318 302-4309"));
			setup12();
			assertEquals("Error. You may have one or more (or all) of these problems:\n(1) This employee is not in the system. Register it.\n(2) This client is not in the system. Register it.\n(3) This vehicle is not in the system. Add it.", dealer.sellAVehicle("329843", "11-22", "397368-45456", 4, 'U', "des", 2020, 65329, "(+57) 318 302-4309"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}