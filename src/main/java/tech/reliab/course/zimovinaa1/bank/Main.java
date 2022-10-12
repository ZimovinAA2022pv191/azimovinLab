package tech.reliab.course.zimovinaa1.bank;

import tech.reliab.course.zimovinaa1.bank.entity.*;
import tech.reliab.course.zimovinaa1.bank.entity.detail.Fcs;
import tech.reliab.course.zimovinaa1.bank.service.*;
import tech.reliab.course.zimovinaa1.bank.service.impl.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("***Bank INFO***");
        BankService bankImpl = new BankImpl();
        Bank bank = bankImpl.createBank("TinkoFF Bank", 1002);
        bankImpl.readBank(bank);
        bankImpl.updateBankName(bank,"SberBank");
        bankImpl.readBank(bank);

        BankOfficeService bankOfficeImpl = new BankOfficeImpl();
        BankOffice office = bankOfficeImpl.createOffice(bank, 12, "SberOffice #1",
                "Белгород, ул.Костюкова д.43", "Не работает", true,true,false,
                false,  120000);
        bankOfficeImpl.readOffice(office);
        bankOfficeImpl.updateOfficeStatusOfSetATM(office, false);
        bankOfficeImpl.updateOfficeStatusOfWorking(office,"Работает");
        bankOfficeImpl.readOffice(office);

        System.out.println("\n***Employee INFO***\n");
        EmployeeService empImpl = new EmployeeImpl();
        Employee employee = empImpl.createEmployee(bank, office, 1001, "Andrey", "Zimovin",
                "Alexandrovich", new Date(), "Admin", true, false, 20000);
        empImpl.readEmployee(employee);
        empImpl.updateEmployeeDistant(employee,false);
        empImpl.updateEmployeeGiving(employee,true);
        empImpl.readEmployee(employee);

        System.out.println("\n***ATM INFO***\n");
        AtmService atmImpl = new AtmImpl();
        BankAtm atm = atmImpl.createAtm(bank, office, 203, "BankAtm 103-45", "Работает", 23,
                true, true, 200100, 30000);
        atmImpl.readATM(atm);
        atmImpl.updateATMMoney(atm, bank, 40000);
        atmImpl.updateATMStatusOfDeposit(atm, false);
        atmImpl.updateATMStatusOfGiving(atm, false);
        atmImpl.readATM(atm);

        System.out.println("\n***USER INFO***\n");
        UserService userImpl = new UserImpl();
        User user = userImpl.createUser(501, "Andrey", "Zimovin", "Alexandrovich",
                new Date(), "БГТУ им. В.Г. Шухова");
        userImpl.readUser(user);
        userImpl.updateUserWork(user, "БелГУ");
        userImpl.readUser(user);

        System.out.println("\n***PaymentAccount INFO***\n");
        PaymentAccountService payImpl = new PaymentAccountImpl();
        PaymentAccount paymentAccount = payImpl.createPayAcc(bank, user, 1002);
        payImpl.readPayAcc(paymentAccount);
        payImpl.updateMoney(paymentAccount,10000);
        payImpl.readPayAcc(paymentAccount);

        System.out.println("\n***CreditAccount INFO***\n");
        CrediteAccountService creditImpl = new CrediteAccountImpl();
        CreditAccount creditAccount = creditImpl.createCreditAcc(bank,user, employee,paymentAccount, 1003, new Date(),
                new Date(), 46, 500000, 23000);
        creditImpl.readCreditAcc(creditAccount);
        creditImpl.updateCreditPayAcc(creditAccount, paymentAccount);
        creditImpl.readCreditAcc(creditAccount);

    }
}
