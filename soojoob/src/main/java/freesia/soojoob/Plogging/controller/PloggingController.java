package freesia.soojoob.Plogging.controller;

import freesia.soojoob.Plogging.dto.PloggingReqDto;
import freesia.soojoob.Plogging.dto.PloggingResDto;
import freesia.soojoob.Plogging.service.PloggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/plogging")
@RequiredArgsConstructor
public class PloggingController {

    private final PloggingService ploggingService;

    // 플로깅 생성
    @PostMapping("")
    public ResponseEntity<PloggingResDto> ploggingCreate(@RequestBody PloggingReqDto ploggingReqDto){


        PloggingResDto data = ploggingService.createPlogging(ploggingReqDto);

        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    // 현재 유저 플로깅 조회
    @GetMapping("/all")
    public ResponseEntity<List<PloggingResDto>> getUserPlogging(){
        List<PloggingResDto> data = ploggingService.getUserPlogging();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
}
