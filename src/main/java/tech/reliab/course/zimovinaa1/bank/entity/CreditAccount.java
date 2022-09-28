package tech.reliab.course.zimovinaa1.bank.entity;

import java.util.Date;

public class CreditAccount {
    private int id_credit_account;
    private User user;
    private String name_bank;
    private Date date_start_credit, date_end_credit; //yyyy-mm-dd
    private int count_months_credit;
    private float sum_credit;
    private float month_pay;
    private int percentage;
    private Employee employee;
    private String pay_detail_account;
}
