package freesia.soojoob.record.entity;

import freesia.soojoob.plogging.entity.Plogging;
import freesia.soojoob.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
@Table(name = "records")

public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="record_id")
    private int id;

    @Column(name="total_distance")
    private double totalDistance;

    @Column(name="total_trash_count")
    private int totalTrashCount;

    @Column(name="total_time_record")
    private int totalTimeRecord;

    @Column(name="badge_count")
    private int badgeCount;

    @Column(name="exp")
    private double exp;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Record(User user) {
        this.user = user;
        this.totalDistance = 0.0;
        this.totalTrashCount = 0;
        this.badgeCount = 0;
        this.totalTimeRecord = 0;
        this.exp = 36.5;
    }

    public void updateRecord(Plogging plogging){
        this.totalDistance += plogging.getDistance();
        this.totalTimeRecord += plogging.getTimeRecord();
        this.totalTrashCount += plogging.getTrashCount();
    }
}