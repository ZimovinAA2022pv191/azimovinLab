package tech.reliab.course.zimovinaa1.bank.entity;

import org.jetbrains.annotations.NotNull;
import tech.reliab.course.zimovinaa1.bank.service.BankOfficeService;

import java.util.HashMap;
import java.util.Map;

public class BankOffice {

    private Bank bank;
    private Integer id;
    private String name;
    private String address;
    private String status;
    private Boolean canSetAtm;
    private Integer countAtm;
    private Boolean canTakeCredit;
    private Boolean canGiveMoney;
    private Boolean canDepositMoney;
    private double money;
    private double cost;

    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public BankOffice(Bank bank, int id, String name, String address, String status, Boolean canSetAtm,
                      Boolean canTakeCredit, Boolean canGiveMoney, Boolean canDepositMoney, Double money, Double cost)
    {
        this.bank = bank;
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

    public void delete_employer(int id){
        this.bank.setCountEmployee(this.bank.getCountEmployee()-1);
        this.employeeMap.remove(id);
    }

    public void addEmployer(int id, Employee emp){
        this.bank.setCountEmployee(this.bank.getCountEmployee()+1);
        this.employeeMap.put(id, emp);
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

    public void setCountAtm(int countAtm) {
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        String info = "BankOffice{" +
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
                '}' + '\n';

        for (Map.Entry<Integer, Employee> employee : this.employeeMap.entrySet()) {
            Employee employeeValue = employee.getValue();
            info += employeeValue + "\n";
        }
        return info;
    }
}
