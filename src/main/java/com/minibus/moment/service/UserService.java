package com.minibus.moment.service;

import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void resign(String email) {
        User userEmail = userRepository.findByEmail(email)
                .orElseThrow();

        userRepository.delete(userEmail);
    }

}
