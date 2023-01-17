package freesia.soojoob.plogging.repository;

import freesia.soojoob.plogging.entity.Plogging;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PloggingRepository extends JpaRepository<Plogging, Integer> {

    Optional<Plogging> findPloggingById(int id);

}
