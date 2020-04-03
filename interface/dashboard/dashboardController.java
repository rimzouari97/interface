/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.event.EventHandler;

/**
 *
 * @author Memmicha
 */
public class dashboardController implements Initializable {
    
  @FXML
    private Label label;
    
private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private AnchorPane parent;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        makeStageDrageable();
    }

    private void makeStageDrageable() {
        parent.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        parent.setOnMouseDragged((MouseEvent event) -> {
            Dashboard.stage.setX(event.getScreenX() - xOffset);
            Dashboard.stage.setY(event.getScreenY() - yOffset);
            Dashboard.stage.setOpacity(0.7f);
        });
        parent.setOnDragDone((e) -> {
            Dashboard.stage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((e) -> {
            Dashboard.stage.setOpacity(1.0f);
        });

    }
    
   /* @FXML
    private void handleClose(ActionEvent event) {
        System.exit(0);
        
    }*/
    
    
}
