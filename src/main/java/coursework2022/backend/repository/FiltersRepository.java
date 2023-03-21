package coursework2022.backend.repository;

import coursework2022.backend.entity.FilterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FiltersRepository  extends JpaRepository<FilterEntity, Integer> {}
