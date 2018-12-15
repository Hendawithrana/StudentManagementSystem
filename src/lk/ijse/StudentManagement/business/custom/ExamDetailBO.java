/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.SuperBO;
import lk.ijse.StudentManagement.model.ExamDetailDTO;

/**
 *
 * @author USER
 */
public interface ExamDetailBO extends SuperBO{
    public boolean saveExamDetail(ExamDetailDTO exam)throws Exception;
    public boolean updateExamDetail(ExamDetailDTO exam)throws Exception;
    public boolean deleteExamDetail(String eid)throws Exception;
    public ExamDetailDTO searchExamDetail(String rid)throws Exception;
    public ArrayList<ExamDetailDTO>getAllExamDetails()throws Exception;
    public ArrayList<String>getAllExamDetailIDS(String eid)throws Exception;

    public ArrayList<String> searchCO_SuIDS(String ID) throws Exception;

    public ArrayList<String> getAllExamIDS(String text)throws Exception;

    public ArrayList<ExamDetailDTO> getAllExamDetailsFromRID(String rid)throws Exception;
}
