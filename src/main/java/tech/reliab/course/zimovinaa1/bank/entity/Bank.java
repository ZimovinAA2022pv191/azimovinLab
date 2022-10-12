package tech.reliab.course.zimovinaa1.bank.entity;

import java.util.Random;

public class Bank {
    private String name;             //название
    private int id;                 //ID банка
    private int count_office;       //кол-во офисов
    private int count_atm;          //кол-во банкоматов
    private int count_employee;     //кол-во работников
    private int count_client;       //кол-во клиентов
    private int rate;               //рейтинг 0-100
    private int money;              //кол-во денег не больше 1 000 000
    private int percentage;         //процентная ставка <=20%


    public Bank(String name, int id) {
        this.setName(name);
        this.setId(id);
        this.setCountOffice(0);
        this.setCountAtm(0);
        this.setCountEmployee(0);
        this.setCountClient(0);
        Random rand = new Random();
        this.setRate(rand.nextInt(0, 100));
        this.setMoney(rand.nextInt(0, 1000000));
        this.setPercentage(rand.nextInt(1, 20));
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountOffice() {
        return count_office;
    }

    public void setCountOffice(int count_office) {
        this.count_office = count_office;
    }

    public int getCountAtm() {
        return count_atm;
    }

    public void setCountAtm(int count_atm) {
        this.count_atm = count_atm;
    }

    public int getCountEmployee() {
        return count_employee;
    }

    public void setCountEmployee(int count_employee) {
        this.count_employee = count_employee;
    }

    public int getCountClient() {
        return count_client;
    }

    public void setCountClient(int count_client) {
        this.count_client = count_client;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", count_office=" + count_office +
                ", count_atm=" + count_atm +
                ", count_employee=" + count_employee +
                ", count_client=" + count_client +
                ", rate=" + rate +
                ", money=" + money +
                ", percentage=" + percentage +
                '}';
    }
}
