package freesia.soojoob.global.login.controller;

import freesia.soojoob.global.CommonResponse;
import freesia.soojoob.global.login.config.JwtTokenProvider;
import freesia.soojoob.global.login.dto.LoginDto;
import freesia.soojoob.global.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/user/login")
    @ResponseBody
    public ResponseEntity<CommonResponse> login(
            @RequestBody LoginDto loginUserDto,
            HttpServletResponse response) {
            response.setHeader("X-AUTH-TOKEN", makeToken(loginUserDto.getEmail()));
            response.addCookie(makeCookie(loginUserDto.getEmail()));

            return ResponseEntity.ok(
                    CommonResponse.getSuccessResponse(getStatusCode(HttpStatus.OK),
                            "", loginService.login(loginUserDto))
            );

    }

    private String makeToken(String email) {
        return jwtTokenProvider.createToken(email);
    }

    private Cookie makeCookie(String email) {
        String token = makeToken(email);
        Cookie cookie = new Cookie("X-AUTH-TOKEN", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        return cookie;
    }

    private int getStatusCode(HttpStatus status) {
        return status.value();
    }
}
