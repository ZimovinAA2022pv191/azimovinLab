package tech.reliab.course.zimovinaa1.bank.entity.JsonClasses;

import tech.reliab.course.zimovinaa1.bank.entity.CreditAccount;

public class JsonCreditAcc {
    private int id;
    private int bankID;
    private int userID;
    private int payAccID;
    private int employeeID;
    private String startDate;
    private String endDate;
    private int countMonth;
    private double sum;
    private double monthlyPay;
    private int interestRate;

    public JsonCreditAcc(CreditAccount creditAcc) {
        this.id = creditAcc.getId();
        this.bankID = creditAcc.getBank().getId();
        this.userID = creditAcc.getUser().getUserId();
        this.payAccID = creditAcc.getPaymentAccount().getIdPayAcc();
        this.employeeID = creditAcc.getEmployeeId();
        this.startDate = creditAcc.getStartDate();
        this.endDate = creditAcc.getEndDate();
        this.countMonth = creditAcc.getCountMonth();
        this.sum = creditAcc.getCreditSum();
        this.monthlyPay = creditAcc.getMonthPay();
        this.interestRate = creditAcc.getInterestRate();
    }

    public Integer getId() {return this.id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getBankID() {return this.bankID;}

    public void setBankID(Integer bankID) {this.bankID = bankID;}

    public Integer getUserID() {return this.userID;}

    public void setUserID(Integer userID) {this.userID = userID;}

    public Integer getPayAccID() {return this.payAccID;}

    public void setPayAccID(Integer payAccID) {this.payAccID = payAccID;}

    public Integer getEmployeeID() {return this.employeeID;}

    public void setEmployeeID(Integer employeeID) {this.employeeID = employeeID;}

    public String getStartDate() {return this.startDate;}

    public void setStartDate(String startDate) {this.startDate = startDate;}

    public String getEndDate() {return this.endDate;}

    public void setEndDate(String endDate) {this.endDate = endDate;}

    public Integer getCountMonth() {return this.countMonth;}

    public void setEndDate(Integer countMonth) {this.countMonth = countMonth;}

    public double getSum() {return this.sum;}

    public void setSum(double sum) {this.sum = sum;}

    public double getMonthlyAmount() {return this.monthlyPay;}

    public void setMonthlyPay(double monthlyPay) {this.monthlyPay = monthlyPay;}

    public int getInterestRate() {return this.interestRate;}

    public void setInterestRate(int interestRate) {this.interestRate = interestRate;}
}