package freesia.soojoob.user.controller;

import freesia.soojoob.user.dto.SelectUser;
import freesia.soojoob.user.dto.SignUpDto;
import freesia.soojoob.user.dto.UpdateUser;
import freesia.soojoob.user.dto.UserInfo;
import freesia.soojoob.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> signUpUser(SignUpDto signUpDto) {
        userService.addUser(signUpDto);
        return new ResponseEntity<>("회원가입에 성공하였습니다 !", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateUser> updateUser(UpdateUser updateUser) {
        return new ResponseEntity<>(userService.editUser(updateUser), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser() {
        userService.deleteUser(1L);
        return new ResponseEntity<>("회원탈퇴하였습니다", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfo> findUser(@PathVariable(name = "userId") Long id) {
        return new ResponseEntity<>(userService.findUser(id), HttpStatus.OK);
    }
}
