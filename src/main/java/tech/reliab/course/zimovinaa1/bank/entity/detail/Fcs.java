package tech.reliab.course.zimovinaa1.bank.entity.detail;

public class Fcs {
    private String firstName;
    private String lastName;
    private String patronymic;

    private String date_birth; //yyyy-mm-dd

    public Fcs(String firstName, String lastName, String patronymic, String date)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.patronymic=patronymic;
        this.date_birth=date;
    }

    public String getFirstName()
    {
        return this.firstName;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public String getPatronymic()
    {
        return this.patronymic;
    }
    public String getDateBirth()
    {
        return this.date_birth;
    }

    @Override
    public String toString() {
        return "FIO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", date_birth='" + date_birth + '\'' +
                '}';
    }
}
