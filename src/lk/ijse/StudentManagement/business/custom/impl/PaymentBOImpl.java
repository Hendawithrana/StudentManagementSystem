/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.custom.PaymentBO;
import lk.ijse.StudentManagement.dao.custom.PaymentDAO;
import lk.ijse.StudentManagement.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.StudentManagement.entity.Payment;
import lk.ijse.StudentManagement.model.PaymentDTO;

/**
 *
 * @author USER
 */
public class PaymentBOImpl implements PaymentBO{
    PaymentDAO paymentDao=new PaymentDAOImpl();

    @Override
    public boolean savePayment(PaymentDTO payment) throws Exception {
        return paymentDao.save(new Payment(payment.getPid(),payment.getDate(),payment.getAmount()));
    }

    @Override
    public boolean updatePayment(PaymentDTO payment) throws Exception {
        return paymentDao.update(new Payment(payment.getPid(),payment.getDate(),payment.getAmount()));
    }

    @Override
    public boolean deletePayment(String pid) throws Exception {
        return paymentDao.delete(pid);
    }

    @Override
    public PaymentDTO searchPayment(String pid) throws Exception {
        Payment payment=paymentDao.search(pid);
        return new PaymentDTO(payment.getPid(),payment.getDate(),payment.getAmount());
    }

    @Override
    public ArrayList<PaymentDTO> getAllPayments() throws Exception {
        ArrayList<Payment>payments=paymentDao.getAll();
        ArrayList<PaymentDTO>dtos=new ArrayList<>();
        for(Payment pay: payments){
            dtos.add(new PaymentDTO(pay.getPid(),pay.getDate(),pay.getAmount()));
        }
        return dtos;
    }

    @Override
    public ArrayList<String> getAllPaymentIDS() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
