package com.khavspring.books_store.service.impl;

import com.khavspring.books_store.dto.UserInfoDto;
import com.khavspring.books_store.entity.UserInfo;
import com.khavspring.books_store.mapper.UserInfoMapper;
import com.khavspring.books_store.repository.UserInfoRepository;
import com.khavspring.books_store.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public UserInfoDto createUser(UserInfoDto userInfoDto) {
        UserInfo userInfo = UserInfoMapper.toEntity(userInfoDto);
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return UserInfoMapper.toDto(userInfo);
    }
}
