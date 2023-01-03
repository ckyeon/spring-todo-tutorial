package com.sequence.todo.todo.dto.response;

import com.sequence.todo.todo.Todo;
import com.sequence.todo.user.User;
import lombok.Getter;

@Getter
public class FindByIdResponseDto {

    private String title;
    private String body;
    private User user;

    private FindByIdResponseDto(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public static FindByIdResponseDto fromEntity(Todo todo) {
        return new FindByIdResponseDto(
                todo.getTitle(),
                todo.getBody(),
                todo.getUser()
        );
    }
}
