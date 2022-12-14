package tech.reliab.course.zimovinaa1.bank.service.impl;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.BankOffice;
import tech.reliab.course.zimovinaa1.bank.entity.Employee;
import tech.reliab.course.zimovinaa1.bank.service.BankOfficeService;

public class BankOfficeImpl implements BankOfficeService {
    private BankOffice office;

    @Override
    public BankOffice createOffice(Bank bank, Integer id, String name, String address, String status,
                                   Boolean canSetAtm, Boolean canTakeCredit, Boolean canGiveMoney,
                                   Boolean canDepositMoney, Double cost) {
        Double money = bank.getMoney();
        office = new BankOffice(bank, id, name, address, status, canSetAtm, canTakeCredit, canGiveMoney,
                canDepositMoney, money, cost);
       return office;
    }
    @Override
    public void addEmployer(BankOffice bankOffice, int idEmp, Employee employee){
        bankOffice.addEmployer(idEmp, employee);
    }

    @Override
    public BankOffice readOffice(BankOffice office) {
        return office;
    }

    @Override
    public void updateOfficeStatusOfWorking(BankOffice office, String status) {
        office.setStatus(status);
    }

    @Override
    public void updateOfficeStatusOfSetATM(BankOffice office, Boolean canSetAtm) {
        office.setCanSetAtm(canSetAtm);
    }

    @Override
    public void delete(BankOffice bankOffice) {
        if (this.office == bankOffice) {
            this.office = null;
        }
    }
}
