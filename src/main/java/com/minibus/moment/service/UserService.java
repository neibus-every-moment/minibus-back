package com.minibus.moment.service;

import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserInfoDto userInfo(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(); //Todo: 예외처리
        return UserInfoDto.from(user);
    }

    public void resign(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(); //Todo: 예외처리
        userRepository.delete(user);
    }
}
