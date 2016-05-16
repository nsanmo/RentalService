package presentation.control;


import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import com.company.*;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateReservationUIController extends DialogUIController {



private Stage primaryStage;	

private static final String CREATE_CUSTOMER="../view/createCustomerView.fxml";
private CreateCustomerUIController createCustomerController;


public void setPrimaryStage(Stage primaryStage) {
this.primaryStage = primaryStage;
}
	
public void fillboxes(){
	for(Category c: vehicleRental.categoryList()){
		category.getItems().add(c.getName());
	};
	for(BranchOffice c: vehicleRental.branchOfficesList()){
		pickUpBo.getItems().add(c.getId());
		returnBo.getItems().add(c.getId());
	}
}

@FXML
private Label returnLabel;
@FXML
private Label pickUpLabel;
@FXML
private Label modelLabel;
@FXML
private Label categoryLabel;
@FXML
private Label pickBOLabel;
@FXML
private Label returnBOLabel;




@FXML
private DatePicker returnDate;

@FXML
private DatePicker pickDate;

@FXML 
private TextField model;

@FXML 
private TextField dni;



@FXML 
private ComboBox category;


@FXML 
private ComboBox pickUpBo;

@FXML 
private ComboBox returnBo;

@FXML
private Button insert;
@FXML
private Button accept;

@FXML
private Button cancel;


private Reservation newReservation;

@Override
	public void initialize(URL location, ResourceBundle resources) {
	vehicleRental= VehicleRental.getVehicleRental();
	dialog = new Stage(StageStyle.DECORATED);
	dialog.initModality(Modality.WINDOW_MODAL);
	dialog.setTitle("CREATE RESERVATION");
	
	model.setVisible(false);
	pickDate.setVisible(false);
	returnDate.setVisible(false);
	
	category.setVisible(false);
	pickUpBo.setVisible(false);
	returnBo.setVisible(false);
	accept.setVisible(false);
	returnLabel.setVisible(false);
	pickUpLabel.setVisible(false);
	modelLabel.setVisible(false);
	categoryLabel.setVisible(false);
	pickBOLabel.setVisible(false);
	returnBOLabel.setVisible(false);
	
	
	
	fillboxes();
	
	insert.setOnAction(event -> {
		if (vehicleRental.getCustomer(dni.getText())== null){
			
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning Dialog");
			alert.setHeaderText("WARNING");
			alert.setContentText("You need to create a customer first");

			alert.showAndWait();
			
			createCustomerController=DialogUIController.initDialog(CREATE_CUSTOMER,CreateCustomerUIController.class, primaryStage);
			createCustomerController.showAndWait();
			
			
			
		}
		else{
			model.setVisible(true);
			pickDate.setVisible(true);
			returnDate.setVisible(true);
			category.setVisible(true);
			pickUpBo.setVisible(true);
			returnBo.setVisible(true);
			accept.setVisible(true);
			returnLabel.setVisible(true);
			pickUpLabel.setVisible(true);
			modelLabel.setVisible(true);
			categoryLabel.setVisible(true);
			pickBOLabel.setVisible(true);
			returnBOLabel.setVisible(true);
			
		}
		
	});
	cancel.setOnAction(event -> dialog.close());
	accept.setOnAction(event -> {
		try{
			 vehicleRental.creaReservation(
					 dni.getText(),
					 LocalDateTime.of(pickDate.getValue(),LocalTime.of(0, 0)),
					 LocalDateTime.of(returnDate.getValue(),LocalTime.of(0, 0)),
					 vehicleRental.getBranchOffice((int) pickUpBo.getValue()).getId(),
					 vehicleRental.getBranchOffice((int) returnBo.getValue()).getId(),
					 vehicleRental.getCategory(category.getValue().toString()).getName(),
					 model.getText()
					 );
             
			
		      dialog.close();
		      
		      Alert alert = new Alert(AlertType.INFORMATION);
		      alert.setTitle("Information Dialog");
		      alert.setHeaderText(null);
		      alert.setContentText("Reservation succesfully created");

		      alert.showAndWait();
		      }
		catch(Exception e){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("Ooops, there was an error!");
			alert.setContentText("Try to fill all the gaps correctly");

			alert.showAndWait();
		}
});


}
}
