package freesia.soojoob.user.controller;

import freesia.soojoob.global.CommonResponse;
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
    public ResponseEntity<CommonResponse> signUpUser(@RequestBody SignUpDto signUpDto) {
        userService.addUser(signUpDto);
        return ResponseEntity.ok(
                CommonResponse.getSuccessResponse(getStatusCode(HttpStatus.CREATED), "회원가입에 성공하였습니다 !","")
        );
    }

    @PutMapping("/update")
    public ResponseEntity<CommonResponse> updateUser(@RequestBody UpdateUser updateUser) {
        return ResponseEntity.ok(
                CommonResponse.getSuccessResponse(getStatusCode(HttpStatus.OK), "회원 정보를 수정했습니다", userService.editUser(updateUser))
        );
    }

    @DeleteMapping
    public ResponseEntity<CommonResponse> deleteUser() {
        userService.deleteUser(1L);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<CommonResponse> findUser(@PathVariable(name = "userId") Long id) {
        return ResponseEntity.ok(
                CommonResponse.getSuccessResponse(getStatusCode(HttpStatus.OK), "ID에 해당하는 유저정보를 전송했습니다 !", userService.findUser(id))
        );
    }

    private int getStatusCode(HttpStatus status) {
        return status.value();
    }
}
