package pairmatching.view;

import pairmatching.domain.Crew;
import pairmatching.domain.CrewPair;
import pairmatching.domain.Mission;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printMenu() {
        System.out.println();
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        System.out.println("- 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("- 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("- 레벨3: ");
        System.out.println("- 레벨4: 성능개선 | 배포");
        System.out.println("- 레벨5:");
        System.out.println("#############################################");
    }

    public static void printMatchingResult(Mission mission) {
        System.out.println();
        System.out.println("페어 매칭 결과입니다.");
        List<CrewPair> crewPairs = mission.getCrewPairs();
        for (CrewPair crewPair : crewPairs) {
            String pairNames = crewPair.getCrews().stream()
                    .map(Crew::getName)
                    .collect(Collectors.joining(" : "));
            System.out.printf("%s%n",pairNames);
        }
        System.out.println();
    }

    public static void printReset() {
        System.out.println();
        System.out.println("초기화 되었습니다.");
    }
}
