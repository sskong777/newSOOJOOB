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

    // 전체 플로깅 조회
    @GetMapping("/all")
    public ResponseEntity<List<PloggingResDto>> getAllPlogging(){
        List<PloggingResDto> data = ploggingService.getAllPlogging();
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    // 플로깅 상세 조회
    @GetMapping("/{ploggingId}")
    public ResponseEntity<PloggingResDto> ploggingDetail(@PathVariable(name = "ploggingId") int plogging_id){
        PloggingResDto data = ploggingService.detailPlogging(plogging_id);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    // 유저별 플로깅 리스트
    @GetMapping("/all/userId")
    public ResponseEntity<List<PloggingResDto>> getUserPlogging(@PathVariable(name = "userId") int user_id){
        List<PloggingResDto> data = ploggingService.getUserPlogging(user_id);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    // 플로깅 삭제
    @DeleteMapping("/delete/{ploggingId}")
    public void deletePlogging(@PathVariable(name="ploggingId") int plogging_id){
        ploggingService.deletePlogging(plogging_id);
    }

}
