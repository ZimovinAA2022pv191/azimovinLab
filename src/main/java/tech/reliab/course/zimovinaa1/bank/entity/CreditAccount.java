package tech.reliab.course.zimovinaa1.bank.entity;


import tech.reliab.course.zimovinaa1.bank.service.CrediteAccountService;

import java.util.Date;

public class CreditAccount{
    private User user;
    private Bank bank;
    private Employee employee;
    private PaymentAccount paymentAccount;
    private int id;
    private String userName;
    private String bankName;
    private Date startDate;
    private Date endDate;
    private int countMonth;
    private int creditSum;
    private int interestRate;
    private int monthPay;
    private String employeeName;
    private int paymentAccountId;

    public CreditAccount(Bank bank, User user, Employee employee, PaymentAccount paymentAccount,
                         int id, Date startDate, Date endDate, int countMonth, int creditSum, int monthPay)
    {
        this.setBank(bank);
        this.setUser(user);
        this.setEmployee(employee);
        this.setPaymentAccount(paymentAccount);
        this.setId(id);
        this.setUserName();
        this.setBankName();
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setCountMonth(countMonth);
        this.setCreditSum(creditSum);
        this.setMonthPay(monthPay);
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(Integer countMonth) {
        this.countMonth = countMonth;
    }

    public int getCreditSum() {
        return creditSum;
    }

    public void setCreditSum(int creditSum) {
        this.creditSum = creditSum;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate() {
        this.interestRate = bank.getRate();
    }

    public int getMonthPay() {
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
                        ", employee: " + getEmployeeName() +
                        ", interestRate: " + getInterestRate() +
                        ", monthPay: " + getMonthPay() +
                        ", paymentAccountId: " + getPaymentAccountId() + "}"
        );
    }

}
