package services;

import dataaccess.UserDB;
import models.Role;
import models.User;
import java.util.List;

/**
 *
 * @author Christian
 */


public class UserService {

    private UserDB userDB;

    public UserService() {
        userDB = new UserDB();
    }

    public List<User> getAll() throws Exception {
        return userDB.getAll();
    }

    public User get(String email) throws Exception {
        return userDB.get(email);
    }

    public void insert(String email, String firstName, String lastName, 
                       String password, int roleID) throws Exception {
        Role role = new Role(roleID);
        User user = new User(email, firstName, lastName, password, role);
        userDB.insert(user);
    }

    public void update(String email, String firstName, String lastName, 
                       String password, int roleID) throws Exception {
        Role role = new Role(roleID);
        User user = new User(email, firstName, lastName, password, role);
        userDB.update(user);
    }

    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        userDB.delete(user);
    }
}

