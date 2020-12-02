/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import exceptions.FavoriteVehicleException;
import exceptions.LackOfLandException;
import exceptions.WorkloadException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Company {

	// -----------------------------------------------------------------
	// Constants
	// -----------------------------------------------------------------

	public final static int PARKING_SIZE_ROWS = 10;
	public final static int PARKING_SIZE_COLUMNS = 5;
	public final static String SEPARATOR = ";";
	public final static String SAVE_VEHICLES_PATH_FILE = "data/vehicles.ap2";
	public final static String SAVE_PEOPLE_PATH_FILE = "data/people.ap2";
	public final static String SAVE_CARS_IN_PARKING_PATH_FILE = "data/parking.ap2";
	public final static String SAVE_HEADQUARTERS_PATH_FILE = "data/headquarters.ap2";

	// -----------------------------------------------------------------
	// Attributes
	// -----------------------------------------------------------------

	private String nameCompany;
	private String nit;
	private double totalEarnings;
	private int numSales;

	// -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

	private List<Person> people;
	private Car[][] parking;
	private List<Vehicle> vehicles;
	private ListHeadquarters headquarters;

	// -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

	/**
	 * Name: Company
	 * Constructor method of a company. <br>
	 * @param nameCompany - name of the company - nameCompany = String, nameCompany != null, nameCompany != ""
	 * @param nit - company's NIT - nit = String, nit != null, nit != ""
	 * @param totalEarnings - total earnings of the company - totalEarnings = double
	 * @param numSales - number of sales of the company - numSales = int, numSales != null
	 * @throws ClassNotFoundException - if the program tries to load in a class through its String name but no definition for the class with the specified name could be found.
     * @throws IOException - if it cannot read the file properly while loading.
	 */
	public Company(String nameCompany, String nit, double totalEarnings, int numSales) throws ClassNotFoundException, IOException {
		this.nameCompany = nameCompany;
		this.nit = nit;
		this.totalEarnings = totalEarnings;
		this.numSales = numSales;
		people = new ArrayList<Person>();
		vehicles = new ArrayList<Vehicle>();
		parking = new Car[PARKING_SIZE_ROWS][PARKING_SIZE_COLUMNS];
		headquarters = new ListHeadquarters();
		loadData();
	}

	/**
	 * Name: getNameCompany
	 * Method used to get the name of the company. <br>
	 * @return A String representing the name of the company.
	*/
	public String getNameCompany() {
		return this.nameCompany;
	}

	/**
	 * Name: setNameCompany
	 * Method used to update the name of the company.  <br>
	 * @param nameCompany - name of the company - nameCompany = String, nameCompany != null, nameCompany != ""
	*/
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	/**
	 * Name: getNit
	 * Method used to get the company's NIT. <br>
	 * @return A String representing the company's NIT.
	*/
	public String getNit() {
		return this.nit;
	}

	/**
	 * Name: setNit
	 * Method used to update the company's NIT. <br>
	 * @param nit - company's NIT - nit = String, nit != null, nit != ""
	*/
	public void setNit(String nit) {
		this.nit = nit;
	}

	/**
	 * Name: getTotalEarnings
	 * Method used to get the total earnings of the company. <br>
	 * @return A double representing the total earnings of the company.
	*/
	public double getTotalEarnings() {
		return this.totalEarnings;
	}

	/**
	 * Name: setTotalEarnings
	 * Method used to update the total earnings of the company. <br>
	 * @param totalEarnings - total earnings of the company - totalEarnings = double
	*/
	public void setTotalEarnings(double totalEarnings) {
		this.totalEarnings = totalEarnings;
	}

	/**
	 * Name: getNumSales
	 * Method used to get the number of sales of the company. <br>
	 * @return An int representing the number of sales of the company.
	*/
	public int getNumSales() {
		return this.numSales;
	}

	/**
	 * Name: setNumSales
	 * Method used to update the number of sales of the company. <br>
	 * @param numSales - number of sales of the company - numSales = int, numSales != null
	*/
	public void setNumSales(int numSales) {
		this.numSales = numSales;
	}

	/**
	 * Name: getPeople
	 * Method used to get the list of people related to the company. <br>
	 * @return An ArrayList Person representing the list of people related to the dealer.
	*/
	public List<Person> getPeople() {
		return people;
	}

	/**
	 * Name: setPeople
	 * Method used to update the list of people related to the company. <br>
	 * @param people - list of people related to the company - people = ArrayList of Person, people != null
	*/
	public void setPeople(List<Person> people) {
		this.people = people;
	}

	/**
	 * Name: getParking
	 * Method used to get the matrix representing the parking of old used vehicles. <br>
	 * @return A Car[][] representing the parking of old used vehicles.
	*/
	public Car[][] getParking() {
		return parking;
	}

	/**
	 * Name: setParking
	 * Method used to update the matrix representing the parking of old used vehicles. <br>
	 * @param parking - matrix representing the parking of old used vehicles - parking = Car[][]
	*/
	public void setParking(Car[][] parking) {
		this.parking = parking;
	}

	/**
	 * Name: getVehicles
	 * Method used to get the list of vehicles of the company. <br>
	 * @return An ArrayList of Vehicle representing the list of vehicles of the company.
	*/
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * Name: setVehicles
	 * Method used to update the list of vehicles of the company. <br>
	 * @param vehicles - list of vehicles of the company - vehicles = ArrayList of Vehicle
	*/
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public ListHeadquarters getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(ListHeadquarters headquarters) {
		this.headquarters = headquarters;
	}

	/**
     * Name: saveDataCarsParking
     * Method used to serialize the list of cars present in the parking. <br>
     * <b>pre: </b> Matrix of Vehicle already initialized and a Vehicle object is added to this matrix. <br>
     * <b>post: </b> Matrix of vehicles serialized. <br>
     * @throws IOException - if it cannot write the file properly while saving.
    */
   	private void saveDataCarsParking() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_CARS_IN_PARKING_PATH_FILE));
		oos.writeObject(parking);
		oos.close();
	}

	/**
	* Name: saveDataPeople
	* Method used to serialize the list of people of the system. <br>
	* <b>pre: </b> List of people already initialized and a Person object is added to this list. <br>
	* <b>post: </b> List of people serialized. <br>
	* @throws IOException - if it cannot write the file properly while saving.
	*/
	private void saveDataPeople() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PEOPLE_PATH_FILE));
		oos.writeObject(people);
		oos.close();
	}

	/**
     * Name: saveDataVehicles
     * Method used to serialize the list of vehicles of the system. <br>
     * <b>pre: </b> List of vehicles already initialized and a Vehicle object is added to this list. <br>
     * <b>post: </b> List of vehicles serialized. <br>
     * @throws IOException - if it cannot write the file properly while saving.
    */
   	private void saveDataVehicles() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_VEHICLES_PATH_FILE));
		oos.writeObject(vehicles);
		oos.close();
 	}

	/**
     * Name: loadData
     * Method used to deserialize all the saved data in the system. <br>
     * <b>post: </b> Loading process determined of all the saved data in the system. <br>
     * @throws ClassNotFoundException - if the program tries to load in a class through its String name but no definition for the class with the specified name could be found.
     * @throws IOException - if it cannot read the file properly while loading.
    */
   @SuppressWarnings("unchecked")
   	private void loadData() throws ClassNotFoundException, IOException {
	  	File f1 = new File(SAVE_VEHICLES_PATH_FILE);
		if (f1.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f1));
			vehicles = (List<Vehicle>) ois.readObject();
			ois.close();
		}
		File f2 = new File(SAVE_PEOPLE_PATH_FILE);
		if (f2.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f2));
			people = (List<Person>) ois.readObject();
			ois.close();
		}
		File f3 = new File(SAVE_CARS_IN_PARKING_PATH_FILE);
		if (f3.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f3));
			parking = (Car[][]) ois.readObject();
			ois.close();
		}
		File f4 = new File(SAVE_HEADQUARTERS_PATH_FILE);
		if (f4.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f4));
			headquarters.setFirst((Headquarter) ois.readObject());
			ois.close();
		}
	}

	public String binarySearchEmployeeID(String idEmployee) { // añadir a diagrama de clases junto con toString() de Employee
		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i) != null) {
				if (people.get(i) instanceof Employee) {
					Employee em = (Employee) people.get(i);
					employees.add(em);
				}
			}
		}
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee emp1, Employee emp2) {
				return emp1.getId().compareTo(emp2.getId());
			}
		});
		int start = 0, end = employees.size() - 1;
		long startTime = System.currentTimeMillis();
		while (start <= end) {
			int middle = (int) Math.floor((start + end) / 2);
			if (employees.get(middle).getId().compareTo(idEmployee) == 0) {
				long endTime = System.currentTimeMillis();
				return "Employee found:\n\nLast name " + SEPARATOR + " Name " + SEPARATOR + " ID number " + SEPARATOR + " Total sales\n" + employees.get(middle).toString(SEPARATOR) + "\n\nSearch duration: " + (endTime - startTime) / 1e6 + " seconds.";
			}
			else if (employees.get(middle).getId().compareTo(idEmployee) < 0)
				start = middle + 1;
			else
				end = middle - 1;
		}
		return "Employee not found with the ID: " + idEmployee;
	}

	public String binarySearchClientPhone(String phone) { // añadir a diagrama de clases junto con toString() de Client
		List<Client> clients = new ArrayList<Client>();
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i) != null) {
				if (people.get(i) instanceof Client) {
					Client em = (Client) people.get(i);
					clients.add(em);
				}
			}
		}
		Collections.sort(clients, new Comparator<Client>() {

			@Override
			public int compare(Client cl1, Client cl2) {
				return cl1.getNumPhone().compareTo(cl2.getNumPhone());
			}
		});
		int start = 0, end = clients.size() - 1;
		long startTime = System.currentTimeMillis();
		while (start <= end) {
			int middle = (int) Math.floor((start + end) / 2);
			if (clients.get(middle).getNumPhone().compareTo(phone) == 0) {
				long endTime = System.currentTimeMillis();
				return "Client found:\n\nLast name " + SEPARATOR + " Name " + SEPARATOR + " ID number " + SEPARATOR + " Phone number " + SEPARATOR + " E-mail " + SEPARATOR + " Active client " + SEPARATOR + " Has seller\n" + clients.get(middle).toString(SEPARATOR) + "\n\nSearch duration: " + (endTime - startTime) / 1e6 + " seconds.";
			}
			else if (clients.get(middle).getNumPhone().compareTo(phone) < 0)
				start = middle + 1;
			else
				end = middle - 1;
		}
		return "Client not found with the phone number: " + phone;
	}

	/**
     * Name: importData
     * Method used to import external data from employees, clients, or a kind of vehicle. <br>
     * <b>pre: </b> List of vehicles already initialized; list of people already initialized. <br>
     * <b>post: </b> Importing process determined of the external data from employees, clients, or vehicles. <br>
     * @param fileName - File name from the external data in question that will be read - fileName = String, fileName != null, fileName != ""
     * @param data - Variable to specify what is it going to be imported - data = int, data != null, data is a number from 1 to 3.
     * @throws IOException - if it cannot write a file properly while saving after importing and then adding an employee, a client, or a vehicle.
	 * @throws LackOfLandException - if there is no more space to place a used car of a specific model in a column of the parking.
	 * @return Eventually a message if an object from Employee, Client or Vehicle class didn't exist while it was trying to import.
    */
   	public String importData(String fileName, int data) throws IOException, NumberFormatException, LackOfLandException {
		String message = "";
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		if (data == 1) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] parts = line.split(SEPARATOR);
				Person objSearch = searchPerson(parts[2]);
				if (objSearch != null)
					message += "\nThe employee with NIT " + parts[2] + " was already registered in the system.\n";
				else {
					addEmployee(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
					saveDataPeople();
				}
				line = br.readLine();
			}
		} else if (data == 2) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] parts = line.split(SEPARATOR);
				Person objSearch = searchPerson(parts[2]);
				if (objSearch != null)
					message += "\nThe client with ID " + parts[2] + " was already registered in the system.\n";
				else {
					addClient(parts[0], parts[1], parts[2], parts[3], parts[4], Boolean.parseBoolean(parts[5]), Boolean.parseBoolean(parts[6]));
					saveDataPeople();
				}
				line = br.readLine();
			}
		} else if (data == 3) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] parts = line.split(SEPARATOR);
				Vehicle objSearch = parts[2].charAt(0) == Vehicle.TYPE_VEHICLE_USED ? searchVehicleWithLicensePlate(parts[4])
						: searchVehicleWithoutLicensePlate(parts[0], Integer.parseInt(parts[1]),
								Double.parseDouble(parts[5]));
				if (objSearch != null)
					message += parts[2].charAt(0) == Vehicle.TYPE_VEHICLE_USED
							? "\nThe gasoline car with license plate " + parts[2]
									+ " was already registered in the system.\n"
							: "\nThe gasoline car with brand " + parts[0] + ", model " + parts[1] + " and cylinder "
									+ parts[5] + " was already registered in the system.\n";
				else {
					addVehicle(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[5]),
							Double.parseDouble(parts[6]), parts[2].charAt(0), parts[4], Double.parseDouble(parts[21]),
							Double.parseDouble(parts[3]), parts[15].charAt(0), Integer.parseInt(parts[16]),
							Boolean.parseBoolean(parts[17]), Double.parseDouble(parts[19]), parts[18].charAt(0),
							Double.parseDouble(parts[20]), Double.parseDouble(parts[8]), Double.parseDouble(parts[12]),
							Integer.parseInt(parts[9]), Integer.parseInt(parts[13]), parts[7], parts[11],
							Double.parseDouble(parts[10]), Double.parseDouble(parts[14]));
					saveDataVehicles();
				}
				line = br.readLine();
			}
		} else if (data == 4) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] parts = line.split(SEPARATOR);
				Vehicle objSearch = parts[2].charAt(0) == Vehicle.TYPE_VEHICLE_USED ? searchVehicleWithLicensePlate(parts[4])
						: searchVehicleWithoutLicensePlate(parts[0], Integer.parseInt(parts[1]),
								Double.parseDouble(parts[5]));
				if (objSearch != null)
					message += parts[2].charAt(0) == Vehicle.TYPE_VEHICLE_USED
							? "\nThe electric car with license plate " + parts[2]
									+ " was already registered in the system.\n"
							: "\nThe electric car with brand " + parts[0] + ", model " + parts[1] + " and cylinder "
									+ parts[5] + " was already registered in the system.\n";
				else {
					addVehicle(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[5]),
							Double.parseDouble(parts[6]), parts[2].charAt(0), parts[4], Double.parseDouble(parts[21]),
							Double.parseDouble(parts[3]), parts[15].charAt(0), Integer.parseInt(parts[16]),
							Boolean.parseBoolean(parts[17]), parts[18].charAt(0), Double.parseDouble(parts[19]),
							Double.parseDouble(parts[20]), Double.parseDouble(parts[8]), Double.parseDouble(parts[12]),
							Integer.parseInt(parts[9]), Integer.parseInt(parts[13]), parts[7], parts[11],
							Double.parseDouble(parts[10]), Double.parseDouble(parts[14]));
					saveDataVehicles();
				}
				line = br.readLine();
			}
		} else if (data == 5) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] parts = line.split(SEPARATOR);
				Vehicle objSearch = parts[2].charAt(0) == Vehicle.TYPE_VEHICLE_USED ? searchVehicleWithLicensePlate(parts[4])
						: searchVehicleWithoutLicensePlate(parts[0], Integer.parseInt(parts[1]),
								Double.parseDouble(parts[5]));
				if (objSearch != null)
					message += parts[2].charAt(0) == Vehicle.TYPE_VEHICLE_USED
							? "\nThe hybrid car with license plate " + parts[2] + " was already registered in the system.\n"
							: "\nThe hybrid car with brand " + parts[0] + ", model " + parts[1] + " and cylinder "
									+ parts[5] + " was already registered in the system.\n";
				else {
					addVehicle(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[5]),
							Double.parseDouble(parts[6]), parts[2].charAt(0), parts[4], Double.parseDouble(parts[24]),
							Double.parseDouble(parts[3]), parts[15].charAt(0), Integer.parseInt(parts[16]),
							Boolean.parseBoolean(parts[17]), Double.parseDouble(parts[19]), parts[18].charAt(0),
							Double.parseDouble(parts[20]), parts[21].charAt(0), Double.parseDouble(parts[22]), Double.parseDouble(parts[23]), Double.parseDouble(parts[8]), Double.parseDouble(parts[12]),
							Integer.parseInt(parts[9]), Integer.parseInt(parts[13]), parts[7], parts[11],
							Double.parseDouble(parts[10]), Double.parseDouble(parts[14]));
					saveDataVehicles();
				}
				line = br.readLine();
			}
		} else if (data == 6) {
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] parts = line.split(SEPARATOR);
				Vehicle objSearch = parts[2].charAt(0) == Vehicle.TYPE_VEHICLE_USED ? searchVehicleWithLicensePlate(parts[4])
						: searchVehicleWithoutLicensePlate(parts[0], Integer.parseInt(parts[1]),
								Double.parseDouble(parts[5]));
				if (objSearch != null)
					message += parts[2].charAt(0) == Vehicle.TYPE_VEHICLE_USED
							? "\nThe motorcycle with license plate " + parts[2]
									+ " was already registered in the system.\n"
							: "\nThe motorcycle with brand " + parts[0] + ", model " + parts[1] + " and cylinder "
									+ parts[5] + " was already registered in the system.\n";
				else {
					addVehicle(parts[0], Integer.parseInt(parts[1]), Double.parseDouble(parts[5]),
							Double.parseDouble(parts[6]), parts[2].charAt(0), parts[4], Double.parseDouble(parts[18]),
							Double.parseDouble(parts[3]), parts[15].charAt(0), Double.parseDouble(parts[16]), Double.parseDouble(parts[17]), Double.parseDouble(parts[8]), Double.parseDouble(parts[12]),
							Integer.parseInt(parts[9]), Integer.parseInt(parts[13]), parts[7], parts[11],
							Double.parseDouble(parts[10]), Double.parseDouble(parts[14]));
					saveDataVehicles();
				}
				line = br.readLine();
			}
		}
		br.close();
		return message;
	}

   	public void exportDataVehicles(String fileName, String separator, char vehicle) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);
		if (vehicle == 'G') {
			List<Gasoline> gasolineCars = new ArrayList<Gasoline>();
			for (int i = 0; i < vehicles.size(); i++) {
				if (vehicles.get(i) != null) {
					if (vehicles.get(i) instanceof Gasoline) {
						Gasoline gas = (Gasoline) vehicles.get(i);
						gasolineCars.add(gas);
					}
				}
			}
			Collections.sort(gasolineCars, new Comparator<Gasoline>() {

				@Override
				public int compare(Gasoline gas1, Gasoline gas2) {
					int result = gas1.getBrand().compareToIgnoreCase(gas2.getBrand());
					if (result == 0)
						result = String.valueOf(gas2.getModel()).compareTo(String.valueOf(gas1.getModel()));
					return result;
				}
			});
			pw.println("Vehicle brand" + separator + "Vehicle model" + separator + "Vehicle type" + separator + "Vehicle base price" + separator + "Vehicle license plate" + separator + "Vehicle cylinder" + separator + "Vehicle mileage" + separator + "Owner ID" + separator + "SOAT document code" + separator + "SOAT document price" + separator + "SOAT document year" + separator + "SOAT coverage amount" + separator + "Mechanical Technical Review document code" + separator + "Mechanical Technical Review document price" + separator + "Mechanical Technical Review document year" + separator + "Gas level released" + separator + "Car type" + separator + "Doors number" + separator + "Polarized Windows" + separator + "Gasoline type" + separator + "Gasoline capacity" + separator + "Gasoline consume" + separator + "Total selling price");
			for (Gasoline gas : gasolineCars)
				pw.println(gas.toString(separator));
		} else if (vehicle == 'E') {
			List<Electric> electricCars = new ArrayList<Electric>();
			for (int i = 0; i < vehicles.size(); i++) {
				if (vehicles.get(i) != null) {
					if (vehicles.get(i) instanceof Electric) {
						Electric elec = (Electric) vehicles.get(i);
						electricCars.add(elec);
					}
				}
			}
			Collections.sort(electricCars, new Comparator<Electric>() {

				@Override
				public int compare(Electric elec1, Electric elec2) {
					int result = elec1.getBrand().compareToIgnoreCase(elec2.getBrand());
					if (result == 0)
						result = String.valueOf(elec2.getModel()).compareTo(String.valueOf(elec1.getModel()));
					return result;
				}
			});
			pw.println("Vehicle brand" + separator + "Vehicle model" + separator + "Vehicle type" + separator + "Vehicle base price" + separator + "Vehicle license plate" + separator + "Vehicle cylinder" + separator + "Vehicle mileage" + separator + "Owner ID" + separator + "SOAT document code" + separator + "SOAT document price" + separator + "SOAT document year" + separator + "SOAT coverage amount" + separator + "Mechanical Technical Review document code" + separator + "Mechanical Technical Review document price" + separator + "Mechanical Technical Review document year" + separator + "Gas level released" + separator + "Car type" + separator + "Doors number" + separator + "Polarized Windows" + separator + "Charger type" + separator + "Battery duration" + separator + "Battery consume" + separator + "Total selling price");
			for (Electric elec : electricCars)
				pw.println(elec.toString(separator));
		} else if (vehicle == 'H') {
			List<Hybrid> hybridCars = new ArrayList<Hybrid>();
			for (int i = 0; i < vehicles.size(); i++) {
				if (vehicles.get(i) != null) {
					if (vehicles.get(i) instanceof Hybrid) {
						Hybrid elec = (Hybrid) vehicles.get(i);
						hybridCars.add(elec);
					}
				}
			}
			Collections.sort(hybridCars, new Comparator<Hybrid>() {

				@Override
				public int compare(Hybrid hyb1, Hybrid hyb2) {
					int result = hyb1.getBrand().compareToIgnoreCase(hyb2.getBrand());
					if (result == 0)
						result = String.valueOf(hyb2.getModel()).compareTo(String.valueOf(hyb1.getModel()));
					return result;
				}
			});
			pw.println("Vehicle brand" + separator + "Vehicle model" + separator + "Vehicle type" + separator + "Vehicle base price" + separator + "Vehicle license plate" + separator + "Vehicle cylinder" + separator + "Vehicle mileage" + separator + "Owner ID" + separator + "SOAT document code" + separator + "SOAT document price" + separator + "SOAT document year" + separator + "SOAT coverage amount" + separator + "Mechanical Technical Review document code" + separator + "Mechanical Technical Review document price" + separator + "Mechanical Technical Review document year" + separator + "Gas level released" + separator + "Car type" + separator + "Doors number" + separator + "Polarized Windows" + separator + "Gasoline type" + separator + "Gasoline capacity" + separator + "Gasoline consume" + separator + "Charger type" + separator + "Battery duration" + separator + "Battery consume" + separator + "Total selling price");
			for (Hybrid hyb : hybridCars)
				pw.println(hyb.toString(separator));
		} else {
			List<Motorcycle> motorcycles = new ArrayList<Motorcycle>();
			for (int i = 0; i < vehicles.size(); i++) {
				if (vehicles.get(i) != null) {
					if (vehicles.get(i) instanceof Motorcycle) {
						Motorcycle elec = (Motorcycle) vehicles.get(i);
						motorcycles.add(elec);
					}
				}
			}
			Collections.sort(motorcycles, new Comparator<Motorcycle>() {

				@Override
				public int compare(Motorcycle mot1, Motorcycle mot2) {
					int result = mot1.getBrand().compareToIgnoreCase(mot2.getBrand());
					if (result == 0)
						result = String.valueOf(mot2.getModel()).compareTo(String.valueOf(mot1.getModel()));
					return result;
				}
			});
			pw.println("Vehicle brand" + separator + "Vehicle model" + separator + "Vehicle type" + separator + "Vehicle base price" + separator + "Vehicle license plate" + separator + "Vehicle cylinder" + separator + "Vehicle mileage" + separator + "Owner ID" + separator + "SOAT document code" + separator + "SOAT document price" + separator + "SOAT document year" + separator + "SOAT coverage amount" + separator + "Mechanical Technical Review document code" + separator + "Mechanical Technical Review document price" + separator + "Mechanical Technical Review document year" + separator + "Gas level released" + separator + "Car type" + separator + "Doors number" + separator + "Polarized Windows" + separator + "Gasoline type" + separator + "Gasoline capacity" + separator + "Gasoline consume" + separator + "Charger type" + separator + "Battery duration" + separator + "Battery consume" + separator + "Total selling price");
			for (Motorcycle moto : motorcycles)
				pw.println(moto.toString(separator));
		}
        pw.close();
   	}

   /**
     * Name: showEmployeesByTotalSalesAndID
     * Method used to get all the employees registered in the system, sorted in descending order by their total sales, or, if same ones, by their ID's. <br>
	 * <b>pre: </b> List of people already initialized. <br>
	 * <b>post: </b> The employees registered in the system have been got. <br>
	 * @return A List<Employee> with all the employees registered in the system, sorted in descending order by their total sales, or, if same ones, by their ID's.
    */
	public List<Employee> showEmployeesByTotalSalesAndID() {
		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i) != null) {
				if (people.get(i) instanceof Employee) {
					Employee emp = (Employee) people.get(i);
					employees.add(emp);
				}
			}
		}
		Collections.sort(employees);
		return employees;
	}

	/**
     * Name: showEmployeesByLastName
     * Method used to get all the employees registered in the system, sorted in ascending order by their last names, or, if same ones, by their names. <br>
	 * <b>pre: </b> List of people already initialized. <br>
	 * <b>post: </b> The employees registered in the system have been got. <br>
	 * @return A List<Employee> with all the employees registered in the system, sorted in ascending order by their last names, or, if same ones, by their names.
    */
	public List<Employee> showEmployeesByLastNameAndName() {
		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i) != null) {
				if (people.get(i) instanceof Employee) {
					Employee emp = (Employee) people.get(i);
					employees.add(emp);
				}
			}
		}
		// Bubble ascending sort:
		Employee aux;
    	for (int i = 0; i < employees.size() - 1; i++) {
    	    for (int j = 0; j < employees.size() - i - 1; j++) {
				int result = employees.get(j).getLastName().compareTo(employees.get(j + 1).getLastName());
        	    if (result == 0) {
					result = employees.get(j).getNamePerson().compareTo(employees.get(j + 1).getNamePerson());
					if (result > 0) {
						aux = employees.get(j);
						employees.set(j, employees.get(j + 1));
						employees.set(j + 1, aux);
					}
                } else if (result > 0) {
					aux = employees.get(j);
	                employees.set(j, employees.get(j + 1));
    	            employees.set(j + 1, aux);
				}
        	}
        }
		return employees;
	}

	/**
     * Name: showClientsByLastNameAndPhone
     * Method used to get all the clients registered in the system, sorted in descending order by their last names, or, if same ones, by their phone numbers. <br>
	 * <b>pre: </b> List of people already initialized. <br>
	 * <b>post: </b> The clients registered in the system have been got. <br>
	 * @return A List<Employee> with all the clients registered in the system, sorted in descending order by their last names, or, if same ones, by their phone numbers.
    */
   public List<Client> showClientsByLastNameAndPhone() {
	   List<Client> clients = new ArrayList<Client>();
	   for (int i = 0; i < people.size(); i++) {
		   if (people.get(i) != null) {
			   if (people.get(i) instanceof Client) {
					Client cl = (Client) people.get(i);
					clients.add(cl);
				}
			}
		}
	   // Selection descending sort:
	   for (int i = 0; i < clients.size() - 1; i++) {
		   int maxPosition = i;
			for (int j = i + 1; j < clients.size(); j++) {
				int result = clients.get(j).getLastName().compareTo(clients.get(maxPosition).getLastName());
				if (result == 0) {
					result = clients.get(j).getNumPhone().compareTo(clients.get(maxPosition).getNumPhone());
					if (result > 0)
						maxPosition = j;
				} else if (result > 0)
					maxPosition = j;
			}
			if (maxPosition != i) {
				Client aux = clients.get(i);
				clients.set(i, clients.get(maxPosition));
				clients.set(maxPosition, aux);
			}
		}
		return clients;
	}

	/**
     * Name: showClientsByNameAndEmail
     * Method used to get all the clients registered in the system, sorted in ascending order by their names, or, if same ones, by their e-mails. <br>
	 * <b>pre: </b> List of people already initialized. <br>
	 * <b>post: </b> The clients registered in the system have been got. <br>
	 * @return A List<Employee> with all the clients registered in the system, sorted in ascending order by their names, or, if same ones, by their e-mails.
    */
   	public List<Client>  showClientsByNameAndEmail() {
	   List<Client> clients = new ArrayList<Client>();
	   for (int i = 0; i < people.size(); i++) {
		   if (people.get(i) != null) {
			   if (people.get(i) instanceof Client) {
					Client cl = (Client) people.get(i);
					clients.add(cl);
				}
			}
		}
		// Insertion ascending sort:
		int i, j;
		for (i = 1; i < clients.size(); i++) {
			Client temp = clients.get(i);
			j = i;
			while (j > 0 && compare(clients.get(j - 1), temp) > 0) {
				clients.set(j, clients.get(j - 1));
				--j;
			}
			clients.set(j, temp);
		}
		return clients;
	}

	/** Name: compare
	 * Method used to compare lexicographically String attributes from a client.
     * <b>pre: </b> List of employees created locally already exists and has at least one employee added in it. <br>
     * <b>post: </b> Comparison result obtained of the degree of lexicographicity between the String attributes compared. <br>
     * @param cl1 - A Client object - cl1 != null
	 * @param cl2 - A Client object - cl2 != null
	 * @return An int representing the comparison result, be it positive, negative or equal to 0.
  	*/
	private int compare(Client cl1, Client cl2) {
		int result = cl1.getNamePerson().compareTo(cl2.getNamePerson());
		if (result == 0)
			result = cl1.getEmail().compareTo(cl2.getEmail());
		return result;
	}

	/** Name: toAssignVehicleNew
	 * Method used to add a type New vehicle of interest in the list of vehicles of interest of a client. <br>
	 * <b>pre: </b> List of people already initialized. List of vehicles already initialized. List of vehicles of interest of a client already initialized. <br>
	 * <b>post: </b> Addition process determined of the vehicle of interest in question in the list of vehicles of interest of the client. <br>
	 * @param idClient - ID of the client - idClient = String, idClient != null, idClient != ""
	 * @param brand - vehicle's brand - brand = String, brand != null, brand != ""
	 * @param model - vehicle's model - model = int, model != null, model != 0
	 * @param cylinder - vehicle's cylinder - cylinder = double, cylinder != null, cylinder != 0
	 * @throws FavoriteVehicleException - when trying to add a vehicle of interest to the list of vehicles of interest of a client, that was already there.
	 * @throws IOException - if it cannot write the file properly while saving.
	 * @return A String with a message of the successfully New vehicle of interest addition in the list of vehicles of interest of the client; or with an error due to the absence of preliminary registrations; or with an error due to the already presence of the vehicle of interest in question in the list of vehicles of interest of the client in question.
	*/
	public String toAssignVehicleNew(String idClient, String brand, int model, double cylinder) throws FavoriteVehicleException, IOException {
		String message = "";
		Person objSearch1 = searchPerson(idClient);
		Vehicle objSearch2 = searchVehicleWithoutLicensePlate(brand, model, cylinder);
		if (objSearch1 == null || objSearch2 == null || (objSearch1 == null && objSearch2 == null))
			message = "Error. You may have one or more (or all) of these problems:\n(1). This client is not in the system. Register it.\n(2). This type new vehicle isn't registered in the system with that brand, that model and that cylinder.";
		else if (objSearch1 != null && objSearch2 != null) {
			boolean assigned = false;
			for (int i = 0; i < people.size() && !assigned; i++) {
				if (people.get(i) instanceof Client) {
					if (people.get(i).getId().equals(idClient)) {
						Client cl = (Client) people.get(i);
						Vehicle objSearch3 = cl.getVehiclesOfInterest().searchFavoriteVehicle(cylinder);
						if (objSearch3 == null) {
							cl.getVehiclesOfInterest().addFavoriteVehicle(objSearch2);
							saveDataPeople();
							message = "The new vehicle with brand " + brand + ", model " + model + ", and cylinder "
									+ cylinder
									+ ", has been added to the list of vehicles of interest of the client with ID "
									+ idClient + ".";
							assigned = true;
						} else {
							message = "Error. The new vehicle with brand " + brand + ", model " + model + ", and cylinder "
									+ cylinder
									+ " is already in the list of vehicles of interest of the client with ID "
									+ idClient + ".";
							throw new FavoriteVehicleException(message);
						}
					}
				}
			}
		}
		return message;
	}

	/** Name: toAssignVehicleUsed
	 * Method used to add a used vehicle of interest in the list of vehicles of interest of a client. <br>
	 * <b>pre: </b> List of people already initialized. List of vehicles already initialized. List of vehicles of interest of a client already initialized. <br>
	 * <b>post: </b> Addition process determined of the vehicle of interest in question in the list of vehicles of interest of the client. <br>
	 * @param idClient - ID of the client - idClient = String, idClient != null, idClient != ""
	 * @param licensePlate - used vehicle's license plate - licensePlate = String, licensePlate != null, licensePlate != ""
	 * @param cylinder - vehicle's cylinder - cylinder = double, cylinder != null, cylinder != 0
	 * @throws FavoriteVehicleException - when trying to add a vehicle of interest to the list of vehicles of interest of a client, that was already there.
	 * @throws IOException - if it cannot write the file properly while saving.
	 * @return A String with a message of the successfully Used vehicle of interest addition in the list of vehicles of interest of the client; or with an error due to the absence of preliminary registrations; or with an error due to the already presence of the vehicle of interest in question in the list of vehicles of interest of the client in question.
	*/
	public String toAssignVehicleUsed(String idClient, String licensePlate, double cylinder) throws FavoriteVehicleException, IOException {
		String message = "";
		Person objSearch1 = searchPerson(idClient);
		Vehicle objSearch2 = searchVehicleWithLicensePlate(licensePlate);
		if (objSearch1 == null || objSearch2 == null || (objSearch1 == null && objSearch2 == null))
			message = "Error. You may have one or more (or all) of these problems:\n(1). This client is not in the system.\n(2). This used vehicle isn't registered in the system with that license plate.";
		else if (objSearch1 != null && objSearch2 != null) {
			boolean assigned = false;
			for (int i = 0; i < people.size() && !assigned; i++) {
				if (people.get(i) instanceof Client) {
					if (people.get(i).getId().equals(idClient)) {
						Client cl = (Client) people.get(i);
						Vehicle objSearch3 = cl.getVehiclesOfInterest().searchFavoriteVehicle(cylinder);
						if (objSearch3 == null) {
							cl.getVehiclesOfInterest().addFavoriteVehicle(objSearch2);
							saveDataPeople();
							message = "The used vehicle with cylinder " + cylinder
									+ " has been added to the list of vehicles of interest of the client with ID "
									+ idClient + ".";
							assigned = true;
						} else {
							message = "The used vehicle with cylinder " + cylinder
									+ " is already in the list of vehicles of interest of the client with ID "
									+ idClient + ".";
							throw new FavoriteVehicleException(message);
						}
					}
				}
			}
		}
		return message;
	}

	/** Name: toAssignClient
	 * Method used to add a client in the array of people of a seller to him/her to be in charge of this client. <br>
	 * <b>pre: </b> List of people already initialized. <br>
	 * <b>post: </b> Addition process determined of the client in question in the array of people of the seller in question. <br>
	 * @param idClient - ID of the client - idClient = String, idClient != null, idClient != ""
	 * @param idEmployee - ID of the seller - idEmployee = String, idEmployee != null, idEmployee != ""
	 * @throws WorkloadException - if an employee has already 5 active clients in his/her charge.
	 * @throws IOException - if it cannot write the file properly while saving.
	 * @return A String with a message of the successfully client addition in the array of people of the seller in question; or with an error due to the absence of preliminary registrations; or with an error due to the reached client array capacity; or with an error due to the already presence of the client in question in the array of people of the seller in question.
	*/
	public String toAssignClient(String idClient, String idEmployee, String phone) throws WorkloadException, IOException {
		String message = "";
		Person objSearch1 = searchPerson(idEmployee);
		Person objSearch2 = searchPerson(idClient);
		if (objSearch1 == null || objSearch2 == null || (objSearch1 == null && objSearch2 == null))
			message = "Error. You may have one (or all) of these problems:\n(1) This employee is not in the system. Register it.\n(2) This client is not in the system. Register it.";
		else if (objSearch1 != null && objSearch2 != null) {
			boolean assigned = false;
			for (int i = 0; i < people.size() && !assigned; i++) {
				if (people.get(i) instanceof Employee) {
					if (people.get(i).getId().equals(idEmployee)) {
						Employee em = (Employee) people.get(i);
						Client objSearch3 = em.getClientsInCharge().searchClientInCharge(phone);
						if (objSearch3 == null) {
							if (em.getClientsInCharge().addAssignedClient((Client) objSearch2)) {
								message = "The employee with ID " + idEmployee + " is now in charge of the client with ID " + idClient + ".";
								((Client) objSearch2).setActive(true);
								((Client) objSearch2).setHasSeller(true);
								saveDataPeople();
								assigned = true;
							} else {
								message = "The employee with ID" + idEmployee + " has already 5 active clients in his/her charge. Try with another employee.";
								throw new WorkloadException(message);
							}
						} else
							message = "The client with ID " + idClient + " is already being attended by the employee with ID " + idEmployee + ".";
					}
				}
			}
		}
		return message;
	}

	/** Name: lookCarsParking
	 * Method used to get the used cars, of a specific model, present in the parking. <br>
	 * <b>pre: </b> Vehicle matrix representing the parking already initialized. List of vehicles already initialized. <br>
	 * <b>post: </b> The used cars, of a specific model, that are present in the parking have been got. <br>
	 * @param n - number to identify the model of a car that the user consult in the parking - n = int, n != null
	 * @return A List<Car> with the used cars, of a specific model, present in the parking.
	*/
	public List<Car> lookCarsParking(int n) {
		List<Car> carsModel = new ArrayList<Car>();
		for (int i = 0; i < parking.length; i++) {
			if (parking[i][n] != null)
				carsModel.add(parking[i][n]);
		}
		return carsModel;
	}

	/** Name: lookCarsParking
	 * Method used to get the used cars, of a specific model, present in the parking. <br>
	 * <b>pre: </b> Vehicle matrix representing the parking already initialized. List of vehicles already initialized. <br>
	 * <b>post: </b> The used cars, of a specific model, that are present in the parking have been got. <br>
	 * @param n - number to identify the model of a car that the user consult in the parking - n = int, n != null
	 * @return A List<Car> with the used cars, of a specific model, present in the parking.
	*/
	public List<Headquarter> showHeadquarters() {
		List<Headquarter> locals = new ArrayList<Headquarter>();
		Headquarter current = headquarters.getFirst();
		while (current != null) {
			locals.add(current);
			current = current.getNext();
		}
		return locals;
	}

	/** Name: showCarsGasoline
	 * Method used to get the gasoline cars of a vehicle type chosen from the list of vehicles of the system, to show them in a gasoline cars' catalog. <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> The gasoline cars of a specific vehicle type have been got. <br>
	 * @param c - letter to identify the vehicle type that the user chose - c = char, c != null, c != ''
	 * @return A List<Gasoline> with the gasoline cars of a specific vehicle type in the vehicles' catalog.
	*/
	public List<Gasoline> showCarsGasoline(char c) {
		List<Gasoline> gasolineCars = new ArrayList<Gasoline>();
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i) != null) {
				if (vehicles.get(i) instanceof Gasoline) {
					if (c != 'B') {
						if (vehicles.get(i).getTypeVehicle() == c) {
							Gasoline g = (Gasoline) vehicles.get(i);
							gasolineCars.add(g);
						}
					} else {
						Gasoline g = (Gasoline) vehicles.get(i);
						gasolineCars.add(g);
					}
				}
			}
		}
		return gasolineCars;
	}

	/** Name: showCarsElectric
	 * Method used to get the electric cars of a vehicle type chosen from the list of vehicles of the system, to show them in an electric cars' catalog. <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> The electric cars of a specific vehicle type have been got. <br>
	 * @param c - letter to identify the vehicle type that the user chose - c = char, c != null, c != ''
	 * @return A List<Electric> with the electric cars of a specific vehicle type in the vehicles' catalog.
	*/
	public List<Electric> showCarsElectric(char c) {
		List<Electric> electricCars = new ArrayList<Electric>();
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i) != null) {
				if (vehicles.get(i) instanceof Electric) {
					if (c != 'B') {
						if (vehicles.get(i).getTypeVehicle() == c) {
							Electric elec = (Electric) vehicles.get(i);
							electricCars.add(elec);
						}
					} else {
						Electric elec = (Electric) vehicles.get(i);
						electricCars.add(elec);
					}
				}
			}
		}
		return electricCars;
	}

	/** Name: showCarsHybrid
	 * Method used to get the hybrid cars of a vehicle type chosen from the list of vehicles of the system, to show them in a hybrid cars' catalog. <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> The hybrid cars of a specific vehicle type have been got. <br>
	 * @param c - letter to identify the vehicle type that the user chose - c = char, c != null, c != ''
	 * @return A List<Hybrid> with the hybrid cars of a specific vehicle type in the vehicles' catalog.
	*/
	public List<Hybrid> showCarsHybrid(char c) {
		List<Hybrid> hybridCars = new ArrayList<Hybrid>();
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i) != null) {
				if (vehicles.get(i) instanceof Hybrid) {
					if (c != 'B') {
						if (vehicles.get(i).getTypeVehicle() == c) {
							Hybrid hyb = (Hybrid) vehicles.get(i);
							hybridCars.add(hyb);
						}
					} else {
						Hybrid hyb = (Hybrid) vehicles.get(i);
						hybridCars.add(hyb);
					}
				}
			}
		}
		return hybridCars;
	}

	/** Name: showMotorcycles
	 * Method used to get the motorcycles of a vehicle type chosen from the list of vehicles of the system, to show them in a motorcycles' catalog. <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> The motorcycles of a specific vehicle type have been got. <br>
	 * @param c - letter to identify the vehicle type that the user chose - c = char, c != null, c != ''
	 * @return A List<Motorcycle> with the motorcycles of a specific vehicle type in the vehicles' catalog.
	*/
	public List<Motorcycle> showMotorcycles(char c) {
		List<Motorcycle> motorcycles = new ArrayList<Motorcycle>();
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i) != null) {
				if (vehicles.get(i) instanceof Motorcycle) {
					if (c != 'B') {
						if (vehicles.get(i).getTypeVehicle() == c) {
							Motorcycle m = (Motorcycle) vehicles.get(i);
							motorcycles.add(m);
						}
					} else {
						Motorcycle m = (Motorcycle) vehicles.get(i);
						motorcycles.add(m);
					}
				}
			}
		}
		return motorcycles;
	}

	/** Name: removePerson
	 * Method used to remove a person registered in the system. people != null <br>
	 * <b>pre: </b> List of people already initialized. <br>
	 * <b>post: </b> Removing process of a person from the system, determined. <br>
	 * @param id - ID of the person in question - id = String, id != null, id != ""
	 * @return A String with a message of the successfully removing process of a person from the system; or with a message evoking the absence of the client in question in the system.
	 * @throws IOException - if it cannot write the file properly while saving.
	*/
	public boolean removePerson(String id) throws IOException {
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).getId().equals(id)) {
				people.remove(i);
				saveDataPeople();
				return true;
			}
		}
		return false;
	}

	/** Name: removeVehicleWithLicensePlate
	 * Method used to remove a used vehicle registered in the system through its license plate. vehicles != null <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> Removing process of a used vehicle from the system, determined. <br>
	 * @param licensePlate - vehicle's license plate - licensePlate = String, licensePlate != null, licensePlate != ""
	 * @throws IOException
	 * @return A String with a message of the successfully removing process of a used vehicle from the system; or with a message evoking the absence of the vehicle in question in the system; or with a message evoking that the list of vehicles of the system is empty.
	*/
	public String removeVehicleWithLicensePlate(String licensePlate) throws IOException {
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getLicensePlate().equalsIgnoreCase(licensePlate)) {
				vehicles.remove(i);
				saveDataVehicles();
				return "The vehicle with license plate " + licensePlate + " has been removed successfully from the system.";
			}
		}
		return "This vehicle is not registered in the system with that license plate.";
	}

	/** Name: removeVehicleWithoutLicensePlate
	 * Method used to remove a new vehicle registered in the system through its brand, model and cylinder. vehicles != null <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> Removing process of a new vehicle from the system, determined. <br>
	 * @param brand - vehicle's brand - brand = String, brand != null, brand != ""
	 * @param model - vehicle's model - model = int, model != null, model != 0
	 * @param cylinder - vehicle's cylinder - cylinder = double, cylinder != null, cylinder != 0
	 * @throws IOException
	 * @return A String with a message of the successfully removing process of a new vehicle from the system; or with a message evoking the absence of the vehicle in question in the system; or with a message evoking that the list of vehicles of the system is empty.
	*/
	public String removeVehicleWithoutLicensePlate(String brand, int model, double cylinder) throws IOException {
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getBrand().equals(brand) && vehicles.get(i).getModel() == model && vehicles.get(i).getCylinder() == cylinder) {
				vehicles.remove(i);
				saveDataVehicles();
				return "The vehicle with brand " + brand + ", model " + model + ", and cylinder " + cylinder + " has been removed successfully from the system.";
			}
		}
		return "This vehicle is not registered in the system with that license plate.";
	}

	/** Name: removeCarParking
	 * Method used to remove a used car located in the parking after its sale. <br>
	 * <b>pre: </b> List of vehicles already initialized, vehicles != null. Vehicle matrix representing the parking already initialized, parking != null. <br>
	 * <b>post: </b> Removing process of a used car from the parking due to sale, determined. <br>
	 * @param model - used car's model - model = int, model != null, model != 0
	 * @param licensePlate - vehicle's license plate - licensePlate = String, licensePlate != null, licensePlate != ""
	 * @throws IOException
	 * @return A boolean with true if the used car of the specific model in question was removed, or with false if not.
	*/
	private boolean removeCarParking(int model, String licensePlate) throws IOException {
		boolean removed = false;
		if (model == 2014) {
			for (int a = 0; a < parking.length && !removed; a++) {
				for (int b = 0; b < parking.length && !removed; b++) {
					if (parking[a][0] != null) {
						if (parking[a][0].getLicensePlate().equals(licensePlate)) {
							parking[a][0] = null;
							saveDataCarsParking();
							return true;
						}
					}
				}
			}
		} else if (model == 2013) {
			for (int a = 0; a < parking.length && !removed; a++) {
				for (int b = 0; b < parking.length && !removed; b++) {
					if (parking[a][1] != null) {
						if (parking[a][1].getLicensePlate().equals(licensePlate)) {
							parking[a][1] = null;
							saveDataCarsParking();
							return true;
						}
					}
				}
			}
		} else if (model == 2012) {
			for (int a = 0; a < parking.length && !removed; a++) {
				for (int b = 0; b < parking.length && !removed; b++) {
					if (parking[a][2] != null) {
						if (parking[a][2].getLicensePlate().equals(licensePlate)) {
							parking[a][2] = null;
							saveDataCarsParking();
							return true;
						}
					}
				}
			}
		} else if (model == 2011) {
			for (int a = 0; a < parking.length && !removed; a++) {
				for (int b = 0; b < parking.length && !removed; b++) {
					if (parking[a][3] != null) {
						if (parking[a][3].getLicensePlate().equals(licensePlate)) {
							parking[a][3] = null;
							saveDataCarsParking();
							return true;
						}
					}
				}
			}
		} else if (model < 2011) {
			for (int a = 0; a < parking.length && !removed; a++) {
				for (int b = 0; b < parking.length && !removed; b++) {
					if (parking[a][4] != null) {
						if (parking[a][4].getLicensePlate().equals(licensePlate)) {
							parking[a][4] = null;
							saveDataCarsParking();
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/** Name: sellAVehicle
	 * Method used to sell a vehicle to a client. <br>
	 * <b>pre: </b> List of vehicles already initialized, vehicles != null. List of people already initialized, people != null. List of vehicles of interest already initialized. Array of people of a seller that is in charge of them already initialized, getClientsInCharge() != null. Array of the documents of a vehicle already initialized, getDocuments() != null <br>
	 * <b>post: </b> Selling process of a used car from the parking due to sale, determined. <br>
	 * @param licensePlate - vehicle's license plate - licensePlate = String, licensePlate != null, licensePlate != ""
	 * @param idEmployee - ID of the seller - idEmployee = String, idEmployee != null, idEmployee != ""
	 * @param idClient - ID of the client - idClient = String, idClient != null, idClient != ""
	 * @param selection - number to identify the kind of vehicle that the user want to sell - selection = int, selection != null, selection != 0
	 * @param typeVehicle - vehicle's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	 * @param brand - vehicle's brand - brand = String, brand != null, brand != ""
	 * @param model - vehicle's model - model = int, model != null, model != 0
	 * @param cylinder - vehicle's cylinder - cylinder = double, cylinder != 0
	 * @throws IOException
	 * @return A String with a message about the successful sale of the vehicle to the client in question; or about an error due to the absence of preliminary registrations; or about an error because the employee in question is not in charge of the client in question.
	*/
	public String sellAVehicle(String licensePlate, String idEmployee, String idClient, int selection, char typeVehicle, String brand, int model, double cylinder, String phone) throws IOException {
		String message = "";
		int currentYear = LocalDate.now().getYear();
		Person objSearchEmp = searchPerson(idEmployee);
		Person objSearchCl = searchPerson(idClient);
		if (typeVehicle == Vehicle.TYPE_VEHICLE_USED) {
			Vehicle objSearchV = searchVehicleWithLicensePlate(licensePlate);
			if (objSearchV == null || objSearchEmp == null || objSearchCl == null
					|| (objSearchV == null && objSearchEmp == null && objSearchCl != null)
					|| (objSearchV == null && objSearchEmp != null && objSearchCl == null)
					|| (objSearchV != null && objSearchEmp == null && objSearchCl == null)
					|| (objSearchV == null && objSearchEmp == null && objSearchCl == null))
				message = "Error. You may have one or more (or all) of these problems:\n(1) This employee is not in the system. Register it.\n(2) This client is not in the system. Register it.\n(3) This vehicle is not in the system. Add it.";
			else if (objSearchV != null && objSearchEmp != null && objSearchCl != null) {
				Client objSearch4 = (Client) objSearchCl;
				objSearch4 = ((Employee) objSearchEmp).getClientsInCharge().searchClientInCharge(phone);
				if (objSearch4 == null)
					message = "Error. The employee with ID" + idEmployee + " is not in charge of the client with ID " + idClient + ".";
				else {
					if (selection == 1) {
						boolean sold = false;
						for (int i = 0; i < vehicles.size() && !sold; i++) {
							if (vehicles.get(i) instanceof Gasoline) {
								if (vehicles.get(i).getLicensePlate().equals(licensePlate)) {
									Gasoline g = (Gasoline) objSearchV;
									if (g.getDocuments().getFirst().getYear() != currentYear
											&& g.getDocuments().getFirst().getNext().getYear() != currentYear) {
										Soat s = (Soat) g.getDocuments().getFirst();
										Review r = (Review) g.getDocuments().getFirst().getNext();
										String codeSoat = s.decodeCode();
										String codeReview = r.decodeCode();
										s.setCodeDoc(codeSoat);
										r.setCodeDoc(codeReview);
									} else if (g.getDocuments().getFirst().getYear() != currentYear
											&& g.getDocuments().getFirst().getNext().getYear() == currentYear) {
										Soat s = (Soat) g.getDocuments().getFirst();
										String codeSoat = s.decodeCode();
										s.setCodeDoc(codeSoat);
									} else if (g.getDocuments().getFirst().getYear() == currentYear
											&& g.getDocuments().getFirst().getNext().getYear() != currentYear) {
										Review r = (Review) g.getDocuments().getFirst().getNext();
										String codeReview = r.decodeCode();
										r.setCodeDoc(codeReview);
									}
									vehicles.get(i).setOwnerID(objSearch4.getId());
									numSales++;
									totalEarnings += g.getTotalPrice();
									Employee e = (Employee) objSearchEmp;
									e.setQuantTotalSales(e.getQuantTotalSales() + 1);
									objSearch4.getVehiclesOfInterest().removeFavoriteVehicle(cylinder);
									if (objSearchV.getModel() < 2015) {
										boolean removed2 = removeCarParking(objSearchV.getModel(), licensePlate);
										if (removed2 == true)
											message = "This used " + model
													+ " model gasoline car has been removed from the parking due to sale.\n";
									}
									e.getClientsInCharge().removeClientsInCharge(phone);
									objSearch4.setActive(false);
									objSearch4.setHasSeller(false);
									message += "\nThe used gasoline car with the license plate " + licensePlate
											+ " has been sold to the client with ID " + idClient + ".";
									sold = true;
								}
							}
						}
					} else if (selection == 2) {
						boolean sold = false;
						for (int i = 0; i < vehicles.size() && !sold; i++) {
							if (vehicles.get(i) instanceof Electric) {
								if (vehicles.get(i).getLicensePlate().equals(licensePlate)) {
									Electric elec = (Electric) objSearchV;
									if (elec.getDocuments().getFirst().getYear() != currentYear
											&& elec.getDocuments().getFirst().getNext().getYear() != currentYear) {
										Soat s = (Soat) elec.getDocuments().getFirst();
										Review r = (Review) elec.getDocuments().getFirst().getNext();
										String codeSoat = s.decodeCode();
										String codeReview = r.decodeCode();
										s.setCodeDoc(codeSoat);
										r.setCodeDoc(codeReview);
									} else if (elec.getDocuments().getFirst().getYear() != currentYear
											&& elec.getDocuments().getFirst().getNext().getYear() == currentYear) {
										Soat s = (Soat) elec.getDocuments().getFirst();
										String codeSoat = s.decodeCode();
										s.setCodeDoc(codeSoat);
									} else if (elec.getDocuments().getFirst().getYear() == currentYear
											&& elec.getDocuments().getFirst().getNext().getYear() != currentYear) {
										Review r = (Review) elec.getDocuments().getFirst().getNext();
										String codeReview = r.decodeCode();
										r.setCodeDoc(codeReview);
									}
									vehicles.get(i).setOwnerID(objSearch4.getId());
									numSales++;
									totalEarnings += elec.getTotalPrice();
									Employee e = (Employee) objSearchEmp;
									e.setQuantTotalSales(e.getQuantTotalSales() + 1);
									objSearch4.getVehiclesOfInterest().removeFavoriteVehicle(cylinder);
									if (objSearchV.getModel() < 2015) {
										boolean removed2 = removeCarParking(objSearchV.getModel(), licensePlate);
										if (removed2 == true)
											message += "\nThis used" + model
													+ " model electric car has been removed from the parking due to sale.\n";
									}
									e.getClientsInCharge().removeClientsInCharge(phone);
									objSearch4.setActive(false);
									objSearch4.setHasSeller(false);
									message = "\nThe used electric car with the license plate " + licensePlate
											+ " has been sold to the client with ID " + idClient + ".\n";
									sold = true;
								}
							}
						}
					} else if (selection == 3) {
						boolean sold = false;
						for (int i = 0; i < vehicles.size() && !sold; i++) {
							if (vehicles.get(i) instanceof Hybrid) {
								if (vehicles.get(i).getLicensePlate().equals(licensePlate)) {
									Hybrid h = (Hybrid) objSearchV;
									if (h.getDocuments().getFirst().getYear() != currentYear
											&& h.getDocuments().getFirst().getNext().getYear() != currentYear) {
										Soat s = (Soat) h.getDocuments().getFirst();
										Review r = (Review) h.getDocuments().getFirst().getNext();
										String codeSoat = s.decodeCode();
										String codeReview = r.decodeCode();
										s.setCodeDoc(codeSoat);
										r.setCodeDoc(codeReview);
									} else if (h.getDocuments().getFirst().getYear() != currentYear
											&& h.getDocuments().getFirst().getNext().getYear() == currentYear) {
										Soat s = (Soat) h.getDocuments().getFirst();
										String codeSoat = s.decodeCode();
										s.setCodeDoc(codeSoat);
									} else if (h.getDocuments().getFirst().getYear() == currentYear
											&& h.getDocuments().getFirst().getNext().getYear() != currentYear) {
										Review r = (Review) h.getDocuments().getFirst().getNext();
										String codeReview = r.decodeCode();
										r.setCodeDoc(codeReview);
									}
									vehicles.get(i).setOwnerID(objSearch4.getId());
									numSales++;
									totalEarnings += h.getTotalPrice();
									Employee e = (Employee) objSearchEmp;
									e.setQuantTotalSales(e.getQuantTotalSales() + 1);
									objSearch4.getVehiclesOfInterest().removeFavoriteVehicle(cylinder);
									if (objSearchV.getModel() < 2015) {
										boolean removed2 = removeCarParking(objSearchV.getModel(), licensePlate);
										if (removed2 == true)
											message = "This used" + model + " model hybrid car has been removed from the parking due to sale.\n";
									}
									e.getClientsInCharge().removeClientsInCharge(phone);
									objSearch4.setActive(false);
									objSearch4.setHasSeller(false);
									message = "\nThe used hybrid car with the license plate " + licensePlate
											+ " has been sold to the client with ID " + idClient + ".";
									sold = true;
								}
							}
						}
					} else if (selection == 4) {
						boolean sold = false;
						for (int i = 0; i < vehicles.size() && !sold; i++) {
							if (vehicles.get(i) instanceof Motorcycle) {
								if (vehicles.get(i).getLicensePlate().equals(licensePlate)) {
									Motorcycle m = (Motorcycle) objSearchV;
									if (m.getDocuments().getFirst().getYear() != currentYear
											&& m.getDocuments().getFirst().getNext().getYear() != currentYear) {
										Soat s = (Soat) m.getDocuments().getFirst();
										Review r = (Review) m.getDocuments().getFirst().getNext();
										String codeSoat = s.decodeCode();
										String codeReview = r.decodeCode();
										s.setCodeDoc(codeSoat);
										r.setCodeDoc(codeReview);
									} else if (m.getDocuments().getFirst().getYear() != currentYear
											&& m.getDocuments().getFirst().getNext().getYear() == currentYear) {
										Soat s = (Soat) m.getDocuments().getFirst();
										String codeSoat = s.decodeCode();
										s.setCodeDoc(codeSoat);
									} else if (m.getDocuments().getFirst().getYear() == currentYear
											&& m.getDocuments().getFirst().getNext().getYear() != currentYear) {
										Review r = (Review) m.getDocuments().getFirst().getNext();
										String codeReview = r.decodeCode();
										r.setCodeDoc(codeReview);
									}
									vehicles.get(i).setOwnerID(objSearch4.getId());
									numSales++;
									totalEarnings += m.getTotalPrice();
									Employee e = (Employee) objSearchEmp;
									e.setQuantTotalSales(e.getQuantTotalSales() + 1);
									objSearch4.getVehiclesOfInterest().removeFavoriteVehicle(cylinder);
									e.getClientsInCharge().removeClientsInCharge(phone);
									objSearch4.setActive(false);
									objSearch4.setHasSeller(false);
									message = "The used motorcycle with the license plate " + licensePlate
											+ " has been sold to the client with ID " + idClient + ".";
									sold = true;
								}
							}
						}
					}
					saveDataVehicles();
					saveDataPeople();
					saveDataCarsParking();
				}
			}
		} else if (typeVehicle == Vehicle.TYPE_VEHICLE_NEW) {
			Vehicle objSearchV = searchVehicleWithoutLicensePlate(brand, model, cylinder);
			if (objSearchV == null || objSearchEmp == null || objSearchCl == null
					|| (objSearchV == null && objSearchEmp == null && objSearchCl != null)
					|| (objSearchV == null && objSearchEmp != null && objSearchCl == null)
					|| (objSearchV != null && objSearchEmp == null && objSearchCl == null)
					|| (objSearchV == null && objSearchEmp == null && objSearchCl == null))
				message = "Error. You may have one or more (or all) of these problems:\n(1) This employee is not in the system. Register it.\n(2) This client is not in the system. Register it.\n(3) This vehicle is not in the system. Add it.";
			else if (objSearchV != null && objSearchEmp != null && objSearchCl != null) {
				Client objSearch4 = (Client) objSearchCl;
				objSearch4 = ((Employee) objSearchEmp).getClientsInCharge().searchClientInCharge(phone);
				if (objSearch4 == null)
					message = "Error. The employee with ID" + idEmployee + " is not in charge of the client with ID " + idClient + ".";
				else {
					if (selection == 1) {
						boolean sold = false;
						for (int i = 0; i < vehicles.size() && !sold; i++) {
							if (vehicles.get(i) instanceof Gasoline) {
								if (vehicles.get(i).getBrand().equals(brand) && vehicles.get(i).getModel() == model
										&& vehicles.get(i).getCylinder() == cylinder) {
									Gasoline g = (Gasoline) objSearchV;
									Soat s = (Soat) g.getDocuments().getFirst();
									Review r = (Review) g.getDocuments().getFirst().getNext();
									String codeSoat = s.decodeCode();
									String codeReview = r.decodeCode();
									s.setCodeDoc(codeSoat);
									s.setYear(2020);
									r.setCodeDoc(codeReview);
									r.setYear(2020);
									vehicles.get(i).setLicensePlate(licensePlate);
									vehicles.get(i).setOwnerID(objSearch4.getId());
									numSales++;
									totalEarnings += g.getTotalPrice();
									Employee e = (Employee) objSearchEmp;
									e.setQuantTotalSales(e.getQuantTotalSales() + 1);
									objSearch4.getVehiclesOfInterest().removeFavoriteVehicle(cylinder);
									e.getClientsInCharge().removeClientsInCharge(phone);
									objSearch4.setActive(false);
									objSearch4.setHasSeller(false);
									message = "The new gasoline car of brand " + brand + ", model " + model
											+ ", and cylinder " + cylinder
											+ " has been sold to the client with ID " + idClient + ".\n";
									message += "\nIts new license plate is " + licensePlate;
									sold = true;
								}
							}
						}
					} else if (selection == 2) {
						boolean sold = false;
						for (int i = 0; i < vehicles.size() && !sold; i++) {
							if (vehicles.get(i) instanceof Electric) {
								if (vehicles.get(i).getBrand().equals(brand) && vehicles.get(i).getModel() == model
										&& vehicles.get(i).getCylinder() == cylinder) {
									Electric elec = (Electric) objSearchV;
									Soat s = (Soat) elec.getDocuments().getFirst();
									Review r = (Review) elec.getDocuments().getFirst().getNext();
									String codeSoat = s.decodeCode();
									String codeReview = r.decodeCode();
									s.setCodeDoc(codeSoat);
									s.setYear(2020);
									r.setCodeDoc(codeReview);
									r.setYear(2020);
									vehicles.get(i).setLicensePlate(licensePlate);
									vehicles.get(i).setOwnerID(objSearch4.getId());
									numSales++;
									totalEarnings += elec.getTotalPrice();
									Employee e = (Employee) objSearchEmp;
									e.setQuantTotalSales(e.getQuantTotalSales() + 1);
									objSearch4.getVehiclesOfInterest().removeFavoriteVehicle(cylinder);
									e.getClientsInCharge().removeClientsInCharge(phone);
									objSearch4.setActive(false);
									objSearch4.setHasSeller(false);
									message = "The new electric car of brand " + brand + ", model " + model
											+ ", and cylinder " + cylinder
											+ " has been sold to the client with ID " + idClient + ".\n";
									message += "\nIts new license plate is " + licensePlate;
									sold = true;
								}
							}
						}
					} else if (selection == 3) {
						boolean sold = false;
						for (int i = 0; i < vehicles.size() && !sold; i++) {
							if (vehicles.get(i) instanceof Hybrid) {
								if (vehicles.get(i).getBrand().equals(brand) && vehicles.get(i).getModel() == model
										&& vehicles.get(i).getCylinder() == cylinder) {
									Hybrid h = (Hybrid) objSearchV;
									Soat s = (Soat) h.getDocuments().getFirst();
									Review r = (Review) h.getDocuments().getFirst().getNext();
									String codeSoat = s.decodeCode();
									String codeReview = r.decodeCode();
									s.setCodeDoc(codeSoat);
									s.setYear(2020);
									r.setCodeDoc(codeReview);
									r.setYear(2020);
									vehicles.get(i).setLicensePlate(licensePlate);
									vehicles.get(i).setOwnerID(objSearch4.getId());
									numSales++;
									totalEarnings += h.getTotalPrice();
									Employee e = (Employee) objSearchEmp;
									e.setQuantTotalSales(e.getQuantTotalSales() + 1);
									objSearch4.getVehiclesOfInterest().removeFavoriteVehicle(cylinder);
									e.getClientsInCharge().removeClientsInCharge(phone);
									objSearch4.setActive(false);
									objSearch4.setHasSeller(false);
									message = "The new hybrid car of brand " + brand + ", model " + model
											+ ", and cylinder " + cylinder
											+ " has been sold to the client with ID " + idClient + ".\n";
									message += "\nIts new license plate is " + licensePlate;
									sold = true;
								}
							}
						}
					} else if (selection == 4) {
						boolean sold = false;
						for (int i = 0; i < vehicles.size() && !sold; i++) {
							if (vehicles.get(i) instanceof Motorcycle) {
								if (vehicles.get(i).getBrand().equals(brand) && vehicles.get(i).getModel() == model
										&& vehicles.get(i).getCylinder() == cylinder) {
									Motorcycle m = (Motorcycle) objSearchV;
									Soat s = (Soat) m.getDocuments().getFirst();
									Review r = (Review) m.getDocuments().getFirst().getNext();
									String codeSoat = s.decodeCode();
									String codeReview = r.decodeCode();
									s.setCodeDoc(codeSoat);
									s.setYear(2020);
									r.setCodeDoc(codeReview);
									r.setYear(2020);
									vehicles.get(i).setLicensePlate(licensePlate);
									vehicles.get(i).setOwnerID(objSearch4.getId());
									numSales++;
									totalEarnings += m.getTotalPrice();
									Employee e = (Employee) objSearchEmp;
									e.setQuantTotalSales(e.getQuantTotalSales() + 1);
									objSearch4.getVehiclesOfInterest().removeFavoriteVehicle(cylinder);
									e.getClientsInCharge().removeClientsInCharge(phone);
									objSearch4.setActive(false);
									objSearch4.setHasSeller(false);
									message = "The new motorcycle of brand " + brand + ", model " + model
											+ ", and cylinder " + cylinder
											+ " has been sold to the client with ID " + idClient + ".\n";
									message += "\nIts new license plate is " + licensePlate;
									sold = true;
								}
							}
						}
					}
					saveDataVehicles();
					saveDataPeople();
					saveDataCarsParking();
				}
			}
		}
		return message;
	}

	/** Name: searchVehicleWithoutLicensePlate
	 * Method used to search a vehicle that has not a license plate yet (mostly the type New ones) in the list of vehicles of the system. <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> Searching process determined of the vehicle in question in the list of vehicles of the system. <br>
	 * @param brand - vehicle's brand - brand = String, brand != null, brand != ""
	 * @param model - vehicle's model - model = int, model != null, model != 0
	 * @param cylinder - vehicle's cylinder - cylinder = double, cylinder != 0
	 * @return An object Vehicle different from null if the vehicle in question was found in the system, or with null if not.
	*/
	private Vehicle searchVehicleWithoutLicensePlate(String brand, int model, double cylinder) {
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i) != null) {
				if (vehicles.get(i).getTypeVehicle() == Vehicle.TYPE_VEHICLE_NEW) {
					if (vehicles.get(i).getBrand().equals(brand) && vehicles.get(i).getModel() == model && vehicles.get(i).getCylinder() == cylinder)
						return vehicles.get(i);
				}
			}
		}
		return null;
	}

	/** Name: searchPerson
	 * Method used to search a person in the list of people of the system. <br>
	 * <b>pre: </b> List of people already initialized. <br>
	 * <b>post: </b> Searching process determined of the person in question in the list of people of the system. <br>
	 * @param id - ID of a person - id = String, id != null, id != ""
	 * @return An object Person different from null if the person in question was found in the system, or with null if not.
	*/
	private Person searchPerson(String id) {
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i) != null) {
				if (people.get(i).getId().equals(id))
					return people.get(i);
			}
		}
		return null;
	}

	/** Name: searchVehicleWithLicensePlate
	 * Method used to search a vehicle that has a license plate already (mostly the type Used ones or the sold ones) in the list of vehicles of the system. <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> Searching process determined of the vehicle in question in the list of vehicles of the system. <br>
	 * @param licensePlate - vehicle's license plate - licensePlate = String, licensePlate != null, licensePlate != ""
	 * @return An object Vehicle different from null if the vehicle in question was found in the system, or with null if not.
	*/
	private Vehicle searchVehicleWithLicensePlate(String licensePlate) {
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i) != null) {
				if (vehicles.get(i).getLicensePlate().equals(licensePlate))
					return vehicles.get(i);
			}
		}
		return null;
	}

	/** Name: addEmployee
	 * Method used to add an employee (seller) to the list of people of the system. <br>
	 * <b>pre: </b> List of people already initialized. <br>
	 * <b>post: </b> Adding process determined of the employee in question in the list of people of the system. <br>
	 * @param namePerson - name of the employee - namePerson = String, namePerson != null, namePerson != ""
	 * @param lastName - last name of the employee - lastName = String, lastName != null, lastName != ""
	 * @param id - ID of the employee - id = String, id != null, id != ""
	 * @param quantTotalSales - total quantity of the employee sales - quantTotalSales = int, quantTotalSales != null, quantTotalSales begins in 0
	 * @throws IOException - if it cannot write the file properly while saving.
	 * @return A String with a message about the successful adding process of the employee to the list of people of the system; or about an error due to the already presence of another person with the same ID in the system.
	*/
	public String addEmployee(String namePerson, String lastName, String id, int quantTotalSales) throws IOException {
		Person objSearch = searchPerson(id);
		if (objSearch != null)
			return "Another employee is already registered in the system with that id.";
		else {
			BSTClientsInCharge clientsInCharge = new BSTClientsInCharge();
			Person obj = new Employee(namePerson, lastName, id, quantTotalSales, clientsInCharge);
			people.add(obj);
			saveDataPeople();
			return "New employee successfully registered.";
		}
	}

	/** Name: addClient
	 * Method used to add a client to the list of people of the system. <br>
	 * <b>pre: </b> List of people already initialized. <br>
	 * <b>post: </b> Adding process determined of the client in question in the list of people of the system. <br>
	 * @param namePerson - name of the client - namePerson = String, namePerson != null, namePerson != ""
	 * @param lastName - last name of the client - lastName = String, lastName != null, lastName != ""
	 * @param id - ID of the client - id = String, id != null, id != ""
	 * @param numPhone - cell phone number of the client - numPhone = String, numPhone != null, numPhone != ""
	 * @param email - e-mail of the client - email = String, email != null, email != ""
	 * @param active - status of a client in the company - active = boolean, active != null, active begins in true
	 * @param hasSeller - parameter to identify if a client is being attended by an employee - hasSeller = boolean, hasSeller != null, hasSeller begins in false
	 * @return A String with a message about the successful adding process of the client to the list of people of the system; or about an error due to the already presence of another person with the same ID in the system.
     * @throws IOException - if it cannot write the file properly while saving.
	*/
	public String addClient(String namePerson, String lastName, String id, String numPhone, String email, boolean active, boolean hasSeller) throws IOException {
		Person objSearch = searchPerson(id);
		if (objSearch != null)
			return "Another client is already registered in the system with that id.";
		else {
			BSTFavoriteVehicles vehiclesOfInterest = new BSTFavoriteVehicles();
			Person obj = new Client(namePerson, lastName, id, numPhone, email, hasSeller, active, vehiclesOfInterest);
			people.add(obj);
			saveDataPeople();
			return "New client successfully registered.";
		}
	}

	/** Name: addVehicle
	 * Method used to add a gasoline car to the list of vehicles of the system. <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> Adding process determined of the gasoline car in question in the list of vehicles of the system. <br>
	 * @param brand - gasoline car's brand - brand = String, brand != null, brand != ""
	 * @param model - gasoline car's model - model = int, model != null, model != 0
	 * @param cylinder - gasoline car's cylinder - cylinder = double, cylinder != 0
	 * @param mileage - gasoline car's mileage - mileage = double, mileage != null
	 * @param typeVehicle - vehicle's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	 * @param licensePlate - gasoline car's license plate - licensePlate = String, licensePlate != null
	 * @param totalPrice - gasoline car's total price - totalPrice = double, totalPrice != null, totalPrice begins in 0
	 * @param basePrice - gasoline car's base price - basePrice = double, basePrice != null, basePrice != 0
	 * @param typeCar - gasoline car's type - typeCar = char, typeCar != null, typeCar != ''
	 * @param numDoors - gasoline car's doors number - numDoors = int, numDoors != null, numDoors != 0
	 * @param polarizedWindows - gasoline car's polarized windows declaration - polarizedWindows = boolean, numDoors != null, polarizedWindows begins in false
	 * @param capacityGasoline - gasoline capacity of the gasoline car - capacityGasoline = double, capacityGasoline != null, capacityGasoline != 0
	 * @param typeGasoline - gasoline type of the gasoline car - typeGasoline = char, typeGasoline != null, typeGasoline != ''
	 * @param consumeGasoline - gasoline consume of the gasoline car - consumeGasoline = double, consumeGasoline != null, consumeGasoline begins in 0
	 * @param n - number to finally decide if the gasoline car has polarized windows or not - n = int, n != null, n == 1 || n== 0
	 * @param price1 - price of the Soat document of the gasoline car - price1 = double, price1 != null, price1 != 0
	 * @param price2 - price of the Mechanical Technical Review document of the gasoline car - price2 = double, price2 != null, price2 != 0
	 * @param year1 - year of the Soat document of the gasoline car - year1 = int, year1 != null, year1 begins in 0 if typeVehicle == 'N' else year1 =! 0
	 * @param year2 - year of the Mechanical Technical Review document of the gasoline car - year2 = int, year2 != null, year2 begins in 0 if typeVehicle == 'N' else year2 =! 0
	 * @param codeDoc1 - code of the Soat document of the gasoline car - codeDoc1 = String, codeDoc1 != null, codeDoc1 begins as "" if typeVehicle == 'N' else codeDoc1 =! ""
	 * @param codeDoc2 - code of the Mechanical Technical Review document of the gasoline car - codeDoc2 = String, codeDoc2 != null, codeDoc2 begins as "" if typeVehicle == 'N' else codeDoc2 =! ""
	 * @param coverageAmount - coverage amount of the Soat document of the gasoline car - coverageAmount = double, coverageAmount != null, coverageAmount != 0
	 * @param gasLevel - gas level thrown by the gasoline car (Mechanical Technical Review document information) - gasLevel = double, gasLevel != null, gasLevel begins in 0 if typeVehicle == 'N' else year2 =! 0
	 * @throws IOException - if it cannot write the file properly while saving.
	 * @throws LackOfLandException - if there is no more space to place a used car of a specific model in a column of the parking.
	 * @return A String with a message about the successful adding process of the gasoline car to the list of vehicles of the system and eventually with a message about the movement of the car to the parking (or with an advice about the need to expand the parking for a certain cars model); or about an error due to the already presence of another same vehicle in the system.
	*/
	public String addVehicle(String brand, int model, double cylinder, double mileage, char typeVehicle,
			String licensePlate, double totalPrice, double basePrice, char typeCar, int numDoors,
			boolean polarizedWindows, double capacityGasoline, char typeGasoline, double consumeGasoline,
			double price1, double price2, int year1, int year2, String codeDoc1, String codeDoc2, double coverageAmount,
			double gasLevel) throws IOException, LackOfLandException {
		String message = "";
			if (typeVehicle == Vehicle.TYPE_VEHICLE_USED) {
				Vehicle objSearch = searchVehicleWithLicensePlate(licensePlate);
				if (objSearch != null)
					message = "This vehicle was already added to the system before with that license plate.";
				else {
					Document documents = new Document();
					documents.setFirst(new Soat(price1, year1, codeDoc1, coverageAmount));
					documents.getFirst().setNext(new Review(price2, year2, codeDoc2, gasLevel));
					Vehicle obj = new Gasoline(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle,
					licensePlate, "", documents, typeCar, numDoors, polarizedWindows, capacityGasoline,
					typeGasoline, consumeGasoline);
					message = addUsedCarToParking((Car) obj);
					vehicles.add(obj);
					saveDataVehicles();
					message += "Used gasoline car successfully registered.";
				}
			} else if (typeVehicle == Vehicle.TYPE_VEHICLE_NEW) {
				Vehicle objSearch=searchVehicleWithoutLicensePlate(brand, model, cylinder);
				if (objSearch != null)
					message = "This vehicle was already added to the system before with those characteristics.";
				else {
					Document documents = new Document();
					documents.setFirst(new Soat(price1, year1, codeDoc1, coverageAmount));
					documents.getFirst().setNext(new Review(price2, year2, codeDoc2, gasLevel));
					Vehicle obj = new Gasoline(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle,
					licensePlate, "", documents, typeCar, numDoors, polarizedWindows, capacityGasoline,
					typeGasoline, consumeGasoline);
					vehicles.add(obj);
					saveDataVehicles();
					message = "New gasoline car successfully registered.";
				}
			}
		return message;
	}

	/** Name: addVehicle
	 * Method used to add an electric car to the list of vehicles of the system. <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> Adding process determined of the electric car in question in the list of vehicles of the system. <br>
	 * @param brand - electric car's brand - brand = String, brand != null, brand != ""
	 * @param model - electric car's model - model = int, model != null, model != 0
	 * @param cylinder - electric car's cylinder - cylinder = double, cylinder != 0
	 * @param mileage - electric car's mileage - mileage = double, mileage != null
	 * @param typeVehicle - vehicle's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	 * @param licensePlate - electric car's license plate - licensePlate = String, licensePlate != null
	 * @param totalPrice - electric car's total price - totalPrice = double, totalPrice != null, totalPrice begins in 0
	 * @param basePrice - electric car's base price - basePrice = double, basePrice != null, basePrice != 0
	 * @param typeCar - electric car's type - typeCar = char, typeCar != null, typeCar != ''
	 * @param numDoors - electric car's doors number - numDoors = int, numDoors != null, numDoors != 0
	 * @param polarizedWindows - electric car's polarized windows declaration - polarizedWindows = boolean, numDoors != null, polarizedWindows begins in false
	 * @param typeCharger - charger type of the electric car - typeCharger = char, typeCharger != null, typeCharger != ''
	 * @param durationBattery - battery duration of the electric car - durationBattery = double, durationBattery != null, durationBattery != 0
	 * @param consumeBattery - battery consume of the electric car - consumeBattery = double, consumeBattery != null, consumeBattery begins in 0
	 * @param n - number to finally decide if the electric car has polarized windows or not - n = int, n != null, n == 1 || n== 0
	 * @param price1 - price of the Soat document of the electric car - price1 = double, price1 != null, price1 != 0
	 * @param price2 - price of the Mechanical Technical Review document of the electric car - price2 = double, price2 != null, price2 != 0
	 * @param year1 - year of the Soat document of the electric car - year1 = int, year1 != null, year1 begins in 0 if typeVehicle == 'N' else year1 =! 0
	 * @param year2 - year of the Mechanical Technical Review document of the electric car - year2 = int, year2 != null, year2 begins in 0 if typeVehicle == 'N' else year2 =! 0
	 * @param codeDoc1 - code of the Soat document of the electric car - codeDoc1 = String, codeDoc1 != null, codeDoc1 begins as "" if typeVehicle == 'N' else codeDoc1 =! ""
	 * @param codeDoc2 - code of the Mechanical Technical Review document of the electric car - codeDoc2 = String, codeDoc2 != null, codeDoc2 begins as "" if typeVehicle == 'N' else codeDoc2 =! ""
	 * @param coverageAmount - coverage amount of the Soat document of the electric car - coverageAmount = double, coverageAmount != null, coverageAmount != 0
	 * @param gasLevel - gas level thrown by the electric car (Mechanical Technical Review document information) - gasLevel = double, gasLevel != null, gasLevel begins in 0 if typeVehicle == 'N' else gasLevel =! 0
	 * @throws IOException - if it cannot write the file properly while saving.
	 * @throws LackOfLandException - if there is no more space to place a used car of a specific model in a column of the parking.
	 * @return A String with a message about the successful adding process of the electric car to the list of vehicles of the system and eventually with a message about the movement of the car to the parking (or with an advice about the need to expand the parking for a certain cars model); or about an error due to the already presence of another same vehicle in the system.
	*/
	public String addVehicle(String brand, int model, double cylinder, double mileage, char typeVehicle,
			String licensePlate, double totalPrice, double basePrice, char typeCar, int numDoors,
			boolean polarizedWindows, char typeCharger, double durationBattery, double consumeBattery,
			double price1, double price2, int year1, int year2, String codeDoc1, String codeDoc2, double coverageAmount,
			double gasLevel) throws IOException, LackOfLandException {
		String message = "";
			if (typeVehicle == Vehicle.TYPE_VEHICLE_USED) {
				Vehicle objSearch = searchVehicleWithLicensePlate(licensePlate);
				if (objSearch != null)
					message = "This vehicle was already added to the system before with that license plate.";
				else {
					Document documents = new Document();
					documents.setFirst(new Soat(price1, year1, codeDoc1, coverageAmount));
					documents.getFirst().setNext(new Review(price2, year2, codeDoc2, gasLevel));
					Vehicle obj = new Electric(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle,
					licensePlate, "", documents, typeCar, numDoors, polarizedWindows, typeCharger,
					durationBattery, consumeBattery);
					message = addUsedCarToParking((Car) obj);
					vehicles.add(obj);
					saveDataVehicles();
					message += "Used electric car successfully registered.";
				}
			} else if (typeVehicle == Vehicle.TYPE_VEHICLE_NEW) {
				Vehicle objSearch=searchVehicleWithoutLicensePlate(brand, model, cylinder);
				if (objSearch != null)
					message = "This vehicle was already added to the system before with those characteristics.";
				else {
					Document documents = new Document();
					documents.setFirst(new Soat(price1, year1, codeDoc1, coverageAmount));
					documents.getFirst().setNext(new Review(price2, year2, codeDoc2, gasLevel));
					Vehicle obj = new Electric(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle,
					licensePlate, "", documents, typeCar, numDoors, polarizedWindows, typeCharger,
					durationBattery, consumeBattery);
					vehicles.add(obj);
					saveDataVehicles();
					message = "New electric car successfully registered.";
				}
			}
		return message;
	}

	/** Name: addVehicle
	 * Method used to add a hybrid car to the list of vehicles of the system. <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> Adding process determined of the hybrid car in question in the list of vehicles of the system. <br>
	 * @param brand - hybrid car's brand - brand = String, brand != null, brand != ""
	 * @param model - hybrid car's model - model = int, model != null, model != 0
	 * @param cylinder - hybrid car's cylinder - cylinder = double, cylinder != 0
	 * @param mileage - hybrid car's mileage - mileage = double, mileage != null
	 * @param typeVehicle - vehicle's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	 * @param licensePlate - hybrid car's license plate - licensePlate = String, licensePlate != null
	 * @param totalPrice - hybrid car's total price - totalPrice = double, totalPrice != null, totalPrice begins in 0
	 * @param basePrice - hybrid car's base price - basePrice = double, basePrice != null, basePrice != 0
	 * @param typeCar - hybrid car's type - typeCar = char, typeCar != null, typeCar != ''
	 * @param numDoors - hybrid car's doors number - numDoors = int, numDoors != null, numDoors != 0
	 * @param polarizedWindows - hybrid car's polarized windows declaration - polarizedWindows = boolean, numDoors != null, polarizedWindows begins in false
	 * @param capacityGasoline - gasoline capacity of the gasoline car - capacityGasoline = double, capacityGasoline != null, capacityGasoline != 0
	 * @param typeGasoline - gasoline type of the gasoline car - typeGasoline = char, typeGasoline != null, typeGasoline != ''
	 * @param consumeGasoline - gasoline consume of the gasoline car - consumeGasoline = double, consumeGasoline != null, consumeGasoline begins in 0
	 * @param typeCharger - charger type of the hybrid car - typeCharger = char, typeCharger != null, typeCharger != ''
	 * @param durationBattery - battery duration of the hybrid car - durationBattery = double, durationBattery != null, durationBattery != 0
	 * @param consumeBattery - battery consume of the hybrid car - consumeBattery = double, consumeBattery != null, consumeBattery begins in 0
	 * @param n - number to finally decide if the hybrid car has polarized windows or not - n = int, n != null, n == 1 || n== 0
	 * @param price1 - price of the Soat document of the hybrid car - price1 = double, price1 != null, price1 != 0
	 * @param price2 - price of the Mechanical Technical Review document of the hybrid car - price2 = double, price2 != null, price2 != 0
	 * @param year1 - year of the Soat document of the hybrid car - year1 = int, year1 != null, year1 begins in 0 if typeVehicle == 'N' else year1 =! 0
	 * @param year2 - year of the Mechanical Technical Review document of the hybrid car - year2 = int, year2 != null, year2 begins in 0 if typeVehicle == 'N' else year2 =! 0
	 * @param codeDoc1 - code of the Soat document of the hybrid car - codeDoc1 = String, codeDoc1 != null, codeDoc1 begins as "" if typeVehicle == 'N' else codeDoc1 =! ""
	 * @param codeDoc2 - code of the Mechanical Technical Review document of the hybrid car - codeDoc2 = String, codeDoc2 != null, codeDoc2 begins as "" if typeVehicle == 'N' else codeDoc2 =! ""
	 * @param coverageAmount - coverage amount of the Soat document of the hybrid car - coverageAmount = double, coverageAmount != null, coverageAmount != 0
	 * @param gasLevel - gas level thrown by the hybrid car (Mechanical Technical Review document information) - gasLevel = double, gasLevel != null, gasLevel begins in 0 if typeVehicle == 'N' else year2 =! 0
	 * @throws IOException - if it cannot write the file properly while saving.
	 * @throws LackOfLandException - if there is no more space to place a used car of a specific model in a column of the parking.
	 * @return A String with a message about the successful adding process of the hybrid car to the list of vehicles of the system and eventually with a message about the movement of the car to the parking (or with an advice about the need to expand the parking for a certain cars model); or about an error due to the already presence of another same vehicle in the system.
	*/
	public String addVehicle(String brand, int model, double cylinder, double mileage, char typeVehicle,
			String licensePlate, double totalPrice, double basePrice, char typeCar, int numDoors,
			boolean polarizedWindows, double capacityGasoline, char typeGasoline, double consumeGasoline,
			char typeCharger, double durationBattery, double consumeBattery, double price1, double price2,
			int year1, int year2, String codeDoc1, String codeDoc2, double coverageAmount, double gasLevel) throws IOException, LackOfLandException {
		String message = "";
			if (typeVehicle == Vehicle.TYPE_VEHICLE_USED) {
				Vehicle objSearch = searchVehicleWithLicensePlate(licensePlate);
				if (objSearch != null)
					message = "This vehicle was already added to the system before with that license plate.";
				else {
					Document documents = new Document();
					documents.setFirst(new Soat(price1, year1, codeDoc1, coverageAmount));
					documents.getFirst().setNext(new Review(price2, year2, codeDoc2, gasLevel));
					Vehicle obj = new Hybrid(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle,
					licensePlate, "", documents, typeCar, numDoors, polarizedWindows, capacityGasoline,
					typeGasoline, consumeGasoline, typeCharger, durationBattery, consumeBattery);
					message = addUsedCarToParking((Car) obj);
					vehicles.add(obj);
					saveDataVehicles();
					message += "Used hybrid car successfully registered.";
				}
			} else if (typeVehicle == Vehicle.TYPE_VEHICLE_NEW) {
				Vehicle objSearch=searchVehicleWithoutLicensePlate(brand, model, cylinder);
				if (objSearch != null)
					message = "This vehicle was already added to the system before with those characteristics.";
				else {
					Document documents = new Document();
					documents.setFirst(new Soat(price1, year1, codeDoc1, coverageAmount));
					documents.getFirst().setNext(new Review(price2, year2, codeDoc2, gasLevel));
					Vehicle obj = new Hybrid(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle,
					licensePlate, "", documents, typeCar, numDoors, polarizedWindows, capacityGasoline,
					typeGasoline, consumeGasoline, typeCharger, durationBattery, consumeBattery);
					vehicles.add(obj);
					saveDataVehicles();
					message = "New hybrid car successfully registered.";
				}
			}
		return message;
	}

	/** Name: addVehicle
	 * Method used to add a motorcycle to the list of vehicles of the system. <br>
	 * <b>pre: </b> List of vehicles already initialized. <br>
	 * <b>post: </b> Adding process determined of the motorcycle in question in the list of vehicles of the system. <br>
	 * @param brand - motorcycle's brand - brand = String, brand != null, brand != ""
	 * @param model - motorcycle's model - model = int, model != null, model != 0
	 * @param cylinder - motorcycle's cylinder - cylinder = double, cylinder != 0
	 * @param mileage - motorcycle's mileage - mileage = double, mileage != null
	 * @param typeVehicle - vehicle's type - typeVehicle = char, typeVehicle != null, typeVehicle != ''
	 * @param licensePlate - motorcycle's license plate - licensePlate = String, licensePlate != null
	 * @param totalPrice - motorcycle's total price - totalPrice = double, totalPrice != null, totalPrice begins in 0
	 * @param basePrice - motorcycle's base price - basePrice = double, basePrice != null, basePrice != 0
	 * @param typeMoto - motorcycle's type - typeMoto = char, typeMoto != null, typeMoto != ''
	 * @param capacityGasoline - gasoline capacity of the motorcycle - capacityGasoline = double, capacityGasoline != null, capacityGasoline != 0
	 * @param consumeGasoline - gasoline consume of the motorcycle - consumeGasoline = double, consumeGasoline != null, consumeGasoline begins in 0
	 * @param price1 - price of the Soat document of the motorcycle - price1 = double, price1 != null, price1 != 0
	 * @param price2 - price of the Mechanical Technical Review document of the motorcycle - price2 = double, price2 != null, price2 != 0
	 * @param year1 - year of the Soat document of the motorcycle - year1 = int, year1 != null, year1 begins in 0 if typeVehicle == 'N' else year1 =! 0
	 * @param year2 - year of the Mechanical Technical Review document of the motorcycle - year2 = int, year2 != null, year2 begins in 0 if typeVehicle == 'N' else year2 =! 0
	 * @param codeDoc1 - code of the Soat document of the motorcycle - codeDoc1 = String, codeDoc1 != null, codeDoc1 begins as "" if typeVehicle == 'N' else codeDoc1 =! ""
	 * @param codeDoc2 - code of the Mechanical Technical Review document of the motorcycle - codeDoc2 = String, codeDoc2 != null, codeDoc2 begins as "" if typeVehicle == 'N' else codeDoc2 =! ""
	 * @param coverageAmount - coverage amount of the Soat document of the motorcycle - coverageAmount = double, coverageAmount != null, coverageAmount != 0
	 * @param gasLevel - gas level thrown by the motorcycle (Mechanical Technical Review document information) - gasLevel = double, gasLevel != null, gasLevel begins in 0 if typeVehicle == 'N' else year2 =! 0
	 * @throws IOException - if it cannot write the file properly while saving.
	 * @return A String with a message about the successful adding process of the motorcycle to the list of vehicles of the system; or about an error due to the already presence of another same vehicle in the system.
	*/
	public String addVehicle(String brand, int model, double cylinder, double mileage, char typeVehicle,
			String licensePlate, double totalPrice, double basePrice, char typeMoto, double capacityGasoline,
			double consumeGasoline, double price1, double price2, int year1, int year2, String codeDoc1,
			String codeDoc2, double coverageAmount, double gasLevel) throws IOException {
		String message = "";
		if (typeVehicle == Vehicle.TYPE_VEHICLE_USED) {
			Vehicle objSearch = searchVehicleWithLicensePlate(licensePlate);
			if (objSearch != null)
				message = "This vehicle was already added to the system before with that license plate.";
			else {
				Document documents = new Document();
				documents.setFirst(new Soat(price1, year1, codeDoc1, coverageAmount));
				documents.getFirst().setNext(new Review(price2, year2, codeDoc2, gasLevel));
				Vehicle obj = new Motorcycle(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle,
				licensePlate, null, documents, typeMoto, capacityGasoline, consumeGasoline);
				vehicles.add(obj);
				saveDataVehicles();
				message = "Used motorcycle successfully registered.";
			}
		} else if (typeVehicle == Vehicle.TYPE_VEHICLE_NEW) {
			Vehicle objSearch = searchVehicleWithoutLicensePlate(brand, model, cylinder);
			if (objSearch != null)
				message = "This vehicle was already added to the system before with those characteristics.";
			else {
				Document documents = new Document();
				documents.setFirst(new Soat(price1, year1, codeDoc1, coverageAmount));
				documents.getFirst().setNext(new Review(price2, year2, codeDoc2, gasLevel));
				Vehicle obj = new Motorcycle(totalPrice, basePrice, brand, model, cylinder, mileage, typeVehicle,
				licensePlate, null, documents, typeMoto, capacityGasoline, consumeGasoline);
				vehicles.add(obj);
				saveDataVehicles();
				message = "New motorcycle successfully registered.";
			}
		}
		return message;
	}

	/** Name: addUsedCarToParking
	 * Method used to add a used car to the parking. <br>
	 * <b>pre: </b> Vehicle matrix representing the parking already initialized. <br>
	 * <b>post: </b> Adding process determined of the used car in question to the parking. <br>
	 * @param obj - Vehicle object that can be just a used Car - obj = Vehicle object, obj != null
	 * @throws LackOfLandException - if there is no more space to place a used car of a specific model in a column of the parking.
	 * @throws IOException - if it cannot write the file properly while saving.
	 * @return A String with a message about the successful adding process of the used car in question to the parking; or with an advice about the need to expand the parking for a certain cars model.
	*/
	private String addUsedCarToParking(Car obj) throws LackOfLandException, IOException {
		String message = "";
		boolean added = false;
		if (obj.getModel() < 2015) {
			if (obj.getModel() == 2014) {
				for (int a = 0; a < parking.length && !added; a++) {
					for (int b = 0; b < parking.length && !added; b++) {
						if (parking[a][0] == null) {
							parking[a][0] = obj;
							added = true;
							message = "This used gasoline/electric/hybrid car has been saved in the old cars' parking.\n\n";
							saveDataCarsParking();
						} else {
							message = "There is no more space to place 2014 cars in the parking. Expand it!";
							throw new LackOfLandException(message);
						}
					}
				}
			} else if (obj.getModel() == 2013) {
				for (int a = 0; a < parking.length && !added; a++) {
					for (int b = 0; b < parking.length && !added; b++) {
						if (parking[a][1] == null) {
							parking[a][1] = obj;
							added = true;
							message = "This used gasoline/electric/hybrid car has been saved in the old cars' parking.\n\n";
							saveDataCarsParking();
						} else {
							message = "There is no more space to place 2013 cars in the parking. Expand it!";
							throw new LackOfLandException(message);
						}
					}
				}
			} else if (obj.getModel() == 2012) {
				for (int a = 0; a < parking.length && !added; a++) {
					for (int b = 0; b < parking.length && !added; b++) {
						if (parking[a][2] == null) {
							parking[a][2] = obj;
							added = true;
							message = "This used gasoline/electric/hybrid car has been saved in the old cars' parking.\n\n";
							saveDataCarsParking();
						} else {
							message = "There is no more space to place 2012 cars in the parking. Expand it!";
							throw new LackOfLandException(message);
						}
					}
				}
			} else if (obj.getModel() == 2011) {
				for (int a = 0; a < parking.length && !added; a++) {
					for (int b = 0; b < parking.length && !added; b++) {
						if (parking[a][3] == null) {
							parking[a][3] = obj;
							added = true;
							message = "This used gasoline/electric/hybrid car has been saved in the old cars' parking.\n\n";
							saveDataCarsParking();
						} else {
							message = "There is no more space to place 2011 cars in the parking. Expand it!";
							throw new LackOfLandException(message);
						}
					}
				}
			} else if (obj.getModel() < 2011) {
				for (int a = 0; a < parking.length && !added; a++) {
					for (int b = 0; b < parking.length && !added; b++) {
						if (parking[a][4] == null) {
							parking[a][4] = obj;
							added = true;
							message = "This used gasoline/electric/hybrid car has been saved in the old cars' parking.\n\n";
							saveDataCarsParking();
						} else {
							message = "There is no more space to place cars of model less than 2011 in the parking. Expand it!";
							throw new LackOfLandException(message);
						}

					}
				}
			}
		}
		return message;
	}
}