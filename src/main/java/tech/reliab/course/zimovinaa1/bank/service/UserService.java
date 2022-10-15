package tech.reliab.course.zimovinaa1.bank.service;

import tech.reliab.course.zimovinaa1.bank.entity.Employee;
import tech.reliab.course.zimovinaa1.bank.entity.User;

import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

public interface UserService {
    User createUser(Integer id, String firstName, String lastName, String patronymic,
                    LocalTime dateBirth, String workPlace);

    User readUser();

    void updateUserWork(User user, String workPlace);

    void delete(User user);
}
