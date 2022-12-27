package tech.reliab.course.zimovinaa1.bank;

import tech.reliab.course.zimovinaa1.bank.entity.*;
import tech.reliab.course.zimovinaa1.bank.exception.*;
import tech.reliab.course.zimovinaa1.bank.service.*;
import tech.reliab.course.zimovinaa1.bank.service.impl.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;


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
            bankImpl.addOfficeBank(bank, offices[j]);
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
                    paymentAccounts[acc] = paymentImpl.createPayAcc(bank, users[user], users[user].getId());
                    userImpl.addPaymentAcc(paymentAccounts[acc].getIdPayAcc(), paymentAccounts[acc], users[user]);

                    creditAccounts[acc] = creditImpl.createCreditAcc(bank, users[user], employees[acc], paymentAccounts[acc], 1003 + acc,
                            "19-11-2022", "19-11-2023", 12, 500000.0);
                    userImpl.addCreditAcc(creditAccounts[acc].getId(), creditAccounts[acc], users[user]);
                }
            }
        }
        return bank;
    }

    static void lab3() {
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
        payment = paymentImpl.createPayAcc(bank[0], user, user.getId());
        user = userImpl.createUser(ran.nextInt(), "Александр", "Пушкин", "Петрович",
                "01-01-2005", "БГТУ им. В.Г. Шухова");
        payment = paymentImpl.createPayAcc(bank[0], user, user.getId());
        user = userImpl.createUser(ran.nextInt(), "Алессандро", "Петручиоли", "Клоки",
                "25-10-2002", "БГТУ им. В.Г. Шухова");
        payment = paymentImpl.createPayAcc(bank[0], user, user.getId());
        user = userImpl.createUser(ran.nextInt(), "Иван", "Иванович", "Иванов",
                "11-12-2003", "БГТУ им. В.Г. Шухова");
        payment = paymentImpl.createPayAcc(bank[0], user, user.getId());
        user = userImpl.createUser(ran.nextInt(), "Хайп", "Хайповски", "Хайпович",
                "03-11-2001", "БГТУ им. В.Г. Шухова");
        payment = paymentImpl.createPayAcc(bank[0], user, user.getId());

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
            System.out.println("Укажите срок кредита (кол-во месяцев):");
            int kDays = console.nextInt();
            ArrayList<BankOffice> officeList = chooseBank.getOffices();
            BankOffice trueOffice = new BankOffice();
            boolean officeCheck = true;
            int exceptionVal = 0;
            for (int i = 0; i < officeList.size() && officeCheck; i++) {
                BankOffice tmp = officeList.get(i + 1);
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
                } else {
                    exceptionVal = 7;
                }

            }
            try {
                if (exceptionVal == 7)
                    throw new EmployeeException("В офисе нет сотрудника, который может выдать кредит.");

            } catch (EmployeeException e) {
                System.out.println('\n' + e.getMessage());
            }
            ArrayList<User> userMap = chooseBank.getUserAccounts();
            officeCheck = false;
            String name, last, mid;

            //System.out.println("Введите имя:");
            name = console.nextLine(); //Тут короче чет с вводом, я не понимаю что
            name = "Михаил";
            //System.out.print("Ввидет фамилию:");
            //last = console.nextLine();
            last = "Ломоносов";
            //System.out.print("Введите отчество:");
            //mid = console.nextLine();
            mid = "Васильевич";
            for (User value : userMap) {
                if (Objects.equals(value.getLastName(), last) &&
                        Objects.equals(value.getFirstName(), name) &&
                        Objects.equals(value.getPatronymic(), mid)) {
                    officeCheck = true;
                    break;
                }
            }
            if (!officeCheck) {
                System.out.println("\n" + "Запуск формы добавления нового клиента банка...");
                //System.out.println("Введите место работы, заработной платы, дату рождения. Через ENTER");
                String workPlace = "ОАО БелГаууоа";
                double salary = 12000.0;
                String date = "16-12-2022";
                User newUser = userImpl.createUser(ran.nextInt(), name, last, mid,
                        date, workPlace, salary);
                payment = paymentImpl.createPayAcc(chooseBank, newUser, ran.nextInt());
                userImpl.addPaymentAcc(payment.getIdPayAcc(), payment, user);
                chooseBank.addUserAcc(user);
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
                    } else {
                        exceptionVal = 1;
                    }
                } else {
                    exceptionVal = 2;
                }
            }
            try {
                if (exceptionVal == 1) {
                    throw new AtmMoneyExceptions("Выберите другой офис. Недостаточно денег!");
                }
                if (exceptionVal == 2) {
                    throw new AtmWorkException("Выберите другой банкомат. Этот не работает");
                }
            } catch (AtmMoneyExceptions e) {
                System.out.println("\n" + e.getMessage());
            } catch (AtmWorkException e) {
                System.out.println("\n" + e.getMessage());
            }
            double mounthPay = (money / chooseBank.getPercentage()) + money / kDays;
            DecimalFormat dF = new DecimalFormat("#.###");
            System.out.format("\nЗаявка на кредит одобрена\n" + "Сумма кредита: " + money + "" +
                    "\nЕжемесячный платеж:" + dF.format(mounthPay) + "\n");
            System.out.println("\nВыдаем деньги...");
            double getMoney = atm.getMoney();
            atm.setMoney(atm.getMoney() - money);
            payment.setMoney(getMoney);
            System.out.println("Деньги выданы!");
        }

    }

    static void export_to_txt(){
        BankImpl bankService = new BankImpl();
        ArrayList<Bank> banks = new ArrayList<>();
        UserService userImpl = new UserImpl();
        CrediteAccountService creditImpl = new CrediteAccountImpl();
        PaymentAccountService paymentImpl = new PaymentAccountImpl();
        EmployeeService empImpl = new EmployeeImpl();
        BankOfficeService bankOfficeImpl = new BankOfficeImpl();
        Bank bank = InitorSystem(100, "Test bank", 5, 5, 5, 5, 10.2);
        BankOffice offices = bankOfficeImpl.createOffice(bank, 20, "Tinkoff #" + " office",
                "Белгород, ул.Костюкова д.43", "Работает", true, true, true,
                true, 120000.0);
        userImpl.createUser(1, "Andrey", "Zimovin", "Alexandrovich",
                "02-10-2001", "BSTU", 10000.0);
        Employee employees =  empImpl.createEmployee(bank, offices, 22, "Andrey", "Zimovin",
                "Alexandrovich", "02-10-2001", "Admin", true, true, 20000.0);

        PaymentAccount paymentAccounts = paymentImpl.createPayAcc(bank, userImpl.readUser(), userImpl.readUser().getId());
        CreditAccount creditAccounts = creditImpl.createCreditAcc(bank, userImpl.readUser(), employees, paymentAccounts,
                userImpl.readUser().getId(),"19-11-2022", "19-11-2023", 12, 500000.0);

        userImpl.addPaymentAcc(paymentAccounts.getIdPayAcc(), paymentAccounts,  userImpl.readUser());
        userImpl.addCreditAcc(creditAccounts.getId(), creditAccounts, userImpl.readUser());
        Bank bank2 = InitorSystem(110, "Test bank2", 5, 5, 5, 5, 10.2);

        try {
            userImpl.saveToFile("file.txt", bank);
            System.out.println("Платёжные счета до записи в файл:");
            System.out.println(userImpl.getPaymentAcc());
            System.out.println("\nКредитные счета до записи в файл:");
            System.out.println(userImpl.readUser().getCreditAccs());
            userImpl.updateFromFile("file.txt", bank2);
            System.out.println("\nПлатёжные счета после обновления из файла:");
            System.out.println(userImpl.getPaymentAcc());
            System.out.println("\nКредитные счета после обновления из файла:");
            System.out.println(userImpl.getCreditAcc());
        } catch (IOException e) {
            System.out.println("Ошибка файла: " + e);
        }
    }
    public static void main(String[] args) {
        export_to_txt();
    }


}

