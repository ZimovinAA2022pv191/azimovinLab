package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.service.BankService;

public class BankImpl implements BankService {

    public BankImpl(){}

    @Override
    public Bank createBank(String name, int id)
    {
        return new Bank(name, id);
    }

    @Override
    public void readBank(Bank bank) {
        System.out.println(bank);
    }

    @Override
    public void updateBankName(Bank bank, String name) {
        bank.setName(name);
    }

}
