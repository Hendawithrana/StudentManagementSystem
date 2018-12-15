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
import lk.ijse.StudentManagement.business.custom.CourseBO;
import lk.ijse.StudentManagement.business.custom.impl.BatchBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.CourseBOImpl;
import lk.ijse.StudentManagement.model.BatchDTO;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddNewBatchController implements Initializable {

    @FXML
    private JFXTextField batchIDtxt;
    @FXML
    private JFXTextField batchNoTxt;
    @FXML
    private JFXTextField timeTxt;
    @FXML
    private JFXComboBox<String> comboCoursID;

    @FXML
    private JFXButton submitBtn;
    @FXML
    private JFXButton cancelBtn;
    @FXML
    private JFXTextField dayTxt;
    
    private static BatchBO batchBo=new BatchBOImpl();
    private static CourseBO courseBo=new CourseBOImpl();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setNewBatchID();
        try {
            loadCourseIDS();
        } catch (Exception ex) {
            Logger.getLogger(AddNewBatchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    @FXML
    void batchAction(ActionEvent event) {
        batchNoTxt.requestFocus();
    }
    
    @FXML
    void batchNoAction(ActionEvent event) {
        timeTxt.requestFocus();
    }
    
     @FXML
    void timeAction(ActionEvent event) {
        
    }

    @FXML
    private void addBatch(MouseEvent event) throws Exception {
        
        if(validation()){
            int num=Integer.parseInt(batchNoTxt.getText());
            String cid=comboCoursID.getSelectionModel().getSelectedItem();
            BatchDTO batch=new BatchDTO(batchIDtxt.getText(),cid,num,dayTxt.getText(),timeTxt.getText());
            boolean isAdded=batchBo.saveBatch(batch);
            if(isAdded){

                Alert a=new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
                a.show();
                setNewBatchID();
                batchIDtxt.clear();
                comboCoursID.getSelectionModel().clearSelection();
                batchNoTxt.clear();
                dayTxt.clear();
                timeTxt.clear();
            }
        }
    }

    @FXML
    private void cancelBatch(MouseEvent event) {
        Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure..?", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> showAndWait = a.showAndWait();
        if(showAndWait.get()==ButtonType.YES){
           batchIDtxt.clear();
           comboCoursID.getSelectionModel().clearSelection();
           batchNoTxt.clear();
           dayTxt.clear();
           timeTxt.clear(); 
        }
    }
 
    public boolean validation(){
        if(batchIDtxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR, "Batch ID Is Empty..", ButtonType.OK);
            a.show();
            return false;
            }else{
                if(batchNoTxt.getText().trim().isEmpty()){
                    Alert a=new Alert(Alert.AlertType.ERROR, "Batch  No Is Empty..", ButtonType.OK);
                    a.show();
                    return false;
                }else{
                    if(dayTxt.getText().trim().isEmpty()){
                        Alert a=new Alert(Alert.AlertType.ERROR, "Day Is Empty..", ButtonType.OK);
                        a.show();
                        return false;
                    }else{
                        if(timeTxt.getText().trim().isEmpty()){
                            Alert a=new Alert(Alert.AlertType.ERROR, "Time Is Empty..", ButtonType.OK);
                            a.show();
                            return false;
                        }
                    }
                }
        }
        return true;
    }

    private void loadCourseIDS() throws Exception {
        ArrayList<String>subID=courseBo.getAllCourseIDS();
        comboCoursID.getItems().clear();
        for (String id : subID) {
            comboCoursID.getItems().add(id);
        }
    }

    private void setNewBatchID() {
        try {
            String bid;
            bid = IDGenerator.getNewID("Batch", "bid", "B");
            batchIDtxt.setText(bid);
        } catch (SQLException | ClassNotFoundException ex) {
        }
    }
        
    
    
}

