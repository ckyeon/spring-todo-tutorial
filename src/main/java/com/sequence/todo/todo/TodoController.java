package com.sequence.todo.todo;

import com.sequence.todo.todo.dto.request.CreateRequestDto;
import com.sequence.todo.todo.dto.request.UpdateRequestDto;
import com.sequence.todo.todo.dto.response.FindAllResponseDto;
import com.sequence.todo.todo.dto.response.FindByIdResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/{userId}")
    public ResponseEntity<Void> create(@PathVariable Long userId, @RequestBody @Valid CreateRequestDto dto) {
        URI uri = todoService.create(userId, dto);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("")
    public ResponseEntity<List<FindAllResponseDto>> findAll() {
        List<FindAllResponseDto> findTodos = todoService.findAll();
        return ResponseEntity.ok(findTodos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindByIdResponseDto> findById(@PathVariable Long id) {
        FindByIdResponseDto findTodo = todoService.findById(id);
        return ResponseEntity.ok(findTodo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody @Valid UpdateRequestDto dto) {
        todoService.updateById(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}