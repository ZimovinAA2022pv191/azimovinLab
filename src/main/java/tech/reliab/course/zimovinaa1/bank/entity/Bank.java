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

    @Override
    public int rnd(int max) {

        return (int) (Math.random() * ++max);
    }

    @Override
    public void calc_percent() {
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

    public int getCountAtm()
    {
        return this.count_atm;
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

    @Override
    public void addMoney(int x)
    {
        this.money+=x;
    }
    @Override
    public void addCountOffice(int i){
        this.count_office+=1;
    }
    @Override
    public void addCountAtm(int i){
        this.count_atm+=1;
    }
    @Override
    public void addCountClient(int i){
        this.count_client+=1;
    }
    @Override
    public void addCountEmployee(int i)
    {
        this.count_employee+=1;
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

    public int getCount_office() {
        return count_office;
    }

    public void setCount_office(int count_office) {
        this.count_office = count_office;
    }

    public int getCount_atm() {
        return count_atm;
    }

    public void setCount_atm(int count_atm) {
        this.count_atm = count_atm;
    }

    public int getCount_employee() {
        return count_employee;
    }

    public void setCount_employee(int count_employee) {
        this.count_employee = count_employee;
    }

    public int getCount_client() {
        return count_client;
    }

    public void setCount_client(int count_client) {
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
}
