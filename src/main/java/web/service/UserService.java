package web.service;



import web.models.User;

import java.util.List;

public interface UserService {

     List<User> getListUsers();

     void add(User user);

    // void update(User user);
     User update(int id, User updateUser);


     void removeUser(int id);

     User getUser(int id);



}
