/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import lk.ijse.StudentManagement.business.custom.AccountSettingBO;
import lk.ijse.StudentManagement.business.custom.impl.AccountSettingBOImpl;
import lk.ijse.StudentManagement.model.LoginDTO;

/**
 *
 * @author USER
 */
public class AcoountSettingController implements Initializable{
    
    AccountSettingBO accountSettingBo=new AccountSettingBOImpl();
    
    @FXML
    private JFXTextField txtUserName;
    
    @FXML
    private JFXPasswordField txtNewPassword;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton BtnDelete;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    @FXML
    void addUser(MouseEvent event) throws Exception {
        LoginDTO login=new LoginDTO(txtUserName.getText(),txtPassword.getText());
        boolean isAdded=accountSettingBo.saveLogin(login);
        if(isAdded){
            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added Success..",ButtonType.OK);
            a.show();
        }
        
    }
    
    @FXML
    void updateUser(MouseEvent event) throws Exception {
        String samplePassword=txtNewPassword.getText();
        String confirmationPassword=txtPassword.getText();
        if(confirmationPassword==samplePassword){
            LoginDTO login=new LoginDTO(txtUserName.getText(),samplePassword);
            boolean isUpdated=accountSettingBo.updateLogin(login);
            if(isUpdated){
                Alert a=new Alert(Alert.AlertType.INFORMATION,"Updated Success..",ButtonType.OK);
                a.show();
            }
        }else{
            Alert a=new Alert(Alert.AlertType.INFORMATION,"Incorect Password..",ButtonType.OK);
            a.show();
        }
        
    }
    
    @FXML
    void loadUser(ActionEvent event) throws Exception {
        LoginDTO login=accountSettingBo.searchLogin(txtUserName.getText());
        txtNewPassword.setText(login.getPassword());
    }

}
