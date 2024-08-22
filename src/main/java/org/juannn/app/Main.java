package org.juannn.app;

import org.juannn.data_structures.DoubleLinkedList;
import org.juannn.models.User;
import org.juannn.repository.UserRepository;
import org.juannn.repository.impl.UserRepositoryImpl;
import org.juannn.services.UserService;

public class Main {
    public static void main(String[] args) {


        DoubleLinkedList<User> userList = new DoubleLinkedList<>();
        UserRepository userRepository = new UserRepositoryImpl(userList);
        UserService userService = new UserService(userRepository);

        User user1 = new User(1L, "Santiago");
        User user2 = new User(2L, "Daniel");
        User user3 = new User(3L, "José");

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);


        for (User user : userService.findAll()){
            System.out.println(user.getNombre());
        }

        System.out.println();
    }
}