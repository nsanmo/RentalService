package presentation.control;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.company.BranchOffice;
import com.company.Reservation;
import com.company.VehicleRental;

public class ListBranchOfficesUIController extends DialogUIController {

	
private int id;
private Stage primaryStage;
private static final String LIST_RESERVATION="../view/ListReservations.fxml";	
	

	
public void setPrimaryStage(Stage primaryStage) {
	 this.primaryStage = primaryStage;
	 }

@FXML
private TextField selectBo;
@FXML 
private TableView<BranchOffice> table1;

@FXML
private TableColumn<BranchOffice,Integer> column1;

@FXML
private TableColumn<BranchOffice,String> column2;

@FXML
private TableColumn<Reservation, Integer> column3;

@FXML
private TableColumn<Reservation, String> column4;

@FXML 
private TableColumn<Reservation,String> column5;

@FXML
private TableView<Reservation> table2;

@FXML
private Button accept;

@FXML
private Button cancel;



@Override
public void initialize(URL location, ResourceBundle resources) {
	vehicleRental=VehicleRental.getVehicleRental();
	dialog = new Stage(StageStyle.DECORATED);
	dialog.initModality(Modality.WINDOW_MODAL);
	dialog.setTitle("LIST BO");
	column1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
	column2.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getAddress()));
	column3.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
	column4.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getCustomer().getDni()));
	cancel.setOnAction(event -> dialog.close());
	accept.setOnAction(event -> {
		BranchOffice bo = table1.getSelectionModel().getSelectedItem();
		id = bo.getId();
		if(vehicleRental.listReservationByBranchOffice(id) == null){
			
			
			table2.getItems().clear();
		}
		
		table2.getItems().setAll(vehicleRental.listReservationByBranchOffice(id));
		
	});
	
	
		
	    table1.getItems().addAll(vehicleRental.branchOfficesList());
	}
  }
