/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.SuperBO;
import lk.ijse.StudentManagement.model.StudentDTO;

/**
 *
 * @author USER
 */
public interface StudentBO extends SuperBO{
    public boolean saveStudent(StudentDTO student) throws Exception;
    public boolean updateStudent(StudentDTO student)throws Exception;
    public boolean deleteStudent(String sid)throws Exception;
    public StudentDTO searchStudent(String sid)throws Exception;
    public ArrayList<StudentDTO>getAllStudents()throws Exception;
    public ArrayList<String>getAllStudentIDS()throws Exception;
}
