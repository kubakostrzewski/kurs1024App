package dao;

import model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {

    void saveUser(User user) throws FileNotFoundException;
    void saveUsers(List<User> users) throws FileNotFoundException;
    List<User> getAllUsers() throws IOException;
    User getUserByLogin(String login) throws IOException;
    User getUserById(long userId) throws IOException;
    void removeUserByLogin(String login) throws IOException;
    void removeUserById(long userId) throws IOException;
}
