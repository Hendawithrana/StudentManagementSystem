/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.SuperBO;
import lk.ijse.StudentManagement.model.SubjectDTO;

/**
 *
 * @author USER
 */
public interface SubjectBO extends SuperBO{
    public boolean saveSubject(SubjectDTO subject)throws Exception;
    public boolean updateSubject(SubjectDTO subject)throws Exception;
    public boolean deleteSubject(String sid)throws Exception;
    public SubjectDTO searchSubject(String sid)throws Exception;
    public ArrayList<SubjectDTO>getAllSubjects()throws Exception;
    public ArrayList<String>getAllSubjectIDS()throws Exception;
}
