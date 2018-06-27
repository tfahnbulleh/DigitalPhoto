/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digitalpictureframe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author Tamu Fahnbulleh
 */
public class FXMLDocumentController implements Initializable {
    
    Timeline timeline; //timeLine object
    Duration duration;//animation duration
    KeyFrame frame; 
    int  index=1; //index images
    @FXML
    private ImageView imageBox;
    @FXML
    private Button playBtn;
    @FXML
    private Button pauseBtn;
    @FXML
    private Button stopBtn;
    
    
  /*  @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
      //  imageBox.setImage(new Image("/Images/Picture1.png"));
       
      duration = new Duration(1000); //new duration object
      
      
      //event handler to stop animation
     EventHandler<ActionEvent>stopBtnHandler;
     stopBtnHandler=new EventHandler<ActionEvent>()
     {
        @Override
        public void handle(ActionEvent event) 
        {
           timeline.stop(); //stop timeline
           index=1;
           imageBox.setImage(new Image("/Images/Picture1.png")); //set image location
           index=index+1;
           
        }   
     };
     
     //set onclick event for the stop button
     this.stopBtn.setOnAction(stopBtnHandler); 
     
     
     //set event handler to pause the animation
     EventHandler<ActionEvent>pauseBtnHandler;
     pauseBtnHandler=new EventHandler<ActionEvent>()
     {
        @Override
        public void handle(ActionEvent event) 
        {
           timeline.pause(); //stop timeline
        }   
     };
     
     //set onClick event for the pause button
      this.pauseBtn.setOnAction(pauseBtnHandler);
     
     
     EventHandler<ActionEvent>playBtnHandler;
     playBtnHandler=new EventHandler<ActionEvent>()
     {
        @Override
        public void handle(ActionEvent event) 
        {
           timeline.play(); //stop timeline
        }   
     };
     
     
     //set onclick action fro the play button
     this.playBtn.setOnAction(playBtnHandler);
      
      
   
        EventHandler<ActionEvent>handler;
        handler=new EventHandler<ActionEvent>()
        {
           
            @Override
            public void handle(ActionEvent event) 
            {
               imageBox.setImage(new Image("/Images/Picture"+index+".png")); //set the image to display in the imagebox
             
               index=index+1; //increase by one
               
               //if the value of index is 8, reset index to 1
                if (index==8) 
                {
                  index=1;  
                }
                              
            }       
        };
            
        
        
        frame = new KeyFrame(duration,handler);  //create new frame object    
        timeline = new Timeline(frame);//create new TimeLine object
        timeline.setCycleCount(Timeline.INDEFINITE); 
        timeline.playFromStart();  //play the timeline from the beginning
    } 
    
    
    
}
