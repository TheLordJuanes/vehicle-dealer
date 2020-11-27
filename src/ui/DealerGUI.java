package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
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
import javafx.stage.Stage;
import model.Car;
import model.Client;
import model.Company;
import model.Electric;
import model.Employee;
import model.Gasoline;
import model.Hybrid;
import model.Motorcycle;
import model.Person;
import model.Vehicle;

public class DealerGUI {

    private Stage primaryStage;

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

    private Company dealer;

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

    @FXML
    public void goBack(ActionEvent event) {
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

    @FXML
    public void loadVehiclesMod(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vehicle-mod.fxml"));
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
     * Name: addVehicleGasoline Method used to add a gasoline car. <br>
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
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("New car") ? 'N'
                            : 'U'),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtLicensePlate.getText()
                            : ""),
                    0, Double.parseDouble(txtBasePrice.getText()),
                    (((RadioButton) toggleGroupCarType.getSelectedToggle()).getText().equals("Sedan") ? 'S' : 'V'),
                    Integer.parseInt(txtNumDoors.getText()), (cbPolarizedWindows.getOnAction() != null ? true : false),
                    Double.parseDouble(txtCapacityGasoline.getText()),
                    (((RadioButton) toggleGroupGasolineType.getSelectedToggle()).getText().equals("Extra") ? 'E'
                            : ((RadioButton) toggleGroupGasolineType.getSelectedToggle()).getText().equals("Ordinary")
                                    ? 'O'
                                    : 'D'),
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
            txtBrand.setText("");
            txtModel.setText("");
            txtCylinder.setText("");
            txtMileage.setText("");
            txtLicensePlate.setText("");
            txtBasePrice.setText("");
            txtNumDoors.setText("");
            cbPolarizedWindows.setOnAction(null);
            txtCapacityGasoline.setText("");
            txtPriceSoat.setText("");
            txtPriceMTR.setText("");
            txtYearSoat.setText("");
            txtYearMTR.setText("");
            txtCodeSoat.setText("");
            txtCodeMTR.setText("");
            txtCoverageAmountSoat.setText("");
            txtGasLevelMTR.setText("");
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
            lole.printStackTrace();
        }
    }

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
     * Name: addVehicleElectric Method used to add an electric car. <br>
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
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("New car") ? 'N'
                            : 'U'),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtLicensePlate.getText()
                            : ""),
                    0, Double.parseDouble(txtBasePrice.getText()),
                    (((RadioButton) toggleGroupCarType.getSelectedToggle()).getText().equals("Sedan") ? 'S' : 'V'),
                    Integer.parseInt(txtNumDoors.getText()), (cbPolarizedWindows.getOnAction() != null ? true : false),
                    (((RadioButton) toggleGroupTypeCharger.getSelectedToggle()).getText().equals("Fast") ? 'F' : 'N'),
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
            txtBrand.setText("");
            txtModel.setText("");
            txtCylinder.setText("");
            txtMileage.setText("");
            txtLicensePlate.setText("");
            txtBasePrice.setText("");
            txtNumDoors.setText("");
            cbPolarizedWindows.setOnAction(null);
            txtDurationBattery.setText("");
            txtPriceSoat.setText("");
            txtPriceMTR.setText("");
            txtYearSoat.setText("");
            txtYearMTR.setText("");
            txtCodeSoat.setText("");
            txtCodeMTR.setText("");
            txtCoverageAmountSoat.setText("");
            txtGasLevelMTR.setText("");
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
            lole.printStackTrace();
        }
    }

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
     * Name: addVehicleHybrid Method used to add a hybrid car. <br>
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
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("New car") ? 'N'
                            : 'U'),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used car")
                            ? txtLicensePlate.getText()
                            : ""),
                    0, Double.parseDouble(txtBasePrice.getText()),
                    (((RadioButton) toggleGroupCarType.getSelectedToggle()).getText().equals("Sedan") ? 'S' : 'V'),
                    Integer.parseInt(txtNumDoors.getText()), (cbPolarizedWindows.getOnAction() != null ? true : false),
                    Double.parseDouble(txtCapacityGasoline.getText()),
                    (((RadioButton) toggleGroupGasolineType.getSelectedToggle()).getText().equals("Extra") ? 'E'
                            : ((RadioButton) toggleGroupGasolineType.getSelectedToggle()).getText().equals("Ordinary")
                                    ? 'O'
                                    : 'D'),
                    0,
                    (((RadioButton) toggleGroupTypeCharger.getSelectedToggle()).getText().equals("Fast") ? 'F' : 'N'),
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
            txtBrand.setText("");
            txtModel.setText("");
            txtCylinder.setText("");
            txtMileage.setText("");
            txtLicensePlate.setText("");
            txtBasePrice.setText("");
            txtNumDoors.setText("");
            cbPolarizedWindows.setOnAction(null);
            txtCapacityGasoline.setText("");
            txtDurationBattery.setText("");
            txtPriceSoat.setText("");
            txtPriceMTR.setText("");
            txtYearSoat.setText("");
            txtYearMTR.setText("");
            txtCodeSoat.setText("");
            txtCodeMTR.setText("");
            txtCoverageAmountSoat.setText("");
            txtGasLevelMTR.setText("");
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
            lole.printStackTrace();
        }
    }

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
     * Name: addVehicleMotorcycle Method used to add a motorcycle. <br>
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
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("New motorcycle") ? 'N'
                            : 'U'),
                    (((RadioButton) toggleGroupVehicleType.getSelectedToggle()).getText().equals("Used motorcycle")
                            ? txtLicensePlate.getText()
                            : ""),
                    0, Double.parseDouble(txtBasePrice.getText()),
                    (((RadioButton) toggleGroupTypeMoto.getSelectedToggle()).getText().equals("Standard") ? 'S'
                            : ((RadioButton) toggleGroupTypeMoto.getSelectedToggle()).getText().equals("Sporty") ? 'D'
                                    : ((RadioButton) toggleGroupTypeMoto.getSelectedToggle()).getText()
                                            .equals("Scooter") ? 'E' : 'C'),
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
            txtBrand.setText("");
            txtModel.setText("");
            txtCylinder.setText("");
            txtMileage.setText("");
            txtLicensePlate.setText("");
            txtBasePrice.setText("");
            txtCapacityGasoline.setText("");
            txtPriceSoat.setText("");
            txtPriceMTR.setText("");
            txtYearSoat.setText("");
            txtYearMTR.setText("");
            txtCodeSoat.setText("");
            txtCodeMTR.setText("");
            txtCoverageAmountSoat.setText("");
            txtGasLevelMTR.setText("");
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

    @FXML
    public void loadSellVehicle(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vehicleKind-sell.fxml"));
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

    @FXML
    public void sellGasolineCar(ActionEvent event) {

    }

    @FXML
    public void sellElectricCar(ActionEvent event) {

    }

    @FXML
    public void sellHybridCar(ActionEvent event) {

    }

    @FXML
    public void sellMotorcycle(ActionEvent event) {

    }

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
                    .showCarsGasoline(rb.getText().equals("Used") ? 'U' : rb.getText().equals("New") ? 'N' : 'B'));
            tvGasolineCarsList.setItems(observableList);
            tcBrand.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("brand"));
            tcModel.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("model"));
            tcVehicleType.setCellValueFactory(new PropertyValueFactory<Vehicle, Character>("typeVehicle"));
            tcBasePrice.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("basePrice"));
            tcLicensePlate.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("licensePlate"));
            tcCylinder.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("cylinder"));
            tcMileage.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("mileage"));
            tcOwner.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("owner"));
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
                    .showCarsElectric(rb.getText().equals("Used") ? 'U' : rb.getText().equals("New") ? 'N' : 'B'));
            tvElectricCarsList.setItems(observableList);
            tcBrand.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("brand"));
            tcModel.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("model"));
            tcVehicleType.setCellValueFactory(new PropertyValueFactory<Vehicle, Character>("typeVehicle"));
            tcBasePrice.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("basePrice"));
            tcLicensePlate.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("licensePlate"));
            tcCylinder.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("cylinder"));
            tcMileage.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("mileage"));
            tcOwner.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("owner"));
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
            ObservableList<Hybrid> observableList = FXCollections.observableArrayList(
                    dealer.showCarsHybrid(rb.getText().equals("Used") ? 'U' : rb.getText().equals("New") ? 'N' : 'B'));
            tvHybridCarsList.setItems(observableList);
            tcBrand.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("brand"));
            tcModel.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("model"));
            tcVehicleType.setCellValueFactory(new PropertyValueFactory<Vehicle, Character>("typeVehicle"));
            tcBasePrice.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("basePrice"));
            tcLicensePlate.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("licensePlate"));
            tcCylinder.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("cylinder"));
            tcMileage.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("mileage"));
            tcOwner.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("owner"));
            tcCarType.setCellValueFactory(new PropertyValueFactory<Car, Character>("typeCar"));
            tcDoorsNumber.setCellValueFactory(new PropertyValueFactory<Car, Integer>("numDoors"));
            tcPolarizedWindows.setCellValueFactory(new PropertyValueFactory<Car, Boolean>("polarizedWindows"));
            tcGasolineTypeCarHybrid.setCellValueFactory(new PropertyValueFactory<Hybrid, Character>("typeGasoline"));
            tcGasolineCapacityCarHybrid
                    .setCellValueFactory(new PropertyValueFactory<Hybrid, Double>("capacityGasoline"));
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
                    dealer.showMotorcycles(rb.getText().equals("Used") ? 'U' : rb.getText().equals("New") ? 'N' : 'B'));
            tvMotorcyclesList.setItems(observableList);
            tcBrand.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("brand"));
            tcModel.setCellValueFactory(new PropertyValueFactory<Vehicle, Integer>("model"));
            tcVehicleType.setCellValueFactory(new PropertyValueFactory<Vehicle, Character>("typeVehicle"));
            tcBasePrice.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("basePrice"));
            tcLicensePlate.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("licensePlate"));
            tcCylinder.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("cylinder"));
            tcMileage.setCellValueFactory(new PropertyValueFactory<Vehicle, Double>("mileage"));
            tcOwner.setCellValueFactory(new PropertyValueFactory<Vehicle, String>("owner"));
            tcMotorcycleType.setCellValueFactory(new PropertyValueFactory<Motorcycle, Character>("typeMoto"));
            tcGasolineCapacityMotorcycle
                    .setCellValueFactory(new PropertyValueFactory<Motorcycle, Double>("capacityGasoline"));
            tcGasolineConsumeMotorcycle
                    .setCellValueFactory(new PropertyValueFactory<Motorcycle, Double>("consumeGasoline"));
            tcTotalSellingPriceMotorcycle
                    .setCellValueFactory(new PropertyValueFactory<Motorcycle, Double>("totalPrice"));
        }
    }

    @FXML
    public void loadRemoveVehicle(ActionEvent event) {

    }

    @FXML
    public void loadEmployeesMod(ActionEvent event) {
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
     * Name: registerEmployee Method used to register an employee. <br>
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
            txtNamePerson.setText("");
            txtLastName.setText("");
            txtID.setText("");
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

    @FXML
    public void loadAssignClient(ActionEvent event) {
        if (dealer.getPeople().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("People list empty");
            alertInfo.setContentText("There are no people registered in the system.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("client-to-employee.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent assignClient = fxmlLoader.load();
                primaryStage.setTitle("Assigning of a client to employee");
                primaryStage.setScene(new Scene(assignClient));
                primaryStage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

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
            we.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Name: showEmployeesByLastNameAndName Method used to show all the employees
     * registered in the system, sorted in ascending order by their last names (or,
     * if same ones, by their names), invoking the showEmployeesByLastNameAndName()
     * method of the Company class. <br>
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
     * Name: showEmployeesByTotalSalesAndID Method used to show all the employees
     * registered in the system, sorted in descending order by their total sales
     * (or, if same ones, by ID's), invoking the showEmployeesByTotalSalesAndID()
     * method of the Company class. <br>
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

    @FXML
    public void loadRemoveEmployee(ActionEvent event) {
        if (dealer.getPeople().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("People list empty");
            alertInfo.setContentText("There are no people registered in the system to remove one.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-employee.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent removeEmployee = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Vehicles exporting process");
                stage.setScene(new Scene(removeEmployee));
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

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

    @FXML
    public void loadClientsMod(ActionEvent event) {
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
     * Name: registerClient Method used to register a client. <br>
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

    @FXML
    public void addClient(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = dealer.addClient(txtNamePerson.getText(), txtLastName.getText(), txtID.getText(),
                    txtNumPhone.getText(), txtEmail.getText(), true, false);
            alertInfo.setTitle("Client adding process");
            alertInfo.setContentText(message);
            alertInfo.showAndWait();
            txtNamePerson.setText("");
            txtLastName.setText("");
            txtID.setText("");
            txtNumPhone.setText("");
            txtEmail.setText("");
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
     * Name: loadAssignVehicle Method used to assign a vehicle of interest to a
     * client. <br>
     * <b>pre: </b> The user of this program has already seen first the vehicles'
     * catalog (mostly in the case of the type NEW vehicles) to assign a vehicle of
     * interest to the list of vehicles of interest of a client). <br>
     */
    @FXML
    public void loadAssignVehicle(ActionEvent event) {
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

    /**
     * Name: assignVehicle Method used to assign a vehicle of interest to a client.
     * <br>
     * <b>pre: </b> The user of this program has already seen first the vehicles'
     * catalog (mostly in the case of the type NEW vehicles) to assign a vehicle of
     * interest to the list of vehicles of interest of a client). <br>
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
            alertInfo.setTitle("Assigning process vehicle of interest");
            alertInfo.setContentText(message);
            alertInfo.showAndWait();
            txtID.setText("");
            txtLicensePlate.setText("");
            txtBrand.setText("");
            txtModel.setText("");
            txtCylinder.setText("");
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
            fve.printStackTrace();
        }
    }

    @FXML
    public void searchClientFastly(ActionEvent event) {

    }

    /**
     * Name: showClientsByLastNameAndPhone Method used to show all the clients
     * registered in the system, sorted in descending order by their last names (or,
     * if same ones, by their phone numbers), invoking the
     * showClientsByLastNameAndPhone() method of the Company class. <br>
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
        ObservableList<Client> observableList = FXCollections
                .observableArrayList(dealer.showClientsByLastNameAndPhone());
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
     * Name: showClientsByNameAndEmail Method used to show all the clients
     * registered in the system, sorted in ascending order by their names (or, if
     * same ones, by their e-mails), invoking the showClientsByNameAndEmail() method
     * of the Company class. <br>
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

    @FXML
    public void loadRemoveClient(ActionEvent event) {
        if (dealer.getPeople().isEmpty()) {
            Alert alertInfo = new Alert(AlertType.INFORMATION);
            alertInfo.setHeaderText(null);
            alertInfo.setTitle("People list empty");
            alertInfo.setContentText("There are no people registered in the system to remove one.");
            alertInfo.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("remove-client.fxml"));
            fxmlLoader.setController(this);
            try {
                Parent removeClient = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Vehicles exporting process");
                stage.setScene(new Scene(removeClient));
                stage.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

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

    @FXML
    public void loadParkingMod(ActionEvent event) {

    }

    @FXML
    public void lookParking(ActionEvent event) {

    }

    @FXML
    public void loadPersistenceMod(ActionEvent event) {
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

    @FXML
    public void importData(ActionEvent event) {
        RadioButton rb = (RadioButton) toggleGroupImport.getSelectedToggle();
        try {
			dealer.importData(txtFileName.getText(), rb.getText().equals("Employees") ? 1 : rb.getText().equals("Clients") ? 2 : rb.getText().equals("Gasoline cars") ? 3 : rb.getText().equals("Electric cars") ? 4 : rb.getText().equals("Hybrid cars") ? 5 : 6);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (LackOfLandException lole) {
            lole.printStackTrace();
        }
    }

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

    @FXML
    public void exportData(ActionEvent event) {
        RadioButton rb = (RadioButton) toggleGroupVehicleKind.getSelectedToggle();
        try {
			dealer.exportDataVehicles(txtFileName.getText(), txtSeparator.getText(), rb.getText().equals("Gasoline cars") ? 'G' : rb.getText().equals("Electric cars") ? 'E' : rb.getText().equals("Hybrid cars") ? 'H' : 'M');
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
    }

    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }
}