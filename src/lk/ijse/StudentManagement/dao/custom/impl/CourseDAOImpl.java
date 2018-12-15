/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudUtil;
import lk.ijse.StudentManagement.dao.custom.CourseDAO;
import lk.ijse.StudentManagement.entity.Course;

/**
 *
 * @author USER
 */
public class CourseDAOImpl implements CourseDAO{
    
    @Override
    public boolean save(Course course) throws Exception {
        return CrudUtil.executeUpdate("insert into course values(?,?,?,?)",course.getCid(),course.getName(),course.getDuration(),course.getFee())>0;
    }

    @Override
    public boolean update(Course course) throws Exception {
        return CrudUtil.executeUpdate("Update Course set course_Name=?,duration=?,fee=? where cid=? ", course.getName(),course.getDuration(),course.getFee(),course.getCid())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Course where cid=? ", id) > 0;
    }

    @Override
    public Course search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from Course where cid=? ", id);
        if(rst.next()){
            return new Course(rst.getString("cid"),rst.getString("course_Name"),rst.getString("duration"),rst.getDouble("fee"));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Course> getAll() throws Exception {
        ArrayList<Course>course=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * from Course");
        while(rst.next()){
            course.add(new Course(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4)));
        }
        return course;
    }
    
}
