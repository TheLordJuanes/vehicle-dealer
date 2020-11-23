package ui;

import java.io.IOException;
import java.util.InputMismatchException;
import exceptions.LackOfLandException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Company;

public class DealerGUI {

    private Stage primaryStage;

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

    @FXML
    public void addVehicleGasoline(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = dealer.addVehicle(txtBrand.getText(), Integer.parseInt(txtModel.getText()), Double.parseDouble(txtCylinder.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Double.parseDouble(txtMileage.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("New car") ? 'N' : 'U'), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtLicensePlate.getText() : ""), 0, Double.parseDouble(txtBasePrice.getText()), (toggleGroupCarType.getSelectedToggle().toString().equals("Sedan") ? 'S' : 'V'), Integer.parseInt(txtNumDoors.getText()), (cbPolarizedWindows.getOnAction() != null ? true : false), Double.parseDouble(txtCapacityGasoline.getText()), (toggleGroupGasolineType.getSelectedToggle().toString().equals("Extra") ? 'E' : toggleGroupGasolineType.getSelectedToggle().toString().equals("Ordinary") ? 'O' : 'D'), 0, Double.parseDouble(txtPriceSoat.getText()), Double.parseDouble(txtPriceMTR.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Integer.parseInt(txtYearSoat.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Integer.parseInt(txtYearMTR.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtCodeSoat.getText() : ""), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtCodeMTR.getText() : ""), Double.parseDouble(txtCoverageAmountSoat.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Double.parseDouble(txtGasLevelMTR.getText()): 0));
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
		}catch (InputMismatchException ime) {
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

    @FXML
    public void addVehicleElectric(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = dealer.addVehicle(txtBrand.getText(), Integer.parseInt(txtModel.getText()), Double.parseDouble(txtCylinder.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Double.parseDouble(txtMileage.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("New car") ? 'N' : 'U'), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtLicensePlate.getText() : ""), 0, Double.parseDouble(txtBasePrice.getText()), (toggleGroupCarType.getSelectedToggle().toString().equals("Sedan") ? 'S' : 'V'), Integer.parseInt(txtNumDoors.getText()), (cbPolarizedWindows.getOnAction() != null ? true : false), (toggleGroupTypeCharger.getSelectedToggle().toString().equals("Fast") ? 'F' : 'N'), Double.parseDouble(txtDurationBattery.getText()), 0, Double.parseDouble(txtPriceSoat.getText()), Double.parseDouble(txtPriceMTR.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Integer.parseInt(txtYearSoat.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Integer.parseInt(txtYearMTR.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtCodeSoat.getText() : ""), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtCodeMTR.getText() : ""), Double.parseDouble(txtCoverageAmountSoat.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Double.parseDouble(txtGasLevelMTR.getText()): 0));
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
		}catch (InputMismatchException ime) {
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

    @FXML
    public void addVehicleHybrid(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = dealer.addVehicle(txtBrand.getText(), Integer.parseInt(txtModel.getText()), Double.parseDouble(txtCylinder.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Double.parseDouble(txtMileage.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("New car") ? 'N' : 'U'), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtLicensePlate.getText() : ""), 0, Double.parseDouble(txtBasePrice.getText()), (toggleGroupCarType.getSelectedToggle().toString().equals("Sedan") ? 'S' : 'V'), Integer.parseInt(txtNumDoors.getText()), (cbPolarizedWindows.getOnAction() != null ? true : false), Double.parseDouble(txtCapacityGasoline.getText()), (toggleGroupGasolineType.getSelectedToggle().toString().equals("Extra") ? 'E' : toggleGroupGasolineType.getSelectedToggle().toString().equals("Ordinary") ? 'O' : 'D'), 0, (toggleGroupTypeCharger.getSelectedToggle().toString().equals("Fast") ? 'F' : 'N'), Double.parseDouble(txtDurationBattery.getText()), 0, Double.parseDouble(txtPriceSoat.getText()), Double.parseDouble(txtPriceMTR.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Integer.parseInt(txtYearSoat.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Integer.parseInt(txtYearMTR.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtCodeSoat.getText() : ""), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtCodeMTR.getText() : ""), Double.parseDouble(txtCoverageAmountSoat.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Double.parseDouble(txtGasLevelMTR.getText()): 0));
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
		}catch (InputMismatchException ime) {
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

    @FXML
    public void addVehicleMotorcycle(ActionEvent event) {
        Alert alertInfo = new Alert(AlertType.INFORMATION);
        Alert alertWarning = new Alert(AlertType.WARNING);
        alertInfo.setHeaderText(null);
        alertWarning.setHeaderText(null);
        try {
            String message = dealer.addVehicle(txtBrand.getText(), Integer.parseInt(txtModel.getText()), Double.parseDouble(txtCylinder.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Double.parseDouble(txtMileage.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("New car") ? 'N' : 'U'), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtLicensePlate.getText() : ""), 0, Double.parseDouble(txtBasePrice.getText()), (toggleGroupTypeMoto.getSelectedToggle().toString().equals("Standard") ? 'S' : toggleGroupTypeMoto.getSelectedToggle().toString().equals("Sporty") ? 'D' : toggleGroupTypeMoto.getSelectedToggle().toString().equals("Scooter") ? 'E' : 'C'), Double.parseDouble(txtCapacityGasoline.getText()), 0, Double.parseDouble(txtPriceSoat.getText()), Double.parseDouble(txtPriceMTR.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Integer.parseInt(txtYearSoat.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Integer.parseInt(txtYearMTR.getText()) : 0), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtCodeSoat.getText() : ""), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? txtCodeMTR.getText() : ""), Double.parseDouble(txtCoverageAmountSoat.getText()), (toggleGroupVehicleType.getSelectedToggle().toString().equals("Used car") ? Double.parseDouble(txtGasLevelMTR.getText()): 0));
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
		}catch (InputMismatchException ime) {
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

    }

    @FXML
    public void loadRemoveVehicle(ActionEvent event) {

    }

    @FXML
    public void loadEmployeesMod(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("employee-mod.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent employeeMod = fxmlLoader.load();
            primaryStage.setTitle("EMPLOYEE MODULE");
            primaryStage.setScene(new Scene(employeeMod));
            primaryStage.show();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @FXML
    public void registerEmployee(ActionEvent event) {

    }

    @FXML
    public void assignClient(ActionEvent event) {

    }

    @FXML
    public void loadClientsMod(ActionEvent event) {

    }

    @FXML
    public void registerClient(ActionEvent event) {

    }

    @FXML
    public void assignVehicle(ActionEvent event) {

    }

    @FXML
    public void loadParkingMod(ActionEvent event) {

    }

    @FXML
    public void lookParking(ActionEvent event) {

    }

    @FXML
    public void loadPersistenceMod(ActionEvent event) {

    }

    @FXML
    public void importData(ActionEvent event) {

    }

    @FXML
    public void exportVehicles(ActionEvent event) {

    }

    @FXML
    public void exit(ActionEvent event) {
        System.exit(0);
    }
}
