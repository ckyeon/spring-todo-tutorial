package com.sequence.todo.user.dto.response;

import com.sequence.todo.user.User;
import lombok.Getter;

@Getter
public class FindByIdResponseDto {

    private Long id;
    private String email;
    private String name;
    private String description;

    private FindByIdResponseDto(Long id, String email, String name, String description) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.description = description;
    }

    public static FindByIdResponseDto fromEntity(User user) {
        return new FindByIdResponseDto(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getDescription()
        );
    }
}
