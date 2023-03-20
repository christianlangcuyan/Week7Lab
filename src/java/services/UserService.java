package services;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import models.User;
import java.util.List;
/**
 *
 * @author Christian
 */

public class UserService {

    public List<User> getAll() throws Exception {
        return new UserDB().getAll();
    }

    public User get(String email) throws Exception {
        return new UserDB().get(email);
    }

    public void insert(String email, String firstName, String lastName, String password, int roleId) throws Exception {
        User user = new User(email, firstName, lastName, password);
        user.setRole(new RoleDB().get(roleId));
        new UserDB().insert(user);
    }

    public void update(String email, String firstName, String lastName, String password, int roleId) throws Exception {
        User user = new UserDB().get(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setRole(new RoleDB().get(roleId));
        new UserDB().update(user);
    }

    public void delete(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }
}

