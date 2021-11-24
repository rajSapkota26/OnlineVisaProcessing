package com.everestcoders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.everestcoders.model.User;

public interface UserRepository extends JpaRepository<User,String> {

    @Query("select u from User  u where  u.email=:email")
    public User getUserByUserName(@Param("email") String email);

    @Query("select u.role from User u where u.email=:email")
    public String getRoles(@Param("email") String email);
}
