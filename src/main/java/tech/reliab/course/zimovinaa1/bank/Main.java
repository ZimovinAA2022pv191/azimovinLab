package tech.reliab.course.zimovinaa1.bank;

import tech.reliab.course.zimovinaa1.bank.entity.*;
import tech.reliab.course.zimovinaa1.bank.entity.detail.Fcs;
import tech.reliab.course.zimovinaa1.bank.service.*;
import tech.reliab.course.zimovinaa1.bank.service.impl.*;

import java.time.LocalTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("***Bank INFO***");
        BankImpl bankImpl = new BankImpl();
        Bank bank = bankImpl.createBank("TinkoFF Bank", 1002);
        System.out.println(bankImpl.readBank());
        bankImpl.updateBankName(bank,"SberBank");
        System.out.println(bankImpl.readBank());

        BankOfficeService bankOfficeImpl = new BankOfficeImpl();
        BankOffice office = bankOfficeImpl.createOffice(bank, 12, "SberOffice #1",
                "Белгород, ул.Костюкова д.43", "Не работает", true,true,false,
                false,  120000.0);
        System.out.println(bankOfficeImpl.readOffice());
        bankOfficeImpl.updateOfficeStatusOfSetATM(office, false);
        bankOfficeImpl.updateOfficeStatusOfWorking(office,"Работает");
        System.out.println(bankOfficeImpl.readOffice());

        System.out.println("\n***Employee INFO***\n");
        EmployeeService empImpl = new EmployeeImpl();
        Employee employee = empImpl.createEmployee(bank, office, 1001, "Andrey", "Zimovin",
                "Alexandrovich", LocalTime.now(), "Admin", true, false, 20000.0);
        System.out.println(empImpl.readEmployee());
        empImpl.updateEmployeeDistant(employee,false);
        empImpl.updateEmployeeGiving(employee,true);
        System.out.println(empImpl.readEmployee());

        System.out.println("\n***ATM INFO***\n");
        AtmService atmImpl = new AtmImpl();
        BankAtm atm = atmImpl.createAtm(bank, office, 203, "BankAtm 103-45", "Работает", 23,
                true, true);
        System.out.println(atmImpl.readAtm(atm));
        atmImpl.updateATMMoney(atm, bank, 40000);
        atmImpl.updateATMStatusOfDeposit(atm, false);
        atmImpl.updateATMStatusOfGiving(atm, false);
        System.out.println(atmImpl.readAtm(atm));

        System.out.println("\n***USER INFO***\n");
        UserService userImpl = new UserImpl();
        User user = userImpl.createUser(501, "Andrey", "Zimovin", "Alexandrovich",
                LocalTime.now(), "БГТУ им. В.Г. Шухова");
        System.out.println(userImpl.readUser());
        userImpl.updateUserWork(user, "БелГУ");
        System.out.println(userImpl.readUser());

        System.out.println("\n***PaymentAccount INFO***\n");
        PaymentAccountService payImpl = new PaymentAccountImpl();
        PaymentAccount paymentAccount = payImpl.createPayAcc(bank, user, 1002);
        System.out.println(payImpl.readPayAcc());
        payImpl.updateMoney(paymentAccount,10000.0);
        System.out.println(payImpl.readPayAcc());

        System.out.println("\n***CreditAccount INFO***\n");
        CrediteAccountService creditImpl = new CrediteAccountImpl();
        CreditAccount creditAccount = creditImpl.createCreditAcc(bank,user, employee,paymentAccount, 1003,
                LocalTime.now(), LocalTime.now(), 46, 500000.0, 23000);
        System.out.println(creditImpl.readCreditAcc());
        creditImpl.updateCreditPayAcc(creditAccount, paymentAccount);
        System.out.println(creditImpl.readCreditAcc());

    }
}
