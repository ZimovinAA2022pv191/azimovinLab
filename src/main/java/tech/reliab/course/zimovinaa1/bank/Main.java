package tech.reliab.course.zimovinaa1.bank;

import tech.reliab.course.zimovinaa1.bank.entity.*;
import tech.reliab.course.zimovinaa1.bank.exception.*;
import tech.reliab.course.zimovinaa1.bank.service.*;
import tech.reliab.course.zimovinaa1.bank.service.impl.*;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


public class Main {
    static Bank InitorSystem(int id, String name, int offCount, int atmCount, int empCount, int userCount, double percentage) {
        BankImpl bankImpl = new BankImpl();
        BankOfficeService bankOfficeImpl = new BankOfficeImpl();
        EmployeeService empImpl = new EmployeeImpl();
        AtmService atmImpl = new AtmImpl();
        UserService userImpl = new UserImpl();
        CrediteAccountService creditImpl = new CrediteAccountImpl();
        PaymentAccountService paymentImpl = new PaymentAccountImpl();

        BankOffice[] offices = new BankOffice[offCount];
        Employee[] employees = new Employee[empCount];
        BankAtm[] atms = new BankAtm[atmCount];
        User[] users = new User[userCount];
        PaymentAccount[] paymentAccounts = new PaymentAccount[2];
        CreditAccount[] creditAccounts = new CreditAccount[2];
        Bank bank = bankImpl.createBank(name, id, percentage);

        Random ran = new Random();
        for (int j = 0; j < offCount; j++) {
            offices[j] = bankOfficeImpl.createOffice(bank, j + 1, "Tinkoff #" + j + " office",
                    "Белгород, ул.Костюкова д.43", "Работает", true, true, true,
                    true, 120000.0);
            bankImpl.addOfficeBank(bank, offices[j].getId(), offices[j]);
            for (int emp = 0; emp < empCount; emp++) {
                employees[emp] = empImpl.createEmployee(bank, offices[j], emp + 1, "Andrey", "Zimovin",
                        "Alexandrovich", "02-10-2001", "Admin", true, false, 20000.0);
                bankOfficeImpl.addEmployer(offices[j], employees[emp].getId(), employees[emp]);
            }
            for (int atm = 0; atm < atmCount; atm++) {
                atms[atm] = atmImpl.createAtm(bank, offices[j], atm + 1, "BankAtm 203-45", "Работает", employees[atm].getId(),
                        true, true);
                empImpl.addAtm(employees[atm], atms[atm].getId(), atms[atm]);
                offices[j].addOfficeAtm(atm+1, atms[atm]);
            }
            for (int user = 0; user < userCount; user++) {
                users[user] = userImpl.createUser(ran.nextInt(), "Andrey", "Zimovin", "Alexandrovich",
                        "02-10-2001", "БГТУ им. В.Г. Шухова");
                for (int acc = 0; acc < 2; acc++) {
                    paymentAccounts[acc] = paymentImpl.createPayAcc(bank, users[user], 40012 + acc);
                    userImpl.addPaymentAcc(paymentAccounts[acc].getIdPayAcc(), paymentAccounts[acc], users[user]);

                    creditAccounts[acc] = creditImpl.createCreditAcc(bank, users[user], employees[acc], paymentAccounts[acc], 1003 + acc,
                            "19-11-2022", "19-11-2023", 12, 500000.0);
                    userImpl.addCreditAcc(creditAccounts[acc].getId(), creditAccounts[acc], users[user]);
                }
            }
        }
        return bank;
    }

    public static void main(String[] args){
        Random ran = new Random();
        Bank bank1 = InitorSystem(103, "VTB", 10, 100, 221, 500, 8.4);
        Bank bank2 = InitorSystem(103, "OPEN BANK", 7, 44, 100, 100, 8.9);
        Bank bank3 = InitorSystem(103, "Sberbank", 5, 24, 40, 88, 9.5);
        Bank bank4 = InitorSystem(103, "Pochta Bank", 3, 7, 24, 12, 12.5);
        Bank bank5 = InitorSystem(102, "TinkoF", 3, 6, 10, 15, 15.3);
        Bank[] bank = new Bank[5];
        bank[0] = bank1;
        bank[1] = bank2;
        bank[2] = bank3;
        bank[3] = bank4;
        bank[4] = bank5;
        UserService userImpl = new UserImpl();
        User user = userImpl.createUser(ran.nextInt(), "Andrey", "Zimovin", "Alexandrovich",
                "02-10-2001", "БГТУ им. В.Г. Шухова");
        PaymentAccountService paymentImpl = new PaymentAccountImpl();
        PaymentAccount payment = new PaymentAccount();
        Scanner console = new Scanner(System.in);

        Bank chooseBank = new Bank();
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите банк для получения кредита:");
            for (int i = 0; i < bank.length; i++) {
                System.out.println(i + 1 + "-" + bank[i].getName() + " Процентная ставка " + bank[i].getPercentage() + "%");
            }
            System.out.print("Ввод: ");
            int com = console.nextInt();
            try{
                if(com>=1 && com<=5){
                    chooseBank = bank[com-1];
                }
                else {
                    throw new BadBankValueException("Ошибка, выбран несуществующий банк!");
                }
            }catch (BadBankValueException e){
                System.out.println("\n" + e.getMessage());
                return;
            }
            System.out.print("Введите сумму кредита:");
            double money = console.nextDouble();
            Map<Integer, BankOffice> officeMap = chooseBank.getOffices();
            BankOffice trueOffice = new BankOffice();
            boolean officeCheck = true;
            for (int i = 0; i < officeMap.size() && officeCheck; i++) {
                BankOffice tmp = officeMap.get(i + 1);
                if (tmp.getCanTakeCredit()) {
                    if (tmp.getMoney() >= money) {
                        trueOffice = tmp;
                        officeCheck = false;
                    }
                }
            }
            officeCheck = true;
            Map<Integer, Employee> employeeMap = trueOffice.getEmployeeMap();
            Employee trueEmp = new Employee();
            for (int i = 0; i < employeeMap.size() && officeCheck; i++) {
                Employee emp = employeeMap.get(i + 1);
                if (emp.getCanGiveCredite()) {
                    trueEmp = emp;
                    officeCheck = false;
                }
            }
            Map<Integer, User> userMap = chooseBank.getUserAccounts();
            officeCheck = false;
            for (Map.Entry<Integer, User> u : userMap.entrySet()) {
                User tmp = u.getValue();
                if (tmp.getDateBirth() != user.getDateBirth()) {
                    if (tmp.getLastName() == user.getLastName() && tmp.getFirstName() == user.getFirstName()) {
                        System.out.println("Вы являетесь клиентом банка!");
                        officeCheck = true;
                    }
                }
            }
            if (!officeCheck) {
                System.out.println("Запуск формы добавления нового клиента банка...");
                System.out.println("Нажмите любую клавишу для продолжения");
                int c = console.nextInt();
                payment = paymentImpl.createPayAcc(chooseBank, user, 111111);
                userImpl.addPaymentAcc(payment.getIdPayAcc(), payment, user);
                chooseBank.addUserAcc(user.getUserId(), user);
                System.out.println("Регистрация успешно завершена!");
            }
            if (user.getCreditRating() < 5000 && chooseBank.getRate() > 50) {
                System.out.println("К сожалению ваш кредитный рейтинг не соответствует необходимым требованиям");
            }
            Map<Integer, BankAtm> atmMap = trueOffice.getAtmMap();
            System.out.println(atmMap);
            officeCheck = true;
            BankAtm atm = new BankAtm();
            for (int i = 0; i < trueOffice.getCountAtm() && officeCheck; i++) {
                BankAtm tmp = atmMap.get(i + 1);
                System.out.println(tmp);
                if (tmp.getCanGiveMoney() && tmp.getMoney() >= money) {
                    officeCheck = false;
                    atm = tmp;
                }
            }
            System.out.println("Выдаем деньги...");
            double getMoney = atm.getMoney();
            atm.setMoney(atm.getMoney()-money);
            payment.setMoney(getMoney);
            System.out.println("Деньги выданы!");
        }

    }
}

