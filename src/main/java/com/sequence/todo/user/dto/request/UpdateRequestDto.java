package com.sequence.todo.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateRequestDto {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String name;

    private String description;
}
