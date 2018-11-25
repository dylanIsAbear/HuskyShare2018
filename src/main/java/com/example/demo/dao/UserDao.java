package com.example.demo.dao;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Nullable
    @Query("select u from User u where u.email=?1")
    User findByEmail(String email);

    @Nullable
    @Query("select u from User u where u.id=?1")
    User findByName(String username);

    @Nullable
    @Query("select u from User u where u.id=?1")
    User findById(int uid);
}
