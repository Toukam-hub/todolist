package com.example.taksmanager.taskmanager.repository;

import com.example.taksmanager.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
