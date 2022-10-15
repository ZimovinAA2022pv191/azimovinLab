package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankAtm;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;
import tech.reliab.course.zimovinaa1.bank.service.AtmService;

import java.util.Random;

public class AtmImpl implements AtmService {

    private BankAtm atm;

    @Override
    public BankAtm createAtm(Bank bank, BankOffice office, Integer id, String name, String status, Integer employeeId,
                             Boolean canGiveMoney, Boolean canDepositMoney)
    {
        bank.setCountAtm(bank.getCountAtm() + 1);
        Random random = new Random();
        atm = new BankAtm(office, id, name, status, employeeId, canGiveMoney, canDepositMoney, bank.getMoney(),
                random.nextDouble(1000.0, 3000.0));
        return atm;
    }

    @Override
    public BankAtm readAtm(BankAtm atm) {
        return atm;
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
    public Boolean updateATMMoney(BankAtm atm, Bank bank, int money) {
        if (bank.getMoney() > money){
            atm.setMoney(money);
            return true;
        }
        else return false;
    }

    @Override
    public void delete(BankAtm bankAtm) {
        if (this.atm == bankAtm) {
            this.atm = null;
        }
    }
}
