/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudUtil;
import lk.ijse.StudentManagement.dao.custom.AccountSettingDAO;
import lk.ijse.StudentManagement.entity.Login;

/**
 *
 * @author USER
 */
public class AccountSettingDAOImpl implements AccountSettingDAO{

    @Override
    public boolean save(Login login) throws Exception {
        return CrudUtil.executeUpdate("Insert into Login Values (?,?)", login.getUsername(),login.getPassword())>0;
    }

    @Override
    public boolean update(Login login) throws Exception {
        return CrudUtil.executeUpdate("Update Login set Password=? where userName=? ", login.getPassword(),login.getUsername())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Login search(String name) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from Login where userName=? ", name);
        if(rst.next()){
            return new Login(rst.getString(1),rst.getString(2));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Login> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
