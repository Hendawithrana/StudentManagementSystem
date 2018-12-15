/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudDAO;
import lk.ijse.StudentManagement.entity.ExamDetail;

/**
 *
 * @author USER
 */
public interface ExamDetailDAO extends CrudDAO<ExamDetail, String>{

    public ArrayList<ExamDetail> getSearchIDS(String ID)throws Exception;

    public ArrayList<ExamDetail> getSearchExamIDS(String eid) throws Exception;

    public ArrayList<ExamDetail> getAllRegistration(String rid) throws Exception;
    
}
