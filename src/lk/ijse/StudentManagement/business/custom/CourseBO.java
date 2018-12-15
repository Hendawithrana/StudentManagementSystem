/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.SuperBO;
import lk.ijse.StudentManagement.model.CourseDTO;

/**
 *
 * @author USER
 */
public interface CourseBO extends SuperBO{
    public boolean saveCourse(CourseDTO course)throws Exception;
    public boolean updateCourse(CourseDTO student)throws Exception;
    public boolean deleteCourse(String sid)throws Exception;
    public CourseDTO searchCourse(String sid)throws Exception;
    public ArrayList<CourseDTO>getAllCourses()throws Exception;
    public ArrayList<String>getAllCourseIDS()throws Exception;
    
}
