/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.SuperBO;
import lk.ijse.StudentManagement.model.ExamDTO;

/**
 *
 * @author USER
 */
public interface ExamBO extends SuperBO{
     public boolean saveExam(ExamDTO course)throws Exception;
    public boolean updateExam(ExamDTO student)throws Exception;
    public boolean deleteExam(String sid)throws Exception;
    public ExamDTO searchExam(String sid)throws Exception;
    public ArrayList<ExamDTO>getAllExams()throws Exception;
    public ArrayList<String>getAllExamIDS()throws Exception;

   // public ArrayList<String> getAllExamIDS(String text) throws Exception;
}
