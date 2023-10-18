package com.example.userservice.dto;

import com.example.userservice.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor @Builder @ToString
public class ResponseFindUserDto {
    private String email;

    private String name;

    private String userId;

    private String uuid;

//    private List<Order> orderList;

    public ResponseFindUserDto(User user){
        this.email = user.getEmail();
        this.name = user.getName();
        this.userId = user.getUserId();
        this.uuid = user.getUuid();
    }
}
