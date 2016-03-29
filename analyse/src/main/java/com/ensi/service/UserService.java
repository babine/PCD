package com.ensi.service;

import java.util.List;

import com.ensi.Model.User;


public interface UserService {
public void saveUser(User u);
public void updateUser(User u);
public void deleteUser(User u);
public List<User> getAllUsers();
}
