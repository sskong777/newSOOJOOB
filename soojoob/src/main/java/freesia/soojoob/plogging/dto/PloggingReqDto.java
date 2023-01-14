package freesia.soojoob.plogging.dto;

import freesia.soojoob.plogging.entity.Plogging;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PloggingReqDto {


    private String dateTime;

    private Float distance;

    private int trashCount;

    private int timeRecord;

    private String ploggingImg;

    public Plogging toEntity() {
        return Plogging.builder()
                .dateTime(getDateTime())
                .distance(getDistance())
                .trashCount(getTrashCount())
                .timeRecord(getTimeRecord())
                .ploggingImg(getPloggingImg())
                .build();

    }

}
