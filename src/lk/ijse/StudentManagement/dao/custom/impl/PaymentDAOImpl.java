/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudUtil;
import lk.ijse.StudentManagement.dao.custom.PaymentDAO;
import lk.ijse.StudentManagement.entity.Payment;

/**
 *
 * @author USER
 */
public class PaymentDAOImpl implements PaymentDAO{

    @Override
    public boolean save(Payment payment) throws Exception {
        return CrudUtil.executeUpdate("Insert Into Payment Values(?,?,?)", payment.getPid(),payment.getDate(),payment.getAmount())>0;
    }

    @Override
    public boolean update(Payment payment) throws Exception {
        return CrudUtil.executeUpdate("Update Payment set date=?,amount=? where pid=? ", payment.getDate(),payment.getAmount(),payment.getPid())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from Payment where pid=? ", id)>0;
    }

    @Override
    public Payment search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from Payment where pid=? ", id);
        if(rst.next()){
            return new Payment(rst.getString("pid"),rst.getString("date"),rst.getDouble("amount"));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Payment> getAll() throws Exception {
        ArrayList<Payment>pay=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * From payment");
        while(rst.next()){
            pay.add(new Payment(rst.getString(1),rst.getString(2),rst.getDouble(3)));
        }
        return pay;
    }
    
}
