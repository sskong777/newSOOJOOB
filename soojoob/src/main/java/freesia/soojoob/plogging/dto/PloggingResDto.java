package freesia.soojoob.plogging.dto;

import freesia.soojoob.plogging.entity.Plogging;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PloggingResDto {

    private int id;

    private String dateTime;

    private Float distance;

    private int trashCount;

    private int timeRecord;

    private String ploggingImg;

    public PloggingResDto(Plogging plogging){
        this.id = plogging.getId();
        this.dateTime = plogging.getDateTime();
        this.distance = plogging.getDistance();
        this.trashCount = plogging.getTrashCount();
        this.timeRecord = plogging.getTimeRecord();
        this.ploggingImg = plogging.getPloggingImg();
    }
}