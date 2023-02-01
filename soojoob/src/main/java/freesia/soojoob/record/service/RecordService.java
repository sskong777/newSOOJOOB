package freesia.soojoob.record.service;

import freesia.soojoob.record.dto.RecordResDto;
import freesia.soojoob.record.entity.Record;
import freesia.soojoob.user.entity.User;
import freesia.soojoob.user.exception.NoExistUserException;
import freesia.soojoob.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecordService {

    private final UserRepository userRepository;
    public RecordResDto getMyRecord() {
        User user = userRepository.findById(3L).orElseThrow( ()-> {
                    throw new NoExistUserException();
                }
        );
        Record userRecord = user.getUserRecord();
        RecordResDto data = new RecordResDto(userRecord);
        return data;
    }




}
