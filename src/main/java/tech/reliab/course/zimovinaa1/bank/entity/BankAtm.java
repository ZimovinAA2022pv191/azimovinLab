package tech.reliab.course.zimovinaa1.bank.entity;

import org.jetbrains.annotations.NotNull;
import tech.reliab.course.zimovinaa1.bank.service.AtmService;

public class BankAtm implements AtmService {
    private int id;
    private String name;
    private String address;
    private String status;
    private BankOffice bankOffice;
    private Bank bank;
    private String AtmLocation;
    private Employee engineer;
    private Boolean canGiveMoney;
    private int count_money;
    private int count_service;

    public BankAtm(String name, int id, @NotNull Bank bank, @NotNull BankOffice bankOffice, @NotNull Employee en)
    {
        this.name = name;
        this.id = id;
        this.address=bankOffice.getAddress();
        this.status = "Работает";
        this.bank = bank;
        this.bankOffice=bankOffice;
        this.AtmLocation=bankOffice.getAddress();
        this.engineer=en;
        this.canGiveMoney=true;
        this.count_money=bank.getMoney();
        this.count_service=125000;
        this.bankOffice.addAtm(1);
        this.bank.addCountAtm(1);
    }

    @Override
    public void collectionToBank()
    {
        this.bank.addMoney(this.count_money);
    }
    @Override
    public String toString() {
        return "BankAtm{" +
                "\nid=" + id +
                ",\n name='" + name + '\'' +
                ",\n address='" + address + '\'' +
                ",\n status='" + status + '\'' +
                ",\n bankOffice=" + bankOffice +
                ",\n bank=" + bank +
                ",\n AtmLocation='" + AtmLocation + '\'' +
                ",\n engineer=" + engineer +
                ",\n canGiveMoney=" + canGiveMoney +
                ",\n count_money=" + count_money +
                ",\n count_service=" + count_service +
                '}';
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

    public int getBankOffice() {
        return bankOffice.getId();
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public int getBank() {
        return bank.getId();
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getAtmLocation() {
        return AtmLocation;
    }

    public void setAtmLocation(String atmLocation) {
        AtmLocation = atmLocation;
    }

    public int getEngineer() {
        return engineer.getId();
    }

    public void setEngineer(Employee engineer) {
        this.engineer = engineer;
    }

    public Boolean getCanGiveMoney() {
        return canGiveMoney;
    }

    public void setCanGiveMoney(Boolean canGiveMoney) {
        this.canGiveMoney = canGiveMoney;
    }

    public int getCount_money() {
        return count_money;
    }

    public void setCount_money(int count_money) {
        this.count_money = count_money;
    }

    public int getCount_service() {
        return count_service;
    }

    public void setCount_service(int count_service) {
        this.count_service = count_service;
    }
}
