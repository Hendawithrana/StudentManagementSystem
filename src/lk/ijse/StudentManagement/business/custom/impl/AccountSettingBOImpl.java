/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.custom.AccountSettingBO;
import lk.ijse.StudentManagement.dao.custom.AccountSettingDAO;
import lk.ijse.StudentManagement.dao.custom.impl.AccountSettingDAOImpl;
import lk.ijse.StudentManagement.entity.Login;
import lk.ijse.StudentManagement.model.LoginDTO;

/**
 *
 * @author USER
 */
public class AccountSettingBOImpl implements AccountSettingBO{
    AccountSettingDAO accountSettingDao=new AccountSettingDAOImpl();

    @Override
    public boolean saveLogin(LoginDTO login) throws Exception {
        return accountSettingDao.save(new Login(login.getUsername(),login.getPassword()));
    }

    @Override
    public boolean updateLogin(LoginDTO login) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteLogin(String user) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginDTO searchLogin(String user) throws Exception {
        Login login=accountSettingDao.search(user);
        return new LoginDTO(login.getUsername(),login.getPassword());
    }

    @Override
    public ArrayList<LoginDTO> getAllLogins() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllLoginS() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
