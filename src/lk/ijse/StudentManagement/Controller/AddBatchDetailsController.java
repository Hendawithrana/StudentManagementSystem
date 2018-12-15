/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.Controller;

import com.jfoenix.controls.JFXButton;
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
import lk.ijse.StudentManagement.business.custom.BatchBO;
import lk.ijse.StudentManagement.business.custom.impl.BatchBOImpl;
import lk.ijse.StudentManagement.model.BatchDTO;

/**
 *
 * @author USER
 */
public class AddBatchDetailsController implements Initializable{
    
     @FXML
    private JFXTextField bidTxt;

    @FXML
    private JFXTextField cidTxt;

    @FXML
    private JFXTextField bnoTxt;

    @FXML
    private JFXTextField bdateTxt;

    @FXML
    private JFXTextField btimeTxt;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton removeBtn;

    @FXML
    private TableView<BatchDTO> batchTbl;
    
    public static BatchBO batchBo=new BatchBOImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        batchTbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("bid"));
        batchTbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cid"));
        batchTbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("num"));
        batchTbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("date"));
        batchTbl.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("time"));
        try{
            loadBatches();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void loadBatches() throws Exception {
       batchTbl.setItems(FXCollections.observableArrayList(batchBo.getAllBatch()));
    }
    
    @FXML
    void removeBatch(MouseEvent event) throws Exception {
        String bid=bidTxt.getText();
        boolean isDelete=batchBo.deleteBatch(bid);
        if(isDelete){
            loadAllBatch();
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Deleted", ButtonType.OK);
            a.show();
            bidTxt.clear();
            cidTxt.clear();
            bnoTxt.clear();
            bdateTxt.clear();
            btimeTxt.clear();
        }
    }

    @FXML
    void updateBatch(MouseEvent event) throws Exception {
        int no=Integer.parseInt(bnoTxt.getText());
        BatchDTO batch=new BatchDTO(bidTxt.getText(),cidTxt.getText(),no,bdateTxt.getText(),btimeTxt.getText());
        boolean isUpdate=batchBo.updateBatch(batch);
        if(isUpdate){
            loadAllBatch();
            Alert a=new Alert(Alert.AlertType.INFORMATION, "Updated", ButtonType.OK);
            a.show();
            bidTxt.clear();
            cidTxt.clear();
            bnoTxt.clear();
            bdateTxt.clear();
            btimeTxt.clear();
        }
    }
    
     @FXML
    void loadBatchDetails(ActionEvent event) throws Exception {
        BatchDTO batch=batchBo.searchBatch(bidTxt.getText());
        if(batch!=null){
            cidTxt.setText(batch.getCid());
            bnoTxt.setText(Integer.toString(batch.getNum()));
            bdateTxt.setText(batch.getDate());
            btimeTxt.setText(batch.getTime());
        }
    }

    void loadAllBatch(){
         try {
             ArrayList<BatchDTO> allBatches = batchBo.getAllBatch();
             batchTbl.setItems(FXCollections.observableArrayList(allBatches));
         } catch (Exception ex) {
             Logger.getLogger(ManageStudentController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @FXML
    void clickData(MouseEvent event) {
        BatchDTO selectedBatch=batchTbl.getSelectionModel().getSelectedItem();
        bidTxt.setText(selectedBatch.getBid());
        cidTxt.setText(selectedBatch.getCid());
        bnoTxt.setText(""+selectedBatch.getNum());
        bdateTxt.setText(selectedBatch.getDate());
        btimeTxt.setText(selectedBatch.getTime());
    }

}
