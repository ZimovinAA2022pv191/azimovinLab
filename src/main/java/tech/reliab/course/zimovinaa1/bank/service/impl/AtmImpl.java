package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankAtm;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;
import tech.reliab.course.zimovinaa1.bank.service.AtmService;

public class AtmImpl implements AtmService {

    public AtmImpl() {
    }

    @Override
    public BankAtm createAtm(Bank bank, BankOffice office, Integer id, String name, String status, Integer employeeId,
                             Boolean canGiveMoney, Boolean canDepositMoney, int money, int cost)
    {
        bank.setCountAtm(bank.getCountAtm() + 1);
        return new BankAtm(office, id, name, status, employeeId, canGiveMoney, canDepositMoney, money, cost);
    }

    @Override
    public void readATM(BankAtm atm) {
        System.out.println(atm);
    }

    @Override
    public void updateATMStatusOfWorking(BankAtm atm, String status) {
        atm.setStatus(status);
    }

    @Override
    public void updateATMStatusOfGiving(BankAtm atm, Boolean canGiveMoney) {
        atm.setCanGiveMoney(canGiveMoney);
    }

    @Override
    public void updateATMStatusOfDeposit(BankAtm atm, Boolean canDepositMoney) {
        atm.setCanDepositMoney(canDepositMoney);
    }

    @Override
    public boolean updateATMMoney(BankAtm atm, Bank bank, int money) {
        if (bank.getMoney() > money){
            atm.setMoney(money);
            return true;
        }
        else return false;
    }
}
