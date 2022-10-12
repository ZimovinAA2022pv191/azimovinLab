package tech.reliab.course.zimovinaa1.bank.entity;

import org.jetbrains.annotations.NotNull;
import tech.reliab.course.zimovinaa1.bank.entity.detail.Fcs;
import tech.reliab.course.zimovinaa1.bank.service.BankOfficeService;
import tech.reliab.course.zimovinaa1.bank.service.EmployeeService;

import java.util.Date;


public class Employee{
    private Bank bank;
    private BankOffice bankOffice;
    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Date dateBirth;
    private String post;
    private String bankName;
    private Boolean canWorkDistance;
    private Boolean canGiveCredite;
    private int officeId;
    private int salary;

    public Employee(Bank bank, BankOffice bankOffice, int id, String firstName, String lastName, String patronymic,
                    Date dateBirth, String post, Boolean canWorkDistance, Boolean canGiveCredite, int salary)
    {
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
        this.officeId=this.bankOffice.getId();
    }
    public int getOfficeId()
    {
        return this.officeId;
    }

    public void setBankName() {
        this.bankName=this.bank.getName();
    }

    public String getBankName()
    {
        return this.bankName;
    }

    public void setBank(Bank bank)
    {
        this.bank = bank;
    }

    public void setBankOffice(BankOffice bankOffice)
    {
        this.bankOffice=bankOffice;
    }

    private void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;
    }

    public void setFirsName(String firsName) {
        this.firstName = firsName;
    }

    public String getFirsName() {
        return firstName;
    }

    public String getFirstName()
    {
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

    public void setDateBirth(Date dateBirth)
    {
        this.dateBirth=dateBirth;
    }

    public Date getDateBirth()
    {
        return this.dateBirth;
    }
    public void setPost(String post)
    {
        this.post=post;
    }

    public String getPost()
    {
        return this.post;
    }

    public void setCanWorkDistance(Boolean canWorkDistance)
    {
        this.canWorkDistance=canWorkDistance;
    }

    public Boolean getCanWorkDistance()
    {
        return this.canWorkDistance;
    }

    public void setCanGiveCredite(Boolean canGiveCredite)
    {
        this.canGiveCredite=canGiveCredite;
    }

    public Boolean getCanGiveCredite()
    {
        return this.canGiveCredite;
    }

    public void setSalary(int salary)
    {
        this.salary=salary;
    }

    public int getSalary()
    {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
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
                '}';
    }
}
