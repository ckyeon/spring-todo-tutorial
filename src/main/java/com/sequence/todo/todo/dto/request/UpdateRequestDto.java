package com.sequence.todo.todo.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class UpdateRequestDto {

    @NotEmpty
    private String title;

    private String body;
}
