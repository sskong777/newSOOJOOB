package freesia.soojoob.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserInfo {
    private Long id;
    private String username;
    private String email;

    @Builder
    private UserInfo(Long id, String username, String email) {
        this.email = email;
        this.id = id;
        this.username = username;
    }

}
