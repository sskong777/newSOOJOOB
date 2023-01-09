package freesia.soojoob.user.dto;

import freesia.soojoob.user.entity.GENDER;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateUser {
    private String username;
    private String email;
    private int age;
    private GENDER gender;
    private String region;
    private int weight;
    private int height;

    @Builder
    private UpdateUser(String username, String email, int age, GENDER gender,
                       String region, int weight, int height) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.region = region;
        this.username = username;
        this.email = email;
        this.gender = gender;
    }
}
