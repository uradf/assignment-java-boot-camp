package com.example.ecommerce.repository;

import com.example.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT id, userid, 'NULL' as password,name, surname, houseid, road, province, postid  FROM user", nativeQuery = true)
    Optional<User> findByUserid(String userId);

    Optional<User> findByUseridAndPassword(String userId, String password);
}
