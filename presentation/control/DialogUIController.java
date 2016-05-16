package presentation.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import com.company.*;
public abstract class DialogUIController implements Initializable{


 protected Stage dialog;
 protected Parent root;
 protected VehicleRental vehicleRental;
 public void setOwner(Stage owner) {
 dialog.initOwner(owner);
 }
 public void setTitle(String title) {
 dialog.setTitle(title);
 }
 public void setRoot(Parent root) {
 this.root = root;
 }

 public void setLogicController(VehicleRental vr) {
 this.vehicleRental = vr;
 }
 public void showAndWait() {
 dialog.setScene(new Scene(root));
 dialog.showAndWait();
 }

 @FXML
 public void initialize(){
 setLogicController(VehicleRental.getVehicleRental());
 }

 public static <T extends DialogUIController> T initDialog(String urlView,Class<T> controlClass, Stage owner) {
 FXMLLoader fxmlLoader = new FXMLLoader();
 fxmlLoader.setLocation(DialogUIController.class.getResource(urlView));
 T controller = null;

 try {
 Parent root =fxmlLoader.load();
 controller = fxmlLoader.getController();
 controller.setRoot(root);
 controller.setOwner(owner);
 } catch (NullPointerException | IOException e) {
 e.printStackTrace();
 }
 return controller;
 }
 
 public static <T extends DialogUIController> T initDialog(String urlView,Class<T> controlClass, Stage owner,int o) {
	 FXMLLoader fxmlLoader = new FXMLLoader();
	 fxmlLoader.setLocation(DialogUIController.class.getResource(urlView));
	 T controller = null;

	 try {
	 Parent root =fxmlLoader.load();
	 controller = fxmlLoader.getController();
	 controller.setRoot(root);
	 controller.setOwner(owner);
	 } catch (NullPointerException | IOException e) {
	 e.printStackTrace();
	 }
	 return controller;
	 }
}