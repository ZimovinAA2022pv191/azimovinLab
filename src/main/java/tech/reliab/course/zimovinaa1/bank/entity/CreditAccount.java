package tech.reliab.course.zimovinaa1.bank.entity;


import tech.reliab.course.zimovinaa1.bank.service.CrediteAccountService;

import java.time.LocalDate;
import java.time.LocalTime;


public class CreditAccount{
    private User user;
    private Bank bank;
    private Employee employee;
    private PaymentAccount paymentAccount;
    private Integer id;
    private String userName;
    private String bankName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer countMonth;
    private Double creditSum;
    private Integer interestRate;
    private int monthPay;
    private String employeeName;
    private int paymentAccountId;

    public CreditAccount(Bank bank, User user, Employee employee, PaymentAccount paymentAccount,
                         Integer id, LocalDate startDate, LocalDate endDate, Integer countMonth, Double creditSum,
                         Integer monthPay)
    {
        this.setBank(bank);
        this.setUser(user);
        this.setEmployee(employee);
        this.setPaymentAccount(paymentAccount);
        this.setPaymentAccountId();
        this.setId(id);
        this.setUserName();
        this.setBankName();
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setCountMonth(countMonth);
        this.setCreditSum(creditSum);
        this.setMonthPay(monthPay);
        this.setInterestRate();
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName() {
        this.userName = user.getFirstName();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName() {
        this.bankName = bank.getName();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(Integer countMonth) {
        this.countMonth = countMonth;
    }

    public Double getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(Double creditSum) {
        this.creditSum = creditSum;
    }

    public Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate() {
        this.interestRate = bank.getRate();
    }

    public Integer getMonthPay() {
        return monthPay;
    }

    public void setMonthPay(int monthPay) {
        this.monthPay = monthPay;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName() {
        this.employeeName = employee.getFirsName();
    }

    public Integer getPaymentAccountId() {
        return paymentAccountId;
    }

    public void setPaymentAccountId() {
        this.paymentAccountId = paymentAccount.getIdPayAcc();
    }

    public String toString(){
        return ("CreditAccount{" +
                "id: " + getId() +
                        ", userName: " + getUserName() +
                        ", bankName: " + getBankName() +
                        ", startDate: " + getStartDate() +
                        ", endDate: " + getEndDate() +
                        ", countMonth: " + getCountMonth() +
                        ", creditSum: " + getCreditSum() +
                        ", interestRate: " + getInterestRate() +
                        ", employee: " + this.employee.getId() +
                        ", interestRate: " + getInterestRate() +
                        ", monthPay: " + getMonthPay() +
                        ", paymentAccountId: " + getPaymentAccountId() + "}"
        );
    }

}
