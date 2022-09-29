package tech.reliab.course.zimovinaa1.bank.entity;

import tech.reliab.course.zimovinaa1.bank.entity.detail.FIO;
import tech.reliab.course.zimovinaa1.bank.service.UserService;

public class User implements UserService {
    private int id_client;
    private FIO fio;
    private String place_work;
    private float salary;
    private Bank bank;
    private CreditAccount credit_account;
    private PaymentAccount pay_account;
    private int rate;


    public User(int id_client, FIO fio, String place_work, float salary, Bank bank) {
        this.id_client = id_client;
        this.fio = fio;
        this.place_work = place_work;
        this.salary = salary;
        this.bank = bank;
        this.credit_account = null;
        this.pay_account = null;
        this.bank.addCountClient(1);
        calc_rate();
    }

    @Override
    public void addPaymentAccount()
    {
        this.pay_account = new PaymentAccount(this.id_client+1,this, this.bank.getName());
    }
    @Override
    public void addCreditAccount(String date_start, String date_end, int count_mount, float sum_credit, float month_pay,
                                 int percentage, Employee employee)
    {
        this.credit_account = new CreditAccount(this.id_client+1,this, this.bank,date_start, date_end,
                count_mount, sum_credit, month_pay, percentage, employee);
    }
    @Override
    public void calc_rate()
    {
        if (this.salary<1000)
        {
            this.rate=100;
        }
        if (this.salary>=1000 || this.salary<=2000)
        {
            this.rate=200;
        }
        if (this.salary>=2000 || this.salary<=3000)
        {
            this.rate=300;
        }
        if (this.salary>=3000 || this.salary<=4000)
        {
            this.rate=400;
        }
        if (this.salary>=4000 || this.salary<=5000)
        {
            this.rate=500;
        }
        if (this.salary>=5000 || this.salary<=6000)
        {
            this.rate=600;
        }
        if (this.salary>=6000 || this.salary<=7000)
        {
            this.rate=700;
        }
        if (this.salary>=7000 || this.salary<=8000)
        {
            this.rate=800;
        }
        if (this.salary>=8000 || this.salary<=9000)
        {
            this.rate=900;
        }
        if (this.salary>=9000 || this.salary<=10000)
        {
            this.rate=1000;
        }

    }
    @Override
    public void leaveBank()
    {
        this.bank=null;
    }
    public int getIdClient() {
        return id_client;
    }

    public void setIdClient(int id_client) {
        this.id_client = id_client;
    }

    public FIO getFio() {
        return fio;
    }

    public void setFio(FIO fio) {
        this.fio = fio;
    }

    public String getPlaceWork() {
        return place_work;
    }

    public void setPlaceWork(String place_work) {
        this.place_work = place_work;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }


    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
