package com.khavspring.books_store.mapper;

import com.khavspring.books_store.entity.UserInfo;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoUserDetailsMapper implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> grantedAuthorities;

    //    constructor
    public UserInfoUserDetailsMapper(UserInfo userInfo) {
        username = userInfo.getUserName();
        password = userInfo.getPassword();
        grantedAuthorities = Arrays.stream(userInfo.getRoles().split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
