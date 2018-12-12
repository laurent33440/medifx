package org.silibre;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FXMLController {
    
    public static final String LABEL_UNCLICKED = "wait for button clicked";
    public static final String LABEL_CLICKED = "changed because button was clicked";
    public static final String BUTTON_UNCLICKED = "click on me!";
    public static final String BUTTON_CLICKED = "i was clicked";
    
    @FXML
    private Button button;
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        button.setText(BUTTON_CLICKED);
        label.setText(LABEL_CLICKED);
    }
    
    public void initialize() {
        button.setText(BUTTON_UNCLICKED);
        label.setText(LABEL_UNCLICKED);
    }    
}
