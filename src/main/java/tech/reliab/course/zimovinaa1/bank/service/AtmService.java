package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankAtm;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;

public interface AtmService {

    BankAtm createAtm(Bank bank, BankOffice office, Integer id, String name, String status, Integer employeeId,
                      Boolean canGiveMoney, Boolean canDepositMoney);

    BankAtm readAtm(BankAtm atm);
    void updateATMStatusOfWorking(BankAtm atm, String status);
    void updateATMStatusOfGiving(BankAtm atm, Boolean canGiveMoney);
    void updateATMStatusOfDeposit(BankAtm atm, Boolean canDepositMoney);
    Boolean updateATMMoney(BankAtm atm, Bank bank, int money);

    void delete(BankAtm bankAtm);
}
