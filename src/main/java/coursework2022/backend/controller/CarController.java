package coursework2022.backend.controller;

import coursework2022.backend.entity.CarEntity;
import coursework2022.backend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/back-end/api/car_entity")
public class CarController {
    @Autowired
    CarRepository carRepository;

    @GetMapping("/retrieve")
    public List<CarEntity> getEntities(){
        return carRepository.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CarEntity postEntity(@RequestBody CarEntity carEntity){
        return carRepository.save(carEntity);
    }

    @PutMapping("/update/{id}")
    public CarEntity putEntity(@PathVariable long id, @RequestBody CarEntity newEntity){
        CarEntity updatedEntity = carRepository.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found missionEntity with id: "+id));
        updatedEntity.setType(newEntity.getType());
        updatedEntity.setName(newEntity.getName());
        updatedEntity.setPower(newEntity.getPower());
        updatedEntity.setWeight(newEntity.getWeight());
        updatedEntity.setFuelConsumption(newEntity.getFuelConsumption());
        updatedEntity.setFuelRange(newEntity.getFuelRange());
        updatedEntity.setFuelTank(newEntity.getFuelTank());
        updatedEntity.setCrew(newEntity.getCrew());
        updatedEntity.setSpeed(newEntity.getSpeed());
        updatedEntity.setProduction(newEntity.getProduction());
        updatedEntity.setImage(newEntity.getImage());
        return carRepository.save(updatedEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id){
        carRepository.deleteById(id);
    }
}
