package tech.reliab.course.zimovinaa1.bank;

import tech.reliab.course.zimovinaa1.bank.entity.*;
import tech.reliab.course.zimovinaa1.bank.exception.*;
import tech.reliab.course.zimovinaa1.bank.service.*;
import tech.reliab.course.zimovinaa1.bank.service.impl.*;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;


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
                        "Alexandrovich", "02-10-2001", "Admin", true, true, 20000.0);
                bankOfficeImpl.addEmployer(offices[j], employees[emp].getId(), employees[emp]);
            }
            for (int atm = 0; atm < atmCount; atm++) {
                atms[atm] = atmImpl.createAtm(bank, offices[j], atm + 1, "BankAtm 203-45", "Работает", employees[atm].getId(),
                        true, true);
                empImpl.addAtm(employees[atm], atms[atm].getId(), atms[atm]);
                offices[j].addOfficeAtm(atm + 1, atms[atm]);
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

    public static void main(String[] args) {
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
        Scanner console = new Scanner(System.in);
        PaymentAccountService paymentImpl = new PaymentAccountImpl();
        PaymentAccount payment = new PaymentAccount();
        User user = userImpl.createUser(ran.nextInt(), "Михаил", "Ломоносов", "Васильевич",
                "12-10-2007", "БГТУ им. В.Г. Шухова");
        payment = paymentImpl.createPayAcc(bank[0], user, 3001);
        user = userImpl.createUser(ran.nextInt(), "Александр", "Пушкин", "Петрович",
                "01-01-2005", "БГТУ им. В.Г. Шухова");
        payment = paymentImpl.createPayAcc(bank[0], user, 3002);
        user = userImpl.createUser(ran.nextInt(), "Алессандро", "Петручиоли", "Клоки",
                "25-10-2002", "БГТУ им. В.Г. Шухова");
        payment = paymentImpl.createPayAcc(bank[0], user, 3003);
        user = userImpl.createUser(ran.nextInt(), "Иван", "Иванович", "Иванов",
                "11-12-2003", "БГТУ им. В.Г. Шухова");
        payment = paymentImpl.createPayAcc(bank[0], user, 3004);
        user = userImpl.createUser(ran.nextInt(), "Хайп", "Хайповски", "Хайпович",
                "03-11-2001", "БГТУ им. В.Г. Шухова");
        payment = paymentImpl.createPayAcc(bank[0], user, 3005);

        userImpl.addPaymentAcc(payment.getIdPayAcc(), payment, user);

        Bank chooseBank = new Bank();

        boolean flag = true;
        /*
         * 1- нет денег в банкоматах
         * 2- банкоматы не работает
         * 3- офисы не работает
         * 4- кредитный рейтинг не соответствует требованиям банка
         * 5- в офисе нет такой суммы
         * 6- несуществующий банк
         * 7- нет работника который может выдавать кредиты, выберите другой оффис
         * */
        while (flag) {
            System.out.println("Выберите банк для получения кредита:");
            for (int i = 0; i < bank.length; i++) {
                System.out.println(i + 1 + "-" + bank[i].getName() + " Процентная ставка " + bank[i].getPercentage() + "%");
            }
            System.out.print("Ввод: ");
            int com = console.nextInt();
            try {
                if (com >= 1 && com <= 5) {
                    chooseBank = bank[com - 1];
                } else {
                    throw new BadBankValueException("Ошибка, выбран несуществующий банк!");
                }
            } catch (BadBankValueException e) {
                System.out.println("\n" + e.getMessage());
                return;
            }
            System.out.print("Введите сумму кредита:");
            double money = console.nextDouble();
            Map<Integer, BankOffice> officeMap = chooseBank.getOffices();
            BankOffice trueOffice = new BankOffice();
            boolean officeCheck = true;
            int exceptionVal = 0;
            for (int i = 0; i < officeMap.size() && officeCheck; i++) {
                BankOffice tmp = officeMap.get(i + 1);
                if (tmp.getStatus() == "Работает") {
                    if (tmp.getCanTakeCredit()) {
                        if (tmp.getMoney() >= money) {
                            trueOffice = tmp;
                            officeCheck = false;
                            exceptionVal = 0;
                        } else {
                            exceptionVal = 5;
                        }
                    } else {
                        exceptionVal = 3;
                    }
                } else {
                    exceptionVal = 3;
                }
            }
            try {
                if (exceptionVal == 3) {
                    throw new OfficeWorkException("Офис не работает");
                }
                if (exceptionVal == 5) {
                    throw new OfficeMoneyException("В офисе нет запрашиваемой суммы");
                }
            } catch (OfficeWorkException e) {
                System.out.println("\n" + e.getMessage());
            } catch (OfficeMoneyException e) {
                System.out.println("\n" + e.getMessage());
            }

            officeCheck = true;
            Map<Integer, Employee> employeeMap = trueOffice.getEmployeeMap();
            Employee trueEmp = new Employee();
            for (int i = 0; i < employeeMap.size() && officeCheck; i++) {
                Employee emp = employeeMap.get(i + 1);
                if (emp.getCanGiveCredite()) {
                    trueEmp = emp;
                    exceptionVal = 0;
                    officeCheck = false;
                    System.out.println("Сработал yes");
                } else {
                    exceptionVal = 7;
                    System.out.println("Сработал no");
                }

            }
            try {
                if (exceptionVal == 7)
                    throw new EmployeeException("В офисе нет сотрудника, который может выдать кредит.");

            } catch (EmployeeException e) {
                System.out.println('\n' + e.getMessage());
            }
            Map<Integer, User> userMap = chooseBank.getUserAccounts();
            officeCheck = false;
            String name, last, mid;

            System.out.println("Введите имя:");
            name = console.nextLine(); //Тут короче чет с вводом, я не понимаю что
            name = "Михаил";
            System.out.print("Ввидет фамилию:");
            //last = console.nextLine();
            last="Ломоносов";
            System.out.print("Введите отчество:");
            //mid = console.nextLine();
            mid="Васильевич";
            for (Map.Entry<Integer, User> u : userMap.entrySet()) {
                User tmp = u.getValue();
                if (tmp.getLastName() == last && tmp.getFirstName() == name && tmp.getPatronymic() == mid) {
                    officeCheck = true;
                }
            }
            if (!officeCheck) {
                System.out.println("\n"+"Запуск формы добавления нового клиента банка...");
                //System.out.println("Введите место работы, заработной платы, дату рождения. Через ENTER");
                String workPlace = "ОАО БелГаууоа";
                double salary = 12000.0;
                String date = "16-12-2022";
                User newUser = userImpl.createUser(ran.nextInt(), name, last, mid,
                        date, workPlace, salary);
                payment = paymentImpl.createPayAcc(chooseBank, newUser, ran.nextInt());
                userImpl.addPaymentAcc(payment.getIdPayAcc(), payment, user);
                chooseBank.addUserAcc(user.getUserId(), user);
                System.out.println("Регистрация успешно завершена!");
            }
            try {
                if (user.getCreditRating() < 50 && chooseBank.getRate() > 50) {
                    throw new RatingException("Ваш кредитный рейтинг не соответсвтует банковским требованиям!");
                }
            } catch (RatingException e) {
                System.out.println("\n" + e.getMessage());
            }
            Map<Integer, BankAtm> atmMap = trueOffice.getAtmMap();
            officeCheck = true;
            BankAtm atm = new BankAtm();
            for (int i = 0; i < trueOffice.getCountAtm() && officeCheck; i++) {
                BankAtm tmp = atmMap.get(i + 1);
                if (tmp.getCanGiveMoney()) {
                    if (tmp.getMoney() >= money) {
                        officeCheck = false;
                        atm = tmp;
                        exceptionVal = 0;
                    }
                    else{
                        exceptionVal= 1;
                    }
                } else {
                    exceptionVal = 2;
                }
            }
            try {
                if (exceptionVal==1) {
                    throw new AtmMoneyExceptions("Выберите другой офис. Недостаточно денег!");
                }
                if (exceptionVal==2){
                    throw new AtmWorkException("Выберите другой банкомат. Этот не работает");
                }
            }catch (AtmMoneyExceptions e) {
                System.out.println("\n" + e.getMessage());
            }
            catch(AtmWorkException e){
                System.out.println("\n" + e.getMessage());
            }
            System.out.println("Выдаем деньги...");
            double getMoney = atm.getMoney();
            atm.setMoney(atm.getMoney() - money);
            payment.setMoney(getMoney);
            System.out.println("Деньги выданы!");
        }

    }
}

