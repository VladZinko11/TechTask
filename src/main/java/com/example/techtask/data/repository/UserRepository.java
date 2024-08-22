package com.example.techtask.data.repository;

import com.example.techtask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u JOIN u.orders o WHERE year(o.createdAt) = 2003 " +
            "GROUP BY u ORDER BY SUM(o.price) DESC LIMIT 1")
    Optional<User> findByMaxSumOrdersPriceIn2003();

    @Query("SELECT u FROM User u JOIN u.orders o WHERE o.orderStatus='PAID' " +
            "AND year(o.createdAt) = 2010 GROUP BY u")
    List<User> findAllByPaidOrdersIn2010();
}
