package tech.reliab.course.zimovinaa1.bank;

import tech.reliab.course.zimovinaa1.bank.entity.*;
import tech.reliab.course.zimovinaa1.bank.service.*;
import tech.reliab.course.zimovinaa1.bank.service.impl.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Random;

class InitorSystem {
    Random random = new Random();
    int id;
    String name;

    public InitorSystem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    Bank initBank(int countOffice, int countEmployee, int countAtm, int countPayAcc, int countCreditAcc, int countUser) {
        Bank bank = new Bank(this.name, this.id);
        int cUsers = 0;
        int cCredit = 0;
        for (int i = 0; i < countOffice; i++) {
            BankOffice office = initOffice(bank, random.nextInt(65536), "Sber №" + i, "Belgorod, Slavyanskaya 45A", "Работает",
                    random.nextBoolean(), random.nextBoolean(), random.nextBoolean(), random.nextBoolean(), random.nextDouble(99999.9), random.nextDouble(99999.9));

            for (int j = 0; j < countEmployee; j++) {
                Employee employee = initEmployee(bank, office, random.nextInt(65536), "Alex", "Popov",
                        "Evgenievich", LocalTime.now(), "работник", random.nextBoolean(), random.nextBoolean(),
                        random.nextDouble(), random.nextInt());
                BankAtm atm = initAtm(office, "Atm#" + random.nextInt(65536), "Работает", random.nextInt(65536),
                        employee, random.nextInt(65536));


                while (cUsers < countUser) {
                    User user = initUser(random.nextInt(), "Andrey", "Zimovin", "Alex",
                            LocalTime.now(), "BSTU");
                    cUsers+=1;
                    while(cCredit < countCreditAcc)
                    {
                        PaymentAccount payAcc = initPayAcc(bank, user, random.nextInt(65536));
                        CreditAccount creditAccount = initCreditAcc(bank, user, employee, payAcc, random.nextInt(65536),
                                LocalDate.of(2017, Month.NOVEMBER, 30), LocalDate.of(2022, Month.NOVEMBER, 30),
                                random.nextInt(65536), random.nextDouble(), random.nextInt(65536));
                        cCredit+=1;
                    }
                }
            }
        }
        return bank;
    }

    public BankOffice initOffice(Bank bank, int id, String name, String address, String status, Boolean canSetAtm,
                                 Boolean canTakeCredit, Boolean canGiveMoney, Boolean canDepositMoney, Double money, Double cost) {
        BankOffice office = new BankOffice(bank, id, name, address, status, canSetAtm, canTakeCredit, canGiveMoney, canDepositMoney,
                money, cost);
        bank.addOfficeBank(id, office);
        return office;
    }

    public Employee initEmployee(Bank bank, BankOffice bankOffice, int id, String firstName, String lastName, String patronymic,
                                 LocalTime dateBirth, String post, Boolean canWorkDistance, Boolean canGiveCredit, Double salary,
                                 int idEmp) {
        Employee employee = new Employee(bank, bankOffice, id, firstName, lastName, patronymic, dateBirth, post,
                canWorkDistance, canGiveCredit, salary);
        bankOffice.addEmployer(idEmp, employee);
        return employee;
    }

    public BankAtm initAtm(BankOffice office, String name, String status, int id, Employee empId, int idAtm) {
        BankAtm atm = new BankAtm(office, id, name, status, empId.getId(), true, true,
                150000, 12000);
        empId.addAtm(idAtm, atm);
        office.setCountAtm(office.getCountAtm() + 1);
        return atm;
    }

    public PaymentAccount initPayAcc(Bank bank, User user, int id) {
        PaymentAccount payAcc = new PaymentAccount(bank, user, id);
        user.addPaymentAcc(id, payAcc, user);
        return payAcc;
    }

    public CreditAccount initCreditAcc(Bank bank, User user, Employee employee, PaymentAccount paymentAccount,
                                       Integer id, LocalDate startDate, LocalDate endDate, Integer countMonth,
                                       Double creditSum, Integer monthPay) {
        CreditAccount acc = new CreditAccount(bank, user, employee, paymentAccount, id, startDate, endDate, countMonth,
                creditSum, monthPay);
        user.addCreditAcc(id, acc);
        return acc;
    }

    public User initUser(int id, String firstName, String lastName, String patronymic, LocalTime dateBirth, String workPlace) {
        return new User(id, firstName, lastName, patronymic, dateBirth, workPlace);
    }
}

public class Main {
    public static void main(String[] args) {
        InitorSystem init = new InitorSystem(1, "TinkoFF Лучший банк");
        Bank bank = init.initBank(3, 5, 5, 2, 2, 5);
        System.out.println(bank);
    }
}
