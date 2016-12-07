
import java.util.ArrayList;

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
import twitter4j.GeoLocation;
import javafx.geometry.*;

public class AlertBox {

	public static void display(String title, String message){

		Stage alertWindow = new Stage();
		//prevent user get back without taking care of the open window
		alertWindow.initModality(Modality.APPLICATION_MODAL);
		alertWindow.setTitle(title);
		alertWindow.setMinWidth(400);

		Label label = new Label();
		label.setText(message);
		Button closeButton = new Button("go back");
		Button findMore = new Button("find more");
		closeButton.setOnAction (e->alertWindow.close());
		findMore.setOnAction(e->FindMore.display());

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, findMore, closeButton);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		alertWindow.setScene(scene);
		alertWindow.showAndWait();


	}

}
