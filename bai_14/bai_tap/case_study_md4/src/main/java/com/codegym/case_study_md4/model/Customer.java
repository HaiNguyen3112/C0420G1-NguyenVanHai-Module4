package com.codegym.case_study_md4.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer", uniqueConstraints = {@UniqueConstraint(columnNames={"code_customer"})})
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "type_customer_id")
    private TypeCustomer typeId;

    @Column(name = "code_customer")

    private String codeCustomer;

    private String name;
    private String birthday;
    private int gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;

    @OneToMany
    private List<Contract> contractList;

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeCustomer getTypeId() {
        return typeId;
    }

    public void setTypeId(TypeCustomer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        String idCard = customer.getIdCard();
        String codeCustomer = customer.getCodeCustomer();
        String phoneNumber = customer.getPhone();
        String email = customer.getEmail();
        ValidationUtils.rejectIfEmpty(errors,"phone","number.empty");

        if (!phoneNumber.matches("(^090[0-9]{7})|(091[0-9]{7}$)|(^\\(84\\)\\+90[0-9]{7}$)|(^\\(84\\)\\+91[0-9]{7}$)")){
            errors.rejectValue("phone","number.matches");
        }
        if (phoneNumber.length() != 10 && phoneNumber.length() != 14){
            errors.rejectValue("phone","number.length");
        }
        if(!email.matches("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$$")){
            errors.rejectValue("email","email.matches");
        }
        if (!codeCustomer.matches("^KH-[0-9]{4}$")){
            errors.rejectValue("codeCustomer","codeCustomer.matches");
        }
        if (!idCard.matches("^[0-9]{9}|[0-9]{11}$")){
            errors.rejectValue("idCard","idCard.matches");
        }

    }
}
