package com.minibus.moment.service;

import com.minibus.moment.domain.user.User;
import com.minibus.moment.domain.user.UserRepository;
import com.minibus.moment.dto.UserDto;
import com.minibus.moment.dto.UserInfoDto;
import com.minibus.moment.dto.api.UpdateProfile;
import com.minibus.moment.exception.UserNotFoundException;
import com.minibus.moment.mockApi.dto.UserRequest;
import com.minibus.moment.service.uploader.S3Uploader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final S3Uploader s3Uploader;

    // 회원 로그인
    public User login(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("등록되지 않은 사용자입니다."));
    }

    // 회원 탈퇴
    public void resign(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("해당 유저를 찾을 수 없습니다."));
        userRepository.delete(user);
    }

    // 프로필 이미지 변경
    @Transactional
    public Long updateProfile(Long userId, MultipartFile image){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("해당 유저를 찾을 수 없습니다."));

        try {
            String profileImage = s3Uploader.uploadProfile(image, image.getOriginalFilename());
            return user.updateImage(profileImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Todo: 메서드 사용하는지 확인
    public UserDto getUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("해당 유저를 찾을 수 없습니다."));
        return UserDto.from(user);
    }

    //소셜 로그인을 사용해 jwt 토큰을 인증받고 토큰으로부터 email 주소를 알아내 사용자 정보를 가져올 때 사용
    public UserInfoDto userInfo(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("해당 유저를 찾을 수 없습니다."));
        return UserInfoDto.from(user);
    }

    // 앱에서 닉네임 변경
    @Transactional
    public Long updateNickname(Long userId, UpdateProfile.Request request){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException("해당 유저를 찾을 수 없습니다.")
        );
        return user.updateNickname(request.getNickname());
    }

    // 추후에 소셜로그인 적용시 사용
    // 카카오로부터 받아온 닉네임과 프로필 사진이 db에 없을 경우 저장, 있거나 기존 정보와 다를 경우 update
    @Transactional
    public User saveOrUpdate(UserRequest userRequest) {
        User user = userRepository.findByEmail(userRequest.getEmail())
                .map(entity -> entity.update(userRequest.getNickname(), userRequest.getProfileImage()))
                .orElse(userRequest.toEntity());
        return userRepository.save(user);
    }
}
