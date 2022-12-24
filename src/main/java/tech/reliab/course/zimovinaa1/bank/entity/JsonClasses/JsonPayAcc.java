package tech.reliab.course.zimovinaa1.bank.entity.JsonClasses;


import tech.reliab.course.zimovinaa1.bank.entity.PaymentAccount;

public class JsonPayAcc {
    private Integer id;
    private Integer bankID;
    private Integer userID;
    private Double balance;

    public JsonPayAcc(PaymentAccount payAcc) {
        this.id = payAcc.getIdPayAcc();
        this.bankID = payAcc.getBank().getId();
        this.userID = payAcc.getUser().getUserId();
        this.balance = payAcc.getMoney();
    }

    public Integer getId() {return this.id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getBankID() {return this.bankID;}

    public void setBankID(Integer bankID) {this.bankID = bankID;}

    public Integer getUserID() {return this.userID;}

    public void setUserID(Integer userID) {this.userID = userID;}

    public Double getBalance() {return this.balance;}

    public void setBalance(Double balance) {this.balance = balance;}
}