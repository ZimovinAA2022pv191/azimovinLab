package tech.reliab.course.zimovinaa1.bank;

import tech.reliab.course.zimovinaa1.bank.entity.*;
import tech.reliab.course.zimovinaa1.bank.service.*;
import tech.reliab.course.zimovinaa1.bank.service.impl.*;

import java.time.LocalTime;


public class Main {
    public static void main(String[] args) {
        BankImpl bankImpl = new BankImpl();
        BankOfficeService bankOfficeImpl = new BankOfficeImpl();
        EmployeeService empImpl = new EmployeeImpl();
        AtmService atmImpl = new AtmImpl();
        UserService userImpl = new UserImpl();
        CrediteAccountService creditImpl = new CrediteAccountImpl();
        PaymentAccountService paymentImpl = new PaymentAccountImpl();

        Bank[] bank = new Bank[5];
        BankOffice[] offices = new BankOffice[3];
        Employee[] employees = new Employee[5];
        BankAtm[] atms = new BankAtm[3];
        User[] users = new User[5];
        PaymentAccount[] paymentAccounts = new PaymentAccount[2];
        CreditAccount[] creditAccounts = new CreditAccount[2];

        for (int i = 0; i < 5; i++) {
            bank[i] = bankImpl.createBank("TinkoFF#" + i, 100 + i);
            for (int j = 0; j < 3; j++) {
                offices[j] = bankOfficeImpl.createOffice(bank[i], 12 + j, "Tinkoff #" + j + " office",
                        "Белгород, ул.Костюкова д.43", "Работает", true, true, true,
                        true, 120000.0);
                bankImpl.addOfficeBank(bank[i], offices[j].getId(), offices[j]);
                for (int emp = 0; emp < 5; emp++) {
                    employees[emp] = empImpl.createEmployee(bank[i], offices[j], 1001 + emp, "Andrey", "Zimovin",
                            "Alexandrovich", "02-10-2001", "Admin", true, false, 20000.0);
                    bankOfficeImpl.addEmployer(offices[j], employees[emp].getId(), employees[emp]);
                }
                for (int atm = 0; atm < 3; atm++) {
                    atms[atm] = atmImpl.createAtm(bank[i], offices[j], 203 + atm, "BankAtm 203-45", "Работает", employees[atm].getId(),
                            true, true);
                    empImpl.addAtm(employees[atm], atms[atm].getId(), atms[atm]);
                }
                for (int user = 0; user < 5; user++) {
                    users[user] = userImpl.createUser(501 + user, "Andrey", "Zimovin", "Alexandrovich",
                            "02-10-2001", "БГТУ им. В.Г. Шухова");
                    for (int acc = 0; acc < 2; acc++) {
                        paymentAccounts[acc] = paymentImpl.createPayAcc(bank[i], users[user], 40012 + acc);
                        userImpl.addPaymentAcc(paymentAccounts[acc].getIdPayAcc(), paymentAccounts[acc], users[user]);

                        creditAccounts[acc] = creditImpl.createCreditAcc(bank[i], users[user], employees[acc], paymentAccounts[acc], 1003 + acc,
                                "19-11-2022", "19-11-2023", 12, 500000.0);
                        userImpl.addCreditAcc(creditAccounts[acc].getId(), creditAccounts[acc], users[user]);
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("************************");
            System.out.println(bank[i]);
        }

    }
}

