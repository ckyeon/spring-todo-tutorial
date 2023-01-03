package com.sequence.todo.user;

import com.sequence.todo.user.dto.request.SignUpRequestDto;
import com.sequence.todo.user.dto.request.UpdateRequestDto;
import com.sequence.todo.user.dto.response.FindAllResponseDto;
import com.sequence.todo.user.dto.response.FindByIdResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signUp(@RequestBody @Valid SignUpRequestDto dto) {
        URI uri = userService.signUp(dto);
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("")
    public ResponseEntity<List<FindAllResponseDto>> findAll() {
        List<FindAllResponseDto> findUsers = userService.findAll();
        return ResponseEntity.ok(findUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindByIdResponseDto> findById(@PathVariable Long id) {
        FindByIdResponseDto findUser = userService.findById(id);
        return ResponseEntity.ok(findUser);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody @Valid UpdateRequestDto dto) {
        userService.updateById(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
