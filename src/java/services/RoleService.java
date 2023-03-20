package services;

import dataaccess.RoleDB;
import models.Role;
/**
 *
 * @author Christian
 */
public class RoleService {
    public Role get(int roleId) throws Exception {
        RoleDB roleDB = new RoleDB();
        return roleDB.get(roleId);
    }
}
