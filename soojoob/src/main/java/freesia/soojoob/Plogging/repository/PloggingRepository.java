package freesia.soojoob.Plogging.repository;

import freesia.soojoob.Plogging.entity.Plogging;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PloggingRepository extends JpaRepository<Plogging, Integer> {

    Optional<Plogging> findPloggingById(int id);

}
