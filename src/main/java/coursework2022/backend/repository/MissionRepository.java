package coursework2022.backend.repository;

import coursework2022.backend.entity.MissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<MissionEntity, Long> {

}
