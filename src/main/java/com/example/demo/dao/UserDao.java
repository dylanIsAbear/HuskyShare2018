package com.example.demo.dao;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email=?1")
    User findByEmail(String email);

    @Query("select u from User u where u.username=?1")
    User findByName(String username);

    @Query("select u from User u where u.id=?1")
    User findById(int uid);

    @Modifying
    @Query("update User u set u.status = ?1 where u.id = ?2")
    void updateByStatus(int status, int uid);
}
