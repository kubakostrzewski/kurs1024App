package dao;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private String fileName;

    public UserDaoImpl(String fileName) {
        this.fileName = fileName;
    }

    public void saveUser(User user) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        PrintWriter writer = new PrintWriter(fileOutputStream);
        writer.print(user.toString());
        writer.close();
    }

    public void saveUsers(List<User> users) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        PrintWriter writer = new PrintWriter(fileOutputStream);
        for (User u : users){
            writer.print(u.toString());
        }
        writer.close();
    }
    public void saveUsers(List<User> users, boolean append) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, append);
        PrintWriter writer = new PrintWriter(fileOutputStream);
        for (User u : users){
            writer.print(u.toString());
        }
        writer.close();
    }

    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while (line!=null){
            users.add(parseUser(line));
            line = reader.readLine();
        }
        reader.close();
        return users;
    }

    public User getUserByLogin(String login) throws IOException {
        UserDaoImpl userDao = new UserDaoImpl(fileName);
        List<User> users = userDao.getAllUsers();
        for (User u : users){
            if (u.getLogin().equals(login)){
                return u;
            }
        }
        return null;
    }

    public User getUserById(long userId) throws IOException {
        UserDaoImpl userDao = new UserDaoImpl(fileName);
        List<User> users = userDao.getAllUsers();
        for (User u : users){
            if (u.getId() == userId){
                return u;
            }
        }
        return null;
    }

    public void removeUserByLogin(String login) throws IOException {
        UserDaoImpl userDao = new UserDaoImpl(fileName);
        List<User> users = userDao.getAllUsers();
        for (User u : users){
            if (u.getLogin().equals(login)){
                users.remove(users.indexOf(u));
                saveUsers(users, false);
                break;
            }
        }
    }

    public void removeUserById(long userId) throws IOException {
        UserDaoImpl userDao = new UserDaoImpl(fileName);
        List<User> users = userDao.getAllUsers();
        for (User u : users){
            if (u.getId() == userId){
                users.remove(users.indexOf(u));
                saveUsers(users, false);
                break;
            }
        }
    }
    private User parseUser(String line){
        String values[] = line.split("#");
        long id = Long.parseLong(values[0]);
        String login = values[1];
        String password = values[2];
        return new User(id,login,password);
    }
}
