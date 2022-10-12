package tech.reliab.course.zimovinaa1.bank.entity;


public class PaymentAccount{
    private User user;
    private Bank bank;
    private int id;
    private String userName;
    private String bankName;
    private int money;


    public PaymentAccount(Bank bank, User user, int id)
    {
        this.setUser(user);
        this.setBank(bank);
        this.setIdPayAcc(id);
        this.setBankName();
        this.setUserName();
        this.setMoney(0);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int getIdPayAcc() {
        return id;
    }

    public void setIdPayAcc(int id) {
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "PaymentAccount{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", bankName='" + bankName + '\'' +
                ", money=" + money +
                '}';
    }
}
