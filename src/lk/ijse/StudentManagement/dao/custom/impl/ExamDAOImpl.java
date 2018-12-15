/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudUtil;
import lk.ijse.StudentManagement.dao.custom.ExamDAO;
import lk.ijse.StudentManagement.entity.Exam;

/**
 *
 * @author USER
 */
public class ExamDAOImpl implements ExamDAO{

    @Override
    public boolean save(Exam exam) throws Exception {
        return CrudUtil.executeUpdate("insert into Exam values(?,?,?,?,?)",exam.getEid(),exam.getE_name(),exam.getE_date(),exam.getStart_time(),exam.getEnd_time())>0;
    }

    @Override
    public boolean update(Exam exam) throws Exception {
        return CrudUtil.executeUpdate("Update Exam set e_name=?,e_date=?,start_time=?,end_time=? where eid=? ", exam.getE_name(),exam.getE_date(),exam.getStart_time(),exam.getEnd_time(),exam.getEid())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Exam where eid=? ", id) > 0;
    }

    @Override
    public Exam search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from Exam where eid=? ", id);
        if(rst.next()){
            return new Exam(rst.getString("eid"),rst.getString("e_name"),rst.getString("e_date"),rst.getString("start_time"),rst.getString("end_time"));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Exam> getAll() throws Exception {
        ArrayList<Exam>exam=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * from Exam");
        while(rst.next()){
            exam.add(new Exam(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)));
        }
        return exam;
    }
    
}
