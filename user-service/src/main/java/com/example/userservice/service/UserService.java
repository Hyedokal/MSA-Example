package com.example.userservice.service;

import com.example.userservice.domain.User;
import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.dto.ResponseFindUserDto;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //회원 가입
    public void createUser(RequestCreateUserDto userDto){
        //dto를 entity로 변경해주는 작업이 필요하다.
        User user = userDto.toEntity();
        userRepository.save(user);
    }

    //UUID로 회원 찾기
    public ResponseFindUserDto findUser(String uuid){
        User user =  userRepository.findUserByUuid(uuid);
        if(user == null){
            throw new UserNotFoundException("해당 유저는 존재하지 않습니다.");
        }
        ResponseFindUserDto dto = new ResponseFindUserDto(user);
//        dto.setOrderList(List.of());
        return new ResponseFindUserDto(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
