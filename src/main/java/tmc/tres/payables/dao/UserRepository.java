package tmc.tres.payables.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tmc.tres.payables.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
    
    User findById(int id);
}
