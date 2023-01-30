package freesia.soojoob.user.dto;

import freesia.soojoob.user.entity.GENDER;
import freesia.soojoob.user.entity.User;

public class UserDetailInfo {
    private Long userid;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private GENDER gender;
    private String region;
    private Integer weight;
    private Integer height;


    private UserDetailInfo UserDetailInfo(User user) {
        this.userid = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.age = user.getAge();
        this.gender = user.getGender();
        this.region = user.getRegion();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        return this;
    }
    
    public UserDetailInfo createUserDetailInfo(User user) {
        return UserDetailInfo(user);
    }

    public static class createUserDetailInfo extends UserDetailInfo {
        public createUserDetailInfo(User user) {
            super();
        }
    }
}
