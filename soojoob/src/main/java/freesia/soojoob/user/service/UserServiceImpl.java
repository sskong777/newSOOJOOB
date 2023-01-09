package freesia.soojoob.user.service;

import freesia.soojoob.user.dto.SignUpDto;
import freesia.soojoob.user.dto.UpdateUser;
import freesia.soojoob.user.entity.User;
import freesia.soojoob.user.exception.AlreadyExistEmailException;
import freesia.soojoob.user.exception.AlreadyExistUsernameException;
import freesia.soojoob.user.exception.NoExistUserException;
import freesia.soojoob.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void addUser(SignUpDto signUpDto) {
        checkDuplicateEmail(signUpDto.getEmail());
        checkDuplicateUsername(signUpDto.getUsername());
        User user = signUpDto.toEntity();
        userRepository.save(user);
    }

    private void checkDuplicateEmail(String email) {
        if (!userRepository.existsByEmail(email)) {
            throw new AlreadyExistEmailException();
        }
    }

    private void checkDuplicateUsername(String username) {
        if (!userRepository.existsByUsername(username)) {
            throw new AlreadyExistUsernameException();
        }
    }

    @Override
    @Transactional
    public UpdateUser editUser(UpdateUser info) {
        // 임시 유저
        User user = userRepository.findById(1L).orElseThrow( ()-> {
            throw new NoExistUserException();
                }
        );
        //
        user.update(info);
        userRepository.save(user);
        return user.toInfoDto();
    }
}
