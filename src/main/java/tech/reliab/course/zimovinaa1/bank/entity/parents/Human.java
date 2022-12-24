package tech.reliab.course.zimovinaa1.bank.entity.parents;

public class Human {
    private Integer id;
    private String name;
    private String surname;
    private String middleName;
    private String birthDay;

    public Human(Integer id, String name, String lastname, String midName, String birthDay) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = midName;
        this.birthDay = birthDay;
    }

    public String getFullName() {
        if (middleName != null)
            return name + " " + surname + " " + middleName;
        else
            return name + " " + surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}