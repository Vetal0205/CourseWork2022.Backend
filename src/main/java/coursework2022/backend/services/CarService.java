package coursework2022.backend.services;

import coursework2022.backend.entity.CarEntity;
import coursework2022.backend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    public long countRows() {
        return carRepository.count();
    }
    public CarEntity createMission(CarEntity mission) {
        return carRepository.save(mission);
    }
    public void createMissionList(List<CarEntity> cars) {
        carRepository.saveAll(cars);
    }

    public List<CarEntity> getAllCar() {
        return carRepository.findAll();
    }

    public CarEntity getCarById(int carId) {
        Optional<CarEntity> carOptional = carRepository.findById(carId);
        return carOptional.orElse(null);
    }


    public CarEntity updateCar(int carId, CarEntity newCar) {
        Optional<CarEntity> carOptional = carRepository.findById(carId);
        if (carOptional.isPresent()) {
            CarEntity existingCar = carOptional.get();
            String[] ignoredProperties = {"id"};
            BeanUtils.copyProperties(newCar, existingCar, ignoredProperties);
            return carRepository.save(existingCar);
        } else {
            return null;
        }
    }

    public CarEntity deleteCar(int carId) {
        Optional<CarEntity> carOptional = carRepository.findById(carId);
        if (carOptional.isPresent()) {
            CarEntity Car = carOptional.get();
            carRepository.deleteById(carId);
            return Car;
        } else {
            return null;
        }
    }
}
