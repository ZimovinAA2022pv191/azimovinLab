package tech.reliab.course.zimovinaa1.bank;

import tech.reliab.course.zimovinaa1.bank.entity.*;
import tech.reliab.course.zimovinaa1.bank.service.*;
import tech.reliab.course.zimovinaa1.bank.service.impl.*;

import java.time.LocalTime;



public class Main {
    public static void main(String[] args) {
        BankImpl bankImpl = new BankImpl();
        Bank bank1 = bankImpl.createBank("TinkoFF", 100);
        Bank bank2 = bankImpl.createBank("SberBank", 212);
        Bank bank3 = bankImpl.createBank("VTB 24", 133);
        Bank bank4 = bankImpl.createBank("ALFA-Bank", 144);
        Bank bank5 = bankImpl.createBank("MTS Bank", 125);

        BankOfficeService bankOfficeImpl = new BankOfficeImpl();
        BankOffice office1 = bankOfficeImpl.createOffice(bank1, 12, "Tinkoff #1",
                "Белгород, ул.Костюкова д.43", "Работает", true,true,true,
                true,  120000.0);
        BankOffice office2 = bankOfficeImpl.createOffice(bank1, 13, "Tinkoff #2",
                "Белгород, ул.Лигачева д.12, корп. 1", "Работает", true,true,true,
                true,  90000.0);
        BankOffice office3 = bankOfficeImpl.createOffice(bank1, 14, "Tinkoff #3",
                "Белгород, ул.Садовая д.25а", "Работает", true,true,true,
                true,  95000.0);
        bankImpl.addOfficeBank(bank1, office1.getId(), office1);
        bankImpl.addOfficeBank(bank1, office2.getId(), office2);
        bankImpl.addOfficeBank(bank1, office3.getId(), office3);

        EmployeeService empImpl = new EmployeeImpl();
        Employee employee1 = empImpl.createEmployee(bank1, office1, 1001, "Andrey", "Zimovin",
                "Alexandrovich", LocalTime.now(), "Admin", true, false, 20000.0);
        Employee employee2 = empImpl.createEmployee(bank1, office1, 1002, "Andrey", "Zimovin",
                "Alexandrovich", LocalTime.now(), "Admin", true, false, 20000.0);
        Employee employee3 = empImpl.createEmployee(bank1, office1, 1003, "Andrey", "Zimovin",
                "Alexandrovich", LocalTime.now(), "Admin", true, false, 20000.0);
        Employee employee4 = empImpl.createEmployee(bank1, office1, 1004, "Andrey", "Zimovin",
                "Alexandrovich", LocalTime.now(), "Admin", true, false, 20000.0);
        Employee employee5 = empImpl.createEmployee(bank1, office1, 1005, "Andrey", "Zimovin",
                "Alexandrovich", LocalTime.now(), "Admin", true, false, 20000.0);
        bankOfficeImpl.addEmployer(office1, employee1.getId(), employee1);
        bankOfficeImpl.addEmployer(office1, employee2.getId(), employee2);
        bankOfficeImpl.addEmployer(office1, employee3.getId(), employee3);
        bankOfficeImpl.addEmployer(office1, employee4.getId(), employee4);
        bankOfficeImpl.addEmployer(office1, employee5.getId(), employee5);

        AtmService atmImpl = new AtmImpl();
        BankAtm atm1 = atmImpl.createAtm(bank1, office1, 203, "BankAtm 203-45", "Работает", employee1.getId(),
                true, true);
        BankAtm atm2 = atmImpl.createAtm(bank1, office1, 204, "BankAtm 204-45", "Работает", employee2.getId(),
                true, true);
        BankAtm atm3 = atmImpl.createAtm(bank1, office1, 205, "BankAtm 205-45", "Работает", employee3.getId(),
                true, true);
        empImpl.addAtm(employee1, atm1.getId(), atm1);
        empImpl.addAtm(employee2, atm2.getId(), atm2);
        empImpl.addAtm(employee3, atm3.getId(), atm3);

        UserService userImpl = new UserImpl();
        User user = userImpl.createUser(501, "Andrey", "Zimovin", "Alexandrovich",
                "02-10-2001", "БГТУ им. В.Г. Шухова");

        PaymentAccountService payImpl = new PaymentAccountImpl();
        PaymentAccount paymentAccount = payImpl.createPayAcc(bank1, user, 40012);
        userImpl.addPaymentAcc(paymentAccount.getIdPayAcc(), paymentAccount, user);

        CrediteAccountService creditImpl = new CrediteAccountImpl();
        CreditAccount creditAccount = creditImpl.createCreditAcc(bank1,user, employee1,paymentAccount, 1003,
                "19-11-2022", "19-11-2023", 12, 500000.0);
        userImpl.addCreditAcc(creditAccount.getId(), creditAccount, user);
        System.out.println(bankImpl.readBank(bank1));
    }
}

