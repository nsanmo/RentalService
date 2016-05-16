package presentation.control;
import java.awt.Label;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.company.*;

public class CreateCustomerUIController extends DialogUIController {


@FXML
private TextField dni;

@FXML
private TextField nameAndSurname;

@FXML
private TextField address;

@FXML
private TextField city;

@FXML
private TextField postalCode;

@FXML
private DatePicker dateDriverLicense;

@FXML
private TextField digitsCC;

@FXML
private TextField monthCC;

@FXML
private TextField yearCC;

@FXML
private TextField cvcCC;

@FXML
private TextField typeCC;


@FXML
private Button accept;

@FXML
private Button cancel;

private Customer newCustomer;

@Override
public void initialize(URL location, ResourceBundle resources) {
	vehicleRental=VehicleRental.getVehicleRental();
	dialog = new Stage(StageStyle.DECORATED);
	dialog.initModality(Modality.WINDOW_MODAL);
	dialog.setTitle("CREATE CUSTOMER");
    
	cancel.setOnAction(event -> dialog.close());
	accept.setOnAction(event -> {
			
		
		if(vehicleRental.getCustomer(dni.getText()) != null){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Customer with this dni is already registered");

				alert.showAndWait();
				dialog.close();
				
				
			}
		else{
				
				if(dni.getText().length()>10){
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					alert.setHeaderText("WARNING");
					alert.setContentText("DNI field can only have a maximum of 10 characters");

					alert.showAndWait();
				} 
				else{
						try{
							newCustomer = new Customer(
			                     		dni.getText(),
			                     		nameAndSurname.getText(),
			                     		address.getText(),
			                     		city.getText(), 
			                     		postalCode.getText(), 
			                     		LocalDateTime.of(dateDriverLicense.getValue(),LocalTime.of(0, 0)),
			                     		digitsCC.getText(),
			                     		Integer.parseInt(monthCC.getText()), 
			                     		Integer.parseInt(yearCC.getText()),
			                     		Integer.parseInt(cvcCC.getText()),
			                     		typeCC.getText());
	                             
							              vehicleRental.createCustomer(newCustomer);
							     
							              dialog.close();
							              Alert alert = new Alert(AlertType.INFORMATION);
							              alert.setTitle("Information Dialog");
							              alert.setHeaderText(null);
							              alert.setContentText("Customer succesfully created");
						
							              alert.showAndWait();
							              }
						catch(Exception e){
									Alert alert = new Alert(AlertType.ERROR);
									alert.setTitle("Error Dialog");
									alert.setHeaderText("ERROR");
									alert.setContentText("Try to fill all the fields correctly");
						
									alert.showAndWait();	
									}
			}
			}
		});
	}
  }