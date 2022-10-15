package tech.reliab.course.zimovinaa1.bank.entity;

import org.jetbrains.annotations.NotNull;
import tech.reliab.course.zimovinaa1.bank.service.AtmService;

public class BankAtm{
    private BankOffice office;
    private Integer id;
    private String name;
    private String status;
    private String address;
    private Integer employeeId;
    private Boolean canGiveMoney;
    private Boolean canDepositMoney;
    private Double money;
    private Double cost;

    public BankAtm(BankOffice office, int id, String name, String status, int employeeId,
                   Boolean canGiveMoney, Boolean canDepositMoney, double money, double cost)
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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(double cost) {
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
