package com.ulisses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ulisses.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
