package com.example.techtask.data.repository;

import com.example.techtask.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT o FROM Order o WHERE o.quantity>1 ORDER BY o.createdAt DESC LIMIT 1")
    Optional<Order> findLastWithMoreThanOneProduct();

    @Query("SELECT o FROM Order o JOIN User u ON o.userId=u.id " +
            "WHERE u.userStatus = 'ACTIVE' ORDER BY o.createdAt" )
    List<Order> findByActiveUsersOrderByDate();
}
