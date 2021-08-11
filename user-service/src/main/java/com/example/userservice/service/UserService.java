package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);

    /* 이메일을 가지고 유저 상세 정보 검사하기 */
    UserDto getUserDetailsByEmail(String email);

    /* 전체 사용자 목록 반환 */
    Iterable<UserEntity> getUserByAll();

}
