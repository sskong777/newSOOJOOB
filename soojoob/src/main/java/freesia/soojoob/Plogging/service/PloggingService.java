package freesia.soojoob.Plogging.service;

import freesia.soojoob.Plogging.dto.PloggingReqDto;
import freesia.soojoob.Plogging.dto.PloggingResDto;
import freesia.soojoob.Plogging.entity.Plogging;
import freesia.soojoob.Plogging.repository.PloggingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PloggingService {

    private final PloggingRepository ploggingRepository;

    public PloggingResDto createPlogging(PloggingReqDto ploggingReqDto){

        // entitiy to dto
        Plogging plogging = ploggingReqDto.toEntity();
        // DB 저장
        ploggingRepository.save(plogging);
        // entity to dto
        PloggingResDto data = new PloggingResDto(plogging);

        return data;
    }

    public List<PloggingResDto> getUserPlogging() {
//        List<Plogging> ploggingList = ploggingRepository.findAll();
        List<PloggingResDto> data = ploggingRepository.findAll().stream().map(PloggingResDto::new).collect(Collectors.toList());
        return data;
    }
}
