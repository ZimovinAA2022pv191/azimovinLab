package tech.reliab.course.zimovinaa1.bank.entity;


import tech.reliab.course.zimovinaa1.bank.entity.JsonClasses.JsonPayAcc;

public class PaymentAccount{
    private User user;
    private Bank bank;
    private Integer id;
    private String userName;
    private String bankName;
    private Double money;


    public PaymentAccount(Bank bank, User user, Integer id)
    {
        this.setBank(bank);
        this.setUser(user);
        this.setIdPayAcc(id);
        this.setBankName();
        this.setUserName();
        this.setMoney(0.0);
    }
    public PaymentAccount(){}
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.bank.addUserAcc(this.user);
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Integer getIdPayAcc() {
        return id;
    }

    public void setIdPayAcc(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName() {
        this.userName =this.user.getLastName() + this.user.getFirstName() + this.user.getPatronymic();
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName() {
        this.bankName = this.bank.getName();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + id +
                ", FirstName='" + user.getFirstName() + '\'' +
                ", LastName='" + user.getLastName() + '\'' +
                ", Patronymic='" + user.getPatronymic() + '\'' +
                ", bankName='" + bankName + '\'' +
                ", money=" + money +
                '}';
    }

    public void updateFromJsonClass(JsonPayAcc jsonPayAcc) {
        this.setIdPayAcc(jsonPayAcc.getId());
        this.getBank().setId(jsonPayAcc.getBankID());
        this.getUser().setId(jsonPayAcc.getUserID());
        this.setMoney(jsonPayAcc.getBalance());
    }
}
