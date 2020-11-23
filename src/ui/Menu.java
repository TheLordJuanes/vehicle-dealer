/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import exceptions.FavoriteVehicleException;
import exceptions.LackOfLandException;
import exceptions.WorkloadException;
import java.io.IOException;
import java.time.LocalDate;
import model.Company;

public class Menu {

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    public Scanner scanner = new Scanner(System.in);

    // -----------------------------------------------------------------
    // Relations
    // -----------------------------------------------------------------

    private Company dealer;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Name: Menu
     * Constructor method of a menu. <br>
    */
    public Menu() {
        String nameCompany = "Dealer S.A.S.®";
        String nit = "57394-65921";
        double totalEarnings = 0;
        int numSales = 0;
        try {
            dealer = new Company(nameCompany, nit, totalEarnings, numSales);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: showMenu
     * Method used to show the option menu. <br>
     * @throws IOException
    */
    public void showMenu() {
        boolean menu = true;
        System.out.println("\n--------------");
        System.out.println(dealer.getNameCompany());
        System.out.println("--------------");
        while (menu) {
            System.out.println("\n**********");
            System.out.println("Start Menu");
            System.out.println("**********");
            System.out.println("\nChoose a module:\n");
            System.out.println("(1) Vehicles' module\n(2) Employees' module\n(3) Clients' module\n(4) Parking module\n(5) Persistence module\n(6) Exit menu\n");
            try {
                int module = Integer.parseInt(scanner.nextLine());
                int opt;
                switch (module) {
                    case 1:
                        System.out.println("\nType 1 to add a vehicle.\nType 2 to sell a vehicle.\nType 3 to show the vehicle catalog.\nType 4 to remove a vehicle.\nType 5 to return to the modules menu.\n");
                        opt = Integer.parseInt(scanner.nextLine());
                        if (opt == 1) {
                            System.out.println("\nType 1 to add a gasoline car.\nType 2 to add an electric car.\nType 3 to add an hybrid car.\nType 4 to add a motorcycle.\n");
                            opt = Integer.parseInt(scanner.nextLine());
                            if (opt == 1)
                                addVehicleCarGasoline();
                            else if (opt == 2)
                                addVehicleCarElectric();
                            else if (opt == 3)
                                addVehicleCarHybrid();
                            else if (opt == 4)
                                addVehicleMotorcycle();
                        } else if (opt == 2)
                            sellVehicle();
                        else if (opt == 3)
                            showCatalog();
                        else if (opt == 4)
                            removeAVehicle();
                        break;
                    case 2:
                        System.out.println("\nType 1 to register an employee.\nType 2 to assign a client to an employee.\nType 3 to show the registered employees by Ascending Last name and name.\nType 4 to show the registered employees by Descending Total Sales and ID. \nType 5 to search for an employee by his id\nType 6 to return to the modules menu.\n");
                        opt = Integer.parseInt(scanner.nextLine());
                        if (opt == 1)
                            registerEmployee();
                        else if (opt == 2)
                            assignClient();
                        else if (opt == 3)
                            showEmployeesByLastNameAndName();
                        else if (opt == 4)
                            showEmployeesByTotalSalesAndID();
                        break;
                    case 3:
                        System.out.println("\nType 1 to register a client.\nType 2 to assign a vehicle of interest to a client.\nType 3 to show the registered clients by Descending Last name and Phone number.\nType 4 to show the registered clients by Ascending Name and E-mail. \nType 5 to search for a client by phone number \nType 6 to return to the modules menu.\n");
                        opt = Integer.parseInt(scanner.nextLine());
                        if (opt == 1)
                            registerClient();
                        else if (opt == 2)
                            assignVehicle();
                        else if (opt == 3)
                            showClientsByLastNameAndPhone();
                        else if (opt == 4)
                            showClientsByNameAndEmail();
                        break;
                    case 4:
                        System.out.println("\nType 1 to look at the parking.\nType 2 to return to the modules menu.\n");
                        opt = Integer.parseInt(scanner.nextLine());
                        if (opt == 1)
                            lookParking();
                        break;
                    case 5:
                        System.out.println("\nType 1 to import data from a file.\nType 2 to export data in a file.\nType 3 to return to the modules menu.\n");
                        opt = Integer.parseInt(scanner.nextLine());
                        if (opt == 1) {

                        }
                        else if (opt == 2)
                        break;
                    case 6:
                        menu = false;
                        System.out.print("\nLeaving the menu...\n\nEnd of menu.\nGoodbye!\n\n");
                        break;
                    default:
                        System.out.println("Option not available ");
                        break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nError! You must enter a whole number. Try again.");
            } catch (NumberFormatException nfe) {
                System.out.println("\nError! Invalid input format. Try again.");
            }
        }
    }

    /**
     * Name: showEmployeesByLastName
     * Method used to show all the employees registered in the system, sorted in ascending order by their last names (or, if same ones, by their names), invoking the showEmployeesByLastNameAndName() method of the Company class. <br>
    */
   public void showEmployeesByLastNameAndName() {
       if (dealer.getPeople().isEmpty())
            System.out.println("\nThere are no people registered in the system to show its data.");
        else
            System.out.println(dealer.showEmployeesByLastNameAndName());
    }

    /**
     * Name: showEmployeesByTotalSalesAndID
     * Method used to show all the employees registered in the system, sorted in descending order by their total sales (or, if same ones, by ID's), invoking the showEmployeesByTotalSalesAndID() method of the Company class. <br>
    */
   public void showEmployeesByTotalSalesAndID() {
       if (dealer.getPeople().isEmpty())
            System.out.println("\nThere are no people registered in the system to show its data.");
        else
            System.out.println(dealer.showEmployeesByTotalSalesAndID());
    }

    /**
     * Name: showClientsByLastNameAndPhone
     * Method used to show all the clients registered in the system, sorted in descending order by their last names (or, if same ones, by their phone numbers), invoking the showClientsByLastNameAndPhone() method of the Company class. <br>
    */
    public void showClientsByLastNameAndPhone() {
       if (dealer.getPeople().isEmpty())
            System.out.println("\nThere are no people registered in the system to show its data.");
       else
            System.out.println(dealer.showClientsByLastNameAndPhone());
    }

    /**
     * Name: showClientsByNameAndEmail
     * Method used to show all the clients registered in the system, sorted in ascending order by their names (or, if same ones, by their e-mails), invoking the showClientsByNameAndEmail() method of the Company class. <br>
    */
    public void showClientsByNameAndEmail() {
       if (dealer.getPeople().isEmpty())
            System.out.println("\nThere are no people registered in the system to show its data.");
        else
            System.out.println(dealer.showClientsByNameAndEmail());
    }

    /**
     * Name: assignVehicle
     * Method used to assign a vehicle of interest to a client. <br>
     * <b>pre: </b> The user of this program has already seen first the vehicles' catalog (mostly in the case of the type NEW vehicles) to assign a vehicle of interest to the list of vehicles of interest of a client). <br>
    */
    public void assignVehicle() {
        if (dealer.getVehicles().isEmpty())
            System.out.println("\nThere are no vehicles registered in the system. Add one to assign it to the list of vehicles of interest of this client.\n");
        else {
            System.out.print("ID of the client: ");
            String idClient = scanner.nextLine();
            System.out.println("\nIs the client interested in a new or in a used car?");
            System.out.println("\n(N) New.\n(U) Used.\n");
            char type = scanner.nextLine().toUpperCase().charAt(0);
            System.out.print("Car's cylinder: ");
            double cylinder = Double.parseDouble(scanner.nextLine());
            System.out.println();
            if (type == 'U') {
                System.out.println("Enter the car's license plate: ");
                String licensePlate = scanner.nextLine();
                try {
                    System.out.println(dealer.toAssignVehicleUsed(idClient, licensePlate, cylinder));
                } catch (FavoriteVehicleException fve) {
                    fve.printStackTrace();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } else if (type == 'N') {
                System.out.print("\nCar's brand: ");
                String brand = scanner.nextLine();
                System.out.print("Car's model: ");
                int model = Integer.parseInt(scanner.nextLine());
                try {
                    System.out.println(dealer.toAssignVehicleNew(idClient, brand, model, cylinder));
                } catch (FavoriteVehicleException fve) {
                    fve.printStackTrace();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    /**
     * Name: assignClient
     * Method used to assign a client to a seller. <br>
    */
    public void assignClient() {
        System.out.print("ID of the client: ");
        String idClient = scanner.nextLine();
        System.out.print("ID of the employee: ");
        String idEmployee = scanner.nextLine();
        System.out.println("Phone of the client");
        String phone = scanner.nextLine();
        try {
			System.out.print(dealer.toAssignClient(idClient, idEmployee, phone));
		} catch (WorkloadException we) {
			we.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
    }

    /**
     * Name: removeAPerson
     * Method used to remove a person. <br>
    */
    public void removeAPerson() {
        System.out.print("ID of the person: ");
        String id = scanner.nextLine();
        System.out.print(dealer.removePerson(id));
    }

    /**
     * Name: removeAVehicle
     * Method used to remove a vehicle. <br>
    */
    public void removeAVehicle() {
        System.out.print("Car's license plate: ");
        String licensePlate = scanner.nextLine();
        System.out.print(dealer.removeVehicleWithLicensePlate(licensePlate));
    }

    /**
     * Name: lookParking
     * Method used to look at the parking. <br>
    */
    public void lookParking() {
        System.out.println("Press 0 to see the 2014 model ones.\nPress 1 to see the 2013 model ones.\nPress 2 to see the 2012 model ones.\nPress 3 to see the 2011 model ones.\nPress 4 to see those of model less than 2011.\n");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(dealer.lookCarsParking(n));
    }

    /**
     * Name: showCatalog
     * Method used to show the vehicle catalog. <br>
    */
    public void showCatalog() {
        System.out.println("Press 1 to see the Gasoline cars available.\nPress 2 to see the Electric cars available.\nPress 3 to see the Hybrid cars available.\nPress 4 to see the motorcycles available.");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Press 'U' to see the used ones.\nPress 'N' to see the new ones.\nPress 'B' to see both used and new ones.");
        char c = scanner.nextLine().toUpperCase().charAt(0);
        while (c != 'U' && c != 'N' && c != 'B') {
            System.out.println("\nError. Option not available. Try again");
            System.out.println("Press 'U' to see the used ones.\nPress 'N' to see the new ones.\nPress 'B' to see both used and new ones.");
            c = scanner.nextLine().toUpperCase().charAt(0);
            System.out.println();
        }
        if (n == 1)
            System.out.println(dealer.showVehiclesGasoline(c));
        else if (n == 2)
            System.out.println(dealer.showVehiclesElectric(c));
        else if (n == 3)
            System.out.println(dealer.showVehiclesHybrid(c));
        else if (n == 4)
            System.out.println(dealer.showVehiclesMotorcycle(c));
    }

    /**
     * Name: sellVehicle
     * Method used to sell a vehicle. <br>
     * <b>pre: </b> The user of this program has already seen first the vehicles' catalog (mostly in the case of the type NEW vehicles) to sell a vehicle to a client). <br>
    */
    public void sellVehicle() {
        System.out.println("What type of vehicle do you want to sell?");
        System.out.println("Type 1 to sell a gasoline car.");
        System.out.println("Type 2 to sell an electric car.");
        System.out.println("Type 3 to sell an hybrid car");
        System.out.println("Type 4 to sell a motorcycle.");
        int selection = Integer.parseInt(scanner.nextLine());
        System.out.println("\nIs it new or used?");
        System.out.println("Type 'N' if it is a new vehicle.");
        System.out.println("Type 'U' if it is an used vehicle.");
        char typeVehicle = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Car's cylinder: ");
        double cylinder = Double.parseDouble(scanner.nextLine());
        String licensePlate = "";
        String brand = "";
        int model = 0;
        if (typeVehicle == 'U') {
            System.out.print("Enter its license plate: ");
            licensePlate = scanner.nextLine();
            System.out.print("Enter its model: ");
            model = Integer.parseInt(scanner.nextLine());
        } else if (typeVehicle == 'N') {
            System.out.print("Assign a new license plate: ");
            licensePlate = scanner.nextLine();
            System.out.println("After looking at the catalog, enter the following characteristics of the car that the client is interested in:");
            System.out.print("\nCar's brand: ");
            brand = scanner.nextLine();
            System.out.print("Car's model: ");
            model = Integer.parseInt(scanner.nextLine());
            System.out.print("Car's cylinder: ");
            cylinder = Double.parseDouble(scanner.nextLine());
        }
        System.out.print("Enter the seller ID: ");
        String idEmployee = scanner.nextLine();
        System.out.print("Enter the client ID: ");
        String idClient = scanner.nextLine();
        System.out.print("Enter the client phone: ");
        String phone = scanner.nextLine();
        System.out.println(dealer.sellAVehicle(licensePlate, idEmployee, idClient, selection, typeVehicle, brand, model, cylinder, phone));
    }

    /**
     * Name: registerClient
     * Method used to register a client. <br>
    */
    public void registerClient() {
        System.out.print("Name of the client: ");
        String namePerson = scanner.nextLine();
        System.out.print("Last name of the client: ");
        String lastName = scanner.nextLine();
        System.out.print("ID of the client: ");
        String id = scanner.nextLine();
        System.out.print("Cell phone number of the client: ");
        String numPhone = scanner.nextLine();
        System.out.print("E-mail of the client: ");
        String email = scanner.nextLine();
        boolean active = true;
        boolean hasSeller = false;
        System.out.println();
        try {
            System.out.println(dealer.addClient(namePerson, lastName, id, numPhone, email, active, hasSeller));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println();
    }

    /**
     * Name: registerEmployee
     * Method used to register an employee. <br>
    */
    public void registerEmployee() {
        System.out.print("Name of the employee: ");
        String namePerson = scanner.nextLine();
        System.out.print("Last name of the employee: ");
        String lastName = scanner.nextLine();
        System.out.print("ID of the employee: ");
        String id = scanner.nextLine();
        int quantTotalSales = 0;
        System.out.println();
        try {
            System.out.println(dealer.addEmployee(namePerson, lastName, id, quantTotalSales));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        System.out.println();
    }

    /**
     * Name: addVehicleCarGasoline
     * Method used to add a gasoline car. <br>
    */
    public void addVehicleCarGasoline() {
        System.out.print("Car's brand: ");
        String brand = scanner.nextLine();
        System.out.print("Car's model: ");
        int model = Integer.parseInt(scanner.nextLine());
        System.out.print("Car's cylinder: ");
        double cylinder = Double.parseDouble(scanner.nextLine());
        System.out.println("\nType of vehicle:");
        System.out.println("Enter 'N' if it is a new vehicle.");
        System.out.println("Enter 'U' if it is an used vehicle.");
        char typeVehicle = scanner.nextLine().toUpperCase().charAt(0);
        double mileage = 0;
        String licensePlate = "";
        if (typeVehicle == 'U') {
            System.out.print("Car's mileage: ");
            mileage = Double.parseDouble(scanner.nextLine());
            System.out.print("Car's license plate: ");
            licensePlate = scanner.nextLine();
        }
        System.out.print("Car's base price: ");
        double basePrice = Double.parseDouble(scanner.nextLine());
        System.out.println("\nType of car:");
        System.out.println("Enter 'S' if it is a Sedan car.");
        System.out.println("Enter 'V' if it is a Van car.");
        char typeCar = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Number of the car doors: ");
        int numDoors = Integer.parseInt(scanner.nextLine());
        System.out.print("Does it have polarized windows? Type 1 if yes, or type 0 if not: ");
        int n = Integer.parseInt(scanner.nextLine());
        boolean polarizedWindows = false;
        while (n != 1 && n != 0) {
            System.out.println("\nError. Option not available. Try again");
            System.out.print("Does it have polarized windows? Type 1 if yes, or type 0 if not: ");
            n = Integer.parseInt(scanner.nextLine());
            System.out.println();
        }
        System.out.print("Car's gasoline tank capacity: ");
        double capacityGasoline = Double.parseDouble(scanner.nextLine());
        System.out.println("\nCar's gasoline type: ");
        System.out.println("Enter letter 'E' if it is an Extra gasoline.");
        System.out.println("Enter letter 'O' if it is an Ordinary gasoline.");
        System.out.println("Enter letter 'D' if it is a Diesel gasoline.");
        char typeGasoline = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Document SOAT - price: ");
        double price1 = Double.parseDouble(scanner.nextLine());
        int year1 = 0;
        String codeDoc1 = "";
        if (typeVehicle == 'U') {
            System.out.print("Document SOAT - year: ");
            year1 = Integer.parseInt(scanner.nextLine());
            int currentYear = LocalDate.now().getYear();
            if (year1 == currentYear) {
                System.out.print("Document SOAT - code: ");
                codeDoc1 = scanner.nextLine();
            }
        }
        System.out.print("\nDocument SOAT - Coverage amount: ");
        double coverageAmount = Double.parseDouble(scanner.nextLine());
        System.out.print("Document Mechanical Technical Review - price: ");
        double price2 = Double.parseDouble(scanner.nextLine());
        int year2 = 0;
        String codeDoc2 = "";
        double gasLevel = 0;
        if (typeVehicle == 'U') {
            System.out.print("Document Mechanical Technical Review - year: ");
            year2 = Integer.parseInt(scanner.nextLine());
            int currentYear = LocalDate.now().getYear();
            if (year2 == currentYear) {
                System.out.print("Document Mechanical Technical Review - code: ");
                codeDoc2 = scanner.nextLine();
            }
            System.out.print("\nDocument Mechanical Technical Review - Gas levels released: ");
            gasLevel = Double.parseDouble(scanner.nextLine());
        }
        System.out.println();
        try {
			System.out.println(dealer.addVehicle(brand, model, cylinder, mileage, typeVehicle, licensePlate, 0,
			basePrice, typeCar, numDoors, polarizedWindows, capacityGasoline, typeGasoline, 0,
			price1, price2, year1, year2, codeDoc1, codeDoc2, coverageAmount, gasLevel));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (LackOfLandException lole) {
			lole.printStackTrace();
		}
        System.out.println();
    }

    /**
     * Name: addVehicleCarElectric
     * Method used to add a electric car. <br>
    */
    public void addVehicleCarElectric() {
        System.out.print("Car's brand: ");
        String brand = scanner.nextLine();
        System.out.print("Car's model: ");
        int model = Integer.parseInt(scanner.nextLine());
        System.out.print("Car's cylinder: ");
        double cylinder = Double.parseDouble(scanner.nextLine());
        System.out.println("\nType of vehicle:");
        System.out.println("Enter 'N' if it is a new vehicle.");
        System.out.println("Enter 'U' if it is an used vehicle.");
        char typeVehicle = scanner.nextLine().toUpperCase().charAt(0);
        double mileage = 0;
        String licensePlate = "";
        if (typeVehicle == 'U') {
            System.out.print("Car's mileage: ");
            mileage = Double.parseDouble(scanner.nextLine());
            System.out.print("Car's license plate: ");
            licensePlate = scanner.nextLine();
        }
        System.out.print("Car's base price: ");
        double basePrice = Double.parseDouble(scanner.nextLine());
        System.out.println("\nType of car:");
        System.out.println("Enter 'S' if it is a Sedan car.");
        System.out.println("Enter 'V' if it is a Van car.");
        char typeCar = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Number of the car doors: ");
        int numDoors = Integer.parseInt(scanner.nextLine());
        System.out.print("Does it have polarized windows? Type 1 if yes, or type 0 if not: ");
        int n = Integer.parseInt(scanner.nextLine());
        boolean polarizedWindows = false;
        while (n != 1 && n != 0) {
            System.out.println("\nError. Option not available. Try again");
            System.out.print("Does it have polarized windows? Type 1 if yes, or type 0 if not: ");
            n = Integer.parseInt(scanner.nextLine());
            System.out.println();
        }
        System.out.println("\nCar's charger type: ");
        System.out.println("Enter 'F' if it is a Fast charger.");
        System.out.println("Enter 'N' if it is a Normal charger.");
        char typeCharger = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Car's battery duration in hours: ");
        double durationBattery = Double.parseDouble(scanner.nextLine());
        System.out.print("Document SOAT - price: ");
        double price1 = Double.parseDouble(scanner.nextLine());
        int year1 = 0;
        String codeDoc1 = "";
        if (typeVehicle == 'U') {
            System.out.print("Document SOAT - year: ");
            year1 = Integer.parseInt(scanner.nextLine());
            int currentYear = LocalDate.now().getYear();
            if (year1 == currentYear) {
                System.out.print("Document SOAT - code: ");
                codeDoc1 = scanner.nextLine();
            }
        }
        System.out.print("\nDocument SOAT - Coverage amount: ");
        double coverageAmount = Double.parseDouble(scanner.nextLine());
        System.out.print("Document Mechanical Technical Review - price: ");
        double price2 = Double.parseDouble(scanner.nextLine());
        int year2 = 0;
        String codeDoc2 = "";
        double gasLevel = 0;
        if (typeVehicle == 'U') {
            System.out.print("Document Mechanical Technical Review - year: ");
            year2 = Integer.parseInt(scanner.nextLine());
            int currentYear = LocalDate.now().getYear();
            if (year2 == currentYear) {
                System.out.print("Document Mechanical Technical Review - code: ");
                codeDoc2 = scanner.nextLine();
            }
            System.out.print("\nDocument Mechanical Technical Review - Gas levels released: ");
            gasLevel = Double.parseDouble(scanner.nextLine());
        }
        System.out.println();
        try {
			System.out.println(dealer.addVehicle(brand, model, cylinder, mileage, typeVehicle, licensePlate, 0,
			basePrice, typeCar, numDoors, polarizedWindows, typeCharger, durationBattery, 0, price1,
			price2, year1, year2, codeDoc1, codeDoc2, coverageAmount, gasLevel));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (LackOfLandException lole) {
			lole.printStackTrace();
		}
        System.out.println();
    }

    /**
     * Name: addVehicleCarHybrid
     * Method used to add a hybrid car. <br>
    */
    public void addVehicleCarHybrid() {
        System.out.print("Car's brand: ");
        String brand = scanner.nextLine();
        System.out.print("Car's model: ");
        int model = Integer.parseInt(scanner.nextLine());
        System.out.print("Car's cylinder: ");
        double cylinder = Double.parseDouble(scanner.nextLine());
        System.out.println("\nType of vehicle:");
        System.out.println("Enter 'N' if it is a new vehicle.");
        System.out.println("Enter 'U' if it is an used vehicle.");
        char typeVehicle = scanner.nextLine().toUpperCase().charAt(0);
        double mileage = 0;
        String licensePlate = "";
        if (typeVehicle == 'U') {
            System.out.print("Car's mileage: ");
            mileage = Double.parseDouble(scanner.nextLine());
            System.out.print("Car's license plate: ");
            licensePlate = scanner.nextLine();
        }
        System.out.print("Car's base price: ");
        double basePrice = Double.parseDouble(scanner.nextLine());
        System.out.println("\nType of car:");
        System.out.println("Enter 'S' if it is a Sedan car.");
        System.out.println("Enter 'V' if it is a Van car.");
        char typeCar = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Number of the car doors: ");
        int numDoors = Integer.parseInt(scanner.nextLine());
        System.out.print("Does it have polarized windows? Type 1 if yes, or type 0 if not: ");
        int n = Integer.parseInt(scanner.nextLine());
        boolean polarizedWindows = false;
        while (n != 1 && n != 0) {
            System.out.println("\nError. Option not available. Try again");
            System.out.print("Does it have polarized windows? Type 1 if yes, or type 0 if not: ");
            n = Integer.parseInt(scanner.nextLine());
            System.out.println();
        }
        System.out.print("Car's gasoline tank capacity: ");
        double capacityGasoline = Double.parseDouble(scanner.nextLine());
        System.out.println("\nCar's gasoline type: ");
        System.out.println("Enter letter 'E' if it is an Extra gasoline.");
        System.out.println("Enter letter 'O' if it is an Ordinary gasoline.");
        System.out.println("Enter letter 'D' if it is a Diesel gasoline.");
        char typeGasoline = scanner.nextLine().toUpperCase().charAt(0);
        System.out.println("\nCar's charger type: ");
        System.out.println("Enter 'F' if it is a Fast charger.");
        System.out.println("Enter 'N' if it is a Normal charger.");
        char typeCharger = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Car's battery duration in hours: ");
        double durationBattery = Double.parseDouble(scanner.nextLine());
        System.out.print("Document SOAT - price: ");
        double price1 = Double.parseDouble(scanner.nextLine());
        int year1 = 0;
        String codeDoc1 = "";
        if (typeVehicle == 'U') {
            System.out.print("Document SOAT - year: ");
            year1 = Integer.parseInt(scanner.nextLine());
            int currentYear = LocalDate.now().getYear();
            if (year1 == currentYear) {
                System.out.print("Document SOAT - code: ");
                codeDoc1 = scanner.nextLine();
            }
        }
        System.out.print("\nDocument SOAT - Coverage amount: ");
        double coverageAmount = Double.parseDouble(scanner.nextLine());
        System.out.print("Document Mechanical Technical Review - price: ");
        double price2 = Double.parseDouble(scanner.nextLine());
        int year2 = 0;
        String codeDoc2 = "";
        double gasLevel = 0;
        if (typeVehicle == 'U') {
            System.out.print("Document Mechanical Technical Review - year: ");
            year2 = Integer.parseInt(scanner.nextLine());
            int currentYear = LocalDate.now().getYear();
            if (year2 == currentYear) {
                System.out.print("Document Mechanical Technical Review - code: ");
                codeDoc2 = scanner.nextLine();
            }
            System.out.print("\nDocument Mechanical Technical Review - Gas levels released: ");
            gasLevel = Double.parseDouble(scanner.nextLine());
        }
        System.out.println();
        try {
            System.out.println(dealer.addVehicle(brand, model, cylinder, mileage, typeVehicle, licensePlate, 0,
                    basePrice, typeCar, numDoors, polarizedWindows, capacityGasoline, typeGasoline, 0,
                    typeCharger, durationBattery, 0, price1, price2, year1, year2, codeDoc1, codeDoc2,
                    coverageAmount, gasLevel));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (LackOfLandException lole) {
			lole.printStackTrace();
		}
        System.out.println();
    }

    /**
     * Name: addVehicleMotorcycle
     * Method used to add a motorcycle. <br>
    */
    public void addVehicleMotorcycle() {
        System.out.print("Car's brand: ");
        String brand = scanner.nextLine();
        System.out.print("Car's model: ");
        int model = Integer.parseInt(scanner.nextLine());
        System.out.print("Car's cylinder: ");
        double cylinder = Double.parseDouble(scanner.nextLine());
        System.out.println("\nType of vehicle:");
        System.out.println("Enter 'N' if it is a new vehicle.");
        System.out.println("Enter 'U' if it is an used vehicle.");
        char typeVehicle = scanner.nextLine().toUpperCase().charAt(0);
        double mileage = 0;
        String licensePlate = "";
        if (typeVehicle == 'U') {
            System.out.print("Car's mileage: ");
            mileage = Double.parseDouble(scanner.nextLine());
            System.out.print("Car's license plate: ");
            licensePlate = scanner.nextLine();
        }
        System.out.print("Motorcycle's base price: ");
        double basePrice = Double.parseDouble(scanner.nextLine());
        System.out.println("\nType of motorcycle:");
        System.out.println("Enter 'S' if it is a Standard motorcycle.");
        System.out.println("Enter 'D' if it is a Sporty motorcycle.");
        System.out.println("Enter 'E' if it is a Scooter motorcycle.");
        System.out.println("Enter 'C' if it is a Cross motorcycle.");
        char typeMoto = scanner.nextLine().toUpperCase().charAt(0);
        System.out.print("Car's gasoline tank capacity: ");
        double capacityGasoline = Double.parseDouble(scanner.nextLine());
        System.out.print("Document SOAT - price: ");
        double price1 = Double.parseDouble(scanner.nextLine());
        int year1 = 0;
        String codeDoc1 = "";
        if (typeVehicle == 'U') {
            System.out.print("Document SOAT - year: ");
            year1 = Integer.parseInt(scanner.nextLine());
            int currentYear = LocalDate.now().getYear();
            if (year1 == currentYear) {
                System.out.print("Document SOAT - code: ");
                codeDoc1 = scanner.nextLine();
            }
        }
        System.out.print("\nDocument SOAT - Coverage amount: ");
        double coverageAmount = Double.parseDouble(scanner.nextLine());
        System.out.print("Document Mechanical Technical Review - price: ");
        double price2 = Double.parseDouble(scanner.nextLine());
        int year2 = 0;
        String codeDoc2 = "";
        double gasLevel = 0;
        if (typeVehicle == 'U') {
            System.out.print("Document Mechanical Technical Review - year: ");
            year2 = Integer.parseInt(scanner.nextLine());
            int currentYear = LocalDate.now().getYear();
            if (year2 == currentYear) {
                System.out.print("Document Mechanical Technical Review - code: ");
                codeDoc2 = scanner.nextLine();
            }
            System.out.print("\nDocument Mechanical Technical Review - Gas levels released: ");
            gasLevel = Double.parseDouble(scanner.nextLine());
        }
        System.out.println();
        try {
			System.out.println(dealer.addVehicle(brand, model, cylinder, mileage, typeVehicle, licensePlate, 0,
			basePrice, typeMoto, capacityGasoline, 0, price1, price2, year1, year2, codeDoc1,
			codeDoc2, coverageAmount, gasLevel));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
        System.out.println();
    }
}
