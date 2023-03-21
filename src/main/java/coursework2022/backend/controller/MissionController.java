package coursework2022.backend.controller;

import coursework2022.backend.entity.MissionEntity;
import coursework2022.backend.services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/back-end/api/mission_entity")
public class MissionController {
    @Autowired
    MissionService missionService;

    @GetMapping("/retrieve")
    public List<MissionEntity> getEntities(){
        return missionService.getAllMissions();
    }
    @GetMapping("/retrieve/{id}")
    public MissionEntity getEntity(@PathVariable int id){
        return missionService.getMissionById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MissionEntity postEntity(@RequestBody MissionEntity missionEntity){
        System.out.println(missionEntity);
        return missionService.createMission(missionEntity);
    }

    @PutMapping("/update/{id}")
    public MissionEntity putEntity(@PathVariable int id, @RequestBody MissionEntity newEntity){
        return missionService.updateMission(id, newEntity);
    }

    @DeleteMapping("/delete/{id}")
    public MissionEntity deleteEntity(@PathVariable int id){
        return missionService.deleteMission(id);
    }
}
