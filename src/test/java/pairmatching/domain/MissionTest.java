package pairmatching.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MissionTest {

    @Test
    void setCrewPairs() {
        Mission mission = new Mission();
        mission.setMissionTemplate(MissionTemplate.RACING_CAR_FRONTEND);
        System.out.println(mission.getCrewPairs().size());
        mission.setCrewPairs(MissionTemplate.RACING_CAR_FRONTEND);
        System.out.println(mission.getCrewPairs().size());
    }

//    @Test
//    void getCrewPairs() {
//        MissionTemplate missionTemplate = MissionTemplate.from("백엔드", "자동차경주");
//        List<String> names = Arrays.asList("하나", "둘", "셋", "넷", "다섯");
//        Mission mission = new Mission(missionTemplate, names);
//        assertThat(mission.getCrewPairs().size()).isEqualTo(2);
//
//        List<Crew> crews1 = Arrays.asList(
//                new Crew(Course.BACKEND, "하나")
//                , new Crew(Course.BACKEND, "둘"));
//
//        List<Crew> crews2 = Arrays.asList(
//                new Crew(Course.BACKEND, "셋")
//                , new Crew(Course.BACKEND, "넷")
//                , new Crew(Course.BACKEND, "다섯"));
//
//        assertThat(mission.getCrewPairs().get(0)).isEqualTo(new CrewPair(crews1));
//        assertThat(mission.getCrewPairs().get(1)).isEqualTo(new CrewPair(crews2));
//    }

}