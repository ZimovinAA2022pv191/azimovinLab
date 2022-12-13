package tech.reliab.course.zimovinaa1.bank.entity;


import java.util.HashMap;
import java.util.Map;
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

    private final Map<Integer, BankOffice> officeMap = new HashMap<>();
    private final Map<Integer, User> userMap = new HashMap<>();

    public Bank(String name, Integer id) {
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

    public void addUserAcc(int id, User user){
        this.userMap.put(id, user);
    }

    public void addOfficeBank(int id, BankOffice bankOffice){
        this.officeMap.put(id, bankOffice);
        this.countOffice++;
    }

    public void delUserAcc(int id){
        this.userMap.remove(id);
    }

    public void delOfficeBank(int id){
        this.officeMap.remove(id);
        this.countOffice--;
    }

    public BankOffice getBankOffice(int id) {
        return this.officeMap.get(id);
    }

    public User getUserAcc(int id) {
        return this.userMap.get(id);
    }

    public Map<Integer, BankOffice> getOffices() {
        return this.officeMap;
    }

    public Map<Integer, User> getUserAccounts() {
        return this.userMap;
    }

    @Override
    public String toString() {
        String info = "Bank{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", countOffice=" + countOffice +
                ", countAtm=" + countAtm +
                ", countEmployee=" + countEmployee +
                ", countClient=" + countClient +
                ", rate=" + rate +
                ", money=" + money +
                ", percentage=" + percentage + "\n";
//        for (Map.Entry<Integer, BankOffice> office : this.officeMap.entrySet()) {
//            BankOffice bankValue = office.getValue();
//            info += bankValue + "\n";
//        }
//        for (Map.Entry<Integer, User> userAcc : this.userMap.entrySet()) {
//            User userValue = userAcc.getValue();
//            info +="\n"+ userValue + "\n";
//        }
//        info += "}";
        return info;
    }
}
