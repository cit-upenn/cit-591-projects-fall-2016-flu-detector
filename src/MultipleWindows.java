

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleWindows extends Application{
	
	Stage window;
	Button button;
	//ComboBox<String> combo;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) {
		
		window = primaryStage;
		window.setTitle("new window");
		
		//combo = new ComboBox<>();
		//combo.getItems().addAll(
//				"NYC",
//				"DC",
//				"PA"
//				);
		//combo.setPromptText("what is your current location?");
		
		
		Button button = new Button("Wanna know more ?");
		button.setOnAction(e->AlertBox.display("Results", "It's goona be flu!"));
		
		StackPane layout = new StackPane();
		layout.getChildren().addAll(button);
		
		Scene scene = new Scene(layout, 500, 500);
		
		window.setScene(scene);
		window.show();
		
		
	}
	
		

}