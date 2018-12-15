/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudUtil;
import lk.ijse.StudentManagement.dao.custom.ExamDetailDAO;
import lk.ijse.StudentManagement.entity.ExamDetail;

/**
 *
 * @author USER
 */
public class ExamDetailDAOImpl implements ExamDetailDAO{

    @Override
    public boolean save(ExamDetail edetail) throws Exception {
        return CrudUtil.executeUpdate("Insert Into ExamDetails Values(?,?,?,?,?)", edetail.getEd_id(),edetail.getEid(),edetail.getCo_sub_id(),edetail.getRid(),edetail.getMarks())>0;
    }

    @Override
    public boolean update(ExamDetail edetail) throws Exception {
        return CrudUtil.executeUpdate("Update ExamDetails set marks=? where ed_id=? ", edetail.getMarks(),edetail.getEd_id())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from examdetails where rid=? ", id)>0;
    }

    @Override
    public ExamDetail search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from ExamDetails where ed_id=? ", id);
        if(rst.next()){
            return new ExamDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<ExamDetail> getAll() throws Exception {
        ArrayList<ExamDetail>exam=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * from ExamDetails");
        while(rst.next()){
            exam.add(new ExamDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5)));
        }
        return exam;
    }

    @Override
    public ArrayList<ExamDetail> getSearchIDS(String ID) throws Exception {
        ArrayList<ExamDetail>cosub=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * From ExamDetails where co_sub_id=? ",ID);
        while(rst.next()){
            cosub.add(new ExamDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5)));
        }
        return cosub;
    }

    @Override
    public ArrayList<ExamDetail> getSearchExamIDS(String eid) throws Exception {
        ArrayList<ExamDetail>eids=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * From ExamDetails where rid=? ",eid);
        while(rst.next()){
            eids.add(new ExamDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5)));
        }
        return eids;
    }

    @Override
    public ArrayList<ExamDetail> getAllRegistration(String rid)throws Exception {
        ArrayList<ExamDetail>eids=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * From ExamDetails where rid=? ",rid);
        while(rst.next()){
            eids.add(new ExamDetail(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getDouble(5)));
        }
        return eids;
    }
}
