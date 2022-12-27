package tech.reliab.course.zimovinaa1.bank.entity;


import tech.reliab.course.zimovinaa1.bank.entity.JsonClasses.JsonCreditAcc;
import tech.reliab.course.zimovinaa1.bank.entity.parents.BankAccount;
import tech.reliab.course.zimovinaa1.bank.service.CrediteAccountService;

import java.time.LocalDate;
import java.time.LocalTime;


public class CreditAccount extends BankAccount {
    private User user;
    private Bank bank;
    private Employee employee;
    private PaymentAccount paymentAccount;
    private Integer id;
    private String userName;
    private String bankName;
    private String startDate;
    private String endDate;
    private Integer countMonth;
    private Double creditSum;
    private Integer interestRate;
    private double monthPay;
    private String employeeName;
    private int paymentAccountId;

    public CreditAccount(Bank bank, User user, Employee employee, PaymentAccount paymentAccount,
                         Integer id, String startDate, String endDate, Integer countMonth, Double creditSum,
                         Double monthPay)
    {
        super(id, user, bank);
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

    public int getEmployeeId(){
        return this.employee.getId();
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

    public Integer getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(Integer countMonth) {
        this.countMonth = countMonth;
    }

    public double getCreditSum() {
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

    public Double getMonthPay() {
        return monthPay;
    }

    public void setMonthPay(double monthPay) {
        this.monthPay = monthPay;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName() {
        this.employeeName = employee.getFirsName();
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
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
                        ", paymentAccountId: " + getPaymentAccount().getIdPayAcc() + "}"
        );
    }

    public Employee getEmployee(){
        return this.employee;
    }


    public void updateFromJsonClass(JsonCreditAcc jsonCreditAcc, Bank bank2) {
        this.setId(jsonCreditAcc.getId());
        this.bank = bank2;
        this.setBankName();
        this.getUser().setId(jsonCreditAcc.getUserID());
        this.getPaymentAccount().setIdPayAcc(jsonCreditAcc.getPayAccID());
        this.getEmployee().setId(jsonCreditAcc.getEmployeeID());
        this.setStartDate(jsonCreditAcc.getStartDate());
        this.setEndDate(jsonCreditAcc.getEndDate());
        this.setCountMonth(jsonCreditAcc.getCountMonth());
        this.setCreditSum(jsonCreditAcc.getSum());
        this.setMonthPay(jsonCreditAcc.getMonthlyAmount());
    }

}
