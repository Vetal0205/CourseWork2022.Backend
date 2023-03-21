package coursework2022.backend.dataGeneration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import coursework2022.backend.entity.CarEntity;
import coursework2022.backend.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class CarDataGenerator implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    CarService carService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (carService.countRows() == 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            CollectionType collectionType = objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, CarEntity.class);
            InputStream inputStream = getClass()
                    .getResourceAsStream("/cars.json");
            try {
                List<CarEntity> cars = objectMapper.readValue(inputStream, collectionType);
                carService.createMissionList(cars);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}