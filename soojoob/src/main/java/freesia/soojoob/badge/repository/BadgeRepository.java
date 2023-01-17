package freesia.soojoob.badge.repository;

import freesia.soojoob.badge.entitiy.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Integer> {
    Optional<Badge> findBadgeById(int id);
}
