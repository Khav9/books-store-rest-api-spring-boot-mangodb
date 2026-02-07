package com.khavspring.books_store.mapper;

import com.khavspring.books_store.dto.UserInfoDto;
import com.khavspring.books_store.entity.UserInfo;

public class UserInfoMapper {

    public static UserInfoDto toDto(UserInfo userInfo) {
        return new UserInfoDto(userInfo.getUserName(), userInfo.getPassword(), userInfo.getRoles());
    }

    public static UserInfo toEntity(UserInfoDto userInfoDto) {
        return new UserInfo(userInfoDto.userName(), userInfoDto.password(), userInfoDto.roles());
    }
}
