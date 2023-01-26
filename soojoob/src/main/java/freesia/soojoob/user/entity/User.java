package freesia.soojoob.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import freesia.soojoob.plogging.entity.Plogging;
import freesia.soojoob.badge.entitiy.UserBadge;
import freesia.soojoob.record.entity.Record;
import freesia.soojoob.user.dto.UpdateUser;
import freesia.soojoob.user.dto.UserInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

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

    private Integer age;

    private String email;

    private GENDER gender;

    private String region;

    private Integer weight;

    private Integer height;

    @OneToMany(mappedBy = "user", cascade = ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserBadge> userBadges = new ArrayList<>();

    @OneToMany(mappedBy = "ploggingUser", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Plogging> ploggingList = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = ALL, orphanRemoval = true)
    @JsonIgnore
    private Record userRecord;

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

    public UpdateUser toUpdateDto(){
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

    public UserInfo toInfoDto(){
        return UserInfo.builder()
                .id(this.id)
                .email(this.email)
                .username(this.username)
                .build();
    }
}
