package pairmatching.domain;

import pairmatching.util.CrewRandomGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchResult {
    private final List<Mission> missions = new ArrayList<>();

    public Mission addMission(Mission mission) {
        int tryNumber = 3;
        while (hasDuplicatedCrewPair(mission) && tryNumber != 0) {
            mission.setCrewPairs(mission.getMissionTemplate());
            tryNumber--;
        };
        this.missions.add(mission);
        return mission;
    }

    private boolean hasDuplicatedCrewPair(Mission mission) {
        return missions.stream()
                .filter(existedMission -> existedMission.hasSameLevel(mission))
                .anyMatch(existedMission -> existedMission.hasSameCrewPair(mission));
    }

//    public Mission getMission1(MissionTemplate missionTemplate) {
//        if (isAlreadyExisted(missionTemplate)) {
//            return getExistingMission(missionTemplate);
//        }
//        return createMission(missionTemplate);
//    }

    public Mission getMission(MissionTemplate template) {
        return missions.stream().filter(mission -> mission.getMissionTemplate() == template)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다."));
    }

//    private static Mission createMission(MissionTemplate missionTemplate) {
//        List<String> crewNames = new ArrayList<>();
//        try {
//            crewNames = CrewRandomGenerator.createCrewNames(missionTemplate.getCourse());
//        } catch (IOException e) {
//            System.out.println("[ERROR] 올바르지 않은 입력입니다.");
//        }
//        Mission mission = new Mission();
//        mission.setMission(missionTemplate);
//        return mission;
//    }

    public boolean isAlreadyExisted(MissionTemplate template) {
        return missions.stream().anyMatch(mission -> mission.getMissionTemplate() == template);
    }
}
