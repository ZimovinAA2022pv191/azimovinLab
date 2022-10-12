package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Employee;
import tech.reliab.course.zimovinaa1.bank.entity.User;

import java.util.Date;

public interface UserService {
    User createUser(Integer id, String firstName, String lastName, String patronymic,
                    Date dateBirth, String workPlace);

    void readUser(User user);

    void updateUserWork(User user, String workPlace);
}
