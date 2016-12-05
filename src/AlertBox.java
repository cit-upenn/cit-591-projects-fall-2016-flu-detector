
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.*;

public class AlertBox {
	
	public static void display(String title, String message){
		
		Stage alertWindow = new Stage();
		//prevent user get back without taking care of the open window
		alertWindow.initModality(Modality.APPLICATION_MODAL);
		alertWindow.setTitle(title);
		alertWindow.setMinWidth(300);
		
		Label label = new Label();
		label.setText(message);
		Button closeButton = new Button("close the window");
		closeButton.setOnAction (e->alertWindow.close());
	
	VBox layout = new VBox(10);
	layout.getChildren().addAll(label, closeButton);
	layout.setAlignment(Pos.CENTER);
	
	Scene scene = new Scene(layout);
	alertWindow.setScene(scene);
	alertWindow.showAndWait();
	
	
	}

}
