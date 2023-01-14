package freesia.soojoob.badge.repository;

import freesia.soojoob.badge.entitiy.UserBadge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBadgeRepository extends JpaRepository<UserBadge, Integer> {

}
