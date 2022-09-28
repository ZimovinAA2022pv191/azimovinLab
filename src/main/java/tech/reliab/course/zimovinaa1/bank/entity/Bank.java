package tech.reliab.course.zimovinaa1.bank.entity;

import tech.reliab.course.zimovinaa1.bank.service.BankService;

public class Bank implements BankService {
    private String name;             //название
    private int id;                 //ID банка
    private int count_office;       //кол-во офисов
    private int count_atm;          //кол-во банкоматов
    private int count_employee;     //кол-во работников
    private int count_client;       //кол-во клиентов
    private int rate;               //рейтинг 0-100
    private int money;              //кол-во денег не больше 1 000 000
    private int percentage;         //процентная ставка <=20%

    private static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }

    private void calc_percent() {
        if (this.rate >= 1 & this.rate <= 20)
            this.percentage = 20;
        if (this.rate >= 21 & this.rate <= 40)
            this.percentage = 17;
        if (this.rate >= 40 & this.rate <= 60)
            this.percentage = 14;
        if (this.rate >= 61 & this.rate <= 80)
            this.percentage = 11;
        if (this.rate >= 81 & this.rate <= 100)
            this.percentage = 8;
    }

    public Bank(String name, int id) {
        this.name = name;
        this.id = id;
        this.count_office = 0;
        this.count_atm = 0;
        this.count_employee = 0;
        this.count_client = 0;
        this.rate = rnd(100);
        this.money = rnd(1000000);
        this.calc_percent();
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

    public void updateBank(String name, int id, int count_office, int count_atm,
                           int count_employee, int count_client, int rate, int money, int percentage) {
        this.name = name;
        this.id = id;
        this.count_office = count_office;
        this.count_atm = count_atm;
        this.count_employee = count_employee;
        this.count_client = count_client;
        this.rate = rate;
        this.money = money;
        this.percentage = percentage;
    }
}
