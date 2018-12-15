/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.StudentManagement.business.custom.PaymentBO;
import lk.ijse.StudentManagement.business.custom.RegistrationBO;
import lk.ijse.StudentManagement.business.custom.StudentBO;
import lk.ijse.StudentManagement.business.custom.impl.PaymentBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.RegistrationBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.StudentBOImpl;
import lk.ijse.StudentManagement.model.PaymentDTO;
import lk.ijse.StudentManagement.model.RegistrationDTO;
import lk.ijse.StudentManagement.model.StudentDTO;

/**
 *
 * @author USER
 */
public class ManageStudentController implements Initializable{

    @FXML
    private TableView<StudentDTO> stTbl;

    @FXML
    private JFXTextField stidTxt;

    @FXML
    private JFXTextField stnameTxt;

    @FXML
    private JFXTextField staddressTxt;

    @FXML
    private JFXTextField telephoneTxt;

    @FXML
    private JFXTextField stageTxt;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton removeBtn;
    
    @FXML
    private JFXTextField stSchoolTxt;
    
    @FXML
    private JFXTextField ridTxt;

    @FXML
    private JFXTextField dateTxt;

    @FXML
    private JFXTextField feeTxt;

     @FXML
    private JFXTextField bidTxt;

    @FXML
    private JFXTextField pidTxt;

    @FXML
    private JFXTextField paymentTxt;

    
    public static StudentBO studentBo=new StudentBOImpl();
    public static RegistrationBO registrationBo=new RegistrationBOImpl();
    public static PaymentBO paymentBo=new PaymentBOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sid"));
        stTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        stTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        stTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("telephone"));
        stTbl.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("age"));
        stTbl.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("school"));
        try{
        loadStudent();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void loadStudent() throws Exception {
        stTbl.setItems(FXCollections.observableArrayList(studentBo.getAllStudents()));
    }
    
      @FXML
    void removeStudent(MouseEvent event) throws Exception {
        boolean isDeleted=studentBo.deleteStudent(stidTxt.getText());
        boolean isDalete=paymentBo.deletePayment(pidTxt.getText());
        if(isDeleted && isDalete){
            loadAllStudent();
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Deleted", ButtonType.OK);
            a.show();
            stidTxt.clear();
            stnameTxt.clear();
            staddressTxt.clear();
            telephoneTxt.clear();
            stageTxt.clear();
            stSchoolTxt.clear();
            ridTxt.clear();
            dateTxt.clear();
            feeTxt.clear();
            bidTxt.clear();
            pidTxt.clear();
            paymentTxt.clear();
        }
    }

    @FXML
    void updateStudent(MouseEvent event) throws Exception {
        if(Validation()){
            int age=Integer.parseInt(stageTxt.getText());
            double pay=Double.parseDouble(paymentTxt.getText());
            double fee=Double.parseDouble(feeTxt.getText());
            PaymentDTO payment=new PaymentDTO(pidTxt.getText(),dateTxt.getText(),pay);
            RegistrationDTO register=new RegistrationDTO(ridTxt.getText(),stidTxt.getText(),bidTxt.getText(),pidTxt.getText(),dateTxt.getText(),fee);
            StudentDTO student=new StudentDTO(stidTxt.getText(),stnameTxt.getText(),staddressTxt.getText(),telephoneTxt.getText(),age,stSchoolTxt.getText(),payment,register);
            boolean isUpdated=studentBo.updateStudent(student);
            if(isUpdated){
                loadAllStudent();
                Alert a=new Alert(Alert.AlertType.INFORMATION, "Updated", ButtonType.OK);
                a.show();
                stidTxt.clear();
                stnameTxt.clear();
                staddressTxt.clear();
                telephoneTxt.clear();
                stageTxt.clear();
                stSchoolTxt.clear();
                ridTxt.clear();
                dateTxt.clear();
                feeTxt.clear();
                bidTxt.clear();
                pidTxt.clear();
                paymentTxt.clear();
            }
        }
    }
    
     @FXML
    private void loadDetails(ActionEvent event) throws Exception {
        String studentid=stidTxt.getText();
        StudentDTO student=studentBo.searchStudent(studentid);
        if(student !=null){
            stnameTxt.setText(student.getName());
            staddressTxt.setText(student.getAddress());
            telephoneTxt.setText(student.getTelephone());
            stageTxt.setText(Integer.toString(student.getAge()));
            stSchoolTxt.setText(student.getSchool());
        }
        RegistrationDTO register=registrationBo.searchRegistration(studentid);
        if(register != null){
            ridTxt.setText(register.getRid());
            bidTxt.setText(register.getBid());
            pidTxt.setText(register.getPid());
            dateTxt.setText(register.getReg_date());
            feeTxt.setText(""+register.getReg_fee());
        }
        String a=register.getPid();
       PaymentDTO payment=paymentBo.searchPayment(a);
       if(payment != null){
           paymentTxt.setText(""+payment.getAmount());
       }
       
    }
    void loadAllStudent(){
         try {
             ArrayList<StudentDTO> allStudents = studentBo.getAllStudents();
             stTbl.setItems(FXCollections.observableArrayList(allStudents));
         } catch (Exception ex) {
             Logger.getLogger(ManageStudentController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    public boolean Validation(){
        if(stidTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Sid..",ButtonType.OK);
            a.show();
            stidTxt.requestFocus();
            return false;
        }else if(stnameTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Name..",ButtonType.OK);
            a.show();
            stnameTxt.requestFocus();
            return false;
        }else if(staddressTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Address..",ButtonType.OK);
            a.show();
            staddressTxt.requestFocus();
            return false;
        }else if(telephoneTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Telephone..",ButtonType.OK);
            a.show();
            telephoneTxt.requestFocus();
            return false;
        }else if(stageTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Age..",ButtonType.OK);
            a.show();
            stageTxt.requestFocus();
            return false;
        }else if(stSchoolTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax School Name..",ButtonType.OK);
            a.show();
            stSchoolTxt.requestFocus();
            return false;
        }else if(ridTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Refgister ID..",ButtonType.OK);
            a.show();
            ridTxt.requestFocus();
            return false;
        }else if(dateTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Date..",ButtonType.OK);
            a.show();
            dateTxt.requestFocus();
            return false;
        }else if(feeTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Register Fee..",ButtonType.OK);
            a.show();
            feeTxt.requestFocus();
            return false;
        }else if(bidTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Course ID..",ButtonType.OK);
            a.show();
            bidTxt.requestFocus();
            return false;
        }else if(pidTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax PAyment ID..",ButtonType.OK);
            a.show();
            pidTxt.requestFocus();
            return false;
        }else if(paymentTxt.getText().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Course Amount..",ButtonType.OK);
            a.show();
            paymentTxt.requestFocus();
            return false;
        }
        return true;
    }
    
}
