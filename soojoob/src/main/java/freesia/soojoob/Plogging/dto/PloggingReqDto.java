package freesia.soojoob.Plogging.dto;

import freesia.soojoob.Plogging.entity.Plogging;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

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
