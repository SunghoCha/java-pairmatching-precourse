package pairmatching.domain;

import pairmatching.util.CrewRandomGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mission {
    private MissionTemplate missionTemplate;
    private final List<CrewPair> crewPairs = new ArrayList<>();

    public void setMissionTemplate(MissionTemplate missionTemplate) {
        this.missionTemplate = missionTemplate;
    }

    public void setCrewPairs(MissionTemplate missionTemplate) {
        List<String> crewNames = new ArrayList<>();
        List<Crew> crews = new ArrayList<>();
        try {
            crewNames = CrewRandomGenerator.createCrewNames1(missionTemplate.getCourse());
        } catch (IOException e) {
            System.out.println("[ERROR] IOException 발생");
        }
        initiateMission(missionTemplate, crewNames, crews);
    }

    private void initiateMission(MissionTemplate missionTemplate, List<String> crewNames, List<Crew> crews) {
        for (int i = 0; i < crewNames.size(); i++) {
            crews.add(new Crew(missionTemplate.getCourse(), crewNames.get(i)));
            if (crewNames.size() % 2 == 1 && i == (crewNames.size() - 2)) {
                crews.add(new Crew(missionTemplate.getCourse(), crewNames.get(i + 1)));
                this.crewPairs.add(new CrewPair(crews));
                break;
            }
            if (i % 2 == 1) {
                this.crewPairs.add(new CrewPair(crews));
                crews = new ArrayList<>();
            }
        }
    }

    public MissionTemplate getMissionTemplate() {
        return missionTemplate;
    }

    public List<CrewPair> getCrewPairs() {
        return crewPairs;
    }

    public boolean hasSameLevel(Mission mission) {
        return this.missionTemplate.getLevel().equals(mission.getMissionTemplate().getLevel());
    }

    public boolean hasSameCrewPair(Mission mission) {
        List<Boolean> duplicatedStates = new ArrayList<>();
        for (CrewPair crewPair : crewPairs) {
            duplicatedStates.add(mission.getCrewPairs().contains(crewPair));
        }
        return duplicatedStates.contains(true);
    }
}
