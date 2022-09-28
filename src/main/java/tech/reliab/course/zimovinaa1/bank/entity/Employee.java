package tech.reliab.course.zimovinaa1.bank.entity;

import java.util.Date;

public class Employee {
    private int id;
    private String FIO;
    private Date date_birth; //yyyy-mm-dd
    private String post;
    private Bank bank;
    private Boolean work_distance;
    private BankOffice bankOffice;
    private Boolean can_give_credit;
    private float salary;
}
