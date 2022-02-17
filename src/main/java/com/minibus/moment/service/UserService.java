package com.minibus.moment.service;

import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.user.UpdateProfile;
import com.minibus.moment.dto.user.UserDto;
import com.minibus.moment.dto.user.UserInfoDto;
import com.minibus.moment.exception.MinibusException;
import com.minibus.moment.service.uploader.S3Uploader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.minibus.moment.exception.MinibusErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final S3Uploader s3Uploader;

    public User login(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public UserInfoDto userInfo(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new MinibusException(USER_NOT_FOUND));
        return UserInfoDto.from(user);
    }

    @Transactional
    public void resign(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new MinibusException(USER_NOT_FOUND));
        userRepository.delete(user);
    }

    public UserDto getUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new MinibusException(USER_NOT_FOUND));
        return UserDto.from(user);

    }

    @Transactional
    public Long updateProfile(Long userId, MultipartFile image) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new MinibusException(USER_NOT_FOUND)
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
    public Long updateNickname(Long userId, UpdateProfile.Request request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new MinibusException(USER_NOT_FOUND)
        );
        return user.updateNickname(request.getNickname());
    }
}
