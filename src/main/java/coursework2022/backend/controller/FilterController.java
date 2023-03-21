package coursework2022.backend.controller;

import coursework2022.backend.entity.CarEntity;
import coursework2022.backend.entity.FilterEntity;
import coursework2022.backend.services.FiltersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/back-end/api/filter_entity")
public class FilterController {
    @Autowired
    FiltersService filtersService;

    @GetMapping("/retrieve")
    public List<FilterEntity> getEntities(){
        return filtersService.getAllFilters();
    }

}
