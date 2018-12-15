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
import javafx.scene.input.MouseEvent;
import lk.ijse.StudentManagement.business.custom.Co_SubBO;
import lk.ijse.StudentManagement.business.custom.CourseBO;
import lk.ijse.StudentManagement.business.custom.SubjectBO;
import lk.ijse.StudentManagement.business.custom.impl.Co_SubBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.CourseBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.SubjectBOImpl;
import lk.ijse.StudentManagement.model.Co_SubDTO;
import lk.ijse.StudentManagement.model.CourseDTO;
import lk.ijse.StudentManagement.model.SubjectDTO;

/**
 *
 * @author USER
 */
public class CourseManageDetailsController implements Initializable{
    
    @FXML
    private JFXTextField searchcoursenameTxt;

    @FXML
    private TableView<CourseDTO> corseTbl;

    @FXML
    private JFXTextField cidTxt;

    @FXML
    private JFXTextField coursenameTxt;

    @FXML
    private JFXTextField cdurationTxt;

    @FXML
    private JFXTextField cfeeTxt;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton removeBtn;

    @FXML
    private JFXComboBox<String> comboSub_Id;

    @FXML
    private JFXTextField txtSubName;

    private JFXTextField txtCoSubID;
    
    public static CourseBO courseBo=new CourseBOImpl();
    private static SubjectBO subjectBo=new SubjectBOImpl();
    private static Co_SubBO coSubBo=new Co_SubBOImpl();
    @FXML
    private JFXComboBox<String> comboCourseSub_ID;
    


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
        corseTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cid"));
        corseTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        corseTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        corseTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fee"));
        try{
            loadCourses();
        }catch(Exception e){
            Logger.getLogger(CourseManageDetailsController.class.getName()).log(Level.SEVERE, null, e);
        }

loadSubjectIDS();
        } catch (Exception ex) {
            Logger.getLogger(CourseManageDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadCourses() throws Exception {
        corseTbl.setItems(FXCollections.observableArrayList(courseBo.getAllCourses()));
        
    }
    
     @FXML
    void removeCourse(MouseEvent event) throws Exception {
        boolean isDeleteCourse=courseBo.deleteCourse(cidTxt.getText());
        if(isDeleteCourse){
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Deleted", ButtonType.OK);
            a.show();
//            cidTxt.clear();
//            coursenameTxt.clear();
//            cdurationTxt.clear();
//            cfeeTxt.clear();
        }
    }

    @FXML
    void selectNAme(ActionEvent event) throws Exception {
        String subID=comboSub_Id.getSelectionModel().getSelectedItem();
        SubjectDTO subject=subjectBo.searchSubject(subID);
        txtSubName.setText(subject.getSu_name());
    }
    
    @FXML
    void selectSubId(ActionEvent event) throws Exception {
       String cos_Sub_ID=comboCourseSub_ID.getSelectionModel().getSelectedItem();
        ArrayList<String>sub=coSubBo.serachSub_IDS(cos_Sub_ID);
        comboSub_Id.getItems().clear();
        for (String ids : sub) {
            System.out.println(ids);
            comboSub_Id.getItems().add(ids);
        }
    }
    
    @FXML
    void updateCourse(MouseEvent event) throws Exception {
        double fee=Double.parseDouble(cfeeTxt.getText());
        String subID=comboSub_Id.getSelectionModel().getSelectedItem();
        //Co_SubDTO sub=new Co_SubDTO(txtCoSubID.getText(),cidTxt.getText(),subID);
        CourseDTO course=new CourseDTO(cidTxt.getText(),coursenameTxt.getText(),cdurationTxt.getText(),fee,null);
        boolean isUpdated=courseBo.updateCourse(course);
        if(isUpdated){
           loadAllCOurse();
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Updated..", ButtonType.OK);
            a.show();
//            cidTxt.clear();
//            coursenameTxt.clear();
//            cdurationTxt.clear();
//            cfeeTxt.clear();
//            comboSub_Id.getSelectionModel().clearSelection();
//            //txtCoSubID.clear();
//            txtSubName.clear();
        }
    }
    
    @FXML
    void loadCourse(ActionEvent event) throws Exception {
        String id=cidTxt.getText();
        CourseDTO course=courseBo.searchCourse(id);
        coursenameTxt.setText(course.getName());
        cdurationTxt.setText(course.getDuration());
        cfeeTxt.setText(""+course.getFee());
        
       ArrayList<String> ab=coSubBo.searchGetIdsSub(id);
       //System.out.println(ab.toString());
       comboCourseSub_ID.getItems().clear();
        for (String ids : ab) {
            //System.out.println(ids);
            comboCourseSub_ID.getItems().add(ids);
        }
        String cos_Sub_ID=comboCourseSub_ID.getSelectionModel().getSelectedItem();
        ArrayList<String>sub=coSubBo.serachSub_IDS(cos_Sub_ID);
        comboSub_Id.getItems().clear();
        for (String ids : sub) {
            System.out.println(ids);
            comboSub_Id.getItems().add(ids);
        }
       
    }

    void loadAllCOurse(){
         try {
             ArrayList<CourseDTO> allCourses = courseBo.getAllCourses();
             corseTbl.setItems(FXCollections.observableArrayList(allCourses));
         } catch (Exception ex) {
             Logger.getLogger(ManageStudentController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    private void loadSubjectIDS() throws Exception {
        ArrayList<String>subID=subjectBo.getAllSubjectIDS();
        comboSub_Id.getItems().clear();
        for (String id : subID) {
            comboSub_Id.getItems().add(id);
        }
    }
}
