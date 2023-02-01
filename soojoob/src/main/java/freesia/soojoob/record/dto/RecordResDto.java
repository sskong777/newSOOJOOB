package freesia.soojoob.record.dto;

import freesia.soojoob.record.entity.Record;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@RequiredArgsConstructor
public class RecordResDto {

    private int id;

    private String userName;

    private double totalDistance;

    private int totalTrashCount;

    private int totalTimeRecord;

    private int badgeCount;

    private double exp;

    public RecordResDto(Record record){
        this.userName = record.getUser().getUsername();
        this.id = record.getId();
        this.totalDistance = record.getTotalDistance();
        this.totalTrashCount = record.getTotalTrashCount();
        this.totalTimeRecord = record.getTotalTimeRecord();
        this.badgeCount = record.getBadgeCount();
        this.exp = record.getExp();
    }
}
