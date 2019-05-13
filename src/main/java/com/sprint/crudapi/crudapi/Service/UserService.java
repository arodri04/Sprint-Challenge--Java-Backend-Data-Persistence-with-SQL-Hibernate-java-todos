package com.sprint.crudapi.crudapi.Service;


import com.sprint.crudapi.crudapi.Model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserName(String username);

    User findUserById(long id);

    void delete(long id);

    User save(User user);

    User update(User user, long id);
}