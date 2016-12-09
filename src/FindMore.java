import java.util.ArrayList;
import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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

import twitter4j.GeoLocation;
import javafx.geometry.*;

public class FindMore {

	public static void display( ArrayList<HashMap<String, Integer>> keywordsCounts){
		
		//Functions f = new Functions();

		Stage findMoreWindow = new Stage();
		//prevent user get back without taking care of the open window
		findMoreWindow.initModality(Modality.APPLICATION_MODAL);
		findMoreWindow.setTitle("More about the flu");
		findMoreWindow.setMinWidth(400);

//		Label label = new Label();
//		label.setText("message");
		Button closeButton = new Button("go back");
		closeButton.setOnAction (e->findMoreWindow.close());
		
//		VBox center = new VBox(10);
//		center.setPadding(new Insets(10));
//	    center.setSpacing(8);
	    
//		Text title = new Text("Here are the key words and frequencies in past 6 days!");
//		title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
//		center.getChildren().add(title);
//		
//		for(String keyword: keywordsCounts.keySet()){
//			Text content = new Text(keyword + ": " +  keywordsCounts.get(keyword));
//			center.getChildren().add(content);
//		}
		
//		String k1 = "s" ;
//	    String k2 = "Brazil";
//	    String k3 = "France";
//	    String k4 = "Italy";
//	    String k5 = "USA";
	 
		
		
	    CategoryAxis xAxis = new CategoryAxis();
	    NumberAxis yAxis = new NumberAxis();
        BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Country Summary");
        xAxis.setLabel("Country");       
        yAxis.setLabel("Value");
 
            
        
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Recent Period");   
       
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Past Period");
       
        for(String keyWord: keywordsCounts.get(0).keySet()){
        series2.getData().add(new XYChart.Data(keyWord, keywordsCounts.get(0).get(keyWord)));
           
        }
        
        for(String keyWord: keywordsCounts.get(1).keySet()){
            series1.getData().add(new XYChart.Data(keyWord, keywordsCounts.get(1).get(keyWord)));
               
        }
 
        bc.getData().addAll(series1, series2);
		
		BorderPane bp = new BorderPane();
		BorderPane.setAlignment(closeButton, Pos.CENTER);
		BorderPane.setMargin(closeButton, new Insets(12, 12, 20, 12));
		bp.setBottom(closeButton);
		bp.setAlignment(closeButton, Pos.CENTER);
		bp.setCenter(bc);
		bp.setAlignment(bc, Pos.CENTER);
//		
			
		Scene scene = new Scene(bp,500,500);
		findMoreWindow.setScene(scene);
		findMoreWindow.showAndWait();

	}

}
