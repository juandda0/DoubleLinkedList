package org.juannn.repository.impl;

import org.juannn.models.User;
import org.juannn.data_structures.DoubleLinkedList;
import org.juannn.repository.UserRepository;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class UserRepositoryImpl implements UserRepository {

    private DoubleLinkedList<User> userList;

    // Constructor that initializes the repository with a given DoubleLinkedList
    public UserRepositoryImpl(DoubleLinkedList<User> userList) {
        this.userList = userList;
    }

    // Saves a new user to the list
    @Override
    public void save(User user) {
        userList.add(user);
    }

    // Finds a user by their ID
    @Override
    public User findById(Long id) {

        for(User user : userList) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        throw new IllegalArgumentException("User with ID: " + id + " not found.");
    }

    // Returns all users in the list
    @Override
    public DoubleLinkedList<User> findAll() {
        return userList;
    }

    // Updates the details of an existing user
    @Override
    public void update(User updatedUser) {
        for(User user : userList){
            if(user.getId().equals(updatedUser.getId())){
                user.setName(updatedUser.getName());
                return;
            }
        }
        throw new IllegalArgumentException("User with ID: " + updatedUser.getId() + " not found.");
    }

    // Deletes a user by their ID
    @Override
    public void deleteById(Long id) {

         for(User user : userList) {
             if (user.getId().equals(id)) {
                 userList.remove(user);
             }
         }
        throw new IllegalArgumentException("User with ID: " + id + " not found.");
    }

    // Checks if a user exists by their ID
    @Override
    public boolean existsById(Long id) {
        return findById(id) != null;
    }

    // Returns the number of users in the list
    @Override
    public Long count() {
        return (long) userList.size(); // Casts the size of the list to a Long
    }

}
