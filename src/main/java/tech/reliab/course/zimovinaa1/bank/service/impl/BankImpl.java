package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.service.BankService;

public class BankImpl implements BankService {

    private Bank bank;

    @Override
    public Bank createBank(String name, Integer id)
    {
        bank = new Bank(name, id);
        return bank;
    }

    @Override
    public Bank readBank()
    {
        return bank;
    }

    @Override
    public void updateBankName(Bank bank, String name) {
        bank.setName(name);
    }

    @Override
    public void delete(Bank bank) {
        if (this.bank == bank) {
            this.bank = null;
        }
    }

}
