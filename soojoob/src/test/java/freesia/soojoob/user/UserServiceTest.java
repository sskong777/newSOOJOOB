package freesia.soojoob.user;

import freesia.soojoob.user.dto.SignUpDto;
import freesia.soojoob.user.dto.UpdateUser;
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

import java.util.Optional;

@DisplayName("유저 서비스")
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

    @Test
    @DisplayName("회원정보 수정 성공")
    void 회원정보_수정_성공() {
        User user = User.builder()
                .email("aaa@aa.aa")
                .username("유저네임")
                .password("password")
                .build();
        UpdateUser info = UpdateUser.builder()
                .username("유저네임2")
                .build();

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Assertions.assertThat(userService.editUser(info).getUsername())
                .isEqualTo(info.getUsername());
    }

    @Test
    @DisplayName("Pk로 회원정보 조회 성공")
    void pk로_회원정보_조회_성공() {
        User user = User.builder()
                .email("aaa@aa.aa")
                .username("유저네임")
                .password("password")
                .build();

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Assertions.assertThat(userService.findUser(1L).getUsername()).isEqualTo("유저네임");
    }

}
