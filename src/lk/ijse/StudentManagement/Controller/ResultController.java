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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.ijse.StudentManagement.business.custom.Co_SubBO;
import lk.ijse.StudentManagement.business.custom.ExamBO;
import lk.ijse.StudentManagement.business.custom.ExamDetailBO;
import lk.ijse.StudentManagement.business.custom.RegistrationBO;
import lk.ijse.StudentManagement.business.custom.impl.Co_SubBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.ExamBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.ExamDetailBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.RegistrationBOImpl;
import lk.ijse.StudentManagement.model.ExamDetailDTO;
import lk.ijse.StudentManagement.model.RegistrationDTO;

/**
 *
 * @author USER
 */
public class ResultController implements Initializable{
    
    private static ExamBO examBo=new ExamBOImpl();
    private static Co_SubBO cosSubBo=new Co_SubBOImpl();
    private static ExamDetailBO examDetailBo=new ExamDetailBOImpl();
    private static RegistrationBO registerBo=new RegistrationBOImpl();
    
      @FXML
    private JFXComboBox<String> comboEID;

    @FXML
    private JFXTextField marksTxt;

    @FXML
    private TableView<ExamDetailDTO> resultTbl;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton removeBtn;

    @FXML
    private JFXTextField reIDTxt;

    @FXML
    private JFXTextField txtExamDetailsID;

    @FXML
    private JFXComboBox<String> ComboCoSubID;
    
    @FXML
    private ImageView iconSearch;
    
     @FXML
    private JFXTextField txtSid;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resultTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ed_id"));
        resultTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("eid"));
        resultTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("co_sub_id"));
        resultTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("rid"));
        resultTbl.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("marks"));
        try {
            loadExamDetails();
        } catch (Exception ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadExamIDS();
        } catch (Exception ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            loadCos_Sub_IDs();
        } catch (Exception ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void clickData(MouseEvent event) {
        ExamDetailDTO selectedDetail=resultTbl.getSelectionModel().getSelectedItem();
        reIDTxt.setText(selectedDetail.getRid());
        txtExamDetailsID.setText(selectedDetail.getEd_id());
        ComboCoSubID.getSelectionModel().select(selectedDetail.getCo_sub_id());
        comboEID.getSelectionModel().select(selectedDetail.getEid());
        marksTxt.setText(""+selectedDetail.getMarks());
    }

    @FXML
    void removeResult(MouseEvent event) throws Exception {
        boolean isDeleted=examDetailBo.deleteExamDetail(reIDTxt.getText());
        if(isDeleted){
            loadDetails();
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Deleted..", ButtonType.OK);
            a.show();
//            txtSid.clear();
//            reIDTxt.clear();
//            txtExamDetailsID.clear();
//            ComboCoSubID.getSelectionModel().clearSelection();
//            comboEID.getSelectionModel().clearSelection();
//            marksTxt.clear();
        }
    }

    @FXML
    void saveResult(MouseEvent event) throws Exception {
        String eid=comboEID.getSelectionModel().getSelectedItem();
        String co_Sub_id=ComboCoSubID.getSelectionModel().getSelectedItem();
        double marks=Double.parseDouble(marksTxt.getText());
        ExamDetailDTO examDetail=new ExamDetailDTO(txtExamDetailsID.getText(),eid, co_Sub_id,reIDTxt.getText(), marks);
        boolean isAdded=examDetailBo.saveExamDetail(examDetail);
        if(isAdded){
            loadDetails();
            Alert a=new Alert(Alert.AlertType.INFORMATION,"Added Success..",ButtonType.OK);
            a.show();
//            txtSid.clear();
//            reIDTxt.clear();
//            txtExamDetailsID.clear();
//            ComboCoSubID.getSelectionModel().clearSelection();
//            comboEID.getSelectionModel().clearSelection();
//            marksTxt.clear();
        }
    }

    @FXML
    void updateResult(MouseEvent event) throws Exception {
        String eid=comboEID.getSelectionModel().getSelectedItem();
        String co_Sub_id=ComboCoSubID.getSelectionModel().getSelectedItem();
        double marks=Double.parseDouble(marksTxt.getText());
        ExamDetailDTO examDetail=new ExamDetailDTO(txtExamDetailsID.getText(),eid, co_Sub_id,reIDTxt.getText(), marks);
        boolean isUpdated=examDetailBo.updateExamDetail(examDetail);
        if(isUpdated){
            Alert a=new Alert(Alert.AlertType.INFORMATION,"Updated Success..",ButtonType.OK);
            a.show();
            loadDetails();
//            txtSid.clear();
//            reIDTxt.clear();
//            txtExamDetailsID.clear();
//            ComboCoSubID.getSelectionModel().clearSelection();
//            comboEID.getSelectionModel().clearSelection();
//            marksTxt.clear();
        }
    }

    private void loadExamIDS() throws Exception {
        ArrayList<String>allEIDS=examBo.getAllExamIDS();
        comboEID.getItems().clear();
        
        for (String id : allEIDS) {
            comboEID.getItems().add(id);
        }
    }

    private void loadCos_Sub_IDs() throws Exception {
        ArrayList<String>allIDS=cosSubBo.getCo_SubsIDS();
        ComboCoSubID.getItems().clear();
        for (String ids : allIDS) {
            ComboCoSubID.getItems().add(ids);
        }
    }
    
    
      @FXML
    void serachReid(ActionEvent event) throws Exception {
        String sid=txtSid.getText();
        RegistrationDTO register=registerBo.searchRegistration(sid);
        reIDTxt.setText(register.getRid());
    }

//    @FXML
//    void loadCo_Sub_Id(ActionEvent event) throws Exception {
//        ArrayList<String>sub=examDetailBo.searchCO_SuIDS(txtExamDetailsID.getText());
//        ComboCoSubID.getItems().clear();
//        for (String ids : sub) {
//            ComboCoSubID.getItems().add(ids);
//        }
//    }
    
        @FXML
    void loadMarks(ActionEvent event) throws Exception {
        //String subID=comboEID.getSelectionModel().getSelectedItem();
        ExamDetailDTO subject=examDetailBo.searchExamDetail(txtExamDetailsID.getText());
        marksTxt.setText(""+subject.getMarks());
    }

    @FXML
    void onActionRID(MouseEvent event) throws Exception {
        ArrayList<ExamDetailDTO>allEIDS=examDetailBo.getAllExamDetailsFromRID(reIDTxt.getText());
        comboEID.getItems().clear();
        for (ExamDetailDTO exams : allEIDS) {
            //String id=exams.getEid();
            comboEID.getItems().add(exams.getEid());
            ComboCoSubID.getItems().add(exams.getCo_sub_id());
            txtExamDetailsID.setText(exams.getEd_id());
        } 
    }

    private void loadExamDetails() throws Exception {
        resultTbl.setItems(FXCollections.observableArrayList(examDetailBo.getAllExamDetails()));
    }
    
    private void loadDetails() throws Exception{
        resultTbl.setItems(FXCollections.observableArrayList(examDetailBo.getAllExamDetails()));
    }
}
