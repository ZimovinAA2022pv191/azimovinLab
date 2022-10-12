package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;
import tech.reliab.course.zimovinaa1.bank.entity.Employee;

import java.util.Date;

public interface EmployeeService {

    public Employee createEmployee(Bank bank, BankOffice office, int id,
                                   String firstName, String lastname, String patronymic, Date dateBirth, String post,
                                   Boolean canWorkDistance, Boolean canGiveCredit, int salary);

    void readEmployee(Employee employee);

    void updateEmployeeDistant(Employee employee, Boolean isDistantWorker);

    void updateEmployeeGiving(Employee employee, Boolean canGiveCredit);
}
