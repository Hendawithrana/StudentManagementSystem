        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import lk.ijse.StudentManagement.Common.IDGenerator;
import lk.ijse.StudentManagement.business.custom.BatchBO;
import lk.ijse.StudentManagement.business.custom.PaymentBO;
import lk.ijse.StudentManagement.business.custom.RegistrationBO;
import lk.ijse.StudentManagement.business.custom.StudentBO;
import lk.ijse.StudentManagement.business.custom.impl.BatchBOImpl;
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
public class AddNewStudentController implements Initializable{
    
    @FXML
    private JFXButton submitBtn;
    
    @FXML
    private JFXTextField sidTxt;

    @FXML
    private JFXTextField nameTxt;

    @FXML
    private JFXTextField addressTxt;

    @FXML
    private JFXTextField tpTxt;

    @FXML
    private JFXTextField ageTxt;
    
    @FXML
    private JFXTextField schoolTxt;
    
     @FXML
    private JFXTextField registerTxt;
     
       @FXML
    private JFXComboBox<String> comboBatchID;       
       @FXML
    private JFXTextField dateTxt;
       
       @FXML
    private JFXTextField amountTxt;
       
       @FXML
    private JFXTextField pidTxt;
       
       @FXML
    private JFXTextField payamountTxt;
       
        @FXML
    private JFXButton cancelBtn;
    
    private static StudentBO studentBo=new StudentBOImpl();
    private static RegistrationBO registerBo=new RegistrationBOImpl();
    private static PaymentBO paymentBO=new PaymentBOImpl();
    private static BatchBO batchBo=new BatchBOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStudentID();
        setRegisterID();
        setPaymentID();
        try {
            loadBatchIDS();
        } catch (Exception ex) {
            Logger.getLogger(AddNewStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @FXML
    void idAction(ActionEvent event) {
        nameTxt.requestFocus();
    }
    
    @FXML
    void nameAction(ActionEvent event) {
        addressTxt.requestFocus();
        
    }
    
    @FXML
    void addressAction(ActionEvent event) {
        tpTxt.requestFocus();
    }
    
    @FXML
    void numberAction(ActionEvent event) {
        String number=tpTxt.getText();
        if(number.matches("[0-9]{10}")){
            ageTxt.requestFocus();
        }else{
            Alert a=new Alert(Alert.AlertType.WARNING, "Error Type", ButtonType.OK);
            a.show();
        }
        
    }
    
     @FXML
    void ageAction(ActionEvent event) {
        String age=ageTxt.getText();
        if(age.matches("[0-9]{2}")){
            schoolTxt.requestFocus();
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR, "Error input", ButtonType.OK);
            a.show();
            ageTxt.clear();
            ageTxt.requestFocus();
        }
        
    }
    
     @FXML
    void schoolAction(ActionEvent event) {
        registerTxt.requestFocus();
    }
    
    @FXML
    void ridAction(ActionEvent event) {
        dateTxt.requestFocus();
    }
    
    @FXML
    void dateAction(ActionEvent event) {
        String date=dateTxt.getText();
        if(date.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")){
            amountTxt.requestFocus();
        }else{
            Alert a=new Alert(Alert.AlertType.ERROR, "Error Date Input", ButtonType.OK);
            a.show();
            dateTxt.clear();
            dateTxt.requestFocus();
        }
    }
    
    @FXML
    void feeAction(ActionEvent event) {
        amountTxt.requestFocus();
    }
    
    @FXML
    void cidAction(ActionEvent event) {
        pidTxt.requestFocus();
    }

     @FXML
    void pidAction(ActionEvent event) {
        payamountTxt.requestFocus();
    }
    
    @FXML
    void addStudent(MouseEvent event) throws Exception{
        if(Validation()){
            int age=Integer.parseInt(ageTxt.getText());
            double amount=Double.parseDouble(payamountTxt.getText());
            double fee=Double.parseDouble(amountTxt.getText());
            String bid=comboBatchID.getSelectionModel().getSelectedItem();
            PaymentDTO payment=new PaymentDTO(pidTxt.getText(),dateTxt.getText(),amount);
            RegistrationDTO register=new RegistrationDTO(registerTxt.getText(),sidTxt.getText(),bid,pidTxt.getText(),dateTxt.getText(),fee);
            StudentDTO student=new StudentDTO(sidTxt.getText(),nameTxt.getText(),addressTxt.getText(),tpTxt.getText(),age,schoolTxt.getText(),payment,register);
            boolean isAddStudent=studentBo.saveStudent(student);
            if(isAddStudent){
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Added",ButtonType.OK);
                a.show();
                setStudentID();
                setRegisterID();
                sidTxt.clear();
                nameTxt.clear();
                addressTxt.clear();
                tpTxt.clear();
                schoolTxt.clear();
                registerTxt.clear();
                comboBatchID.getSelectionModel().clearSelection();
                pidTxt.clear();
                dateTxt.clear();
                amountTxt.clear();
                payamountTxt.clear();
            }
        }
    }
    
    @FXML
    void cancelAdd(MouseEvent event) {
        Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure..?", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> showAndWait = a.showAndWait();
        if(showAndWait.get()==ButtonType.YES){
           sidTxt.clear();
            nameTxt.clear();
            addressTxt.clear();
            tpTxt.clear();
            schoolTxt.clear();
            registerTxt.clear();
            comboBatchID.getSelectionModel().clearSelection();
            pidTxt.clear();
            dateTxt.clear();
            amountTxt.clear();
            payamountTxt.clear();
        }
    }
    
    public boolean Validation(){
        if(sidTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Sid..",ButtonType.OK);
            a.show();
            sidTxt.requestFocus();
            return false;
        }else if(nameTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Name..",ButtonType.OK);
            a.show();
            nameTxt.requestFocus();
            return false;
        }else if(addressTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Address..",ButtonType.OK);
            a.show();
            addressTxt.requestFocus();
            return false;
        }else if(tpTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Telephone..",ButtonType.OK);
            a.show();
            tpTxt.requestFocus();
            return false;
        }else if(ageTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Age..",ButtonType.OK);
            a.show();
            ageTxt.requestFocus();
            return false;
        }else if(schoolTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax School Name..",ButtonType.OK);
            a.show();
            schoolTxt.requestFocus();
            return false;
        }else if(registerTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Refgister ID..",ButtonType.OK);
            a.show();
            sidTxt.requestFocus();
            return false;
        }else if(dateTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Date..",ButtonType.OK);
            a.show();
            dateTxt.requestFocus();
            return false;
        }else if(amountTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Register Fee..",ButtonType.OK);
            a.show();
            amountTxt.requestFocus();
            return false;
        }else if(pidTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax PAyment ID..",ButtonType.OK);
            a.show();
            pidTxt.requestFocus();
            return false;
        }else if(payamountTxt.getText().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Course Amount..",ButtonType.OK);
            a.show();
            payamountTxt.requestFocus();
            return false;
        }
        return true;
    }

    private void loadBatchIDS() throws Exception {
        ArrayList<String>batchID=batchBo.getAllBatchIds();
        comboBatchID.getItems().clear();
        for (String id : batchID) {
            comboBatchID.getItems().add(id);
        }
    }

    private void setStudentID() {
         try {
            String sid;
            sid = IDGenerator.getNewID("student", "sid", "S");
            sidTxt.setText(sid);
        } catch (SQLException | ClassNotFoundException ex) {
        }
    }

    private void setRegisterID() {
      try {
            String rid;
            rid = IDGenerator.getNewID("registration", "rid", "R");
            registerTxt.setText(rid);
        } catch (SQLException | ClassNotFoundException ex) {
        }  
    }

    private void setPaymentID() {
        try {
            String pid;
            pid = IDGenerator.getNewID("Payment", "pid", "P");
            pidTxt.setText(pid);
        } catch (SQLException | ClassNotFoundException ex) {
        } 
    }
    
}
