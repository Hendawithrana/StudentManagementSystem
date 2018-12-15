/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.StudentManagement.business.custom.StudentBO;
import lk.ijse.StudentManagement.dao.custom.PaymentDAO;
import lk.ijse.StudentManagement.dao.custom.RegistrationDAO;
import lk.ijse.StudentManagement.dao.custom.StudentDAO;
import lk.ijse.StudentManagement.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.StudentManagement.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.StudentManagement.dao.custom.impl.StudentDAOImpl;
import lk.ijse.StudentManagement.db.DBConnection;
import lk.ijse.StudentManagement.entity.Payment;
import lk.ijse.StudentManagement.entity.Registration;
import lk.ijse.StudentManagement.entity.Student;
import lk.ijse.StudentManagement.model.StudentDTO;

/**
 *
 * @author USER
 */
public class StudentBOImpl implements StudentBO{
    StudentDAO studentDao=new StudentDAOImpl();
    RegistrationDAO registerDao=new RegistrationDAOImpl();
    PaymentDAO paymentDao=new PaymentDAOImpl();
    
    @Override
    public boolean saveStudent(StudentDTO student) throws Exception {
        Connection connection=DBConnection.getInstacne().getConnection();
        connection.setAutoCommit(false);
        try{
            boolean result=studentDao.save(new Student(student.getSid(),student.getName(),student.getAddress(),student.getTelephone(),student.getAge(),student.getSchool()));
            if(!result){
                return false;
            }
             result = paymentDao.save(new Payment(student.getPaymentDto().getPid(),student.getPaymentDto().getDate(), student.getPaymentDto().getAmount()));
            if(!result){
                connection.rollback();
                return false;
            }
            result=registerDao.save(new Registration(student.getRegisterDto().getRid(),student.getRegisterDto().getSid() , student.getRegisterDto().getBid(), student.getRegisterDto().getPid(), student.getRegisterDto().getReg_date(),student.getRegisterDto().getReg_fee()));
            if(!result){
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;
        }finally{
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean updateStudent(StudentDTO student) throws Exception {
        Connection connection=DBConnection.getInstacne().getConnection();
        connection.setAutoCommit(false);
        try{
            boolean result=studentDao.update(new Student(student.getSid(),student.getName(),student.getAddress(),student.getTelephone(),student.getAge(),student.getSchool()));
            if(!result){
                return false;
            }
            result=paymentDao.update(new Payment(student.getPaymentDto().getPid(),student.getPaymentDto().getDate(),student.getPaymentDto().getAmount()));
            if(!result){
                connection.rollback();
                return false;
            }
//            

            connection.commit();
            return true;
        }finally{
            connection.setAutoCommit(true);
        }
    }

    @Override
    public boolean deleteStudent(String sid) throws Exception {
        return studentDao.delete(sid);
    }

    @Override
    public StudentDTO searchStudent(String sid) throws Exception {
        Student student=studentDao.search(sid);
        return new StudentDTO(student.getSid(),student.getName(),student.getAddress(),student.getTelephone(),student.getAge(),student.getSchool(),null,null);
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws Exception {
        ArrayList<Student>students=studentDao.getAll();
        ArrayList<StudentDTO>dtos=new ArrayList<>();
        for(Student student: students){
            dtos.add(new StudentDTO(student.getSid(),student.getName(),student.getAddress(),student.getTelephone(),student.getAge(),student.getSchool(),null,null));
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getAllStudentIDS() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
