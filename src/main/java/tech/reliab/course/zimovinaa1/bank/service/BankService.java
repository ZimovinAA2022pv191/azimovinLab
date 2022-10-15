package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;

public interface BankService {


    Bank createBank(String name, Integer id);
    Bank readBank();
    void updateBankName(Bank bank, String name);
    void delete(Bank bank);


}
