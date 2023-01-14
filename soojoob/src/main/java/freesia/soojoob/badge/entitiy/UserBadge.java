package freesia.soojoob.badge.entitiy;


import freesia.soojoob.user.entity.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class UserBadge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

    public UserBadge(User user, Badge badge){
        this.user = user;
        this.badge = badge;
    }
}
