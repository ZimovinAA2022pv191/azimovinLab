package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankAtm;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;
import tech.reliab.course.zimovinaa1.bank.entity.Employee;

import java.time.LocalTime;
import java.util.Date;

public interface EmployeeService {

    Employee createEmployee(Bank bank, BankOffice office, Integer id,
                            String firstName, String lastname, String patronymic, LocalTime dateBirth, String post,
                            Boolean canWorkDistance, Boolean canGiveCredit, Double salary);

    void addAtm(Employee emp, int idAtm, BankAtm atm);

    Employee readEmployee();

    void updateEmployeeDistant(Employee employee, Boolean isDistantWorker);

    void updateEmployeeGiving(Employee employee, Boolean canGiveCredit);

    void delete(Employee emp);
}
