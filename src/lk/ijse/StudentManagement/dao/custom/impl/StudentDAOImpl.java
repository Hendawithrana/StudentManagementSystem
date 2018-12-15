/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudUtil;
import lk.ijse.StudentManagement.dao.custom.StudentDAO;
import lk.ijse.StudentManagement.entity.Student;

/**
 *
 * @author USER
 */
public class StudentDAOImpl implements StudentDAO{

    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtil.executeUpdate("Insert Into Student values(?,?,?,?,?,?)", student.getSid(),student.getName(),student.getAddress(),student.getTelephone(),student.getAge(),student.getSchool())>0;
    }

    @Override
    public boolean update(Student student) throws Exception {
        return CrudUtil.executeUpdate("Update Student set name=?,address=?,telephone=?,age=?,school=? where sid=? ", student.getName(),student.getAddress(),student.getTelephone(),student.getAge(),student.getSchool(),student.getSid())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Student where sid=? ", id) > 0;
    }

    @Override
    public Student search(String sid) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from Student where sid=? ", sid);
        if(rst.next()){
            return new Student(rst.getString("sid"),rst.getString("name"),rst.getString("address"),rst.getString("telephone"),rst.getInt("age"),rst.getString("school"));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Student> getAll() throws Exception {
        ArrayList<Student>student=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * From Student");
        while(rst.next()){
            student.add(new Student(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getShort(5),rst.getString(6)));
        }
        return student;
    }

    
}
