/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Author: Juan Esteban Caicedo A.
 * @Date: December, 5th 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import exceptions.FavoriteVehicleException;
import exceptions.LackOfLandException;
import exceptions.WorkloadException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Car;
import model.Client;
import model.Company;
import model.Electric;
import model.Employee;
import model.Gasoline;
import model.Headquarter;
import model.Hybrid;
import model.Motorcycle;
import model.Person;
import model.Ringlet;
import model.Square;
import model.Vehicle;
import thread.RingletThread;

public class DealerGUI {

    // -----------------------------------------------------------------
	// Attributes
    // -----------------------------------------------------------------

    private Stage primaryStage;

    @FXML
    private TableView<Headquarter> tvHeadquartersList;

    @FXML
    private TableColumn<Headquarter, String> tcNameHeadquarter;

    @FXML
    private TableColumn<Headquarter, String> tcNitHeadquarter;

    @FXML
    private TableColumn<Headquarter, String> tcAddressHeadquarter;

    @FXML
    private TableColumn<Headquarter, Integer> tcNumSalesHeadquarter;

    @FXML
    private TableColumn<Headquarter, Integer> tcTotalEarningsHeadquarter;

    @FXML
    private TableView<Car> tvParkingCarsList;

    @FXML
    private Rectangle shSquare0;

    @FXML
    private Rectangle shSquare1;

    @FXML
    private Rectangle shSquare2;

    @FXML
    private Rectangle shSquare3;

    @FXML
    private TextField txtNewLicensePlate;

    @FXML
    private TextField txtNameHeadquarter;

    @FXML
    private TextField txtNIT;

    @FXML
    private TextField txtAddress;

    @FXML
    private ToggleGroup toggleGroupCarModelParking;

    @FXML
    private ToggleGroup toggleGroupImport;

    @FXML
    private TextField txtSeparator;

    @FXML
    private TextField txtFileName;

    @FXML
    private TextField txtClientPhoneAssigning;

    @FXML
    private TextField txtIdClientAssigning;

    @FXML
    private TextField txtIdEmployeeAssigning;

    @FXML
    private TableView<Motorcycle> tvMotorcyclesList;

    @FXML
    private TableColumn<Motorcycle, Character> tcMotorcycleType;

    @FXML
    private TableColumn<Motorcycle, Double> tcGasolineCapacityMotorcycle;

    @FXML
    private TableColumn<Motorcycle, Double> tcGasolineConsumeMotorcycle;

    @FXML
    private TableColumn<Motorcycle, Double> tcTotalSellingPriceMotorcycle;

    @FXML
    private TableView<Hybrid> tvHybridCarsList;

    @FXML
    private TableColumn<Hybrid, Character> tcGasolineTypeCarHybrid;

    @FXML
    private TableColumn<Hybrid, Double> tcGasolineCapacityCarHybrid;

    @FXML
    private TableColumn<Hybrid, Double> tcGasolineConsumeCarHybrid;

    @FXML
    private TableColumn<Hybrid, Character> tcChargerTypeCarHybrid;

    @FXML
    private TableColumn<Hybrid, Double> tcBatteryDurationCarHybrid;

    @FXML
    private TableColumn<Hybrid, Double> tcBatteryConsumeCarHybrid;

    @FXML
    private TableColumn<Hybrid, Double> tcTotalSellingPriceCarHybrid;

    @FXML
    private TableView<Electric> tvElectricCarsList;

    @FXML
    private TableColumn<Electric, Character> tcChargerTypeCarElectric;

    @FXML
    private TableColumn<Electric, Double> tcBatteryDurationCarElectric;

    @FXML
    private TableColumn<Electric, Double> tcBatteryConsumeCarElectric;

    @FXML
    private TableColumn<Electric, Double> tcTotalSellingPriceCarElectric;

    @FXML
    private TableView<Gasoline> tvGasolineCarsList;

    @FXML
    private TableColumn<Vehicle, String> tcBrand;

    @FXML
    private TableColumn<Vehicle, Integer> tcModel;

    @FXML
    private TableColumn<Vehicle, Character> tcVehicleType;

    @FXML
    private TableColumn<Vehicle, Double> tcBasePrice;

    @FXML
    private TableColumn<Vehicle, String> tcLicensePlate;

    @FXML
    private TableColumn<Vehicle, Double> tcCylinder;

    @FXML
    private TableColumn<Vehicle, Double> tcMileage;

    @FXML
    private TableColumn<Vehicle, String> tcOwner;

    @FXML
    private TableColumn<Car, Character> tcCarType;

    @FXML
    private TableColumn<Car, Integer> tcDoorsNumber;

    @FXML
    private TableColumn<Car, Boolean> tcPolarizedWindows;

    @FXML
    private TableColumn<Gasoline, Character> tcGasolineTypeCarGasoline;

    @FXML
    private TableColumn<Gasoline, Double> tcGasolineCapacityCarGasoline;

    @FXML
    private TableColumn<Gasoline, Double> tcGasolineConsumeCarGasoline;

    @FXML
    private TableColumn<Gasoline, Double> tcTotalSellingPriceCarGasoline;

    @FXML
    private ToggleGroup toggleGroupVehicleKind;

    @FXML
    private TableColumn<Employee, Integer> tcQuantTotalSales;

    @FXML
    private TableView<Employee> tvEmployeesList;

    @FXML
    private TextField txtNamePerson;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtNumPhone;

    @FXML
    private TextField txtEmail;

    @FXML
    private TableView<Client> tvClientsList;

    @FXML
    private TableColumn<Person, String> tcLastName;

    @FXML
    private TableColumn<Person, String> tcName;

    @FXML
    private TableColumn<Person, String> tcID;

    @FXML
    private TableColumn<Client, String> tcPhone;

    @FXML
    private TableColumn<Client, String> tcEmail;

    @FXML
    private TableColumn<Client, Boolean> tcActive;

    @FXML
    private TableColumn<Client, Boolean> tcHasSeller;

    @FXML
    private ToggleGroup toggleGroupTypeMoto;

    @FXML
    private ToggleGroup toggleGroupTypeCharger;

    @FXML
    private TextField txtDurationBattery;

    @FXML
    private TextField txtModel;

    @FXML
    private ToggleGroup toggleGroupVehicleType;

    @FXML
    private TextField txtMileage;

    @FXML
    private TextField txtLicensePlate;

    @FXML
    private TextField txtBasePrice;

    @FXML
    private ToggleGroup toggleGroupCarType;

    @FXML
    private ToggleGroup toggleGroupGasolineType;

    @FXML
    private TextField txtNumDoors;

    @FXML
    private CheckBox cbPolarizedWindows;

    @FXML
    private TextField txtCapacityGasoline;

    @FXML
    private TextField txtPriceSoat;

    @FXML
    private TextField txtYearSoat;

    @FXML
    private TextField txtCoverageAmountSoat;

    @FXML
    private TextField txtPriceMTR;

    @FXML
    private TextField txtYearMTR;

    @FXML
    private TextField txtGasLevelMTR;

    @FXML
    private TextField txtCodeMTR;

    @FXML
    private TextField txtCodeSoat;

    @FXML
    private TextField txtCylinder;

    @FXML
    private TextField txtBrand;

    // -----------------------------------------------------------------
	// Relations
	// -----------------------------------------------------------------

    private Company dealer;
    private Ringlet ringlet;

    // -----------------------------------------------------------------
	// Methods
	// -----------------------------------------------------------------

    /**
     * Name: DealerGUI
     * GUI constructor method. <br>
     * @param primaryStage - GUI primary stage - primaryStage = Stage
    */
    public DealerGUI(Stage primaryStage) {
        this.primaryStage = primaryStage;
        try {
            dealer = new Company("Dealer S.A.S.®", "57394-65921", 0, 0);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: initialize
     * Method used to initialize the relation to the Ringlet class, to call its addSquare method and to create a new thread of the RingletThread class. <br>
    */
    public void initialize() {
    	ringlet = new Ringlet();
        ringlet.addSquare(shSquare0.getRotate());
    	ringlet.addSquare(shSquare1.getRotate());
    	ringlet.addSquare(shSquare2.getRotate());
        ringlet.addSquare(shSquare3.getRotate());
        new RingletThread(ringlet, this).start();
    }

    /**
     * Name: updateRinglet
     * Method used to update the ringlet status according to the rotation of its squares.
    */
    public void updateRinglet() {
    	List<Square> squares = ringlet.getSquares();
    	shSquare0.setRotate(squares.get(0).getRotation());
    	shSquare1.setRotate(squares.get(1).getRotation());
    	shSquare2.setRotate(squares.get(2).getRotation());
    	shSquare3.setRotate(squares.get(3).getRotation());
    }

    /**
     * Name: goBack
     * Method used to go back to the start menu. <br>
     * @param event - event representing going back to the start menu - event = ActionEvent
    */
    @FXML
    public void goBack(ActionEvent event) {
        ringlet.setSpin(true);
        new RingletThread(ringlet, this).start();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("Dealer S.A.S.");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: goBackVehiclesMod
     * Method used to go back to the vehicles module. <br>
     * @param event - event representing going back to the vehicles module - event = ActionEvent
    */
    @FXML
    public void goBackVehiclesMod(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vehicles-mod.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("VEHICLES MODULE");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: goBackVehicleKind
     * Method used to go back to the scene where the kind of vehicle to add is chosen. <br>
     * @param event - event representing going back to the scene where the kind of vehicle to add is chosen - event = ActionEvent
    */
    @FXML
    public void goBackVehicleKind(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vehicle-kind.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent vehicleKind = fxmlLoader.load();
            primaryStage.setTitle("Kind of vehicle");
            primaryStage.setScene(new Scene(vehicleKind));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: goBackEmployeesMod
     * Method used to go back to the employees module. <br>
     * @param event - event representing going back to the employees module - event = ActionEvent
    */
    @FXML
    public void goBackEmployeesMod(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employees-mod.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent employeesMod = fxmlLoader.load();
            primaryStage.setTitle("EMPLOYEES MODULE");
            primaryStage.setScene(new Scene(employeesMod));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: goBackClientsMod
     * Method used to go back to the clients module. <br>
     * @param event - event representing going back to the clients module - event = ActionEvent
    */
    @FXML
    public void goBackClientsMod(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clients-mod.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent clientsMod = fxmlLoader.load();
            primaryStage.setTitle("CLIENTS MODULE");
            primaryStage.setScene(new Scene(clientsMod));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: goBackHeadquartersMod
     * Method used to go back to the headquarters module. <br>
     * @param event - event representing going back to the headquarters module - event = ActionEvent
    */
    @FXML
    public void goBackHeadquartersMod(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("headquarters-mod.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent headquartersMod = fxmlLoader.load();
            primaryStage.setTitle("HEADQUARTERS MODULE");
            primaryStage.setScene(new Scene(headquartersMod));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: goBackPersistenceMod
     * Method used to go back to the persistence module. <br>
     * @param event - event representing going back to the persistence module - event = ActionEvent
    */
    @FXML
    public void goBackPersistenceMod(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("persistence-mod.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent persistenceMod = fxmlLoader.load();
            primaryStage.setTitle("PERSISTENCE MODULE");
            primaryStage.setScene(new Scene(persistenceMod));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: loadVehiclesMod
     * Method used to load the vehicles module. <br>
     * @param event - event representing loading the vehicles module - event = ActionEvent
    */
    @FXML
    public void loadVehiclesMod(ActionEvent event) {
        ringlet.setSpin(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vehicles-mod.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent vehicleMod = fxmlLoader.load();
            primaryStage.setTitle("VEHICLE MODULE");
            primaryStage.setScene(new Scene(vehicleMod));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: addVehicle
     * Method used to load the vehicles adding function. <br>
     * @param event - event representing loading the vehicles adding function - event = ActionEvent
    */
    @FXML
    public void addVehicle(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vehicle-kind.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent vehicleKind = fxmlLoader.load();
            primaryStage.setTitle("Kind of vehicle");
            primaryStage.setScene(new Scene(vehicleKind));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: loadGasolineAdding
     * Method used to load the gasoline car adding function. <br>
     * @param event - event representing loading the gasoline car adding function - event = ActionEvent
    */
    @FXML
    public void loadGasolineAdding(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gasoline-data.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent gasolineData = fxmlLoader.load();
            primaryStage.setTitle("Adding process of a Gasoline Car");
            primaryStage.setScene(new Scene(gasolineData));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: addVehicleGasoline
     * Method used to add a gasoline car. <br>
     * @param event - event representing adding a gasoline car - event = ActionEvent
    */
    @FXML
    public void addVehicleGasoline(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = dealer.addVehicle(txtBrand.getText(), Integer.parseInt(txtModel.getText()),
                    Double.parseDouble(txtCylinder.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Double.parseDouble(txtMileage.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("New car") ? Vehicle.TYPE_VEHICLE_NEW
                            : Vehicle.TYPE_VEHICLE_USED),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtLicensePlate.getText()
                            : ""),
                    0, Double.parseDouble(txtBasePrice.getText()),
                    (((RadioButton) toggleGroupCarType.getSelectedToggle()).getText().equals("Sedan") ? Car.TYPE_CAR_SEDAN : Car.TYPE_CAR_VAN),
                    Integer.parseInt(txtNumDoors.getText()), (cbPolarizedWindows.getOnAction() != null ? true : false),
                    Double.parseDouble(txtCapacityGasoline.getText()),
                    (((RadioButton) toggleGroupGasolineType.getSelectedToggle()).getText().equals("Extra") ? Gasoline.TYPE_GASOLINE_EXTRA
                            : ((RadioButton) toggleGroupGasolineType.getSelectedToggle()).getText().equals("Ordinary")
                                    ? Gasoline.TYPE_GASOLINE_ORDINARY
                                    : Gasoline.TYPE_GASOLINE_DIESEL),
                    0, Double.parseDouble(txtPriceSoat.getText()), Double.parseDouble(txtPriceMTR.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Integer.parseInt(txtYearSoat.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Integer.parseInt(txtYearMTR.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtCodeSoat.getText()
                            : ""),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtCodeMTR.getText()
                            : ""),
                    Double.parseDouble(txtCoverageAmountSoat.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Double.parseDouble(txtGasLevelMTR.getText())
                            : 0));
            alertInfo.setTitle("Vehicle adding process");
            alertInfo.setContentText(message);
            alertInfo.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
            fxmlLoader.setController(this);
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("Dealer S.A.S.");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
        } catch (NumberFormatException ime) {
            alertWarning.setTitle("Invalid number format");
            alertWarning.setContentText("Invalid number format in a text field.");
            alertWarning.showAndWait();
        } catch (InputMismatchException ime) {
            alertWarning.setTitle("Invalid input");
            alertWarning.setContentText("Invalid input format in a text field.");
            alertWarning.showAndWait();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (LackOfLandException lole) {
            alertWarning.setTitle("Lack Of Land Exception");
            alertWarning.setContentText(lole.getMessage());
            alertWarning.showAndWait();
        }
    }

    /**
     * Name: loadElectricAdding
     * Method used to load the electric car function. <br>
     * @param event - event representing loading the electric car function - event = ActionEvent
    */
    @FXML
    public void loadElectricAdding(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("electric-data.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent electricData = fxmlLoader.load();
            primaryStage.setTitle("Adding process of an Electric Car");
            primaryStage.setScene(new Scene(electricData));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: addVehicleElectric
     * Method used to add an electric car. <br>
     * @param event - event representing adding an electric car - event = ActionEvent
    */
    @FXML
    public void addVehicleElectric(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = dealer.addVehicle(txtBrand.getText(), Integer.parseInt(txtModel.getText()),
                    Double.parseDouble(txtCylinder.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Double.parseDouble(txtMileage.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("New car") ? Vehicle.TYPE_VEHICLE_NEW
                            : Vehicle.TYPE_VEHICLE_USED),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtLicensePlate.getText()
                            : ""),
                    0, Double.parseDouble(txtBasePrice.getText()),
                    (((RadioButton) toggleGroupCarType.getSelectedToggle()).getText().equals("Sedan") ? Car.TYPE_CAR_SEDAN : Car.TYPE_CAR_VAN),
                    Integer.parseInt(txtNumDoors.getText()), (cbPolarizedWindows.getOnAction() != null ? true : false),
                    (((RadioButton) toggleGroupTypeCharger.getSelectedToggle()).getText().equals("Fast") ? Electric.TYPE_CHARGER_FAST : Vehicle.TYPE_VEHICLE_NEW),
                    Double.parseDouble(txtDurationBattery.getText()), 0, Double.parseDouble(txtPriceSoat.getText()),
                    Double.parseDouble(txtPriceMTR.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Integer.parseInt(txtYearSoat.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Integer.parseInt(txtYearMTR.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtCodeSoat.getText()
                            : ""),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtCodeMTR.getText()
                            : ""),
                    Double.parseDouble(txtCoverageAmountSoat.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Double.parseDouble(txtGasLevelMTR.getText())
                            : 0));
            alertInfo.setTitle("Vehicle adding process");
            alertInfo.setContentText(message);
            alertInfo.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
            fxmlLoader.setController(this);
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("Dealer S.A.S.");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
        } catch (NumberFormatException ime) {
            alertWarning.setTitle("Invalid number format");
            alertWarning.setContentText("Invalid number format in a text field.");
            alertWarning.showAndWait();
        } catch (InputMismatchException ime) {
            alertWarning.setTitle("Invalid input");
            alertWarning.setContentText("Invalid input format in a text field.");
            alertWarning.showAndWait();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (LackOfLandException lole) {
            alertWarning.setTitle("Lack Of Land Exception");
            alertWarning.setContentText(lole.getMessage());
            alertWarning.showAndWait();
        }
    }

    /**
     * Name: loadHybridAdding
     * Method used to load the electric car function. <br>
     * @param event - event representing loading the electric car function - event = ActionEvent
    */
    @FXML
    public void loadHybridAdding(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hybrid-data.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent hybridData = fxmlLoader.load();
            primaryStage.setTitle("Adding process of an Hybrid Car");
            primaryStage.setScene(new Scene(hybridData));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: addVehicleHybrid
     * Method used to add a hybrid car. <br>
     * @param event - event representing adding a hybrid car - event = ActionEvent
    */
    @FXML
    public void addVehicleHybrid(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = dealer.addVehicle(txtBrand.getText(), Integer.parseInt(txtModel.getText()),
                    Double.parseDouble(txtCylinder.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Double.parseDouble(txtMileage.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("New car") ? Vehicle.TYPE_VEHICLE_NEW
                            : Vehicle.TYPE_VEHICLE_USED),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtLicensePlate.getText()
                            : ""),
                    0, Double.parseDouble(txtBasePrice.getText()),
                    (((RadioButton) toggleGroupCarType.getSelectedToggle()).getText().equals("Sedan") ? Car.TYPE_CAR_SEDAN : Car.TYPE_CAR_VAN),
                    Integer.parseInt(txtNumDoors.getText()), (cbPolarizedWindows.getOnAction() != null ? true : false),
                    Double.parseDouble(txtCapacityGasoline.getText()),
                    (((RadioButton) toggleGroupGasolineType.getSelectedToggle()).getText().equals("Extra") ? Hybrid.TYPE_GASOLINE_EXTRA
                            : ((RadioButton) toggleGroupGasolineType.getSelectedToggle()).getText().equals("Ordinary")
                                    ? Hybrid.TYPE_GASOLINE_ORDINARY
                                    : Hybrid.TYPE_GASOLINE_DIESEL),
                    0,
                    (((RadioButton) toggleGroupTypeCharger.getSelectedToggle()).getText().equals("Fast") ? Electric.TYPE_CHARGER_FAST : Vehicle.TYPE_VEHICLE_NEW),
                    Double.parseDouble(txtDurationBattery.getText()), 0, Double.parseDouble(txtPriceSoat.getText()),
                    Double.parseDouble(txtPriceMTR.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Integer.parseInt(txtYearSoat.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Integer.parseInt(txtYearMTR.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtCodeSoat.getText()
                            : ""),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtCodeMTR.getText()
                            : ""),
                    Double.parseDouble(txtCoverageAmountSoat.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? Double.parseDouble(txtGasLevelMTR.getText())
                            : 0));
            alertInfo.setTitle("Vehicle adding process");
            alertInfo.setContentText(message);
            alertInfo.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
            fxmlLoader.setController(this);
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("Dealer S.A.S.");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
        } catch (NumberFormatException ime) {
            alertWarning.setTitle("Invalid number format");
            alertWarning.setContentText("Invalid number format in a text field.");
            alertWarning.showAndWait();
        } catch (InputMismatchException ime) {
            alertWarning.setTitle("Invalid input");
            alertWarning.setContentText("Invalid input format in a text field.");
            alertWarning.showAndWait();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (LackOfLandException lole) {
            alertWarning.setTitle("Lack Of Land Exception");
            alertWarning.setContentText(lole.getMessage());
            alertWarning.showAndWait();
        }
    }

    /**
     * Name: loadMotorcycleAdding
     * Method used to load the hybrid car function. <br>
     * @param event - event representing loading the hybrid car function - event = ActionEvent
    */
    @FXML
    public void loadMotorcycleAdding(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("motorcycle-data.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent motorcycleData = fxmlLoader.load();
            primaryStage.setTitle("Adding process of a Motorcycle");
            primaryStage.setScene(new Scene(motorcycleData));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: addVehicleMotorcycle
     * Method used to add a motorcycle. <br>
     * @param event - event representing adding a motorcycle - event = ActionEvent
    */
    @FXML
    public void addVehicleMotorcycle(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = dealer.addVehicle(txtBrand.getText(), Integer.parseInt(txtModel.getText()),
                    Double.parseDouble(txtCylinder.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used motorcycle")
                            ? Double.parseDouble(txtMileage.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("New motorcycle") ? Vehicle.TYPE_VEHICLE_NEW
                            : Vehicle.TYPE_VEHICLE_USED),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used motorcycle")
                            ? txtLicensePlate.getText()
                            : ""),
                    0, Double.parseDouble(txtBasePrice.getText()),
                    (((RadioButton) toggleGroupTypeMoto.getSelectedToggle()).getText().equals("Standard") ? Motorcycle.TYPE_MOTO_STANDARD
                            : ((RadioButton) toggleGroupTypeMoto.getSelectedToggle()).getText().equals("Sporty") ? Motorcycle.TYPE_MOTO_SPORTY
                                    : ((RadioButton) toggleGroupTypeMoto.getSelectedToggle()).getText()
                                            .equals("Scooter") ? Motorcycle.TYPE_MOTO_SCOOTER : Motorcycle.TYPE_MOTO_CROSS),
                    Double.parseDouble(txtCapacityGasoline.getText()), 0, Double.parseDouble(txtPriceSoat.getText()),
                    Double.parseDouble(txtPriceMTR.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used motorcycle")
                            ? Integer.parseInt(txtYearSoat.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used motorcycle")
                            ? Integer.parseInt(txtYearMTR.getText())
                            : 0),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used motorcycle")
                            ? txtCodeSoat.getText()
                            : ""),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used motorcycle")
                            ? txtCodeMTR.getText()
                            : ""),
                    Double.parseDouble(txtCoverageAmountSoat.getText()),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used motorcycle")
                            ? Double.parseDouble(txtGasLevelMTR.getText())
                            : 0));
            alertInfo.setTitle("Vehicle adding process");
            alertInfo.setContentText(message);
            alertInfo.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
            fxmlLoader.setController(this);
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("Dealer S.A.S.");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
        } catch (NumberFormatException ime) {
            alertWarning.setTitle("Invalid number format");
            alertWarning.setContentText("Invalid number format in a text field.");
            alertWarning.showAndWait();
        } catch (InputMismatchException ime) {
            alertWarning.setTitle("Invalid input");
            alertWarning.setContentText("Invalid input format in a text field.");
            alertWarning.showAndWait();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: loadSellVehicle
     * Method used to load the selling vehicle function. <br>
     * @param event - event representing loading the selling vehicle function - event = ActionEvent
    */
    @FXML
    public void loadSellVehicle(ActionEvent event) {
        if (dealer.getPeople().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("People list empty");
            alertInfo.setContentText("There are no people registered in the system to begin a vehicle selling process.");
            alertInfo.showAndWait();
        } else if (dealer.getVehicles().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("Vehicles list empty");
            alertInfo.setContentText("There are no vehicles registered in the system to begin a vehicle selling process.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sell-vehicle.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent sellVehicle = fxmlLoader.load();
                primaryStage.setTitle("Selling process of a vehicle");
                primaryStage.setScene(new Scene(sellVehicle));
                primaryStage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: sellVehicle
     * Method used to sell a vehicle. <br>
     * @param event - event representing selling a vehicle - event = ActionEvent
    */
    @FXML
    public void sellVehicle(ActionEvent event) {
        RadioButton rbVehicleType = (RadioButton) toggleGroupVehicleType.getSelectedToggle();
        RadioButton rbVehicleKind = (RadioButton) toggleGroupVehicleKind.getSelectedToggle();
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        alertInfo.setHeaderText(null);
        alertInfo.setTitle("Vehicle selling process");
		try {
            String message = dealer.sellAVehicle((rbVehicleType.getText().equals("Used") ? txtLicensePlate.getText() : ""), txtIdEmployeeAssigning.getText(), txtIdClientAssigning.getText(), (rbVehicleKind.getText().equals("Gasoline car") ? 1 : rbVehicleKind.getText().equals("Electric car") ? 2 : rbVehicleKind.getText().equals("Hybrid car") ? 3 : 4), (rbVehicleType.getText().equals("Used") ? Vehicle.TYPE_VEHICLE_USED : Vehicle.TYPE_VEHICLE_NEW), (rbVehicleType.getText().equals("New") ? txtBrand.getText() : ""), (rbVehicleType.getText().equals("New") ? Integer.parseInt(txtModel.getText()) : 0), (rbVehicleType.getText().equals("New") ? Double.parseDouble(txtCylinder.getText()) : 0), txtNumPhone.getText());
            alertInfo.setContentText(message);
            alertInfo.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
            fxmlLoader.setController(this);
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("Dealer S.A.S.");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
		} catch (NumberFormatException nfe) {
            Alert alertWarning = new Alert(AlertType.WARNING);
            alertWarning.setHeaderText(null);
			alertWarning.setTitle("Invalid number format");
            alertWarning.setContentText("Invalid number format in a text field.");
            alertWarning.showAndWait();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
    }

    /**
     * Name: loadShowCatalog
     * Method used to load the showing vehicle catalog function. <br>
     * @param event - event representing loading the showing vehicle catalog function - event = ActionEvent
    */
    @FXML
    public void loadShowCatalog(ActionEvent event) {
        if (dealer.getVehicles().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("Vehicles list empty");
            alertInfo.setContentText("There are no vehicles registered in the system to create a catalog.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("catalog-vehicle-kind.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent catalogVehicleKind = fxmlLoader.load();
                primaryStage.setTitle("VEHICLE KIND IN CATALOG");
                primaryStage.setScene(new Scene(catalogVehicleKind));
                primaryStage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: showCatalog
     * Method used to show the vehicle catalog. <br>
     * @param event - event representing showing the vehicle catalog - event = ActionEvent
    */
    @FXML
    public void showCatalog(ActionEvent event) {
        RadioButton rb = (RadioButton) toggleGroupVehicleType.getSelectedToggle();
        if (((RadioButton) toggleGroupVehicleKind.getSelectedToggle()).getText().equals("Gasoline cars")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("gasolineCars-list.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent gasolineCarsList = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("GASOLINE CARS CATALOG");
                stage.setScene(new Scene(gasolineCarsList));
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            ObservableList<Gasoline> observableList = FXCollections.observableArrayList(dealer
                    .showCarsGasoline(rb.getText().equals("Used") ? Vehicle.TYPE_VEHICLE_USED : rb.getText().equals("New") ? Vehicle.TYPE_VEHICLE_NEW : 'B'));
            tvGasolineCarsList.setItems(observableList);
            tcBrand.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("brand"));
            tcModel.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("model"));
            tcVehicleType.setCellValueFactory(new PropertyValueFactory<Vehicle, Character>("typeVehicle"));
            tcBasePrice.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("basePrice"));
            tcLicensePlate.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("licensePlate"));
            tcCylinder.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("cylinder"));
            tcMileage.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("mileage"));
            tcOwner.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("ownerID"));
            tcCarType.setCellValueFactory(new PropertyValueFactory<Car, Character>("typeCar"));
            tcDoorsNumber.setCellValueFactory(new PropertyValueFactory<Car, Integer>("numDoors"));
            tcPolarizedWindows.setCellValueFactory(new PropertyValueFactory<Car, Boolean>("polarizedWindows"));
            tcGasolineTypeCarGasoline
                    .setCellValueFactory(new PropertyValueFactory<Gasoline, Character>("typeGasoline"));
            tcGasolineCapacityCarGasoline
                    .setCellValueFactory(new PropertyValueFactory<Gasoline, Double>("capacityGasoline"));
            tcGasolineConsumeCarGasoline
                    .setCellValueFactory(new PropertyValueFactory<Gasoline, Double>("consumeGasoline"));
            tcTotalSellingPriceCarGasoline
                    .setCellValueFactory(new PropertyValueFactory<Gasoline, Double>("totalPrice"));
        } else if (((RadioButton) toggleGroupVehicleKind.getSelectedToggle()).getText()
                .equals("Electric cars")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("electricCars-list.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent electricCarsList = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("ELECTRIC CARS CATALOG");
                stage.setScene(new Scene(electricCarsList));
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            ObservableList<Electric> observableList = FXCollections.observableArrayList(dealer
                    .showCarsElectric(rb.getText().equals("Used") ? Vehicle.TYPE_VEHICLE_USED : rb.getText().equals("New") ? Vehicle.TYPE_VEHICLE_NEW : 'B'));
            tvElectricCarsList.setItems(observableList);
            tcBrand.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("brand"));
            tcModel.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("model"));
            tcVehicleType.setCellValueFactory(new PropertyValueFactory<Vehicle, Character>("typeVehicle"));
            tcBasePrice.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("basePrice"));
            tcLicensePlate.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("licensePlate"));
            tcCylinder.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("cylinder"));
            tcMileage.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("mileage"));
            tcOwner.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("ownerID"));
            tcCarType.setCellValueFactory(new PropertyValueFactory<Car, Character>("typeCar"));
            tcDoorsNumber.setCellValueFactory(new PropertyValueFactory<Car, Integer>("numDoors"));
            tcPolarizedWindows.setCellValueFactory(new PropertyValueFactory<Car, Boolean>("polarizedWindows"));
            tcChargerTypeCarElectric.setCellValueFactory(new PropertyValueFactory<Electric, Character>("typeCharger"));
            tcBatteryDurationCarElectric
                    .setCellValueFactory(new PropertyValueFactory<Electric, Double>("durationBattery"));
            tcBatteryConsumeCarElectric
                    .setCellValueFactory(new PropertyValueFactory<Electric, Double>("consumeBattery"));
            tcTotalSellingPriceCarElectric
                    .setCellValueFactory(new PropertyValueFactory<Electric, Double>("totalPrice"));
        } else if (((RadioButton) toggleGroupVehicleKind.getSelectedToggle()).getText().equals("Hybrid cars")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hybridCars-list.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent hybridCarsList = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("HYBRID CARS CATALOG");
                stage.setScene(new Scene(hybridCarsList));
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            ObservableList<Hybrid> observableList = FXCollections.observableArrayList(dealer.showCarsHybrid(rb.getText().equals("Used") ? Vehicle.TYPE_VEHICLE_USED : rb.getText().equals("New") ? Vehicle.TYPE_VEHICLE_NEW : 'B'));
            tvHybridCarsList.setItems(observableList);
            tcBrand.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("brand"));
            tcModel.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("model"));
            tcVehicleType.setCellValueFactory(new PropertyValueFactory<Vehicle, Character>("typeVehicle"));
            tcBasePrice.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("basePrice"));
            tcLicensePlate.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("licensePlate"));
            tcCylinder.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("cylinder"));
            tcMileage.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("mileage"));
            tcOwner.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("ownerID"));
            tcCarType.setCellValueFactory(new PropertyValueFactory<Car, Character>("typeCar"));
            tcDoorsNumber.setCellValueFactory(new PropertyValueFactory<Car, Integer>("numDoors"));
            tcPolarizedWindows.setCellValueFactory(new PropertyValueFactory<Car, Boolean>("polarizedWindows"));
            tcGasolineTypeCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Character>("typeGasoline"));
            tcGasolineCapacityCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Double>("capacityGasoline"));
            tcGasolineConsumeCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Double>("consumeGasoline"));
            tcChargerTypeCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Character>("typeCharger"));
            tcBatteryDurationCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Double>("durationBattery"));
            tcBatteryConsumeCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Double>("consumeBattery"));
            tcTotalSellingPriceCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Double>("totalPrice"));
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("motorcycles-list.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent motorcyclesList = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("MOTORCYCLES CATALOG");
                stage.setScene(new Scene(motorcyclesList));
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            ObservableList<Motorcycle> observableList = FXCollections.observableArrayList(
                    dealer.showMotorcycles(rb.getText().equals("Used") ? Vehicle.TYPE_VEHICLE_USED : rb.getText().equals("New") ? Vehicle.TYPE_VEHICLE_NEW : 'B'));
            tvMotorcyclesList.setItems(observableList);
            tcBrand.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("brand"));
            tcModel.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("model"));
            tcVehicleType.setCellValueFactory(new PropertyValueFactory<Vehicle, Character>("typeVehicle"));
            tcBasePrice.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("basePrice"));
            tcLicensePlate.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("licensePlate"));
            tcCylinder.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("cylinder"));
            tcMileage.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("mileage"));
            tcOwner.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("ownerID"));
            tcMotorcycleType.setCellValueFactory(new PropertyValueFactory<Motorcycle, Character>("typeMoto"));
            tcGasolineCapacityMotorcycle
                    .setCellValueFactory(new PropertyValueFactory<Motorcycle, Double>("capacityGasoline"));
            tcGasolineConsumeMotorcycle
                    .setCellValueFactory(new PropertyValueFactory<Motorcycle, Double>("consumeGasoline"));
            tcTotalSellingPriceMotorcycle
                    .setCellValueFactory(new PropertyValueFactory<Motorcycle, Double>("totalPrice"));
        }
    }

    /**
     * Name: loadRemoveVehicle
     * Method used to load the removing vehicle function. <br>
     * @param event - event representing loading the removing vehicle function - event = ActionEvent
    */
    @FXML
    public void loadRemoveVehicle(ActionEvent event) {
        if (dealer.getVehicles().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("Vehicles list empty");
            alertInfo.setContentText("There are no vehicles registered in the system to remove one.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-vehicle.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent removeVehicle = fxmlLoader.load();
                primaryStage.setTitle("Removing process of a vehicle");
                primaryStage.setScene(new Scene(removeVehicle));
                primaryStage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: removeVehicle
     * Method used to remove a vehicle. <br>
     * @param event - event representing removing a vehicle - event = ActionEvent
    */
    @FXML
    public void removeVehicle(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        alertInfo.setHeaderText(null);
        alertInfo.setTitle("Vehicle removing process");
        try {
            if (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used vehicle"))
                alertInfo.setContentText(dealer.removeVehicleWithLicensePlate(txtLicensePlate.getText()));
            else {
                alertInfo.setContentText(dealer.removeVehicleWithoutLicensePlate(txtBrand.getText(), Integer.parseInt(txtModel.getText()), Double.parseDouble(txtCylinder.getText())));
            }
            alertInfo.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
            fxmlLoader.setController(this);
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("Dealer S.A.S.");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: loadEmployeesMod
     * Method used to load the employees module. <br>
     * @param event - event representing loading the employees module - event = ActionEvent
    */
    @FXML
    public void loadEmployeesMod(ActionEvent event) {
        ringlet.setSpin(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employees-mod.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent employeesMod = fxmlLoader.load();
            primaryStage.setTitle("EMPLOYEES MODULE");
            primaryStage.setScene(new Scene(employeesMod));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: registerEmployee
     * Method used to load the registering employee function. <br>
     * @param event - event representing load the registering employee function - event = ActionEvent
    */
    @FXML
    public void registerEmployee(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employee-data.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent employeeData = fxmlLoader.load();
            primaryStage.setTitle("Adding process of an employee");
            primaryStage.setScene(new Scene(employeeData));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: addEmployee
     * Method used to add an employee. <br>
     * @param event - event representing adding an employee - event = ActionEvent
    */
    @FXML
    public void addEmployee(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = dealer.addEmployee(txtNamePerson.getText(), txtLastName.getText(), txtID.getText(), 0);
            alertInfo.setTitle("Employee adding process");
            alertInfo.setContentText(message);
            alertInfo.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
            fxmlLoader.setController(this);
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("Dealer S.A.S.");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
        } catch (NumberFormatException ime) {
            alertWarning.setTitle("Invalid number format");
            alertWarning.setContentText("Invalid number format in a text field.");
            alertWarning.showAndWait();
        } catch (InputMismatchException ime) {
            alertWarning.setTitle("Invalid input");
            alertWarning.setContentText("Invalid input format in a text field.");
            alertWarning.showAndWait();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: loadAssignClient
     * Method used to load the assigning of a client to an employee function. <br>
     * @param event - event representing loading the assigning of a client to an employee function - event = ActionEvent
    */
    @FXML
    public void loadAssignClient(ActionEvent event) {
        if (dealer.getPeople().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("People list empty");
            alertInfo.setContentText("There are no people registered in the system to assign a client to an employee.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("client-to-employee.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent assignClient = fxmlLoader.load();
                primaryStage.setTitle("Assigning of a client to an employee");
                primaryStage.setScene(new Scene(assignClient));
                primaryStage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: assignClient
     * Method used to assign a client to an employee. <br>
     * @param event - event representing assigning a client to an employee - event = ActionEvent
    */
    @FXML
    public void assignClient(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            alertInfo.setTitle("Assigning process of a client");
            String message = dealer.toAssignClient(txtIdClientAssigning.getText(), txtIdEmployeeAssigning.getText(), txtClientPhoneAssigning.getText());
            alertInfo.setContentText(message);
            alertInfo.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
            fxmlLoader.setController(this);
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("Dealer S.A.S.");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
        } catch (NumberFormatException ime) {
            alertWarning.setTitle("Invalid number format");
            alertWarning.setContentText("Invalid number format in a text field.");
            alertWarning.showAndWait();
        } catch (InputMismatchException ime) {
            alertWarning.setTitle("Invalid input");
            alertWarning.setContentText("Invalid input format in a text field.");
            alertWarning.showAndWait();
        } catch (WorkloadException we) {
            alertWarning.setTitle("Workload Exception");
            alertWarning.setContentText(we.getMessage());
            alertWarning.showAndWait();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: loadSearchEmployeeFastly
     * Method used to load the searching employee fastly function. <br>
     * @param event - event representing loading the searching employee fastly function - event = ActionEvent
    */
    @FXML
    public void loadSearchEmployeeFastly(ActionEvent event) {
        if (dealer.getPeople().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("People list empty");
            alertInfo.setContentText("There are no people registered in the system to search one of type Employee.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search-employee.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent searchEmployee = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Efficient employee search process");
                stage.setScene(new Scene(searchEmployee));
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: searchEmployeeFastly
     * Method used to search an employee fastly. <br>
     * @param event - event representing searching an employee fastly - event = ActionEvent
    */
    @FXML
    public void searchEmployeeFastly(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        alertInfo.setHeaderText(null);
        alertInfo.setTitle("Efficient employee search process");
        alertInfo.setContentText(dealer.binarySearchEmployeeID(txtID.getText()));
        alertInfo.showAndWait();
    }

    /**
     * Name: showEmployeesByLastNameAndName
     * Method used to show all the employees registered in the system, sorted in ascending order by their last names (or, if same ones, by their names), invoking the showEmployeesByLastNameAndName() method of the Company class. <br>
     * @param event - event representing showing all the employees registered in the system - event = ActionEvent
    */
    @FXML
    public void showEmployeesByLastNameAndName(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employees-list.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent employeesList = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("EMPLOYEES CATALOG");
            stage.setScene(new Scene(employeesList));
            stage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        ObservableList<Employee> observableList = FXCollections
                .observableArrayList(dealer.showEmployeesByLastNameAndName());
        tvEmployeesList.setItems(observableList);
        tcLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        tcName.setCellValueFactory(new PropertyValueFactory<Person, String>("namePerson"));
        tcID.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
        tcQuantTotalSales.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("quantTotalSales"));
    }

    /**
     * Name: showEmployeesByTotalSalesAndID
     * Method used to show all the employees registered in the system, sorted in descending order by their total sales (or, if same ones, by ID's), invoking the showEmployeesByTotalSalesAndID() method of the Company class. <br>
     * @param event - event representing showing all the employees registered in the system - event = ActionEvent
    */
    @FXML
    public void showEmployeesByTotalSalesAndID(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employees-list.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent employeesList = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("EMPLOYEES CATALOG");
            stage.setScene(new Scene(employeesList));
            stage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        ObservableList<Employee> observableList = FXCollections
                .observableArrayList(dealer.showEmployeesByTotalSalesAndID());
        tvEmployeesList.setItems(observableList);
        tcLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        tcName.setCellValueFactory(new PropertyValueFactory<Person, String>("namePerson"));
        tcID.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
        tcQuantTotalSales.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("quantTotalSales"));
    }

    /**
     * Name: loadRemoveEmployee
     * Method used to load the removing employee function. <br>
     * @param event - event representing loading the removing employee function - event = ActionEvent
    */
    @FXML
    public void loadRemoveEmployee(ActionEvent event) {
        if (dealer.getPeople().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("People list empty");
            alertInfo.setContentText("There are no people registered in the system to remove one of type Employee.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-employee.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent removeEmployee = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Removing process of an employee");
                stage.setScene(new Scene(removeEmployee));
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: loadRemoveEmployee
     * Method used to remove an employee. <br>
     * @param event - event representing removing an employee - event = ActionEvent
    */
    @FXML
    public void removeEmployee(ActionEvent event) {
        try {
            if (dealer.removePerson(txtID.getText())) {
                Alert alertInfo = new Alert(AlertType.INFORMATION);
                alertInfo.setHeaderText(null);
                alertInfo.setTitle("Employee removed");
                alertInfo.setContentText("The employee with ID " + txtID.getText() + " has been successfully removed from the system.");
                alertInfo.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employees-mod.fxml"));
                fxmlLoader.setController(this);
                Parent employeesMod = fxmlLoader.load();
                primaryStage.setTitle("EMPLOYEES MODULE");
                primaryStage.setScene(new Scene(employeesMod));
                primaryStage.show();
            } else {
                Alert alertWarning = new Alert(AlertType.WARNING);
                alertWarning.setHeaderText(null);
                alertWarning.setTitle("Removing process interrupted");
                alertWarning.setContentText("This employee is not registered in the system.");
                alertWarning.showAndWait();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: loadClientsMod
     * Method used to load the clients module. <br>
     * @param event - event representing loading the clients module - event = ActionEvent
    */
    @FXML
    public void loadClientsMod(ActionEvent event) {
        ringlet.setSpin(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clients-mod.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent clientsMod = fxmlLoader.load();
            primaryStage.setTitle("CLIENTS MODULE");
            primaryStage.setScene(new Scene(clientsMod));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: registerClient
     * Method used to load the registering client function. <br>
     * @param event - event representing loading the registering client function - event = ActionEvent
    */
    @FXML
    public void registerClient(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("client-data.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent clientData = fxmlLoader.load();
            primaryStage.setTitle("Adding process of a client");
            primaryStage.setScene(new Scene(clientData));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: addClient
     * Method used to add a client. <br>
     * @param event - event representing adding a client - event = ActionEvent
    */
    @FXML
    public void addClient(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = dealer.addClient(txtNamePerson.getText(), txtLastName.getText(), txtID.getText(), txtNumPhone.getText(), txtEmail.getText(), false, false);
            alertInfo.setTitle("Client adding process");
            alertInfo.setContentText(message);
            alertInfo.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
            fxmlLoader.setController(this);
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("Dealer S.A.S.");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
        } catch (NumberFormatException ime) {
            alertWarning.setTitle("Invalid number format");
            alertWarning.setContentText("Invalid number format in a text field.");
            alertWarning.showAndWait();
        } catch (InputMismatchException ime) {
            alertWarning.setTitle("Invalid input");
            alertWarning.setContentText("Invalid input format in a text field.");
            alertWarning.showAndWait();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: loadAssignVehicle
     * Method used to load the assigning vehicle of interest to a client function. <br>
     * @param event - event representing loading the assigning vehicle of interest to a client function - event = ActionEvent
    */
    @FXML
    public void loadAssignVehicle(ActionEvent event) {
        if (dealer.getPeople().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("People list empty");
            alertInfo.setContentText("There are no people registered in the system to assign a vehicle to a client.");
            alertInfo.showAndWait();
        } else if (dealer.getVehicles().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("Vehicles list empty");
            alertInfo.setContentText("There are no vehicles registered in the system to assign one to a client.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vehicle-interest.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent vehicleInterest = fxmlLoader.load();
                primaryStage.setTitle("Assigning of a vehicle of interest");
                primaryStage.setScene(new Scene(vehicleInterest));
                primaryStage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: assignVehicle
     * Method used to assign a vehicle of interest to a client. <br>
     * @param event - event representing assigning a vehicle of interest to a client - event = ActionEvent
    */
    @FXML
    public void assignVehicle(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = "";
            if (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used vehicle"))
                message = dealer.toAssignVehicleUsed(txtID.getText(), txtLicensePlate.getText(),
                        Double.parseDouble(txtCylinder.getText()));
            else if (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("New vehicle")) {
                message = dealer.toAssignVehicleNew(txtID.getText(), txtBrand.getText(),
                        Integer.parseInt(txtModel.getText()), Double.parseDouble(txtCylinder.getText()));
            }
            alertInfo.setTitle("Assigning process of a vehicle of interest");
            alertInfo.setContentText(message);
            alertInfo.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
            fxmlLoader.setController(this);
            Parent startMenu = fxmlLoader.load();
            primaryStage.setTitle("Dealer S.A.S.");
            primaryStage.setScene(new Scene(startMenu));
            primaryStage.show();
        } catch (NumberFormatException ime) {
            alertWarning.setTitle("Invalid number format");
            alertWarning.setContentText("Invalid number format in a text field.");
            alertWarning.showAndWait();
        } catch (InputMismatchException ime) {
            alertWarning.setTitle("Invalid input");
            alertWarning.setContentText("Invalid input format in a text field.");
            alertWarning.showAndWait();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (FavoriteVehicleException fve) {
            alertWarning.setTitle("Favorite Vehicle Exception");
            alertWarning.setContentText(fve.getMessage());
            alertWarning.showAndWait();
        }
    }

    /**
     * Name: loadSearchClientFastly
     * Method used to load the searching client fastly function. <br>
     * @param event - event representing loading the searching client fastly function - event = ActionEvent
    */
    @FXML
    public void loadSearchClientFastly(ActionEvent event) {
        if (dealer.getPeople().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("People list empty");
            alertInfo.setContentText("There are no people registered in the system to search one of type Client.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("search-client.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent searchClient = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Efficient client search process");
                stage.setScene(new Scene(searchClient));
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: searchClientFastly
     * Method used to search a client fastly. <br>
     * @param event - event representing searching a client fastly - event = ActionEvent
    */
    @FXML
    public void searchClientFastly(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        alertInfo.setHeaderText(null);
        alertInfo.setTitle("Efficient employee search process");
        alertInfo.setContentText(dealer.binarySearchClientPhone(txtNumPhone.getText()));
        alertInfo.showAndWait();
    }

    /**
     * Name: showClientsByLastNameAndPhone
     * Method used to show all the clients registered in the system, sorted in descending order by their last names (or, if same ones, by their phone numbers), invoking the showClientsByLastNameAndPhone() method of the Company class. <br>
     * @param event - event representing showing all the clients registered in the system - event = ActionEvent
    */
    @FXML
    public void showClientsByLastNameAndPhone(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clients-list.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent clientsList = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("CLIENTS CATALOG");
            stage.setScene(new Scene(clientsList));
            stage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        ObservableList<Client> observableList = FXCollections.observableArrayList(dealer.showClientsByLastNameAndPhone());
        tvClientsList.setItems(observableList);
        tcLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        tcName.setCellValueFactory(new PropertyValueFactory<Person, String>("namePerson"));
        tcID.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<Client, String>("numPhone"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
        tcActive.setCellValueFactory(new PropertyValueFactory<Client, Boolean>("active"));
        tcHasSeller.setCellValueFactory(new PropertyValueFactory<Client, Boolean>("hasSeller"));
    }

    /**
     * Name: showClientsByNameAndEmail
     * Method used to show all the clients registered in the system, sorted in ascending order by their names (or, if same ones, by their e-mails), invoking the showClientsByNameAndEmail() method of the Company class. <br>
     * @param event - event representing showing all the clients registered in the system - event = ActionEvent
    */
    @FXML
    public void showClientsByNameAndEmail(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clients-list.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent clientsList = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("CLIENTS CATALOG");
            stage.setScene(new Scene(clientsList));
            stage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        ObservableList<Client> observableList = FXCollections.observableArrayList(dealer.showClientsByNameAndEmail());
        tvClientsList.setItems(observableList);
        tcLastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        tcName.setCellValueFactory(new PropertyValueFactory<Person, String>("namePerson"));
        tcID.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<Client, String>("numPhone"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
        tcActive.setCellValueFactory(new PropertyValueFactory<Client, Boolean>("active"));
        tcHasSeller.setCellValueFactory(new PropertyValueFactory<Client, Boolean>("hasSeller"));
    }

    /**
     * Name: loadRemoveClient
     * Method used to load the removing client function. <br>
     * @param event - event representing loading the removing client function - event = ActionEvent
    */
    @FXML
    public void loadRemoveClient(ActionEvent event) {
        if (dealer.getPeople().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("People list empty");
            alertInfo.setContentText("There are no people registered in the system to remove one of type Client.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-client.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent removeClient = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Removing process of a client");
                stage.setScene(new Scene(removeClient));
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: removeClient
     * Method used to remove a client. <br>
     * @param event - event representing removing a client - event = ActionEvent
    */
    @FXML
    public void removeClient(ActionEvent event) {
        try {
            if (dealer.removePerson(txtID.getText())) {
                Alert alertInfo = new Alert(AlertType.INFORMATION);
                alertInfo.setHeaderText(null);
                alertInfo.setTitle("Client removed");
                alertInfo.setContentText("The client with ID " + txtID.getText() + " has been successfully removed from the system.");
                alertInfo.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clients-mod.fxml"));
                fxmlLoader.setController(this);
                Parent clientMod = fxmlLoader.load();
                primaryStage.setTitle("CLIENTS MODULE");
                primaryStage.setScene(new Scene(clientMod));
                primaryStage.show();
            } else {
                Alert alertWarning = new Alert(AlertType.WARNING);
                alertWarning.setHeaderText(null);
                alertWarning.setTitle("Removing process interrupted");
                alertWarning.setContentText("This client is not registered in the system.");
                alertWarning.showAndWait();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: loadHeadquarterMod
     * Method used to load the headquarters module. <br>
     * @param event - event representing loading the headquarters module - event = ActionEvent
    */
    @FXML
    public void loadHeadquarterMod(ActionEvent event) {
        ringlet.setSpin(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("headquarters-mod.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent headquartersMod = fxmlLoader.load();
            primaryStage.setTitle("HEADQUARTERS MODULE");
            primaryStage.setScene(new Scene(headquartersMod));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: loadModelCarsParking
     * Method used to load the choosing model cars in parking function. <br>
     * @param event - event representing loading the choosing model cars in parking function - event = ActionEvent
    */
    @FXML
    public void loadModelCarsParking(ActionEvent event) {
        if (dealer.getVehicles().isEmpty() || Arrays.deepEquals(dealer.getParking(), new Car[Company.PARKING_SIZE_ROWS][Company.PARKING_SIZE_COLUMNS])) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("Empty used old cars parking");
            alertInfo.setContentText("There are no used old cars present in the parking.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("parking-model-cars.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent parkingModelCars = fxmlLoader.load();
                primaryStage.setTitle("Car model choice");
                primaryStage.setScene(new Scene(parkingModelCars));
                primaryStage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: lookParking
     * Method used to look at the used old cars present in the parking. <br>
     * @param event - event representing looking at the used old cars present in the parking - event = ActionEvent
    */
    @FXML
    public void lookParking(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("parkingCars-list.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent gasolineCarsList = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Old used parking cars catalog");
                stage.setScene(new Scene(gasolineCarsList));
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        RadioButton rb = (RadioButton) toggleGroupCarModelParking.getSelectedToggle();
        ObservableList<Car> observableList = FXCollections.observableArrayList(dealer.lookCarsParking(rb.getText().equals("2014") ? 0 : rb.getText().equals("2013") ? 1 : rb.getText().equals("2012") ? 2 : rb.getText().equals("2011") ? 3 : 4));
        tvParkingCarsList.setItems(observableList);
        tcBrand.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("brand"));
        tcModel.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("model"));
        tcVehicleType.setCellValueFactory(new PropertyValueFactory<Vehicle, Character>("typeVehicle"));
        tcBasePrice.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("basePrice"));
        tcLicensePlate.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("licensePlate"));
        tcCylinder.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("cylinder"));
        tcMileage.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("mileage"));
        tcOwner.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("ownerID"));
        tcCarType.setCellValueFactory(new PropertyValueFactory<Car, Character>("typeCar"));
        tcDoorsNumber.setCellValueFactory(new PropertyValueFactory<Car, Integer>("numDoors"));
        tcPolarizedWindows.setCellValueFactory(new PropertyValueFactory<Car, Boolean>("polarizedWindows"));
        tcGasolineTypeCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Character>("typeGasoline"));
        tcGasolineCapacityCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Double>("capacityGasoline"));
        tcGasolineConsumeCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Double>("consumeGasoline"));
        tcChargerTypeCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Character>("typeCharger"));
        tcBatteryDurationCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Double>("durationBattery"));
        tcBatteryConsumeCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Double>("consumeBattery"));
        tcTotalSellingPriceCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Double>("totalPrice"));
    }

    /**
     * Name: loadAddHeadquarter
     * Method used to load the adding headquarter function. <br>
     * @param event - event representing loading the adding headquarter function - event = ActionEvent
    */
    @FXML
    public void loadAddHeadquarter(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("headquarter-data.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent headquarterData = fxmlLoader.load();
            primaryStage.setTitle("Adding process of a headquarter");
            primaryStage.setScene(new Scene(headquarterData));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: addHeadquarter
     * Method used to add a headquarter. <br>
     * @param event - event representing adding a headquarter - event = ActionEvent
    */
    @FXML
    public void addHeadquarter(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        alertInfo.setHeaderText(null);
        alertInfo.setTitle("Headquarter adding process");
        try {
            if (dealer.getHeadquarters().addHeadquarter(txtNameHeadquarter.getText(), txtNIT.getText(), txtAddress.getText(), 0, 0)) {
                alertInfo.setContentText("Headquarter successfully registered.");
                alertInfo.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
                fxmlLoader.setController(this);
                Parent startMenu = fxmlLoader.load();
                primaryStage.setTitle("Dealer S.A.S.");
                primaryStage.setScene(new Scene(startMenu));
                primaryStage.show();
            } else {
                alertInfo.setContentText("A headquarter already exists in the system with that NIT.");
                alertInfo.showAndWait();
            }
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
    }

    /**
     * Name: showHeadquarters
     * Method used to show the list of headquarters. <br>
     * @param event - event representing showing the list of headquarters - event = ActionEvent
    */
    @FXML
    public void showHeadquarters(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("headquarters-list.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent headquartersList = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("HEADQUARTERS CATALOG");
            stage.setScene(new Scene(headquartersList));
            stage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        ObservableList<Headquarter> observableList = FXCollections.observableArrayList(dealer.showHeadquarters());
        tvHeadquartersList.setItems(observableList);
        tcNameHeadquarter.setCellValueFactory(new PropertyValueFactory<Headquarter, String>("name"));
        tcNitHeadquarter.setCellValueFactory(new PropertyValueFactory<Headquarter, String>("nit"));
        tcAddressHeadquarter.setCellValueFactory(new PropertyValueFactory<Headquarter, String>("address"));
        tcNumSalesHeadquarter.setCellValueFactory(new PropertyValueFactory<Headquarter, Integer>("numSales"));
        tcTotalEarningsHeadquarter.setCellValueFactory(new PropertyValueFactory<Headquarter, Integer>("totalEarnings"));
    }

    /**
     * Name: loadRemoveHeadquarter
     * Method used to load the removing headquarter function. <br>
     * @param event - event representing loading the removing headquarter function - event = ActionEvent
    */
    @FXML
    public void loadRemoveHeadquarter(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-headquarter.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent removeHeadquarter = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Removing process of a headquarter");
            stage.setScene(new Scene(removeHeadquarter));
            stage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: removeHeadquarter
     * Method used to remove a headquarter. <br>
     * @param event - event representing removing a headquarter - event = ActionEvent
    */
    @FXML
    public void removeHeadquarter(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        alertInfo.setHeaderText(null);
        alertInfo.setTitle("Headquarter removing process");
        try {
            if (dealer.getHeadquarters().removeHeadquarter(txtNIT.getText())) {
                alertInfo.setContentText("The headquarter with NIT " + txtNIT.getText() + " has been removed from the system.");
                alertInfo.showAndWait();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
                fxmlLoader.setController(this);
                Parent startMenu = fxmlLoader.load();
                primaryStage.setTitle("Dealer S.A.S.");
                primaryStage.setScene(new Scene(startMenu));
                primaryStage.show();
            } else {
                alertInfo.setContentText("This headquarter isn't registered in the system.");
                alertInfo.showAndWait();
            }
        } catch (IOException ioe) {
			ioe.printStackTrace();
		}
    }

    /**
     * Name: loadPersistenceMod
     * Method used to load the persistence module. <br>
     * @param event - event representing loading the persistence module - event = ActionEvent
    */
    @FXML
    public void loadPersistenceMod(ActionEvent event) {
        ringlet.setSpin(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("persistence-mod.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent persistenceMod = fxmlLoader.load();
            primaryStage.setTitle("PERSISTENCE MODULE");
            primaryStage.setScene(new Scene(persistenceMod));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: loadImportData
     * Method used to load the importing data function. <br>
     * @param event - event representing loading the importing data function - event = ActionEvent
    */
    @FXML
    public void loadImportData(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("import-data.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent importData = fxmlLoader.load();
            primaryStage.setTitle("Data importing process");
            primaryStage.setScene(new Scene(importData));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: importData
     * Method used to import data. <br>
     * @param event - event representing importing data - event = ActionEvent
    */
    @FXML
    public void importData(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.WARNING);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        RadioButton rb = (RadioButton) toggleGroupImport.getSelectedToggle();
        try {
            String message = dealer.importData(txtFileName.getText(), rb.getText().equals("Employees") ? 1 : rb.getText().equals("Clients") ? 2 : rb.getText().equals("Gasoline cars") ? 3 : rb.getText().equals("Electric cars") ? 4 : rb.getText().equals("Hybrid cars") ? 5 : 6);
            if (!message.equals("")) {
                alertInfo.setTitle("Import process notice");
                alertInfo.setContentText(message + "\n\nThe eventual rest of the data was successfully imported.");
                alertInfo.showAndWait();
            } else {
                alertInfo.setTitle("Import process done");
                alertInfo.setContentText("Data successfully imported.");
                alertInfo.showAndWait();
            }
		} catch (FileNotFoundException fnfe) {
            alertWarning.setTitle("File Not Found Exception");
            alertWarning.setContentText("The specified file name wasn't found.");
            alertWarning.showAndWait();
		} catch (NumberFormatException nfe) {
            alertWarning.setTitle("Invalid number format");
            alertWarning.setContentText("Invalid number format in a text field.");
            alertWarning.showAndWait();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (LackOfLandException lole) {
            alertWarning.setTitle("Lack Of Land Exception");
            alertWarning.setContentText(lole.getMessage());
            alertWarning.showAndWait();
        }
    }

    /**
     * Name: loadExportVehicles
     * Method used to load the exporting vehicles data function. <br>
     * @param event - event representing loading the exporting vehicles data function - event = ActionEvent
    */
    @FXML
    public void loadExportVehicles(ActionEvent event) {
        if (dealer.getVehicles().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("Vehicles list empty");
            alertInfo.setContentText("There is no vehicles registered in the system to export them.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("export-vehicles.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent exportVehicles = fxmlLoader.load();
                primaryStage.setTitle("Vehicles exporting process");
                primaryStage.setScene(new Scene(exportVehicles));
                primaryStage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Name: exportData
     * Method used to export vehicles data. <br>
     * @param event - event representing exporting vehicles data - event = ActionEvent
    */
    @FXML
    public void exportData(ActionEvent event) {
        RadioButton rb = (RadioButton) toggleGroupVehicleKind.getSelectedToggle();
        try {
			dealer.exportDataVehicles(txtFileName.getText(), txtSeparator.getText(), rb.getText().equals("Gasoline cars") ? 'G' : rb.getText().equals("Electric cars") ? 'E' : rb.getText().equals("Hybrid cars") ? 'H' : 'M');
		} catch (FileNotFoundException fnfe) {
			Alert alertWarning = new Alert(AlertType.WARNING);
            alertWarning.setHeaderText(null);
            alertWarning.setTitle("File Not Found Exception");
            alertWarning.setContentText("The specified file name wasn't found.");
            alertWarning.showAndWait();
		}
    }

    /**
     * Name: exit
     * Method used to terminate the program. <br>
     * @param event - event representing terminating the program - event = ActionEvent
    */
    @FXML
    public void exit(ActionEvent event) {
        ringlet.setSpin(false);
        System.exit(0);
    }
}