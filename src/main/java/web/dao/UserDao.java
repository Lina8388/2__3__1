package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {

    List<User> getListUsers();

    void add(User user);

    User update(int id, User updateUser);

    void removeUser(int id);

    User getUser(int id);
}
