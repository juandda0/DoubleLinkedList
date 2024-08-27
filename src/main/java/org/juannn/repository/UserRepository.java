package org.juannn.repository;

import org.juannn.data_structures.DoubleLinkedList;
import org.juannn.models.User;

public interface UserRepository {

    public void save(User user);
    public User findById(Long id);
    public DoubleLinkedList<User> findAll();
    public void update(User user);
    public void deleteById(Long id);
    public boolean existsById(Long id);
    public Long count();
}
