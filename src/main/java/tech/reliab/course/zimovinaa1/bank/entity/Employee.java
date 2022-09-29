package tech.reliab.course.zimovinaa1.bank.entity;

import org.jetbrains.annotations.NotNull;
import tech.reliab.course.zimovinaa1.bank.entity.detail.FIO;
import tech.reliab.course.zimovinaa1.bank.service.EmployeeService;


public class Employee implements EmployeeService {
    private int id;
    private FIO fio;
    private String post;
    private Bank bank;
    private Boolean work_distance;
    private BankOffice bankOffice;
    private Boolean can_give_credit;
    private float salary;

    public Employee(int id, @NotNull Bank bank,@NotNull FIO fio, String post,
                    Boolean work_distance, BankOffice bankOffice, Boolean can_give_credit, float salary) {
        this.id = id;
        this.fio = fio;
        this.post = post;
        this.bank = bank;
        this.work_distance = work_distance;
        this.bankOffice = bankOffice;
        this.can_give_credit = can_give_credit;
        this.salary = salary;
        this.bank.addCountEmployee(1);
    }

    @Override
    public void changeSalary(float newSalary)
    {
        this.salary=newSalary;
    }
    public int getId() {
        return id;
    }

    public FIO getFio() {
        return fio;
    }

    public String getPost() {
        return post;
    }

    public Boolean getWorkDistance() {
        return work_distance;
    }

    public Boolean getCanGiveCredit() {
        return can_give_credit;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fio=" + fio +
                ", post='" + post + '\'' +
                ", work_distance=" + work_distance +
                ", salary=" + salary +
                ", can_give_credit=" + can_give_credit +
                ",\n bank=" + bank +
                ",\n bankOffice=" + bankOffice +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFio(FIO fio) {
        this.fio = fio;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setWorkDistance(Boolean work_distance) {
        this.work_distance = work_distance;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public void setCanGiveCredit(Boolean can_give_credit) {
        this.can_give_credit = can_give_credit;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
