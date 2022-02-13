package com.minibus.moment.service;

import com.minibus.moment.auth.service.JwtTokenProvider;
import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.UserDto;
import com.minibus.moment.dto.UserInfoDto;
import com.minibus.moment.dto.api.UpdateProfile;
import com.minibus.moment.exception.UserNotFoundException;
import com.minibus.moment.service.uploader.S3Uploader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final S3Uploader s3Uploader;

    public User login(Long userId){
        return userRepository.findById(userId).orElseThrow();
    }

    public UserInfoDto userInfo(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("해당 유저를 찾을 수 없습니다.")); //Todo: 예외처리
        return UserInfoDto.from(user);
    }

    public void resign(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("해당 유저를 찾을 수 없습니다.")); //Todo: 예외처리
        userRepository.delete(user);
    }

    public UserDto getUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("해당 유저를 찾을 수 없습니다."));
        return UserDto.from(user);

    }

    @Transactional
    public Long updateProfile(Long userId, MultipartFile image){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("해당 유저를 찾을 수 없습니다.")
        );
        try {
            String profileImage = s3Uploader.uploadProfile(image, image.getOriginalFilename());
            return user.updateImage(profileImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public Long updateNickname(Long userId, UpdateProfile.Request request){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("해당 유저를 찾을 수 없습니다.")
        );
        return user.updateNickname(request.getNickname());
    }
}
