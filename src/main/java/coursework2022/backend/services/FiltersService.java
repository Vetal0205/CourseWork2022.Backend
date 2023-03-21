package coursework2022.backend.services;

import coursework2022.backend.entity.CarEntity;
import coursework2022.backend.entity.FilterEntity;
import coursework2022.backend.repository.FiltersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiltersService {
    @Autowired
    private FiltersRepository filtersRepository;
    public long countRows() {
        return filtersRepository.count();
    }
    public void createFiltersList(List<FilterEntity> filters) {
        filtersRepository.saveAll(filters);
    }


    public List<FilterEntity> getAllFilters() {
        return filtersRepository.findAll();
    }
}
