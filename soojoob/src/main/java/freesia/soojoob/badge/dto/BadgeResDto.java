package freesia.soojoob.badge.dto;

import freesia.soojoob.badge.entitiy.Badge;
import freesia.soojoob.badge.entitiy.UserBadge;
import freesia.soojoob.user.entity.User;
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

    public BadgeResDto(Badge badge){
        this.id = badge.getId();
        this.name = badge.getName();
        this.detail = badge.getDetail();
        this.imgUrl = badge.getImgUrl();
    }


}
