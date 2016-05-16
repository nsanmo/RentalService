package presentation.control;
import java.net.URL;
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
import com.company.Category;
import com.company.Reservation;
import com.company.Vehicle;
import com.company.VehicleRental;

public class ListVehiclesUIController extends DialogUIController {

int id;
@FXML 
private TableView<BranchOffice> table1;

@FXML
private TableColumn<BranchOffice,Integer> column1;

@FXML
private TableColumn<BranchOffice,String> column2;

@FXML
private TableColumn<Vehicle, String> column3;

@FXML
private TableColumn<Vehicle, Double> column4;
@FXML
private TableColumn<Vehicle, String> column5;

@FXML
private TableView<Vehicle> table2;
@FXML
private Button accept;

@FXML
private Button cancel;



@Override
public void initialize(URL location, ResourceBundle resources) {
	vehicleRental=VehicleRental.getVehicleRental();
	dialog = new Stage(StageStyle.DECORATED);
	dialog.initModality(Modality.WINDOW_MODAL);
	dialog.setTitle("LIST VEHICLES");
	column1.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getId()));
	column2.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getAddress()));
	column3.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getPlate_number()));
	column4.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getKms()));
	column5.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().getvCa().getName()));
	cancel.setOnAction(event -> dialog.close());
	accept.setOnAction(event -> {
	BranchOffice bo = table1.getSelectionModel().getSelectedItem();
	id = bo.getId();
	if(vehicleRental.listAvailableVehiclesByBO(bo) == null) {
		
		table2.getItems().clear();
	}
	else table2.getItems().setAll(vehicleRental.listAvailableVehiclesByBO(bo));
	
	});
	 table1.getItems().addAll(vehicleRental.branchOfficesList());
	}
  }
