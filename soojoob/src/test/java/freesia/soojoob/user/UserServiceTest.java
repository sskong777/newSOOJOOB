package freesia.soojoob.user;

import freesia.soojoob.user.dto.SignUpDto;
import freesia.soojoob.user.entity.User;
import freesia.soojoob.user.repository.UserRepository;
import freesia.soojoob.user.service.UserService;
import freesia.soojoob.user.service.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    UserService userService;

    @MockBean
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    @DisplayName("회원가입 성공")
    void 회원가입_성공() {
        SignUpDto signUpDto = new SignUpDto("aaa@aa.aa", "유저네임", "password");
        User user = signUpDto.toEntity();

        Mockito.when(userRepository.save(user)).thenReturn(user);
        userService.addUser(signUpDto);

        Assertions.assertThat(userRepository.save(user)).isEqualTo(user);
    }
}
