/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.StudentManagement.business.custom.CourseBO;
import lk.ijse.StudentManagement.business.custom.ExamBO;
import lk.ijse.StudentManagement.business.custom.SubjectBO;
import lk.ijse.StudentManagement.business.custom.impl.CourseBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.ExamBOImpl;
import lk.ijse.StudentManagement.business.custom.impl.SubjectBOImpl;
import lk.ijse.StudentManagement.dao.custom.SubjectDAO;
import lk.ijse.StudentManagement.model.CourseDTO;
import lk.ijse.StudentManagement.model.ExamDTO;
import lk.ijse.StudentManagement.model.SubjectDTO;

/**
 *
 * @author USER
 */
public class DashBoardLoadController implements Initializable{
    
    @FXML
    private TableView<CourseDTO> cTbl;

    @FXML
    private TableView<SubjectDTO> lTbl;

    @FXML
    private TableView<ExamDTO> eTbl;
    
    private static CourseBO courseBo=new CourseBOImpl();
    private static ExamBO examBo=new ExamBOImpl();
    private static SubjectBO subjectBo=new SubjectBOImpl();
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cid"));
        cTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        cTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        cTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fee"));
        try{
            loadCourses();
        }catch(Exception e){
            e.printStackTrace();
        }
        eTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("eid"));
        eTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("e_name"));
        eTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("e_date"));
        eTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("start_time"));
        eTbl.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("end_time"));
        try{
            loadExams();
        }catch(Exception e){
            e.printStackTrace();
        }
        lTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sub_id"));
        lTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("su_name"));
        try{
            loadSubjects();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void loadCourses() throws Exception {
        cTbl.setItems(FXCollections.observableArrayList(courseBo.getAllCourses()));
    }

    private void loadExams() throws Exception {
        eTbl.setItems(FXCollections.observableArrayList(examBo.getAllExams()));
    }

    private void loadSubjects() throws Exception {
        ArrayList<SubjectDTO> allCourses = subjectBo.getAllSubjects();
        lTbl.setItems(FXCollections.observableArrayList(allCourses));
    }


}
