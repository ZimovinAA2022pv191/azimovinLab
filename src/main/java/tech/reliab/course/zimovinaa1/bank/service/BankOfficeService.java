package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;
import tech.reliab.course.zimovinaa1.bank.entity.Employee;

import java.nio.DoubleBuffer;

public interface BankOfficeService {

    BankOffice createOffice(Bank bank, Integer id, String name, String address, String status,
                                   Boolean canSetAtm, Boolean canTakeCredit, Boolean canGiveMoney,
                                   Boolean canDepositMoney, Double cost);

    void addEmployer(BankOffice bankOffice, int idEmp, Employee employee);

    BankOffice readOffice(BankOffice office);

    void updateOfficeStatusOfWorking(BankOffice office, String status);

    void updateOfficeStatusOfSetATM(BankOffice office, Boolean canSetATM);

    void delete(BankOffice bankOffice);
}
