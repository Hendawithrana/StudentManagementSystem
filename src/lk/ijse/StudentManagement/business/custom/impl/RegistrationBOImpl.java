/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.StudentManagement.model.RegistrationDTO;
import lk.ijse.StudentManagement.business.custom.RegistrationBO;
import lk.ijse.StudentManagement.dao.custom.RegistrationDAO;
import lk.ijse.StudentManagement.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.StudentManagement.entity.Registration;

/**
 *
 * @author USER
 */
public class RegistrationBOImpl implements RegistrationBO{
    RegistrationDAO registrationDao=new RegistrationDAOImpl();

    @Override
    public boolean saveRegistration(RegistrationDTO registration) throws Exception {
        return registrationDao.save(new Registration(registration.getRid(),registration.getSid(),registration.getBid(),registration.getPid(),registration.getReg_date(),registration.getReg_fee()));
    }

    @Override
    public boolean updateRegistration(RegistrationDTO registration) throws Exception {
        return registrationDao.update(new Registration(registration.getRid(),registration.getSid(),registration.getBid(),registration.getPid(),registration.getReg_date(),registration.getReg_fee()));
    }

    @Override
    public boolean deleteRegistration(String rid) throws Exception {
        return registrationDao.delete(rid);
    }

    @Override
    public RegistrationDTO searchRegistration(String sid) throws Exception {
        Registration register=registrationDao.search(sid);
        return new RegistrationDTO(register.getRid(),register.getSid(),register.getBid(),register.getPid(),register.getReg_date(),register.getReg_fee());
    }

    @Override
    public ArrayList<RegistrationDTO> getAllRegistrations() throws Exception {
        ArrayList<Registration>resgister=registrationDao.getAll();
        ArrayList<RegistrationDTO>dtos=new ArrayList<>();
        for(Registration reg: resgister){
            dtos.add(new RegistrationDTO(reg.getRid(),reg.getSid(),reg.getBid(),reg.getPid(),reg.getReg_date(),reg.getReg_fee()));
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getAllRegistrationIDS() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
