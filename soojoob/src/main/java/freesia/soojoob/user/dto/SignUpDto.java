package freesia.soojoob.user.dto;

import freesia.soojoob.user.entity.User;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class SignUpDto {
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String email;

    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-z|A-Z|0-9|ㄱ-ㅎ|가-힣]{2,10}$", message = "닉네임은 최소 2자, 최대 10자 영어, 한글, 숫자만 입력가능합니다.")
    private String username;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;

    public User toEntity(){
        return User.builder()
                .email(this.email)
                .username(this.username)
                .password(this.password)
                .build();
    }

}
