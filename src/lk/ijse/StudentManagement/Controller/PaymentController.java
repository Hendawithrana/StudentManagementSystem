/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.Controller;

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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.StudentManagement.business.custom.PaymentBO;
import lk.ijse.StudentManagement.business.custom.RegistrationBO;
import lk.ijse.StudentManagement.business.custom.impl.PaymentBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.RegistrationBOImpl;
import lk.ijse.StudentManagement.model.PaymentDTO;
import lk.ijse.StudentManagement.model.RegistrationDTO;

/**
 *
 * @author USER
 */
public class PaymentController implements Initializable{
    
    RegistrationBO registerBo=new RegistrationBOImpl();
    PaymentBO paymentBo=new PaymentBOImpl();
    
    @FXML
    private JFXTextField txtSid;

    @FXML
    private JFXTextField txtPid;

    @FXML
    private JFXTextField txtDate;

    @FXML
    private JFXTextField txtAmount;
    
    @FXML
    private TableView<PaymentDTO> TblPayment;

    @FXML
    private TableView<RegistrationDTO> TblRegister;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TblRegister.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("rid"));
        TblRegister.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("sid"));
        TblRegister.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("bid"));
        TblRegister.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("pid"));
        TblRegister.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("reg_date"));
        TblRegister.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("reg_fee"));
        
        try {
            loadRegistraion();
        } catch (Exception ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TblPayment.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("pid"));
        TblPayment.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        TblPayment.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("amount"));
        
        try {
            loadPayments();
        } catch (Exception ex) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    void loadDetails(ActionEvent event) throws Exception {
        String sid=txtSid.getText();
        RegistrationDTO register=registerBo.searchRegistration(sid);
        txtPid.setText(register.getPid());
        
        PaymentDTO searchPayment = paymentBo.searchPayment(txtPid.getText());
        txtDate.setText(searchPayment.getDate());
        txtAmount.setText(""+searchPayment.getAmount());
    }
    
    void loadRegistraion() throws Exception{
        try {
             ArrayList<RegistrationDTO> allRegistrations = registerBo.getAllRegistrations();
             TblRegister.setItems(FXCollections.observableArrayList(allRegistrations));
         } catch (Exception ex) {
             Logger.getLogger(ManageStudentController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    void loadPayments() throws Exception{
        try {
             ArrayList<PaymentDTO> allPayments = paymentBo.getAllPayments();
             TblPayment.setItems(FXCollections.observableArrayList(allPayments));
         } catch (Exception ex) {
             Logger.getLogger(ManageStudentController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
