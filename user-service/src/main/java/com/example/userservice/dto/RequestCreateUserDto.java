package com.example.userservice.dto;

import com.example.userservice.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

//Controller Layer에 클라이언트의 회원가입 요청이 들어왔을 때 데이터를 받아오는 DTO.
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @Builder @ToString
//@Data 어노테이션의 경우 ToString에서 충돌이 일어날 수 있으므로 잘 사용하지 않는다.
public class RequestCreateUserDto {

    @Email
    private String email;

    @Size(min=8, max=20, message = "비밀번호는 최소 8글자에서 최대 20글자입니다.")
    private String pw;

    private String name;

    private String userId;

    public User toEntity(){
        return User.builder()
                .email(this.email)
                .encPw(this.pw)
                .userId(this.userId)
                .name(this.name)
                .uuid(UUID.randomUUID().toString())
                .createAt(LocalDateTime.now())
                .build();
    }
}
