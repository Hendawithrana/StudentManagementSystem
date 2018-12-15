/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.model;

/**
 *
 * @author USER
 */
public class StudentDTO {
    private String sid;
    private String name;
    private String address;
    private String telephone;
    private int age;
    private String school;
    private PaymentDTO paymentDto;
    private RegistrationDTO registerDto;

    public StudentDTO() {
    }

    public StudentDTO(String sid, String name, String address, String telephone, int age, String school, PaymentDTO paymentDto, RegistrationDTO registerDto) {
        this.sid = sid;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.age = age;
        this.school = school;
        this.paymentDto = paymentDto;
        this.registerDto = registerDto;
    }

    /**
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the paymentDto
     */
    public PaymentDTO getPaymentDto() {
        return paymentDto;
    }

    /**
     * @param paymentDto the paymentDto to set
     */
    public void setPaymentDto(PaymentDTO paymentDto) {
        this.paymentDto = paymentDto;
    }

    /**
     * @return the registerDto
     */
    public RegistrationDTO getRegisterDto() {
        return registerDto;
    }

    /**
     * @param registerDto the registerDto to set
     */
    public void setRegisterDto(RegistrationDTO registerDto) {
        this.registerDto = registerDto;
    }

    
}
