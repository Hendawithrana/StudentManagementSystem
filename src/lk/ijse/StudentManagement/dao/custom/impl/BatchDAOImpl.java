/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudUtil;
import lk.ijse.StudentManagement.dao.custom.BatchDAO;
import lk.ijse.StudentManagement.entity.Batch;

/**
 *
 * @author USER
 */
public class BatchDAOImpl implements BatchDAO{

    @Override
    public boolean save(Batch batch) throws Exception {
        return CrudUtil.executeUpdate("Insert into Batch Values(?,?,?,?,?)", batch.getBid(),batch.getCid(),batch.getB_no(),batch.getB_date(),batch.getB_Time())>0;
    }

    @Override
    public boolean update(Batch batch) throws Exception {
        return CrudUtil.executeUpdate("Update Batch set cid=?,b_no=?,b_date=?,b_time=? where bid=? ", batch.getCid(),batch.getB_no(),batch.getB_date(),batch.getB_Time(),batch.getBid())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Batch where bid=? ", id) > 0;
    }

    @Override
    public Batch search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from Batch where bid=? ", id);
        if(rst.next()){
            return new Batch(rst.getString("bid"),rst.getString("cid"),rst.getInt("b_no"),rst.getString("b_date"),rst.getString("b_time"));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Batch> getAll() throws Exception {
        ArrayList<Batch>batch=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * From Batch");
        while(rst.next()){
            batch.add(new Batch(rst.getString(1),rst.getString(2),rst.getInt(3),rst.getString(4),rst.getString(5)));
        }
        return batch;
    }
    
    
}
