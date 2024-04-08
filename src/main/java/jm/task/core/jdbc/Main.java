package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
         //реализуйте алгоритм здесь
        userService.dropUsersTable();
        userService.createUsersTable();

        userService.saveUser("Vladimir", "Putin", (byte) 70);
        userService.saveUser("Lavrov", "Sergey", (byte) 73);
        userService.saveUser("Shoigu", "Sergey", (byte) 68);
        userService.saveUser("Biden", "Joseph", (byte) 80);

        userService.removeUserById(2);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();
    }
}
