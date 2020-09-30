package com.codegym.case_study.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Contract implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;


    @Column(name = "start_date")
    @NotEmpty(message = "Start Date not empty")
    private String startDate;

    @Column(name = "end_date")
    @NotEmpty(message = "End Date is not empty")
    private String endDate;

    private double deposit;

    @Column(name = "total_money")
    private double totalMoney;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Servicee serviceId;

    @OneToMany
    private List<ContractDetail> contractDetailList;

    @Column(unique = true)
    private String codeContract;

    private boolean status = true;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCodeContract() {
        return this.codeContract;
    }

    public void setCodeContract(String codeContract) {
        this.codeContract = codeContract;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Servicee getServiceId() {
        return serviceId;
    }

    public void setServiceId(Servicee serviceId) {
        this.serviceId = serviceId;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
        Contract contract = (Contract) target;
        try {
            Date start = format.parse(contract.startDate);
            Date end = format.parse(contract.endDate);
            if (!start.before(end)){
                errors.rejectValue("startDate","date.error");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
