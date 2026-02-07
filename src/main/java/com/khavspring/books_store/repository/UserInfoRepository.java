package com.khavspring.books_store.repository;

import com.khavspring.books_store.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserInfoRepository extends MongoRepository<UserInfo, String> {

    Optional<UserInfo> findByUserName(String userName);
}
