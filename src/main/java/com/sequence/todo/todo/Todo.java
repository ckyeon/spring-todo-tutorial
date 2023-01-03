package com.sequence.todo.todo;

import com.sequence.todo.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Todo(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public void update(String title, String body) {
        if (title != null) {
            this.title = title;
        }

        if (body != null) {
            this.body = body;
        }
    }
}
