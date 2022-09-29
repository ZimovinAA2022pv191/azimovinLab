package tech.reliab.course.zimovinaa1.bank.entity;

import org.jetbrains.annotations.NotNull;
import tech.reliab.course.zimovinaa1.bank.service.BankOfficeService;

public class BankOffice implements BankOfficeService {
    private Bank bank;
    private int id;
    private String name;
    private String address="";
    private String status;
    private Boolean can_replace;
    private int count_atm;
    private Boolean give_credit;
    private Boolean can_give_money;
    private Boolean can_input_money;
    private int count_money;
    private int cost_rent;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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

    public Boolean getCan_replace() {
        return can_replace;
    }

    public void setCan_replace(Boolean can_replace) {
        this.can_replace = can_replace;
    }

    public int getCount_atm() {
        return count_atm;
    }

    public void setCount_atm(int count_atm) {
        this.count_atm = count_atm;
    }

    public Boolean getGive_credit() {
        return give_credit;
    }

    public void setGive_credit(Boolean give_credit) {
        this.give_credit = give_credit;
    }

    public Boolean getCan_give_money() {
        return can_give_money;
    }

    public void setCan_give_money(Boolean can_give_money) {
        this.can_give_money = can_give_money;
    }

    public Boolean getCan_input_money() {
        return can_input_money;
    }

    public void setCan_input_money(Boolean can_input_money) {
        this.can_input_money = can_input_money;
    }

    public int getCount_money() {
        return count_money;
    }

    public void setCount_money(int count_money) {
        this.count_money = count_money;
    }

    public int getCost_rent() {
        return cost_rent;
    }

    public void setCost_rent(int cost_rent) {
        this.cost_rent = cost_rent;
    }

    @Override
    public void addAtm(int i){
        this.count_atm+=1;
    }



    public BankOffice(String name, int id, @NotNull Bank bank, String address)
    {
        this.name=name;
        this.id=id;
        this.bank=bank;
        this.address=address;
        this.status="Работает";
        this.can_replace=true;
        this.count_atm=bank.getCountAtm();
        this.give_credit=true;
        this.can_give_money=true;
        this.can_input_money=true;
        this.count_money=bank.getMoney();
        this.cost_rent=150000;
        this.bank.addCountOffice(1);
    }

    @Override
    public String toString() {
        return "BankOffice{" +
                "\nbank=" + bank +
                ",\n id=" + id +
                ",\n name='" + name + '\'' +
                ",\n address='" + address + '\'' +
                ",\n status='" + status + '\'' +
                ",\n can_replace=" + can_replace +
                ",\n count_atm=" + count_atm +
                ",\n give_credit=" + give_credit +
                ",\n can_give_money=" + can_give_money +
                ",\n can_input_money=" + can_input_money +
                ",\n count_money=" + count_money +
                ",\n cost_rent=" + cost_rent +
                '}';
    }
}
