package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankAtm;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;

public interface AtmService {
    BankAtm createAtm(Bank bank, BankOffice office, Integer id, String name, String status, Integer employeeId,
                      Boolean canGiveMoney, Boolean canDepositMoney, int money, int cost);

    public void readATM(BankAtm atm);
    public void updateATMStatusOfWorking(BankAtm atm, String status);
    public void updateATMStatusOfGiving(BankAtm atm, Boolean canGiveMoney);
    public void updateATMStatusOfDeposit(BankAtm atm, Boolean canDepositMoney);
    public boolean updateATMMoney(BankAtm atm, Bank bank, int money);
}
