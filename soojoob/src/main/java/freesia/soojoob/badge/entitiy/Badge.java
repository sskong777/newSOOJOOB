package freesia.soojoob.badge.entitiy;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "badges")
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="badge_id")
    private int id;


    @Column(name="badge_name")
    private String name;

    @Column(name="badge_detail")
    private String detail;

    @Column(name="badge_url")
    private String imgUrl;

}
