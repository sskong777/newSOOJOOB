package freesia.soojoob.user.entity;

import javax.persistence.*;

@Entity
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
}
