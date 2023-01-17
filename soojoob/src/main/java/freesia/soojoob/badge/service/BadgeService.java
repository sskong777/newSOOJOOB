package freesia.soojoob.badge.service;

import freesia.soojoob.badge.dto.BadgeResDto;
import freesia.soojoob.badge.dto.UserBadgeResDto;
import freesia.soojoob.badge.entitiy.Badge;
import freesia.soojoob.badge.entitiy.UserBadge;
import freesia.soojoob.badge.exception.NoBadgeException;
import freesia.soojoob.badge.repository.BadgeRepository;
import freesia.soojoob.badge.repository.UserBadgeRepository;
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
    private final BadgeRepository badgeRepository;

    private final UserBadgeRepository userBadgeRepository;

    @Transactional
    public List<BadgeResDto> getMyBadges() {
        User user = userRepository.findById(1L).orElseThrow( ()-> {
                    throw new NoExistUserException();
                }
        );
//        System.out.println(user.getUserBadges());
        List<BadgeResDto> data = user.getUserBadges().stream().map(BadgeResDto::new).collect(Collectors.toList());
        return data;
    }

    @Transactional
    public List<BadgeResDto> getNoBadges() {
        User user = userRepository.findById(1L).orElseThrow( ()-> {
                    throw new NoExistUserException();
                }
        );
        // 로직 다시 생각해보기 -> 사용자가 미보유한 뱃지
        List<BadgeResDto> data = badgeRepository.findAll().stream().map(BadgeResDto::new).collect(Collectors.toList());
        List<BadgeResDto> userBadges = user.getUserBadges().stream().map(BadgeResDto::new).collect(Collectors.toList());

        data.removeAll(userBadges);
        return data;

    }

    public UserBadgeResDto addUserBadge(Long userId, int badgeId) {
        User user = userRepository.findById(userId).orElseThrow( ()-> {
                    throw new NoExistUserException();
                }
        );
        Badge badge = badgeRepository.findBadgeById(badgeId).orElseThrow( ()->{
                    throw  new NoBadgeException();
                }
        );
        UserBadge userBadge = new UserBadge(user,badge);
        userBadgeRepository.save(userBadge);

        UserBadgeResDto data = new UserBadgeResDto(userBadge);

        return data;

    }
}
