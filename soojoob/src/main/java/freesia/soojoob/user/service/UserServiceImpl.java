package freesia.soojoob.user.service;

import freesia.soojoob.user.dto.SignUpDto;
import freesia.soojoob.user.entity.User;
import freesia.soojoob.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void addUser(SignUpDto signUpDto) {
        User user = signUpDto.toEntity();
        userRepository.save(user);
    }
}
