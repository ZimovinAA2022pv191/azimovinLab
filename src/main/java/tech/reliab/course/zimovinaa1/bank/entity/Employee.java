package tech.reliab.course.zimovinaa1.bank.entity;

import org.jetbrains.annotations.NotNull;
import tech.reliab.course.zimovinaa1.bank.service.BankOfficeService;
import tech.reliab.course.zimovinaa1.bank.service.EmployeeService;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Employee {
    private Bank bank;
    private BankOffice bankOffice;
    private Integer id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalTime dateBirth;
    private String post;
    private String bankName;
    private Boolean canWorkDistance;
    private Boolean canGiveCredite;
    private Integer officeId;
    private Double salary;

    private Map<Integer, BankAtm> atmMap = new HashMap<>();
    private Map<Integer, PaymentAccount> paymentAccountMap = new HashMap<>();

    public Employee(Bank bank, BankOffice bankOffice, Integer id, String firstName, String lastName, String patronymic,
                    LocalTime dateBirth, String post, Boolean canWorkDistance, Boolean canGiveCredite, Double salary) {
        this.setBank(bank);
        this.setBankOffice(bankOffice);
        this.setId(id);
        this.setFirsName(firstName);
        this.setLastName(lastName);
        this.setPatronymic(patronymic);
        this.setDateBirth(dateBirth);
        this.setPost(post);
        this.setBankName();
        this.setCanWorkDistance(canWorkDistance);
        this.setCanGiveCredite(canGiveCredite);
        this.setOfficeId();
        this.setSalary(salary);
    }

    public void setOfficeId() {
        this.officeId = this.bankOffice.getId();
    }

    public int getOfficeId() {
        return this.officeId;
    }

    public void setBankName() {
        this.bankName = this.bank.getName();
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    private void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setFirsName(String firsName) {
        this.firstName = firsName;
    }

    public String getFirsName() {
        return firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setDateBirth(LocalTime dateBirth) {
        this.dateBirth = dateBirth;
    }

    public LocalTime getDateBirth() {
        return this.dateBirth;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPost() {
        return this.post;
    }

    public void setCanWorkDistance(Boolean canWorkDistance) {
        this.canWorkDistance = canWorkDistance;
    }

    public Boolean getCanWorkDistance() {
        return this.canWorkDistance;
    }

    public void setCanGiveCredite(Boolean canGiveCredite) {
        this.canGiveCredite = canGiveCredite;
    }

    public Boolean getCanGiveCredite() {
        return this.canGiveCredite;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void addAtm(int id, BankAtm atm){
        this.bank.setCountAtm(this.bank.getCountAtm()+1);
        this.atmMap.put(id, atm);
    }

    public Double getSalary() {
        return this.salary;
    }

    public void delAtm(int id) {
        this.atmMap.remove(id);
        this.bankOffice.setCountAtm(this.bankOffice.getCountAtm() - 1);
    }

    public void dellPayAcc(int id) {
        this.paymentAccountMap.remove(id);
    }

    public Map<Integer, PaymentAccount> getPaymentAccountMap() {
        return this.paymentAccountMap;
    }

    public BankAtm getAtm(int id) {
        return this.atmMap.get(id);
    }

    public PaymentAccount getCreditAccount(int id) {
        return this.paymentAccountMap.get(id);
    }

    @Override
    public String toString() {
        String info = "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateBirth=" + dateBirth +
                ", post='" + post + '\'' +
                ", bankName='" + bankName + '\'' +
                ", canWorkDistance=" + canWorkDistance +
                ", canGiveCredite=" + canGiveCredite +
                ", officeId=" + officeId +
                ", salary=" + salary +
                '\n';

        for (Map.Entry<Integer, BankAtm> atm : this.atmMap.entrySet()) {
            BankAtm value = atm.getValue();
            info += value.toString();
        }
        for (Map.Entry<Integer, PaymentAccount> payment : this.paymentAccountMap.entrySet()) {
            PaymentAccount payValue = payment.getValue();
            info += payValue.toString();
        }
        info += "}\n";
        return info;
    }
}
