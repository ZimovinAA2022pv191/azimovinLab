package tech.reliab.course.zimovinaa1.bank.entity;

import org.jetbrains.annotations.NotNull;
import tech.reliab.course.zimovinaa1.bank.service.BankOfficeService;

public class BankOffice {
    private Integer id;
    private String name;
    private String address;
    private String status;
    private Boolean canSetAtm;
    private Integer countAtm;
    private Boolean canTakeCredit;
    private Boolean canGiveMoney;
    private Boolean canDepositMoney;
    private int money;
    private int cost;

    public BankOffice(int id, String name, String address, String status, Boolean canSetAtm,
                      Boolean canTakeCredit, Boolean canGiveMoney, Boolean canDepositMoney, int money, int cost)
    {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setStatus(status);
        this.setCanSetAtm(canSetAtm);
        this.setCountAtm(0);
        this.setCanDepositMoney(canDepositMoney);
        this.setCanTakeCredit(canTakeCredit);
        this.setCanGiveMoney(canGiveMoney);
        this.setMoney(money);
        this.setCost(cost);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCanSetAtm() {
        return canSetAtm;
    }

    public void setCanSetAtm(Boolean canSetAtm) {
        this.canSetAtm = canSetAtm;
    }

    public Integer getCountAtm() {
        return countAtm;
    }

    public void setCountAtm(Integer countAtm) {
        this.countAtm = countAtm;
    }

    public Boolean getCanTakeCredit() {
        return canTakeCredit;
    }

    public void setCanTakeCredit(Boolean canTakeCredit) {
        this.canTakeCredit = canTakeCredit;
    }

    public Boolean getCanGiveMoney() {
        return canGiveMoney;
    }

    public void setCanGiveMoney(Boolean canGiveMoney) {
        this.canGiveMoney = canGiveMoney;
    }

    public Boolean getCanDepositMoney() {
        return canDepositMoney;
    }

    public void setCanDepositMoney(Boolean canDepositMoney) {
        this.canDepositMoney = canDepositMoney;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BankOffice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", canSetAtm=" + canSetAtm +
                ", countAtm=" + countAtm +
                ", canTakeCredit=" + canTakeCredit +
                ", canGiveMoney=" + canGiveMoney +
                ", canDepositMoney=" + canDepositMoney +
                ", money=" + money +
                ", cost=" + cost +
                '}';
    }
}
