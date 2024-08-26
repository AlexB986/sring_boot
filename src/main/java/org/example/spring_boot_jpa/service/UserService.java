package org.example.spring_boot_jpa.service;



import org.example.spring_boot_jpa.model.User;

import java.util.List;


public interface UserService {

    User addUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    User findByIdUser(Long id);

    List<User> findAllUser();
}
