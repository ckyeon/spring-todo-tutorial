package com.sequence.todo.todo.dto.request;

import com.sequence.todo.todo.Todo;
import com.sequence.todo.user.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateRequestDto {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    private String body;

    public Todo toEntity(User user) {
        return new Todo(title, body, user);
    }
}
