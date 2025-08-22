package Dao;

import java.util.List;

import Pojo.User;

public interface userDao {
    void addUser(User user);
    User getUserId(int userId);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int userId);
    User checkLogin(String username, String password);

}
