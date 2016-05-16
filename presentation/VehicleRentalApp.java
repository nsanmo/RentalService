package presentation;

import java.io.IOException;
import java.net.URL;



import com.company.VehicleRental;
import presentation.control.MainUIController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VehicleRentalApp extends Application {

	 private Stage primaryStage;
	 private BorderPane rootLayout;
	 private MainUIController controller;

	 public static void main(String[] args) {
	 launch(args);
	 }
	 @Override
	 public void start(Stage primaryStage) {

	 this.primaryStage = primaryStage;
	 this.primaryStage.setTitle("RENT A VEHICLE");
	 
	 initRootLayout();
	 }

	 public void initRootLayout() {
	 try {
		 // Load root layout from fxml file.
		 FXMLLoader loader = new FXMLLoader();
		 loader.setLocation(VehicleRentalApp.class.getResource("view/MainView.fxml"));
		 
		 rootLayout = (BorderPane) loader.load();
		 // Show the scene containing the root layout.
		 Scene scene = new Scene(rootLayout);
		 primaryStage.setScene(scene);
		 primaryStage.show();
		 controller = loader.getController();
		 //controller.setPrimaryStage(primaryStage);
	 	} catch (IOException e) {
	 		e.printStackTrace();
	 	}
	 }
}