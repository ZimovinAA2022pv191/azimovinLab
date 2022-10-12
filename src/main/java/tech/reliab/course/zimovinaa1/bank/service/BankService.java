package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;

public interface BankService {


    Bank createBank(String name, int id);
    public void readBank(Bank bank);
    public void updateBankName(Bank bank, String name);


}
