package pairmatching.controller;

import pairmatching.domain.MatchResult;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionTemplate;
import pairmatching.util.FunctionFactor;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;

public class MatchingController {
    private MatchResult matchResult = new MatchResult();
    private boolean functionState = true;

    public void run() {
        while (functionState) {
            selectFunction(InputView.readInputFunctionFactor());
        }
    }

    private void selectFunction(String functionFactor) {
        if (!FunctionFactor.isValid(functionFactor)) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다.");
        }
        if (FunctionFactor.MATCH.hasFactor(functionFactor)) {
            match();
        }
        if (FunctionFactor.QUERY.hasFactor(functionFactor)) {
            query();
        }
        if (FunctionFactor.RESET.hasFactor(functionFactor)) {
            reset();
        }
        if (FunctionFactor.CLOSE.hasFactor(functionFactor)) {
            close();
        }
    }

    private void match() {
        OutputView.printMenu();

        Mission mission = new Mission();
        boolean matchingState = false;
        while (!matchingState) {
            matchingState = true;
            MissionTemplate missionTemplate = createMissionTemplate();
            mission.setMissionTemplate(missionTemplate);
            mission.setCrewPairs(missionTemplate);
            if (matchResult.isAlreadyExisted(missionTemplate)) {
                matchingState = InputView.readInputRepeatMatching();
            }
        }
        Mission checkedMission = matchResult.addMission(mission);
        OutputView.printMatchingResult(checkedMission);
    }

    private static MissionTemplate createMissionTemplate() {
        try {
            return MissionTemplate.from(InputView.readInputMission());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createMissionTemplate();
        }
    }

    private void query() {
        OutputView.printMenu();
        MissionTemplate missionTemplate = MissionTemplate.from(InputView.readInputMission());
        Mission mission = matchResult.getMission(missionTemplate);
        OutputView.printMatchingResult(mission);
    }

    private void reset() {
        matchResult = new MatchResult();
        OutputView.printReset();
    }

    private void close() {
        this.functionState = false;
    }
}
