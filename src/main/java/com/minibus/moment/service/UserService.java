package com.minibus.moment.service;

import com.minibus.moment.auth.service.JwtTokenProvider;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.UserDto;
import com.minibus.moment.dto.UserInfoDto;
import com.minibus.moment.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserDto login(Long userId){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException()
        );
        return UserDto.from(user);
    }

    public UserInfoDto userInfo(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("해당 유저를 찾을 수 없습니다.")); //Todo: 예외처리
        return UserInfoDto.from(user);
    }

    public void resign(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("잘못된 접근입니다.")); //Todo: 예외처리
        userRepository.delete(user);
    }

    public UserDto getUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("해당 유저를 찾을 수 없습니다."));
        return UserDto.from(user);

    }
}
