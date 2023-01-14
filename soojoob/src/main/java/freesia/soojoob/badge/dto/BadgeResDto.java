package freesia.soojoob.badge.dto;

import freesia.soojoob.badge.entitiy.Badge;
import freesia.soojoob.badge.entitiy.UserBadge;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BadgeResDto {

    private int id;

    private String name;

    private String detail;

    private String imgUrl;


    public BadgeResDto(UserBadge userBadge) {
        this.id = userBadge.getBadge().getId();
        this.name = userBadge.getBadge().getName();
        this.detail = userBadge.getBadge().getDetail();
        this.imgUrl = userBadge.getBadge().getImgUrl();
    }
}
