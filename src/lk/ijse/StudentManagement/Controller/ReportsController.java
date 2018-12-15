/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package lk.ijse.StudentManagement.Controller;

import com.jfoenix.controls.JFXButton;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import lk.ijse.StudentManagement.db.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USER
 */
public class ReportsController implements Initializable{
    
     @FXML
    private JFXButton slistBtn;
     
      @FXML
    private JFXButton reBtn;
      
       @FXML
    private JFXButton BtnExam;
       
       @FXML
    private JFXButton lectureBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         
    }
    
     @FXML
    void loadStudentReport(MouseEvent event) {
        try {
             InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/StudentManagement/reports/Student.jasper");
             HashMap map=new HashMap();
             
             
             
             JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream,map,DBConnection.getInstacne().getConnection());
             JasperViewer.viewReport(jasperPrint,false);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (JRException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
     @FXML
    void loadResult(MouseEvent event) {
        InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/StudentManagement/reports/result.jasper");
        HashMap map=new HashMap();
        
         try {
             JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map,DBConnection.getInstacne().getConnection());
             JasperViewer.viewReport(jasperPrint,false);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (JRException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    void loadExam(MouseEvent event) {
        InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/StudentManagement/reports/Exams.jasper");
        HashMap map=new HashMap();
        
         try {
             JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map,DBConnection.getInstacne().getConnection());
             JasperViewer.viewReport(jasperPrint,false);
         } catch (JRException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @FXML
    void loadLecture(MouseEvent event) {
        InputStream inputStream=getClass().getResourceAsStream("/lk/ijse/StudentManagement/reports/Course.jasper");
        HashMap map=new HashMap();
        
         try {
             JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map,DBConnection.getInstacne().getConnection());
             JasperViewer.viewReport(jasperPrint,false);
         } catch (JRException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(ReportsController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

}
