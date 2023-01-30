package freesia.soojoob.record.controller;


import freesia.soojoob.record.dto.RecordResDto;
import freesia.soojoob.record.service.RecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("record")
@Slf4j
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @GetMapping("")
    public ResponseEntity<RecordResDto> getMyRecord(){
        RecordResDto data = recordService.getMyRecord();

        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
