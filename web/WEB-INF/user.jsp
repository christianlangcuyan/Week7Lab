<%-- 
    Document   : users
    Created on : 11-Mar-2023, 7:11:47 PM
    Author     : Christian
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Users</title>
    </head>
    <body>
        ${message}
        <h1>Manage Users</h1>
        <a href="users.jsp"></a>
            <table border="1">
                <tr>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role</th>
                    <th></th>
                    <th></th>
                </tr>
                
                <h2>Add User</h2>
                <form action="" method="POST">
                    Email: <input type="email" name="email" value="${email}"><br>
                    First name: <input type="text" name="firstname" value="${firstname}"><br>
                    Last name: <input type="text" name="lastname" value="${lastname}" ><br>
                    Password: <input type="password" name="password"><br>
                    Role:  
                    <select name="role">
                        <option value="2">regular user</option>
                        <option value="1">system admin</option>
                    </select><br>

                    <input type="submit" name="submit" value="Add user">
                </form>
                ${formmessage}
                  
    </body>
</html>

