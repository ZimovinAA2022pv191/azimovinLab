package tech.reliab.course.zimovinaa1.bank;

import tech.reliab.course.zimovinaa1.bank.entity.*;
import tech.reliab.course.zimovinaa1.bank.entity.detail.FIO;

public class Main {
    public static void main(String[] args) {
        System.out.println("***Bank INFO***");
        Bank bank = new Bank("TinkoFF Bank", 1002);
        System.out.println("*********");
        System.out.println(bank);

        System.out.println("\n***BankOffice INFO***\n");
        BankOffice office = new BankOffice("TinkoFF Office #1",102, bank, "Белгород, ул.Костюкова д.46");
        System.out.println(office);
        System.out.println("*********");

        System.out.println("\n***Employee INFO***\n");
        FIO fio = new FIO("Andrey", "Zimovin", "Alexandrovich", "02-10-2001");
        Employee employee = new Employee(23,bank, fio,"Студент" , true,
                office, false, 2000.0f);
        System.out.println("id:"+employee.getId());
        System.out.println(employee.getFio());
        System.out.println("Должность:"+employee.getPost());
        System.out.println("Зарплата: "+employee.getSalary());
        System.out.println("Может давать кредит: "+employee.getCanGiveCredit());
        System.out.println("Может работать дистанционно:"+employee.getWorkDistance());
        System.out.println("*********");

        System.out.println("\n***BankATM INFO***\n");
        BankAtm atm = new BankAtm("Термина #1", 9123,bank, office,employee);
        System.out.println("ID: "+atm.getId());
        System.out.println("Имя: "+atm.getName());
        System.out.println("Адрес: "+atm.getAddress());
        System.out.println("Статус: "+atm.getStatus());
        System.out.println("Местоположение: "+atm.getAtmLocation());
        System.out.println("ID офиса: "+atm.getBankOffice());
        System.out.println("ID банка: "+atm.getBank());
        System.out.println("ID инженера: "+atm.getEngineer());
        System.out.println("*********");

        System.out.println("\n***USER INFO***\n");
        FIO fio2 = new FIO("Andrey", "Zimovin", "Alexandrovich", "02-10-2001");
        User client = new User(1000, fio2, "БГТУ им. В.Г.Шухова", 2000.0f,bank);
        System.out.println("id:"+client.getIdClient());
        System.out.println("Личные данные:"+client.getFio());
        System.out.println("Место работы:"+client.getPlaceWork());
        System.out.println("Рейтинг:"+client.getRate());
        System.out.println("Зарплата:"+client.getSalary());
        System.out.println("*********");

        System.out.println("\n***PaymentAccount INFO***\n");
        PaymentAccount paymentAccount = new PaymentAccount(123, client, bank.getName());
        System.out.println("ID_payment:"+paymentAccount.getIdPayment());
        System.out.println("Клиент:"+paymentAccount.getUser());
        System.out.println("Банк:"+paymentAccount.getName_bank());
        System.out.println("Баланс:"+paymentAccount.getSum());
        System.out.println("*********");

        System.out.println("\n***PaymentAccount INFO***\n");
        CreditAccount creditAccount = new CreditAccount(client.getIdClient(), client,bank, "29-09-2022",
                "29-09-2023",12,120000.0f, 12000.80f, 12,employee);
        System.out.println("ID_credit:"+creditAccount.getIdCreditAccount());
        System.out.println("Клиент:"+creditAccount.getUser());
        System.out.println("Дата начала кредита:"+creditAccount.getDateStartCredit());
        System.out.println("Дата окончания кредита:"+creditAccount.getDateEndCredit());
        System.out.println("Сумма кредита:"+creditAccount.getSum_credit());
        System.out.println("Банк:"+creditAccount.getNameBank());
        System.out.println("Месячный платеж:"+creditAccount.getMonth_pay());
        System.out.println("Процент(%):"+creditAccount.getPercentage());
        System.out.println("Кол-во месяцев:"+creditAccount.getCountMonthsCredit());
        System.out.println("Работник банка:"+creditAccount.getEmployee());
        System.out.println("*********");
    }
}
