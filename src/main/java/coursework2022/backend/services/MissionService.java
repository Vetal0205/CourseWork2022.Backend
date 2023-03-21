package coursework2022.backend.services;

import coursework2022.backend.entity.MissionEntity;
import coursework2022.backend.repository.MissionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    @Autowired
    private MissionRepository missionRepository;

    public MissionEntity createMission(MissionEntity mission) {
        return missionRepository.save(mission);
    }

    public List<MissionEntity> getAllMissions() {
        return missionRepository.findAll();
    }

    public MissionEntity getMissionById(int missionId) {
        Optional<MissionEntity> missionOptional = missionRepository.findById(missionId);
        return missionOptional.orElse(null);
    }


    public MissionEntity updateMission(int missionId, MissionEntity mission) {
        Optional<MissionEntity> missionOptional = missionRepository.findById(missionId);
        if (missionOptional.isPresent()) {
            MissionEntity existingMission = missionOptional.get();
            String[] ignoredProperties = {"id"};
            BeanUtils.copyProperties(mission, existingMission, ignoredProperties);
            return missionRepository.save(existingMission);
        } else {
            return null;
        }
    }

    public MissionEntity deleteMission(int missionId) {
        Optional<MissionEntity> missionOptional = missionRepository.findById(missionId);
        System.out.println(missionOptional);
        if (missionOptional.isPresent()) {
            MissionEntity mission = missionOptional.get();
            missionRepository.deleteById(missionId);
            return mission;
        } else {
            return null;
        }
    }
}
