package com.example.car.security.oauth2.user;

import com.example.car.exception.OAuth2AuthenticationProcessingException;
import com.example.car.entity.AuthProvider;

import java.util.Map;

public class OAuth2UserInfoFactory {
    //OAuth2UserInfo 객체 생성
    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.kakao.toString())) {
            return new KakaoOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}