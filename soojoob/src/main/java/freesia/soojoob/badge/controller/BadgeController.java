package freesia.soojoob.badge.controller;

import freesia.soojoob.badge.dto.BadgeResDto;
import freesia.soojoob.badge.dto.UserBadgeResDto;
import freesia.soojoob.badge.service.BadgeService;
import freesia.soojoob.global.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/badge")
@RequiredArgsConstructor
public class BadgeController {

    private final BadgeService badgeService;

    @GetMapping("")
    public ResponseEntity<CommonResponse> getMyBadges(){

        List<BadgeResDto> data = badgeService.getMyBadges();
//        return new ResponseEntity<>(data, HttpStatus.OK);
        return ResponseEntity.ok(
                CommonResponse.getSuccessResponse(getStatusCode(HttpStatus.CREATED), "내 뱃지 조회에 성공하였습니다.",data)
        );

    }



    @GetMapping("/no")
    public ResponseEntity<List<BadgeResDto>> getNoBadges(){
        List<BadgeResDto> data = badgeService.getNoBadges();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @PostMapping("/{userId}/{badgeId}")
    public ResponseEntity<UserBadgeResDto> addUserBadge(
            @PathVariable(name="userId") Long userId, @PathVariable(name = "badgeId") int badgeId){
        UserBadgeResDto data = badgeService.addUserBadge(userId,badgeId);
        return new ResponseEntity<>(data,HttpStatus.CREATED);
    }

    private int getStatusCode(HttpStatus status) {
        return status.value();
    }
}

