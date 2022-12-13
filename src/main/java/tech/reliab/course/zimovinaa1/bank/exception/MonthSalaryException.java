package tech.reliab.course.zimovinaa1.bank.exception;

public class MonthSalaryException extends Exception{
    public MonthSalaryException(){
        super("Выдача кредита невозможна. Ваша ежемесечная зарплата не соответсвутет сумме запрашиваемого кредита!");
    }
}
