/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.SuperBO;
import lk.ijse.StudentManagement.model.PaymentDTO;

/**
 *
 * @author USER
 */
public interface PaymentBO extends SuperBO{
    public boolean savePayment(PaymentDTO payment) throws Exception;
    public boolean updatePayment(PaymentDTO payment)throws Exception;
    public boolean deletePayment(String pid)throws Exception;
    public PaymentDTO searchPayment(String pid)throws Exception;
    public ArrayList<PaymentDTO>getAllPayments()throws Exception;
    public ArrayList<String>getAllPaymentIDS()throws Exception;
}
