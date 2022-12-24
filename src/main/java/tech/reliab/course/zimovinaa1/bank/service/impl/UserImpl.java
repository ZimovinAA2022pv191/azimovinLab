package tech.reliab.course.zimovinaa1.bank.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import tech.reliab.course.zimovinaa1.bank.entity.Bank;
import tech.reliab.course.zimovinaa1.bank.entity.CreditAccount;
import tech.reliab.course.zimovinaa1.bank.entity.JsonClasses.JsonCreditAcc;
import tech.reliab.course.zimovinaa1.bank.entity.JsonClasses.JsonPayAcc;
import tech.reliab.course.zimovinaa1.bank.entity.PaymentAccount;
import tech.reliab.course.zimovinaa1.bank.entity.User;
import tech.reliab.course.zimovinaa1.bank.service.UserService;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class UserImpl implements UserService {
    private User user;
    Gson gson = new Gson();
    Type payAccArrType = new TypeToken<ArrayList<JsonPayAcc>>() {}.getType();
    Type credAccArrType = new TypeToken<ArrayList<JsonCreditAcc>>() {}.getType();

    @Override
    public User createUser(Integer id, String firstName, String lastName, String patronymic,
                           String dateBirth, String workPlace, Double salary) {
        user = new User(id, firstName, lastName, patronymic, dateBirth, workPlace, salary);
        return user;
    }
    @Override
    public User createUser(Integer id, String firstName, String lastName, String patronymic,
                           String dateBirth, String workPlace) {
        user = new User(id, firstName, lastName, patronymic, dateBirth, workPlace);
        return user;
    }

    @Override
    public User readUser() {
        return user;
    }

    @Override
    public ArrayList<PaymentAccount> getPaymentAcc(){
        return this.user.getPaymentAccs();
    }

    @Override
    public ArrayList<CreditAccount> getCreditAcc(){return this.user.getCreditAccs();}

    @Override
    public void updateUserWork(User user, String workPlace) {
        user.setWorkPlace(workPlace);
    }

    @Override
    public void addPaymentAcc(int id, PaymentAccount paymentAccount, User user) {
        user.addPaymentAcc(id, paymentAccount, user);
    }


    @Override
    public void addCreditAcc(int id, CreditAccount creditAccount, User user){
        user.addCreditAcc(creditAccount);
    }



    @Override
    public void delete(User user) {
        if (this.user == user) {
            this.user = null;
        }
    }

    @Override
    public void saveToFile(String fileName, Bank bank) throws IOException {
        String payAccStr = gson.toJson(this.makeJsonPayAcc(bank.getId()));
        String creditAccStr = gson.toJson(this.makeJsonCreditAcc(bank.getId()));
        File file = new File(fileName);
        FileWriter writer = new FileWriter(file);
        writer.write("Платёжные счета:\n" + payAccStr + "\n\nКредитные счета:\n" + creditAccStr);
        writer.close();
    }

    private ArrayList<JsonPayAcc> makeJsonPayAcc(Integer bankID) {
        ArrayList<JsonPayAcc> jsonPay = new ArrayList<>();
        for (PaymentAccount paymentAccount : user.getPaymentAccs()) {
            if (Objects.equals(paymentAccount.getBank().getId(), bankID)) {
                jsonPay.add(new JsonPayAcc(paymentAccount));
            }
        }
        return jsonPay;
    }

    private ArrayList<JsonCreditAcc> makeJsonCreditAcc(Integer bankID) {
        ArrayList<JsonCreditAcc> jsonCredit = new ArrayList<>();
        for (CreditAccount creditAccount : user.getCreditAccs()) {
            if (Objects.equals(creditAccount.getBank().getId(), bankID)) {
                jsonCredit.add(new JsonCreditAcc(creditAccount));
            }
        }
        return jsonCredit;
    }

    private void makeCreditAccFromJson(ArrayList<JsonCreditAcc> jsonCreditAcc) {
        ArrayList<CreditAccount> creditAccounts = this.user.getCreditAccs();
        if (!jsonCreditAcc.isEmpty()) {
            for (int i = 0; i < creditAccounts.size(); i++) {
                for (int j = 0; j < creditAccounts.size(); j++) {
                    if (Objects.equals(creditAccounts.get(i).getId(), jsonCreditAcc.get(j).getId())) {
                        creditAccounts.get(i).updateFromJsonClass(jsonCreditAcc.get(j));
                    }
                }
            }
            this.user.setCreditAccs(creditAccounts);
        }
    }

    private void makePayAccFromJson(ArrayList<JsonPayAcc> jsonPayAcc) {
        ArrayList<PaymentAccount> payAcc = this.user.getPaymentAccs();
        if (!jsonPayAcc.isEmpty()) {
            for (int i = 0; i < payAcc.size(); i++) {
                for (int j = 0; j < payAcc.size(); j++) {
                    if (Objects.equals(payAcc.get(i).getIdPayAcc(), jsonPayAcc.get(j).getId())) {
                        payAcc.get(i).updateFromJsonClass(jsonPayAcc.get(j));
                    }
                }
            }
            this.user.setPaymentAccs(payAcc);
        }
    }

    @Override
    public void updateFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        boolean first = true;
        while (line != null) {
            if (!line.isEmpty()) {
                if (line.charAt(0) == '[') {
                    if (first) {
                        first = false;
                        this.makePayAccFromJson(gson.fromJson(line, payAccArrType));
                    } else {
                        this.makeCreditAccFromJson(gson.fromJson(line, credAccArrType));
                    }
                }
            }
            line = reader.readLine();
        }
    }

}
