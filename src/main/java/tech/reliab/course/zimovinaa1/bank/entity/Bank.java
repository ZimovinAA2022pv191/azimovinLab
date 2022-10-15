package tech.reliab.course.zimovinaa1.bank.entity;


import java.util.Random;

public class Bank {
    private String name;             //название
    private Integer id;                 //ID банка
    private Integer countOffice;       //кол-во офисов
    private Integer countAtm;          //кол-во банкоматов
    private Integer countEmployee;     //кол-во работников
    private Integer countClient;       //кол-во клиентов
    private Integer rate;               //рейтинг 0-100
    private Double money;              //кол-во денег не больше 1 000 000
    private Double percentage;         //процентная ставка <=20%


    public Bank(String name, Integer id)
    {
        this.setName(name);
        this.setId(id);
        this.setCountOffice(0);
        this.setCountAtm(0);
        this.setCountEmployee(0);
        this.setCountClient(0);
        Random rand = new Random();
        this.setRate(rand.nextInt(0, 100));
        this.setMoney(rand.nextDouble(0, 1000000));
        this.setPercentage(rand.nextDouble(1, 20));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountOffice() {
        return countOffice;
    }

    public void setCountOffice(Integer countOffice) {
        this.countOffice = countOffice;
    }

    public Integer getCountAtm() {
        return countAtm;
    }

    public void setCountAtm(Integer countAtm) {
        this.countAtm = countAtm;
    }

    public Integer getCountEmployee() {
        return countEmployee;
    }

    public void setCountEmployee(Integer countEmployee) {
        this.countEmployee = countEmployee;
    }

    public Integer getCountClient() {
        return countClient;
    }

    public void setCountClient(Integer countClient) {
        this.countClient = countClient;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", countOffice=" + countOffice +
                ", countAtm=" + countAtm +
                ", countEmployee=" + countEmployee +
                ", countClient=" + countClient +
                ", rate=" + rate +
                ", money=" + money +
                ", percentage=" + percentage +
                '}';
    }
}
