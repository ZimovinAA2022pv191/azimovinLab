package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;

public interface BankService {


    Bank createBank(String name, Integer id, Double percentage);
    Bank readBank(Bank bank);

    void addOfficeBank(Bank bank, int id, BankOffice bankOffice);

    void updateBankName(Bank bank, String name);
    void delete(Bank bank);


}
