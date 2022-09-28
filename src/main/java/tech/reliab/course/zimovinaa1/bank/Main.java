package tech.reliab.course.zimovinaa1.bank;

import tech.reliab.course.zimovinaa1.bank.entity.Bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Tinkoff", 40221);
        System.out.println(bank);
        bank = new Bank("Sber", 955211);
        System.out.println(bank);
        bank.updateBank("SberUpdater", 955222, 1, 1,
                1, 1, 78, 90000, 11);
        System.out.println(bank);

    }
}
