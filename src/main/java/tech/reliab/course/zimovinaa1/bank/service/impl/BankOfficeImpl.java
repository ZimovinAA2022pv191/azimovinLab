package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;
import tech.reliab.course.zimovinaa1.bank.service.BankOfficeService;

public class BankOfficeImpl implements BankOfficeService {
    public BankOfficeImpl(){}

    @Override
    public BankOffice createOffice(Bank bank, Integer id, String name, String address, String status,
                                   Boolean canSetAtm, Boolean canTakeCredit, Boolean canGiveMoney,
                                   Boolean canDepositMoney, int cost) {
        bank.setCountOffice(bank.getCountOffice() + 1);
        int money = bank.getMoney();
        return new BankOffice(id, name, address, status, canSetAtm, canTakeCredit, canGiveMoney,
                canDepositMoney, money, cost);
    }

    @Override
    public void readOffice(BankOffice office) {
        System.out.println(office);
    }

    @Override
    public void updateOfficeStatusOfWorking(BankOffice office, String status) {
        office.setStatus(status);
    }

    @Override
    public void updateOfficeStatusOfSetATM(BankOffice office, Boolean canSetAtm) {
        office.setCanSetAtm(canSetAtm);
    }


}
