package freesia.soojoob.user.controller;

import freesia.soojoob.user.dto.SignUpDto;
import freesia.soojoob.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> signUpUser(SignUpDto signUpDto) {
        userService.addUser(signUpDto);
        return new ResponseEntity<>("회원가입에 성공하였습니다 !", HttpStatus.OK);
    }

}
