package org.example.spring_boot_jpa.service;
import jakarta.transaction.Transactional;

import org.example.spring_boot_jpa.model.User;
import org.example.spring_boot_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User addUser(User user) {
        return userRepository.save(user);

    }

    @Transactional
    @Override
    public void updateUser(Long id, User user) {
        User userFind = findByIdUser(id);
        if (userFind != null) {
            userFind.setName(user.getName());
            userFind.setEmail(user.getEmail());
            userFind.setCourse(user.getCourse());
            userRepository.save(userFind);
        }
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(Math.toIntExact(id));
    }

    @Transactional
    @Override
    public User findByIdUser(Long id) {
        Optional<User> userFindId = userRepository.findById(Math.toIntExact(id));
        if (userFindId.isPresent()) {
            return userFindId.get();
        }
        return null;
    }

    @Transactional
    @Override
    public List<User> findAllUser() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }
}
