package freesia.soojoob.badge.service;

import freesia.soojoob.badge.dto.BadgeResDto;
import freesia.soojoob.user.entity.User;
import freesia.soojoob.user.exception.NoExistUserException;
import freesia.soojoob.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BadgeService {

    private final UserRepository userRepository;

    @Transactional
    public List<BadgeResDto> getMyBadges() {
        User user = userRepository.findById(1L).orElseThrow( ()-> {
                    throw new NoExistUserException();
                }
        );
        System.out.println(user.getUserBadges());
        List<BadgeResDto> data = user.getUserBadges().stream().map(BadgeResDto::new).collect(Collectors.toList());
        return data;
    }
}
