package coursework2022.backend.controller;

import coursework2022.backend.entity.MissionEntity;
import coursework2022.backend.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/back-end/api/mission_entity")
public class MissionController {
    @Autowired
    MissionRepository missionRepository;

    @GetMapping("/retrieve")
    public List<MissionEntity> getEntities(){
        return missionRepository.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MissionEntity postEntity(@RequestBody MissionEntity missionEntity){
        return missionRepository.save(missionEntity);
    }

    @PutMapping("/update/{id}")
    public MissionEntity putEntity(@PathVariable long id, @RequestBody MissionEntity newEntity){
        MissionEntity updatedEntity = missionRepository.findById(id)
                .orElseThrow(()-> new ResourceAccessException("Not found missionEntity with id: "+id));
        updatedEntity.setCar(newEntity.getCar());
        updatedEntity.setRoute(newEntity.getRoute());
        updatedEntity.setFuel(newEntity.getFuel());
        updatedEntity.setDuration(newEntity.getDuration());
        updatedEntity.setDistance(newEntity.getDistance());
        updatedEntity.setPrice(newEntity.getPrice());
        return missionRepository.save(updatedEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEntity(@PathVariable long id){
        missionRepository.deleteById(id);
    }
}
