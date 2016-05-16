package presentation.control;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.company.BranchOffice;
import com.company.Employee;
import com.company.Pickup;
import com.company.Reservation;
import com.company.Vehicle;
import com.company.VehicleRental;

public class PickUpReservationUIController extends DialogUIController {

	
private int id;

public void filltable1(){
	for(Reservation r: vehicleRental.getReservations()){
		if(r.getPickup() == null)
		table1.getItems().add(r);
	}
}
	
@FXML 
private TableView<Reservation> table1;

@FXML 
private TableColumn<Reservation,Integer> column1;

@FXML 
private TableColumn<Reservation,String> column2;

@FXML 
private TableColumn<Reservation,String> column3;
@FXML 
private TableColumn<Reservation,String> column4;

@FXML 
private TableColumn<Reservation,String> column5;
@FXML 
private TableColumn<Reservation,String> column6;
@FXML 
private TableColumn<Reservation,String> column7;

@FXML
private TableView<Vehicle> table2;

@FXML
private TableColumn<Vehicle, String> column8;

@FXML
private TableColumn<Vehicle, Double> column9;
@FXML
private TableColumn<Vehicle, String> column10;

@FXML 
private TextField insurance;
@FXML
private TextField km;
@FXML
private TextField tankLevel;

@FXML
private Button accept;

@FXML
private Button cancel;

@FXML
private Button vehicles;

@Override
public void initialize(URL location, ResourceBundle resources) {
	vehicleRental=VehicleRental.getVehicleRental();
	dialog = new Stage(StageStyle.DECORATED);
	dialog.initModality(Modality.WINDOW_MODAL);
	dialog.setTitle("RESERVED VEHICLE PICKUP");
	column1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
	column2.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPickupDate().toString()));
	column3.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getReturnDate().toString()));
	column4.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCategory().getName()));
	column5.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getRentalModality()));
	column6.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCustomer().getDni()));
	column7.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCustomer().getNameAndSurname()));
	column8.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPlate_number()));
	column9.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getKms()));
	column10.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getvCa().getName()));
	
	filltable1();
	vehicles.setOnAction(event -> {
	if (table1.getSelectionModel().getSelectedItem() == null){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning Dialog");
		alert.setHeaderText("Look, a Warning Dialog");
		alert.setContentText("Please, select a Reservation");
		
		alert.showAndWait();
	}
	
	else{
		Reservation res = table1.getSelectionModel().getSelectedItem();
		if(vehicleRental.showAvailableVehicles(res) == null) {
			table2.getItems().clear();
		}	
		else table2.getItems().setAll(vehicleRental.showAvailableVehicles(res));
		}
	});
	cancel.setOnAction(event -> dialog.close());
	accept.setOnAction(event -> {
		
	if(table2.getSelectionModel().getSelectedItem() == null){
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning Dialog");
		alert.setHeaderText("WARNING");
		alert.setContentText("Please, select a vehicle");

		alert.showAndWait();
		
	}else{
	
	try{
		vehicleRental.ReservationToPickup(
			insurance.getText(),
			Double.parseDouble(km.getText()),
			Double.parseDouble(tankLevel.getText()),
			table2.getSelectionModel().getSelectedItem(),
			table1.getSelectionModel().getSelectedItem().getrBOpickup(),
			table1.getSelectionModel().getSelectedItem().getId()

			);
		dialog.close();
	}catch(Exception e){
		
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error Dialog");
		alert.setHeaderText("Ooops, there was an error!");
		alert.setContentText("Try to fill all the fields correctly");

		alert.showAndWait();
	}
	}
	});
	
	
		
	}
  }
