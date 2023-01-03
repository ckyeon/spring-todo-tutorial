package com.sequence.todo.todo;

import com.sequence.todo.exception.ErrorMessage;
import com.sequence.todo.todo.dto.request.CreateRequestDto;
import com.sequence.todo.todo.dto.request.UpdateRequestDto;
import com.sequence.todo.todo.dto.response.FindAllResponseDto;
import com.sequence.todo.todo.dto.response.FindByIdResponseDto;
import com.sequence.todo.user.User;
import com.sequence.todo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Transactional
    public URI create(Long userId, CreateRequestDto dto) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElseThrow(() -> new NoSuchElementException(ErrorMessage.USER_NOT_FOUND.getMessage()));

        Todo todo = dto.toEntity(user);
        todoRepository.save(todo);

        return URI.create("/todos/" + todo.getId());
    }

    @Transactional(readOnly = true)
    public List<FindAllResponseDto> findAll() {
        List<Todo> todos = todoRepository.findAll();
        Stream<Todo> todoStream = todos.stream();
        Stream<FindAllResponseDto> dtoStream = todoStream.map(FindAllResponseDto::fromEntity);
        return dtoStream.toList();
    }

    @Transactional(readOnly = true)
    public FindByIdResponseDto findById(Long id) {
        Todo todo = findTodoById(id);
        return FindByIdResponseDto.fromEntity(todo);
    }

    @Transactional
    public void updateById(Long id, UpdateRequestDto dto) {
        Todo todo = findTodoById(id);
        todo.update(dto.getTitle(), dto.getBody());
    }

    @Transactional
    public void deleteById(Long id) {
        Todo todo = findTodoById(id);
        todoRepository.delete(todo);
    }

    private Todo findTodoById(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        return optionalTodo.orElseThrow(() -> new NoSuchElementException(ErrorMessage.TODO_NOT_FOUND.getMessage()));
    }
}
