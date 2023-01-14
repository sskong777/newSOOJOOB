package freesia.soojoob.badge.dto;

import freesia.soojoob.badge.entitiy.Badge;
import freesia.soojoob.badge.entitiy.UserBadge;
import freesia.soojoob.user.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
public class UserBadgeResDto {


    private User user;

    private Badge badge;

    public UserBadgeResDto(UserBadge userBadge){
        this.user = userBadge.getUser();
        this.badge = userBadge.getBadge();
    }
}
