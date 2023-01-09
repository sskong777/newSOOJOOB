package freesia.soojoob.record.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "records")

public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="record_id")
    private int id;

    @Column(name="total_distance")
    private int totalDistance;

    @Column(name="total_trash_count")
    private int totalTrashCount;

    @Column(name="total_time_record")
    private int totalTimeRecord;

    @Column(name="badge_count")
    private int badgeCount;

    @Column(name="exp")
    private int exp;
}
