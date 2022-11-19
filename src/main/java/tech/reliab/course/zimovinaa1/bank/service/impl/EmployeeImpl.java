package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankAtm;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;
import tech.reliab.course.zimovinaa1.bank.entity.Employee;
import tech.reliab.course.zimovinaa1.bank.service.EmployeeService;

import java.time.LocalTime;

public class EmployeeImpl implements EmployeeService {
    private Employee emp;

    @Override
    public Employee createEmployee(Bank bank, BankOffice office, Integer id,
                                   String firstName, String lastname, String patronymic, String dateBirth, String post,
                                   Boolean canWorkDistance, Boolean canGiveCredit, Double salary) {
        emp = new Employee(bank, office, id, firstName, lastname, patronymic, dateBirth, post,
                canWorkDistance, canGiveCredit, salary);
        return emp;
    }

    @Override
    public void addAtm(Employee emp, int idAtm, BankAtm atm){
        emp.addAtm(idAtm, atm);
    }

    @Override
    public Employee readEmployee()
    {
        return emp;
    }

    @Override
    public void updateEmployeeDistant(Employee employee, Boolean canWorkDistance) {
        employee.setCanWorkDistance(canWorkDistance);
    }

    @Override
    public void updateEmployeeGiving(Employee employee, Boolean canGiveCredite) {
        employee.setCanGiveCredite(canGiveCredite);
    }

    @Override
    public void delete(Employee emp) {
        if (this.emp == emp) {
            this.emp = null;
        }
    }

}
