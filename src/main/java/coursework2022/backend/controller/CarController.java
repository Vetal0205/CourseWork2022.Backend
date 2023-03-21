package coursework2022.backend.controller;

import coursework2022.backend.entity.CarEntity;
import coursework2022.backend.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/back-end/api/car_entity")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/retrieve")
    public List<CarEntity> getEntities(){
        return carService.getAllCar();
    }

    @GetMapping("/retrieve/{id}")
    public CarEntity getEntity(@PathVariable int id){
        return carService.getCarById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CarEntity postEntity(@RequestBody CarEntity carEntity){
        return carService.createMission(carEntity);
    }

    @PutMapping("/update/{id}")
    public CarEntity putEntity(@PathVariable int id, @RequestBody CarEntity newEntity){
        return carService.updateCar(id, newEntity);
    }

    @DeleteMapping("/delete/{id}")
    public CarEntity deleteEntity(@PathVariable int id){
        return  carService.deleteCar(id);
    }
}
