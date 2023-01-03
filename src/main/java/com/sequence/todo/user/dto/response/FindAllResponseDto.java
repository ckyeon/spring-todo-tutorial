package com.sequence.todo.user.dto.response;

import com.sequence.todo.user.User;
import lombok.Getter;

@Getter
public class FindAllResponseDto {

    private Long id;
    private String email;
    private String name;

    private FindAllResponseDto(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public static FindAllResponseDto fromEntity(User user) {
        return new FindAllResponseDto(
                user.getId(),
                user.getEmail(),
                user.getName()
        );
    }
}
