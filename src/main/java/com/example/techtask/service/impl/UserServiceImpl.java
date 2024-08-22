package com.example.techtask.service.impl;

import com.example.techtask.data.repository.UserRepository;
import com.example.techtask.model.User;
import com.example.techtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUser() {
        Optional<User> optionalUser = userRepository.findByMaxSumOrdersPriceIn2003();
        return optionalUser.orElseThrow(()-> new RuntimeException("Not found user "));
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAllByPaidOrdersIn2010();
    }
}
