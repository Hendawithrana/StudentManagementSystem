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
import lk.ijse.StudentManagement.Common.IDGenerator;
import lk.ijse.StudentManagement.business.custom.ExamBO;
import lk.ijse.StudentManagement.business.custom.ExamDetailBO;
import lk.ijse.StudentManagement.business.custom.impl.ExamBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.ExamDetailBOImpl;
import lk.ijse.StudentManagement.model.ExamDTO;

/**
 *
 * @author USER
 */
public class ExamController implements Initializable{
    
     @FXML
    private JFXTextField eidTxt;

    @FXML
    private JFXTextField enameTxt;

    @FXML
    private JFXTextField edateTxt;

    @FXML
    private TableView<ExamDTO> examTbl;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton removeBtn;

    @FXML
    private JFXTextField startTimeTxt;

    @FXML
    private JFXTextField endTimeTxt;
    
     @FXML
    private JFXTextField edidTxt;
    
    private static ExamBO examBo=new ExamBOImpl();
    private static ExamDetailBO examDetailBo=new ExamDetailBOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        examTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("eid"));
        examTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("e_name"));
        examTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("e_date"));
        examTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("start_time"));
        examTbl.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("end_time"));
        try{
            loadExams();
        }catch(Exception e){
            e.printStackTrace();
        }
        setExamIDS();
    }
    
    @FXML
    void removeExam(MouseEvent event) throws Exception {
        boolean isDeleted=examBo.deleteExam(eidTxt.getText());
        if(isDeleted){
            loadAllExam();
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Deleted", ButtonType.OK);
            a.show();  
            eidTxt.clear();
            enameTxt.clear();
            edateTxt.clear();
            startTimeTxt.clear();
            endTimeTxt.clear();
        }
    }

    @FXML
    void saveExam(MouseEvent event) throws Exception {
        if(Validation()){
            ExamDTO exam=new ExamDTO(eidTxt.getText(),enameTxt.getText(),edateTxt.getText(),startTimeTxt.getText(),endTimeTxt.getText());
            boolean isAdded=examBo.saveExam(exam);
            if(isAdded){
               loadAllExam();
                Alert a=new Alert(Alert.AlertType.INFORMATION, "Added Success...", ButtonType.OK);
                a.show();
                eidTxt.clear();
                enameTxt.clear();
                edateTxt.clear();
                startTimeTxt.clear();
                endTimeTxt.clear(); 
            }
        }
    }
     @FXML
    void updateExam(MouseEvent event) throws Exception {
        if(Validation()){
            ExamDTO exam=new ExamDTO(eidTxt.getText(),enameTxt.getText(),edateTxt.getText(),startTimeTxt.getText(),endTimeTxt.getText());
            boolean isUpdated=examBo.updateExam(exam);
            if(isUpdated){
                loadAllExam();
                Alert a=new Alert(Alert.AlertType.INFORMATION, "Updated..", ButtonType.OK);
                a.show();
                eidTxt.clear();
                enameTxt.clear();
                edateTxt.clear();
                startTimeTxt.clear();
                endTimeTxt.clear();
            }
        }
    }

    private void loadExams() throws Exception {
        examTbl.setItems(FXCollections.observableArrayList(examBo.getAllExams()));
    }
    
    @FXML
    void loadExamDetails(ActionEvent event) throws Exception {
        String id=eidTxt.getText();
        ExamDTO exam=examBo.searchExam(id);
        enameTxt.setText(exam.getE_name());
        edateTxt.setText(exam.getE_date());
        startTimeTxt.setText(exam.getStart_time());
        endTimeTxt.setText(exam.getEnd_time());
   }
    
    void loadAllExam(){
         try {
             ArrayList<ExamDTO> allCourses =examBo.getAllExams();
             examTbl.setItems(FXCollections.observableArrayList(allCourses));
         } catch (Exception ex) {
             Logger.getLogger(ManageStudentController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @FXML
    void selectExam(MouseEvent event) {
        ExamDTO selectedExam=examTbl.getSelectionModel().getSelectedItem();
        eidTxt.setText(selectedExam.getEid());
        enameTxt.setText(selectedExam.getE_name());
        edateTxt.setText(selectedExam.getE_date());
        startTimeTxt.setText(selectedExam.getStart_time());
        endTimeTxt.setText(selectedExam.getEnd_time());
    }

    public boolean Validation(){
        if(eidTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Exam ID..",ButtonType.OK);
            a.show();
            eidTxt.requestFocus();
            return false;
        }else if(enameTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Exam Name..",ButtonType.OK);
            a.show();
            enameTxt.requestFocus();
            return false;
        }else if(edateTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Exam Date..",ButtonType.OK);
            a.show();
            edateTxt.requestFocus();
            return false;
        }else if(startTimeTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax Start TIme..",ButtonType.OK);
            a.show();
            startTimeTxt.requestFocus();
            return false;
        }else if(endTimeTxt.getText().trim().isEmpty()){
            Alert a=new Alert(Alert.AlertType.ERROR,"Error Syntax End Time..",ButtonType.OK);
            a.show();
            endTimeTxt.requestFocus();
            return false;
        }
        return true;
    }

    private void setExamIDS() {
        try {
            String eid;
            eid = IDGenerator.getNewID("Exam", "eid", "E");
            eidTxt.setText(eid);
        } catch (SQLException | ClassNotFoundException ex) {
        }
    }
}
