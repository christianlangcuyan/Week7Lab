package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author Christian
 */
public class UserDB {

    private static final ConnectionPool CP = ConnectionPool.getInstance();

    private static void executeQuery(String sql, Object... params) throws Exception {
        try (Connection con = CP.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ps.executeUpdate();
        }
    }

    public List<User> getAll() throws Exception {
        List<User> users = new ArrayList<>();
        try (Connection con = CP.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM user");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String email = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                int roleID = rs.getInt(5);
                User user = new User(email, firstName, lastName, new Role(roleID));
                users.add(user);
            }
        }
        return users;
    }

    public User get(String email) throws Exception {
        try (Connection con = CP.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE email=?")) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String firstName = rs.getString(2);
                    String lastName = rs.getString(3);
                    int roleID = rs.getInt(5);
                    return new User(email, firstName, lastName, new Role(roleID));
                }
            }
        }
        return null;
    }

    public void insert(User user) throws Exception {
        executeQuery("INSERT INTO user VALUES (?, ?, ?, ?, ?)", 
                     user.getEmail(), user.getFirstName(), user.getLastName(),
                     user.getPassword(), user.getRole().getRoleID());
    }

    public void update(User user) throws Exception {
        executeQuery("UPDATE user SET first_name=?, last_name=?, password=?, role=? WHERE email=?",
                     user.getFirstName(), user.getLastName(), user.getPassword(),
                     user.getRole().getRoleID(), user.getEmail());
    }

    public void delete(User user) throws Exception {
        executeQuery("DELETE FROM user WHERE email=?", user.getEmail());
    }
}
