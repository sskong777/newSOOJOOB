package freesia.soojoob.plogging.service;

import freesia.soojoob.plogging.dto.PloggingReqDto;
import freesia.soojoob.plogging.dto.PloggingResDto;
import freesia.soojoob.plogging.entity.Plogging;
import freesia.soojoob.plogging.exception.NoExistPloggingException;
import freesia.soojoob.plogging.repository.PloggingRepository;
import freesia.soojoob.user.entity.User;
import freesia.soojoob.user.exception.NoExistUserException;
import freesia.soojoob.user.repository.UserRepository;
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
    private final UserRepository userRepository;


    public PloggingResDto createPlogging(PloggingReqDto ploggingReqDto){

        // entitiy to dto
        Plogging plogging = ploggingReqDto.toEntity();
        // DB 저장
        ploggingRepository.save(plogging);
        // entity to dto
        PloggingResDto data = new PloggingResDto(plogging);

        // 기록 처리


        return data;
    }

    public List<PloggingResDto> getAllPlogging() {
//        List<Plogging> ploggingList = ploggingRepository.findAll();
        List<PloggingResDto> data = ploggingRepository.findAll().stream().map(PloggingResDto::new).collect(Collectors.toList());
        return data;
    }

    public PloggingResDto detailPlogging(int plogging_id) {
        Plogging plogging = ploggingRepository.findPloggingById(plogging_id).orElseThrow(
                ()->new NoExistPloggingException()
        );
        PloggingResDto data = new PloggingResDto(plogging);
        return data;
    }


    public List<PloggingResDto> getUserPlogging(int user_id) {
        User user = userRepository.findById(1L).orElseThrow( ()-> {
                    throw new NoExistUserException();
                }
        );
        List<PloggingResDto> data = user.getPloggingList().stream().map(PloggingResDto::new).collect(Collectors.toList());
        return data;

    }


    public void deletePlogging(int plogging_id) {
        Plogging plogging = ploggingRepository.findPloggingById(plogging_id).orElseThrow(
                ()->new NoExistPloggingException()
        );
        ploggingRepository.delete(plogging);
    }

    public List<PloggingResDto> getCurrentUserPlogging() {
        User user = userRepository.findById(1L).orElseThrow( ()-> {
                    throw new NoExistUserException();
                }
        );
        List<PloggingResDto> data = user.getPloggingList().stream().map(PloggingResDto::new).collect(Collectors.toList());
        return data;
    }
}
