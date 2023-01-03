package com.sequence.todo.user.dto.request;

import com.sequence.todo.user.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String name;

    private String description;

    public User toEntity() {
        return new User(email, name, description);
    }
}
