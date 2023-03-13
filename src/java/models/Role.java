package models;

import java.io.Serializable;

/**
 *
 * @author Chris
 */
public class Role implements Serializable {
    private int roleID;
    private String roleName;
    
    public Role(int roleID) {
        this.roleID = roleID;
        if (roleID == 1) {
            roleName = "system admin";
        } else {
            roleName = "regular user";
        }
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}