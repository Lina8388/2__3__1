package web.list;



import web.models.User;

import java.util.ArrayList;
import java.util.List;

public class ListOfUsers {

private List<User> listUsers;

    {
        listUsers = new ArrayList<>();
        listUsers.add(new User("User1", "Lastname1", "user1@mail.ru"));
        listUsers.add(new User("User2", "Lastname2", "user2@mail.ru"));
        listUsers.add(new User("User3", "Lastname3", "user3@mail.ru"));
        listUsers.add(new User("User4", "Lastname4", "user4@mail.ru"));
    }

    public  List<User> getListUsers(){
        return listUsers;
    }

    public void setListUsers(User User){
        listUsers.add(User);
    }


}
