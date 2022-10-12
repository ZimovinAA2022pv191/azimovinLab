package tech.reliab.course.zimovinaa1.bank.entity;

import org.jetbrains.annotations.NotNull;
import tech.reliab.course.zimovinaa1.bank.service.AtmService;

public class BankAtm{
    private BankOffice office;
    private int id;
    private String name;
    private String status;
    private String address;
    private int employeeId;
    private Boolean canGiveMoney;
    private Boolean canDepositMoney;
    private int money;
    private int cost;

    public BankAtm(BankOffice office, int id, String name, String status, int employeeId,
                   Boolean canGiveMoney, Boolean canDepositMoney, int money, int cost)
    {
        setOffice(office);
        setId(id);
        setName(name);
        setStatus(status);
        setEmployeeId(employeeId);
        setAddress();
        setCanGiveMoney(canGiveMoney);
        setCanDepositMoney(canDepositMoney);
        setMoney(money);
        setCost(cost);
    }

    public BankOffice getOffice() {
        return office;
    }

    public void setOffice(BankOffice office) {
        this.office = office;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        this.address = office.getAddress();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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
        return ("Atm{"+
                "id=" + getId() +
                ", name='" + getName() +
                ", status='" + getStatus() +
                ", address='" + getAddress() +
                ", employeeId=" + getEmployeeId() +
                ", canGiveMoney=" + getCanGiveMoney() +
                ", canDepositMoney=" + getCanDepositMoney() +
                ", money=" + getMoney() +
                ", cost=" + getCost() + "}"
        );
    }
}
