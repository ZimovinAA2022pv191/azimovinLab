package tech.reliab.course.zimovinaa1.bank.entity;


import tech.reliab.course.zimovinaa1.bank.entity.parents.Human;

import java.time.LocalTime;
import java.util.*;

public class User extends Human {
    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String dateBirth;
    private String workPlace;
    private Double monthSalary;
    private int creditRating;

    private ArrayList<PaymentAccount> paymentAccMap = new ArrayList<>();
    private ArrayList<CreditAccount> crediteAccMap = new ArrayList<>();

    public User(int id, String firstName, String lastName, String patronymic, String dateBirth, String workPlace) {
        super(id, firstName, lastName,patronymic, dateBirth);
        this.setUserId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPatronymic(patronymic);
        this.setDateBirth(dateBirth);
        this.setWorkPlace(workPlace);
        Random rand = new Random();
        this.monthSalary = rand.nextDouble(1, 100000);
        this.setCreditRating(rand.nextInt(50, 100));

    }
    public User(int id, String firstName, String lastName, String patronymic, String dateBirth, String workPlace, Double salary) {
        super(id, firstName, lastName,patronymic, dateBirth);
        this.setUserId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPatronymic(patronymic);
        this.setDateBirth(dateBirth);
        this.setWorkPlace(workPlace);
        Random rand = new Random();
        this.monthSalary = salary;
        this.setCreditRating(rand.nextInt(50, 100));
    }

    public int getUserId() {
        return id;
    }

    public void setUserId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public Double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(Double monthSalary) {
        this.monthSalary = monthSalary;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    public void addPaymentAcc(int id, PaymentAccount payAcc, User user) {
        Bank bank = payAcc.getBank();
        bank.setCountClient(bank.getCountClient() + 1);
        bank.addUserAcc(user);
        this.paymentAccMap.add(payAcc);
    }

    public void setPaymentAccs(ArrayList<PaymentAccount> paymentAccs){
        this.paymentAccMap = paymentAccs;
    }

    public void setCreditAccs(ArrayList<CreditAccount> creditAccs){
        this.crediteAccMap = creditAccs;
    }
    public void addCreditAcc(CreditAccount creditAccount){
        this.crediteAccMap.add(creditAccount);
    }

    public void setCreditAcc(CreditAccount creditAcc) {
        this.crediteAccMap.add(creditAcc);
    }

    public void delPaymentAcc(int id) {
        this.paymentAccMap.remove(id);
    }

    public void delCreditAcc(int id) {
        this.crediteAccMap.remove(id);
    }

    public ArrayList<PaymentAccount> getPaymentAccs() {
        return this.paymentAccMap;
    }

    public PaymentAccount getPaymentAcc(){
        return this.paymentAccMap.get(id);
    }

    public CreditAccount getCreditAcc(){
        return this.crediteAccMap.get(this.getUserId());
    }

    public ArrayList<CreditAccount> getCreditAccs() {
        return this.crediteAccMap;
    }

    @Override
    public String toString() {
        String info = "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateBirth=" + dateBirth +
                ", workPlace='" + workPlace + '\'' +
                ", monthSalary=" + monthSalary +
                ", creditRating=" + creditRating +
                "\n";
        return info;
    }
}
