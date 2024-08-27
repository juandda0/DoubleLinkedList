package org.juannn.app;

import org.juannn.data_structures.DoubleLinkedList;
import org.juannn.models.User;
import org.juannn.repository.UserRepository;
import org.juannn.repository.impl.UserRepositoryImpl;
import org.juannn.services.UserService;

public class Main {
    public static void main(String[] args) {
        // Create a DoubleLinkedList to store users
        DoubleLinkedList<User> userList = new DoubleLinkedList<>();

        // Create a UserRepositoryImpl with the DoubleLinkedList
        UserRepository userRepository = new UserRepositoryImpl(userList);

        // Create a UserService with the UserRepository
        UserService userService = new UserService(userRepository);

        // Test save method
        User user1 = new User(1L, "Alice");
        User user2 = new User(2L, "Bob");
        userService.save(user1);
        userService.save(user2);

        // Print all users to verify save
        System.out.println("All users after save:");
        userService.findAll().printFoward();

        // Test findById method
        System.out.println("Finding user with ID 1:");
        User foundUser = userService.findById(1L);
        System.out.println(foundUser);

        // Test update method
        User updatedUser = new User(1L, "Alice Smith");
        userService.update(updatedUser);
        System.out.println("All users after update:");
        userService.findAll().printFoward();

        // Test deleteById method
        userService.deleteById(2L);
        System.out.println("All users after deleting user with ID 2:");
        userService.findAll().printFoward();

        // Test existsById method
        System.out.println("Checking if user with ID 1 exists:");
        boolean exists = userService.existsById(1L);
        System.out.println("Exists: " + exists);

        System.out.println("Checking if user with ID 2 exists:");
        exists = userService.existsById(2L);
        System.out.println("Exists: " + exists);

        // Test count method
        System.out.println("Number of users:");
        Long userCount = userService.count();
        System.out.println("Count: " + userCount);
    }
}
