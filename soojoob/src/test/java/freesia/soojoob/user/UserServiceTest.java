package freesia.soojoob.user;

import freesia.soojoob.global.login.UserDetailsImpl;
import freesia.soojoob.record.repository.RecordRepository;
import freesia.soojoob.user.dto.SignUpDto;
import freesia.soojoob.user.dto.UpdateUser;
import freesia.soojoob.user.dto.UserDetailInfo;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("유저 서비스")
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    UserService userService;
    @MockBean
    UserRepository userRepository;
    @MockBean
    RecordRepository recordRepository;
    @MockBean
    UserDetailsImpl userDetails;

    @MockBean
    PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository, passwordEncoder, recordRepository);
    }

    @Test
    @DisplayName("회원가입 성공")
    void 회원가입_성공() {
        SignUpDto signUpDto = new SignUpDto("aaa@aa.aa", "유저네임", "password");
        User user = signUpDto.toEntity();

        Mockito.when(passwordEncoder.encode(user.getPassword())).thenReturn("encodingPassword");
        userService.addUser(signUpDto);

        verify(userRepository, times(1)).save(any(User.class));
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
        Mockito.when(userDetails.getUser()).thenReturn(user);


        Assertions.assertThat(userService.editUser(info, userDetails).getUsername())
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


    @Test
    @DisplayName("현재 회원조회 성공")
    @WithMockUser
    void 현재_회원조회_성공() {
        User user = User.builder()
                .email("aaa@aa.aa")
                .username("유저네임")
                .password("password")
                .build();
        UserDetailInfo userDetailInfo = UserDetailInfo.createUserDetailInfo(user);

        Mockito.when(userDetails.getUser()).thenReturn(user);

        Assertions.assertThat(userService.findUserDetail(userDetails)).usingRecursiveComparison().isEqualTo(userDetailInfo);
    }

    @Test
    @DisplayName("회원 탈퇴 성공")
    void 회원_탈퇴_성공() {
        userService.deleteUser(1L);
        verify(userRepository, times(1)).deleteById(1L);

    }

}
