package presentation.control;

import exceptions.LogicException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import com.company.*;

public class MainUIController {

	//TODO add String constants for the views related to the use cases Create Reservation and List Reservations
 private static final String VEHICLE_PICKUP="../view/reservedVehiclePickupView.fxml";
 private static final String LIST_VEHICLE_BRANCH_OFFICE="../view/listVehicles.fxml";
 private static final String CREATE_RESERVATION="../view/createReservation.fxml";
 private static final String LIST_BRANCH_OFFICE="../view/listBOReservations.fxml";
 private static final String CREATE_CUSTOMER="../view/createCustomerView.fxml";
 private Stage primaryStage;
 private ListBranchOfficesUIController listBranchOfficesController;
 private CreateCustomerUIController createCustomerController;
 private CreateReservationUIController createReservationController;
 private ListVehiclesUIController listVehiclesController;
 private PickUpReservationUIController pickUpReservation;
 
 @FXML private MenuItem menuPickUpReservation;
 @FXML private MenuItem menuListVehicles;
 @FXML private MenuItem menuClose;
 @FXML private MenuItem menuCreateReservation;
 @FXML private MenuItem menuListBranchOffices;
 @FXML private MenuItem menuCreateCustomer;

 @FXML
 void exit(ActionEvent event) {
 Platform.exit();
 }
 
 @FXML
 void pickUpReservation(ActionEvent event) throws LogicException {
	 
	 pickUpReservation=DialogUIController.initDialog(VEHICLE_PICKUP,PickUpReservationUIController.class, primaryStage);
	 pickUpReservation.showAndWait();
 }
 
 @FXML
 void listVehicles(ActionEvent event) throws LogicException {
	 
	 listVehiclesController=DialogUIController.initDialog(LIST_VEHICLE_BRANCH_OFFICE,ListVehiclesUIController.class, primaryStage);
	 listVehiclesController.showAndWait();
 }
 
 
 @FXML
 void listBranchOffices(ActionEvent event) throws LogicException {
	 
	 listBranchOfficesController=DialogUIController.initDialog(LIST_BRANCH_OFFICE,ListBranchOfficesUIController.class, primaryStage);
	 listBranchOfficesController.showAndWait();
 }

 @FXML
 void createCustomer(ActionEvent event) throws LogicException {

 createCustomerController=DialogUIController.initDialog(CREATE_CUSTOMER,CreateCustomerUIController.class, primaryStage);
 createCustomerController.showAndWait();

 }

 @FXML
 void createReservation(ActionEvent event) throws LogicException {
	 
 createReservationController=DialogUIController.initDialog(CREATE_RESERVATION,CreateReservationUIController.class, primaryStage);
 createReservationController.showAndWait();

 }

 
 public void setPrimaryStage(Stage primaryStage) {
 this.primaryStage = primaryStage;
 }
}