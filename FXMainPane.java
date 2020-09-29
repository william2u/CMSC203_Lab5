package application;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

//import javafx.stage.Stage;
//import javafx.application.Application;
/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a text field
	
	//	Button 1 “Hello”
	Button bouton1 ;//= new Button("Hello");
	//	Button 2 “Howdy”
	Button bouton2 ;//= new Button("Howdy");
	//	Button 3 “Chinese“
	Button bouton3 ;//= new Button("Chinese");
	//	Button 4 “Clear”
	Button bouton4 ;//= new Button("Clear");
	//	Button 5 “Exit”
	Button bouton5 ;//= new Button("Exit");
	//	Button 6 “French“
	Button bouton6 ;//= new Button("French");
	
	//	Instantiate label
	Label feedback ;//= new Label("FeedBack: ");
	
	// 	Instantiate the text field
	TextField txtFld ;//= new TextField();
	
	//  declare two HBoxes
	HBox box1 ;
	HBox box2 ;
	VBox vbox ;
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;  
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		bouton1	= new Button("Hello");
	    bouton2	= new Button("Howdy");
	    bouton3 = new Button("Chinese");
	    bouton4 = new Button("Clear");
	    bouton5 = new Button("Exit");
	    bouton6 = new Button("French");
	    
	    feedback = new Label("FeedBack: ");
	    
	    txtFld = new TextField();

		//  instantiate the HBoxes
		box1 = new HBox();
	    box2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
	    dataManager = new DataManager();
	    
		//  set margins and set alignment of the components
	    HBox.setMargin(bouton1, new Insets(10));
	    HBox.setMargin(bouton2, new Insets(10));
	    HBox.setMargin(bouton3, new Insets(10));
	    HBox.setMargin(bouton4, new Insets(10));
	    HBox.setMargin(bouton5, new Insets(10));
	    HBox.setMargin(bouton6, new Insets(10));
	    
	    box1.setAlignment( Pos.CENTER );
		box2.setAlignment( Pos.CENTER );		
		
		//student Task #3:
		//  add the label and text field to one of the HBoxes
		box1.getChildren().addAll(bouton1, bouton2, bouton3, bouton6, bouton4, bouton5);
		
		//  add the buttons to the other HBox
		box2.getChildren().addAll(feedback, txtFld);
		
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(box1,box2);
		
		
		bouton1.setOnAction( new ButtonHandler() );
		bouton2.setOnAction( new ButtonHandler() );
		bouton3.setOnAction( new ButtonHandler() );
		bouton4.setOnAction( new ButtonHandler() );
		bouton5.setOnAction( new ButtonHandler() );
		bouton6.setOnAction( new ButtonHandler() );
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>{
	public void handle(ActionEvent click) {
			if (click.getTarget() == bouton1) {
				txtFld.setText( dataManager.getHello() );
			}else if (click.getTarget() == bouton2) {
				txtFld.setText( dataManager.getHowdy() );
			}else if (click.getTarget() == bouton3) {
				txtFld.setText( dataManager.getChinese() );
			}else if (click.getTarget() == bouton6) {
				txtFld.setText( dataManager.getFrench() );
			}else if (click.getTarget() == bouton4) {
				txtFld.setText("");
			}else if (click.getTarget() == bouton5) {
	           Platform.exit();
	           System.exit(0);
			}
	}
	}
	
}
	
