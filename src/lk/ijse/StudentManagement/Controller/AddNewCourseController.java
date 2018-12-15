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
import lk.ijse.StudentManagement.business.custom.CourseBO;
import lk.ijse.StudentManagement.business.custom.SubjectBO;
import lk.ijse.StudentManagement.business.custom.impl.CourseBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.SubjectBOImpl;
import lk.ijse.StudentManagement.model.Co_SubDTO;
import lk.ijse.StudentManagement.model.CourseDTO;
import lk.ijse.StudentManagement.model.SubjectDTO;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddNewCourseController implements Initializable {

    @FXML
    private JFXTextField courseIDTxt;

    @FXML
    private JFXTextField courseNameTxt;

    @FXML
    private JFXTextField durationTxt;

    @FXML
    private JFXTextField feeTxt;

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXComboBox<String> comboSub_ID;

    @FXML
    private JFXTextField txtSub_Name;

    @FXML
    private JFXTextField txtCo_sub_ID;

    
    private static CourseBO courseBO=new CourseBOImpl(); 
    private static SubjectBO subjectBo=new SubjectBOImpl();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setCourseID();
        setCoSubIDS();
        try {
            loadSubjectIDS();
        } catch (Exception ex) {
            Logger.getLogger(AddNewCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
     @FXML
    void courseIDAction(ActionEvent event) {
        courseNameTxt.requestFocus();
    }
    
    @FXML
    void courseNameAction(ActionEvent event) {
        durationTxt.requestFocus();
    }
    
    @FXML
    void Duration(ActionEvent event) {
        feeTxt.requestFocus();
    }
    
    @FXML
    void feeAction(ActionEvent event) {
        //lectureIDTxt.requestFocus();
    }
    
     @FXML
    void setName(ActionEvent event) throws Exception {
        String subID=comboSub_ID.getSelectionModel().getSelectedItem();
        SubjectDTO subject=subjectBo.searchSubject(subID);
        txtSub_Name.setText(subject.getSu_name());
    }

    @FXML
    private void addCourse(MouseEvent event) throws Exception {
        double fee=Double.parseDouble(feeTxt.getText());
        String subID=comboSub_ID.getSelectionModel().getSelectedItem();
        Co_SubDTO cosub=new Co_SubDTO(txtCo_sub_ID.getText(),courseIDTxt.getText(),subID);
        CourseDTO course=new CourseDTO(courseIDTxt.getText(),courseNameTxt.getText(),durationTxt.getText(),fee,cosub);
        boolean isAdded=courseBO.saveCourse(course);
        if(isAdded){
            setCourseID();
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
            a.show();
            setCoSubIDS();
//            courseIDTxt.clear();
//            courseNameTxt.clear();
//            durationTxt.clear();
//            feeTxt.clear();
//            comboSub_ID.getSelectionModel().clearSelection();
//            txtCo_sub_ID.clear();
//            txtSub_Name.clear();
        }
        
        
//        if(Validation()){
//            double fee=Double.parseDouble(feeTxt.getText());
//            String subID=comboSub_ID.getSelectionModel().getSelectedItem();
//            Co_SubDTO sub=new Co_SubDTO(txtCo_sub_ID.getText(),courseIDTxt.getText(),subID);
//            CourseDTO course=new CourseDTO(courseIDTxt.getText(),courseNameTxt.getText(),durationTxt.getText(),fee,sub);
//            boolean isadded= courseBO.saveCourse(course);
//            if(isadded){
//                Alert a=new Alert(Alert.AlertType.INFORMATION, "Added", ButtonType.OK);
//                a.show();
//                courseIDTxt.clear();
//                courseNameTxt.clear();
//                durationTxt.clear();
//                feeTxt.clear();
////                lectureIDTxt.clear();
////                lNameTxt.clear();
//            }
//        }
    }
    
     @FXML
    void cancelAdd(MouseEvent event) {
        Alert a=new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure..?", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> showAndWait = a.showAndWait();
        if(showAndWait.get()==ButtonType.YES){
           courseIDTxt.clear();
           courseNameTxt.clear();
           durationTxt.clear();
           feeTxt.clear();
           
        }
    }
    
    public boolean Validation(){
        if(courseIDTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR, "Error CourseID..", ButtonType.OK);
            a.show();
            return false;
        }else if(courseNameTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR, "Error CourseName..", ButtonType.OK);
            a.show();
            return false;
        }else if(durationTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR, "Error Duration..", ButtonType.OK);
            a.show();
            return false;
        }else if(feeTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR, "Error Fee..", ButtonType.OK);
            a.show();
            return false;
        }
        return true;
    }

    private void loadSubjectIDS() throws Exception {
        ArrayList<String>subID=subjectBo.getAllSubjectIDS();
        comboSub_ID.getItems().clear();
        for (String id : subID) {
            comboSub_ID.getItems().add(id);
        }
    }

    private void setCourseID() {
        try {
            String cid;
            cid = IDGenerator.getNewID("Course", "cid", "C");
            courseIDTxt.setText(cid);
        } catch (SQLException | ClassNotFoundException ex) {
        }
    }

    private void setCoSubIDS() {
        try {
            String co_sub_id;
            co_sub_id = IDGenerator.getNewID("co_sub", "co_sub_id", "CS");
            txtCo_sub_ID.setText(co_sub_id);
        } catch (SQLException | ClassNotFoundException ex) {
        }
    }

    
}
