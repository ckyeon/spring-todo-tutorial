package com.sequence.todo.user;

import com.sequence.todo.exception.ErrorMessage;
import com.sequence.todo.user.dto.request.SignUpRequestDto;
import com.sequence.todo.user.dto.request.UpdateRequestDto;
import com.sequence.todo.user.dto.response.FindAllResponseDto;
import com.sequence.todo.user.dto.response.FindByIdResponseDto;
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
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public URI signUp(SignUpRequestDto dto) {
        String email = dto.getEmail();
        validateDuplicateEmail(email);

        User user = dto.toEntity();
        userRepository.save(user);

        return URI.create("/users/" + user.getId());
    }

    @Transactional(readOnly = true)
    public List<FindAllResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        Stream<User> userStream = users.stream();
        Stream<FindAllResponseDto> dtoStream = userStream.map(FindAllResponseDto::fromEntity);
        return dtoStream.toList();
    }

    @Transactional(readOnly = true)
    public FindByIdResponseDto findById(Long id) {
        User user = findUserById(id);
        return FindByIdResponseDto.fromEntity(user);
    }

    @Transactional
    public void updateById(Long id, UpdateRequestDto dto) {
        User user = findUserById(id);
        user.update(dto.getEmail(), dto.getName(), dto.getDescription());
    }

    @Transactional
    public void deleteById(Long id) {
        User user = findUserById(id);
        userRepository.delete(user);
    }

    private void validateDuplicateEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        optionalUser.ifPresent(user -> {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_EMAIL.getMessage());
        });
    }

    private User findUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseThrow(() -> new NoSuchElementException(ErrorMessage.USER_NOT_FOUND.getMessage()));
    }
}
