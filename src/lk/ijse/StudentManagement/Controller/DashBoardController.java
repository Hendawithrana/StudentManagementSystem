/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.Controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class DashBoardController implements Initializable{
    
    @FXML
    private AnchorPane root;
    
      @FXML
    private AnchorPane anchorPane;
    
     @FXML
    private JFXButton AddNewStudentBtn;
     
     @FXML
     private JFXButton ManageStudentBtn;
     
     @FXML
     private JFXButton AddBatchDetailsBtn;
     
     @FXML
     private JFXButton AddNewBatchBtn;
     
     @FXML
     private JFXButton AddNewCourseBtn;
     
     
     @FXML
     private JFXButton CourseMangeDetailsBtn;
     
     @FXML
     private JFXButton MakePaymentBtn;
     
     @FXML
     private JFXButton AccountSettingBtn;
     
     @FXML
     private JFXButton ExamBtn;
     
     @FXML
     private JFXButton ResultBtn;
     
     @FXML
     private JFXButton logOutBtn;
     
     @FXML
    private JFXButton dashBordBtn;
     
      @FXML
    private Label dateLbl;
      
      @FXML
    private ImageView mimimizeImg;
     
     @FXML
    private Label time;

    @FXML
    private ImageView cancelImg;
    
    @FXML
    private JFXButton reportsBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/DashBoardLoad.fxml"));
            anchorPane.getChildren().setAll(parentRoot);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setDatetime();
    }
    
    public void loadDashBoard() throws IOException{
         AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/DashBoardLoad.fxml"));
              anchorPane.getChildren().setAll(parentRoot);
              
    }
    
    
     @FXML
    private void loadNewStudent(){
          try {
              AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/AddNewStudent.fxml"));
              Scene temp=new Scene(parentRoot);
              
              anchorPane.getChildren().setAll(parentRoot);
              
          } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage());
              //Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    @FXML
    private void loadManageStudent(){
          try {
              AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/ManageStudent.fxml"));
              Scene temp=new Scene(parentRoot);
              
              anchorPane.getChildren().setAll(parentRoot);
          } catch (IOException ex) {
              Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
          }
}
    
    @FXML
    private void loadBatchDetails(){
          try {
              AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/AddBatchDetails.fxml"));
              Scene temp=new Scene(parentRoot);
              
              anchorPane.getChildren().setAll(parentRoot);
          } catch (IOException ex) {
              Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    @FXML
    private void loadAddNewBatch(){
          try {
              AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/AddNewBatch.fxml"));
              Scene temp=new Scene(parentRoot);
              
              anchorPane.getChildren().setAll(parentRoot);
          } catch (IOException ex) {
              Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    @FXML
    private void loadAddNewCourse(){
          try {
              AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/AddNewCourse.fxml"));
              Scene temp=new Scene(parentRoot);
              
              anchorPane.getChildren().setAll(parentRoot);
          } catch (IOException ex) {
              Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
//    @FXML
//    private void loadCourseRegistrationDetails(){
//          try {
//              AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/CourseRegistrationDetails.fxml"));
//              Scene temp=new Scene(parentRoot);
//              
//              anchorPane.getChildren().setAll(parentRoot);
//          } catch (IOException ex) {
//              Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
//          }
//    }
    
    @FXML
    private void loadCourseMangeDetails(){
          try {
              AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/CourseManageDetails.fxml"));
              Scene temp=new Scene(parentRoot);
              
              anchorPane.getChildren().setAll(parentRoot);
          } catch (IOException ex) {
              Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    @FXML
    private void loadPayments(){
          try {
              AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/Payments.fxml"));
              Scene temp=new Scene(parentRoot);
              
              anchorPane.getChildren().setAll(parentRoot);
          } catch (IOException ex) {
              Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    @FXML
    private void loadAccountSettings(){
          try {
              AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/AccountSettings.fxml"));
              Scene temp=new Scene(parentRoot);
              
              anchorPane.getChildren().setAll(parentRoot);
          } catch (IOException ex) {
              Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    @FXML
    private void loadExam(){
          try {
              AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/Exam.fxml"));
              Scene temp=new Scene(parentRoot);
              
              anchorPane.getChildren().setAll(parentRoot);
          } catch (IOException ex) {
              Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    @FXML
    private void loadResult(){
          try {
              AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/Result.fxml"));
              Scene temp=new Scene(parentRoot);
              
              anchorPane.getChildren().setAll(parentRoot);
          } catch (IOException ex) {
              Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
     @FXML
    void loadDashBoardLoad(MouseEvent event) throws IOException {
        loadDashBoard();
    }
    
    @FXML
    void loadReports() {
        try {
            AnchorPane parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/Reports.fxml"));
            anchorPane.getChildren().setAll(parentRoot);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void loadLogin(){
        try {
            Parent parentRoot=FXMLLoader.load(this.getClass().getResource("/lk/ijse/StudentManagement/View/login.fxml"));
            Scene temp=new Scene(parentRoot);
            Stage window=(Stage) this.root.getScene().getWindow();
            window.setScene(temp);
        } catch (IOException ex) {
            Logger.getLogger(DashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setDatetime(){
        Timeline newTimeLine=new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                dateLbl.setText(new SimpleDateFormat("YYYY-MM-dd" ).format(new Date()));
                time.setText(new SimpleDateFormat("hh:mm:ss a" ).format(new Date()));
            }
            
        }),new KeyFrame(Duration.seconds(1)));
        newTimeLine.setCycleCount(Animation.INDEFINITE);
        newTimeLine.play();
    }
     @FXML
    void onMinimize(MouseEvent e) {
        ((Stage)((ImageView)e.getSource()).getScene().getWindow()).setIconified(true);
    }
    
    @FXML
    void onClose(MouseEvent event) {
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure ?",ButtonType.YES,ButtonType.NO,ButtonType.CANCEL);
        Optional<ButtonType> showAndWait = a.showAndWait();
        if(showAndWait.get()==ButtonType.YES){
             Platform.exit();
             System.exit(0);
        }
    }
    
    @FXML
    void enterDashBoard(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),AccountSettingBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }

     @FXML
    void enterAccountSetting(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),AccountSettingBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }

    @FXML
    void enterAddBatchDetails(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),AddBatchDetailsBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }

    @FXML
    void enterCourseMangeDetails(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),CourseMangeDetailsBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }

    @FXML
    void enterExam(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),ExamBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }

    @FXML
    void enterManageStudent(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),ManageStudentBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }

    @FXML
    void enterNewBatch(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),AddNewBatchBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }

    @FXML
    void enterNewCourse(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),AddNewCourseBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }

    @FXML
    void enterNewStudent(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),AddNewStudentBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }

    @FXML
    void enterPayments(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),MakePaymentBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }

    @FXML
    void enterRepots(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),reportsBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }

    @FXML
    void enterResult(MouseEvent event) {
        FadeTransition fadetransation=new FadeTransition(Duration.millis(500),ResultBtn);
        fadetransation.setFromValue(0.0);
        fadetransation.setToValue(1.0);
        fadetransation.play();
    }
}
