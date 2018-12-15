/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.StudentManagement.db.DBConnection;

/**
 *
 * @author USER
 */
public class LogInController implements Initializable{
    
    @FXML
    private AnchorPane anchor;
    
    @FXML
    private JFXButton LogBtn;
    
    @FXML
    private JFXButton cancelBtn;
    
    @FXML
    private ImageView logoImg;
    
     @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    void getPassword(ActionEvent event) {
        //if()
    }
    
    @FXML
    public void loadDashBoard() throws IOException{
        
        Parent parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/DashBoard.fxml"));
                Scene tempScene=new Scene(parentRoot);
                Stage window=(Stage) this.anchor.getScene().getWindow();
                window.setScene(tempScene);
                window.centerOnScreen();
//       try{
//           if(Login(txtUserName.getText(), txtPassword.getText())){
//                Parent parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/DashBoard.fxml"));
//                Scene tempScene=new Scene(parentRoot);
//                Stage window=(Stage) this.anchor.getScene().getWindow();
//                window.setScene(tempScene);
//                window.centerOnScreen();
//           }else{
//               Alert a=new Alert(Alert.AlertType.ERROR,"Error Password OR UserName", ButtonType.OK);
//               a.show();
//           }
//       }catch(Exception e){
//           Alert a=new Alert(Alert.AlertType.ERROR,e.getMessage(),ButtonType.OK);
//           a.show();
//       }
    }
    
    @FXML
    public void cancelAll(){
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure ?",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
        Optional<ButtonType> showAndWait = a.showAndWait();
        if(showAndWait.get()==ButtonType.YES){
             Stage stage = (Stage) cancelBtn.getScene().getWindow();
            stage.close();
        }
    }
    
    
    @FXML
    void mouseEnter(MouseEvent event) {
        if(event.getSource() instanceof ImageView){
            ImageView image=(ImageView) event.getSource();
            String id=image.getId();
            FadeTransition t=new FadeTransition(Duration.millis(2000), image);
            switch(id){
                case "logoImg":
                    t.setFromValue(0.0);
                        t.setToValue(1.0);
                        t.play();
                        break;
                default :
                    break;
            }
            ScaleTransition sca = new ScaleTransition(Duration.millis(200), image);
                sca.setToX(1.2);
                sca.setToY(1.2);
                sca.play();

                DropShadow d = new DropShadow();
                d.setColor(Color.CORNFLOWERBLUE);
                d.setHeight(20);
                d.setWidth(20);
                d.setRadius(20);
                image.setEffect(d);
               // display.setEffect(d);
        }
    }
    
    public boolean Login(String userName,String password) throws ClassNotFoundException, SQLException{
        Connection connection=DBConnection.getInstacne().getConnection();
        PreparedStatement prepareStm=null;
        ResultSet rst=null;
        
        try{
            String SQL="Select * from Login where userName=? and Password=? ";
            prepareStm=connection.prepareStatement(SQL);
            prepareStm.setString(1, userName);
            prepareStm.setString(2,password);

            rst=prepareStm.executeQuery();
            if(rst.next()){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            return false;
        }finally{
            rst.close();
        }
        
    }
}
