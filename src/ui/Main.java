/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * @Authors: Juan Esteban Caicedo A.
 * @Date: December, 3rd 2020
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Name: main
     * Main method.
     * @param args - Arguments - args = String[]
    */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Name: start
     * GUI start method.
     * @param primaryStage - GUI primary stage - primaryStage = Stage
     * @throws Exception - to indicate the conditions this program might want to catch.
    */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-menu.fxml"));
        DealerGUI dealerGUI = new DealerGUI(primaryStage);
        fxmlLoader.setController(dealerGUI);
        Parent root = fxmlLoader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Dealer S.A.S.");
        primaryStage.show();
    }
}