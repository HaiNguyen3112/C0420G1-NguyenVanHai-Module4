package com.codegym.exam_nguyenvanhai_md4.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Discount implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Not Empty")
    private String title;

    @NotEmpty(message = "Not Empty")
    private String startDate;

    @NotEmpty(message = "Not Empty")
    private String endDate;

    @Min(value = 10000, message = "Giảm giá phải lớn hon 10.000!")
    private int number;

    @NotEmpty(message = "Not Empty")
    private String detail;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Discount.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Discount discount = (Discount) target;
        int number = discount.number;
        try {
            Date date = new Date();

            Date start = format.parse(discount.startDate);
            Date end = format.parse(discount.endDate);
            if (!start.before(end)){
                errors.rejectValue("startDate","date.error");
            }
            if (!start.after(date)){
                errors.rejectValue("startDate","date.errors");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (number<10000){
            errors.rejectValue("number","number.price");
        }




    }
//
//    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
//
//        Date now = new Date();
//        Date test = format.parse("26/09/2020");
//        System.out.println("now: "+now+", test: "+test);
//        System.out.println(now.getHours());
//        System.out.println(test.getHours());
//    }
}
