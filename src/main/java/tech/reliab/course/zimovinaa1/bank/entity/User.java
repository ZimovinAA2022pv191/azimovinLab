package tech.reliab.course.zimovinaa1.bank.entity;


import java.time.LocalTime;
import java.util.*;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalTime dateBirth;
    private String workPlace;
    private Double monthSalary;
    private int creditRating;

    private Map<Integer, PaymentAccount> paymentAccMap = new HashMap<>();
    private Map<Integer, CreditAccount> crediteAccMap = new HashMap<>();

    public User(int id, String firstName, String lastName, String patronymic, LocalTime dateBirth, String workPlace) {
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

    public LocalTime getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalTime dateBirth) {
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

    public void addPaymentAcc(int id, PaymentAccount payAcc) {
        Bank bank = payAcc.getBank();
        bank.setCountClient(bank.getCountClient() + 1);
        bank.addPaymentAcc(id + 12, payAcc);
        this.paymentAccMap.put(id, payAcc);
    }

    public void addCreditAcc(int id, CreditAccount creditAcc) {
        this.crediteAccMap.put(id, creditAcc);
    }

    public void delPaymentAcc(int id) {
        this.paymentAccMap.remove(id);
    }

    public void delCreditAcc(int id) {
        this.crediteAccMap.remove(id);
    }

    public PaymentAccount getPaymentAcc(int id) {
        return this.paymentAccMap.get(id);
    }

    public CreditAccount getCreditAcc(int id) {
        return this.crediteAccMap.get(id);
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

        for (Map.Entry<Integer, PaymentAccount> payAcc: this.paymentAccMap.entrySet()){
            PaymentAccount payValue = payAcc.getValue();
            info+=payValue.toString();
        }

        for (Map.Entry<Integer, CreditAccount> creditAcc: this.crediteAccMap.entrySet()){
            CreditAccount creditValue = creditAcc.getValue();
            info+=creditValue.toString();
        }
        info+="\n}";
        return info.toString();
    }
}
