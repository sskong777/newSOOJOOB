package freesia.soojoob.global.login.service;

import freesia.soojoob.global.login.config.JwtTokenProvider;
import freesia.soojoob.global.login.dto.LoginDto;
import freesia.soojoob.global.login.dto.LoginResponse;
import freesia.soojoob.global.login.exception.IncorrectPassword;
import freesia.soojoob.global.login.exception.NoExistEmail;
import freesia.soojoob.user.entity.User;
import freesia.soojoob.user.exception.NoExistUserException;
import freesia.soojoob.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public LoginResponse login(LoginDto loginDto) {

        User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> {
                    throw new NoExistEmail();
                }
        );
        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new IncorrectPassword();

        }
        String email = user.getEmail();
        return new LoginResponse(jwtTokenProvider.createToken(email));
    }


}
