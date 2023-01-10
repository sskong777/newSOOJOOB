package freesia.soojoob.user.dto;

import freesia.soojoob.user.entity.GENDER;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateUser {
    private String username;
    private String email;
    private Integer age;
    private GENDER gender;
    private String region;
    private Integer weight;
    private Integer height;

    @Builder
    private UpdateUser(String username, String email, Integer age, GENDER gender,
                       String region, Integer weight, Integer height) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.region = region;
        this.username = username;
        this.email = email;
        this.gender = gender;
    }
}
