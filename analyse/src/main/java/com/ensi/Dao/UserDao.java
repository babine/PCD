package com.ensi.Dao;

import java.util.List;

import com.ensi.Model.User;

public interface UserDao {
public void saveUser(User u);
public void updateUser(User u);
public void deleteUser(User u);
public User findByUsername(String username);
public List<User> getAllUsers();
}
