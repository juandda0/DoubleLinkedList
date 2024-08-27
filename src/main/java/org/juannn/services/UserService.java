package org.juannn.services;

import org.juannn.data_structures.DoubleLinkedList;
import org.juannn.models.User;
import org.juannn.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    // Constructor that initializes the service with a given UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Saves a new user to the repository
    public void save(User user) {
        userRepository.save(user);
    }

    // Finds all users in the repository
    public DoubleLinkedList<User> findAll() {
        return userRepository.findAll();
    }

    // Finds a user by their ID
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    // Updates the details of an existing user
    public void update(User updatedUser) {
        userRepository.update(updatedUser);
    }

    // Deletes a user by their ID
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    // Checks if a user exists by their ID
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    // Returns the number of users in the repository
    public Long count() {
        return userRepository.count();
    }
}
