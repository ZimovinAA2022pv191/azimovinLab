package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;

public interface BankOfficeService {

    public BankOffice createOffice(Bank bank, Integer id, String name, String address, String status,
                                   Boolean canSetAtm, Boolean canTakeCredit, Boolean canGiveMoney,
                                   Boolean canDepositMoney, int cost);

    void readOffice(BankOffice office);

    void updateOfficeStatusOfWorking(BankOffice office, String status);

    void updateOfficeStatusOfSetATM(BankOffice office, Boolean canSetATM);
}
