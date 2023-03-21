package coursework2022.backend.dataGeneration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import coursework2022.backend.entity.FilterEntity;
import coursework2022.backend.services.FiltersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class FilterDataGeneration implements ApplicationListener<ContextRefreshedEvent>{
    @Autowired
    FiltersService filtersService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (filtersService.countRows() == 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            CollectionType collectionType = objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, FilterEntity.class);
            InputStream inputStream = getClass()
                    .getResourceAsStream("/filters.json");
            try {
                List<FilterEntity> filters = objectMapper.readValue(inputStream, collectionType);
                filtersService.createFiltersList(filters);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
