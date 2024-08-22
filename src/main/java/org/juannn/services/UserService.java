package org.juannn.services;

import org.juannn.data_structures.DoubleLinkedList;
import org.juannn.models.User;
import org.juannn.repository.UserRepository;

public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public DoubleLinkedList<User> findAll() {
        return userRepository.findAll();
    }

}
