package freesia.soojoob.user.entity;

import freesia.soojoob.user.dto.UpdateUser;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String password;

    private String username;

    private int age;

    private String email;

    private GENDER gender;

    private String region;

    private int weight;

    private int height;

    @Builder
    public User (String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = encodingPassword(password);
    }

    private String encodingPassword(String password) {
        return password;
    }

    public void update(UpdateUser info) {
        this.weight = info.getWeight();
        this.height = info.getHeight();
        this.age = info.getAge();
        this.region = info.getRegion();
        this.username = info.getUsername();
        this.email = info.getEmail();
        this.gender = info.getGender();
    }

    public UpdateUser toInfoDto(){
        return UpdateUser.builder()
                .email(this.email)
                .username(this.username)
                .weight(this.weight)
                .height(this.height)
                .age(this.age)
                .region(this.region)
                .gender(this.gender)
                .build();
    }

}
