package model;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

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
			dealer.addClient("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com", false, false);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void setup3() {
		dealer = new Company();
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
		clients.add(new Client("Sara", "Martinez", "8734", "(+57) 316 366-8955", "sara@gmail.com", false, false, new BSTFavoriteVehicles()));
		clients.add(new Client("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com", false, false, new BSTFavoriteVehicles()));
		assertEquals(clients.size(), dealer.showClientsByLastNameAndPhone().size());
		for (int i = 0; i < clients.size(); i++)
			assertEquals(clients.get(i).getId(), dealer.showClientsByLastNameAndPhone().get(i).getId());
	}

	@Test
	public void testShowClientsByNameAndEmail() {
		setup2();
		List<Client> clients = new ArrayList<Client>();
		clients.add(new Client("Juan Esteban", "Caicedo", "397368-45456", "(+57) 318 302-4309", "juancaicedo@gmail.com", false, false, new BSTFavoriteVehicles()));
		clients.add(new Client("Sara", "Martinez", "8734", "(+57) 316 366-8955", "sara@gmail.com", false, false, new BSTFavoriteVehicles()));
		assertEquals(clients.size(), dealer.showClientsByNameAndEmail().size());
		for (int i = 0; i < clients.size(); i++)
			assertEquals(clients.get(i).getId(), dealer.showClientsByNameAndEmail().get(i).getId());
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
			ioe.printStackTrace();
		}
	}

	@Test
    public void testAddEmployee() {
		try {
			setup1();
			assertEquals("New employee successfully registered.", dealer.addEmployee("Gabriel", "Mejía", "398-231", 0));
			assertEquals(4, dealer.getPeople().size());
			setup1();
			assertEquals("Another employee is already registered in the system with that id.", dealer.addEmployee("Gabriel", "Mejía", "11-22", 0));
			assertEquals(3, dealer.getPeople().size());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Test
    public void testAddClient() {
		try {
			setup1();
			assertEquals("New client successfully registered.", dealer.addClient("Raul", "Suarez", "398-231", "5479-5432", "gabriel@gmail.com", false, false));
			assertEquals(4, dealer.getPeople().size());
			setup1();
			assertEquals("Another client is already registered in the system with that id.", dealer.addClient("Raul", "Suarez", "397368-45456", "5479-5432", "gabriel@gmail.com", false, false));
			assertEquals(3, dealer.getPeople().size());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}