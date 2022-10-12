package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;
import tech.reliab.course.zimovinaa1.bank.entity.Employee;
import tech.reliab.course.zimovinaa1.bank.service.EmployeeService;

import java.util.Date;

public class EmployeeImpl implements EmployeeService {
    public EmployeeImpl(){}

    @Override
    public Employee createEmployee(Bank bank, BankOffice office, int id,
                                   String firstName, String lastname, String patronymic, Date dateBirth, String post,
                                   Boolean canWorkDistance, Boolean canGiveCredit, int salary) {
        bank.setCountEmployee(bank.getCountEmployee() + 1);
        return new Employee(bank, office, id, firstName, lastname, patronymic, dateBirth, post,
                canWorkDistance, canGiveCredit, salary);
    }

    @Override
    public void readEmployee(Employee employee) {
        System.out.println(employee);
    }

    @Override
    public void updateEmployeeDistant(Employee employee, Boolean canWorkDistance) {
        employee.setCanWorkDistance(canWorkDistance);
    }

    @Override
    public void updateEmployeeGiving(Employee employee, Boolean canGiveCredite) {
        employee.setCanGiveCredite(canGiveCredite);
    }

}
