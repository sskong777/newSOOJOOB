package freesia.soojoob.Plogging.entity;


import freesia.soojoob.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "ploggings")
@RequiredArgsConstructor
@AllArgsConstructor
public class Plogging {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="plogging_id")
    private int id;

    @Column(name = "date_time")
    private String dateTime;

    @Column(name = "distance")
    private Float distance;

    @Column(name = "trash_count")
    private int trashCount;

    @Column(name = "time_record")
    private int timeRecord;

    @Column(name = "plogging_img")
    private String ploggingImg;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User ploggingUser;

}
