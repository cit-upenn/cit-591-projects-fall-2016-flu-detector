import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import twitter4j.GeoLocation;
import javafx.geometry.*;

public class FindMore {

	public static void display(){

		Stage findMoreWindow = new Stage();
		//prevent user get back without taking care of the open window
		findMoreWindow.initModality(Modality.APPLICATION_MODAL);
		findMoreWindow.setTitle("More about the flu");
		findMoreWindow.setMinWidth(400);

//		Label label = new Label();
//		label.setText("message");
		Button closeButton = new Button("go back");
		closeButton.setOnAction (e->findMoreWindow.close());
		
		VBox center = new VBox(10);
		center.setPadding(new Insets(10));
	    center.setSpacing(8);
	    
		Text title = new Text("Here are the top tweets around!");
		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		center.getChildren().add(title);
				

		BorderPane bp = new BorderPane();
		BorderPane.setAlignment(closeButton, Pos.CENTER);
		BorderPane.setMargin(closeButton, new Insets(12, 12, 20, 12));
		bp.setBottom(closeButton);
		bp.setAlignment(closeButton, Pos.CENTER);
		bp.setCenter(center);
		bp.setAlignment(center, Pos.CENTER);
		
			
		Scene scene = new Scene(bp,500,500);
		findMoreWindow.setScene(scene);
		findMoreWindow.showAndWait();

	}

}
