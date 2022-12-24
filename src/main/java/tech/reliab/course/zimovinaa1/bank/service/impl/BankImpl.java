package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;
import tech.reliab.course.zimovinaa1.bank.service.BankService;

public class BankImpl implements BankService {

    private Bank bank;

    @Override
    public Bank createBank(String name, Integer id, Double percentage)
    {
        bank = new Bank(name, id,percentage);
        return bank;
    }

    @Override
    public Bank readBank(Bank bank)
    {
        return bank;
    }


    @Override
    public void addOfficeBank(Bank bank,BankOffice bankOffice){
        bank.addOfficeBank(bankOffice);
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
