package freesia.soojoob.badge.controller;

import freesia.soojoob.Plogging.dto.PloggingResDto;
import freesia.soojoob.badge.dto.BadgeResDto;
import freesia.soojoob.badge.service.BadgeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/badge")
@RequiredArgsConstructor
public class BadgeController {

    private final BadgeService badgeService;

    @GetMapping("")
    public ResponseEntity<List<BadgeResDto>> getMyBadges(){

        List<BadgeResDto> data = badgeService.getMyBadges();
        return new ResponseEntity<>(data, HttpStatus.OK);    }


}
