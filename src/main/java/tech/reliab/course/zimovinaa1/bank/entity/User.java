package tech.reliab.course.zimovinaa1.bank.entity;


import java.util.Date;
import java.util.Random;

public class User{
    private int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Date dateBirth;
    private String workPlace;
    private int monthSalary;
    private int creditRating;

    public User(int id, String firstName, String lastName, String patronymic,Date dateBirth, String workPlace)
    {
        this.setUserId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPatronymic(patronymic);
        this.setDateBirth(dateBirth);
        this.setWorkPlace(workPlace);
        Random rand = new Random();
        this.monthSalary = rand.nextInt(1,100000);
        this.setCreditRating(rand.nextInt(50,100));

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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public int getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateBirth=" + dateBirth +
                ", workPlace='" + workPlace + '\'' +
                ", monthSalary=" + monthSalary +
                ", creditRating=" + creditRating +
                '}';
    }
}
