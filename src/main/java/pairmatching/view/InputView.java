package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.FunctionFactor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputView {
    private static final Map<String, Boolean> booleanClassifier = new HashMap<>();
    private static final List<String> functionFactors = Arrays.asList("1", "2", "3", "Q");

    static {
        booleanClassifier.put("네", true);
        booleanClassifier.put("아니오", false);
    }

    public static List<String> readInputMission() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        try {
            return InputView.readMission();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readInputMission();
        }
    }

    public static boolean readInputRepeatMatching() {
        try {
            System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
            System.out.println("네 | 아니오");
            String booleanString = Console.readLine();
            if (!booleanClassifier.containsKey(booleanString)) {
                throw new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다.");
            }
            return booleanClassifier.get(booleanString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readInputRepeatMatching();
        }
    }

    public static String readInputFunctionFactor() {
        readFunctionFactor();
        String InputFunctionFactor = Console.readLine();
        if (!functionFactors.contains(InputFunctionFactor)) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다.");
        }
        return InputFunctionFactor;
    }

    private static List<String> readMission() {
        String inputString = Console.readLine();
        return Arrays.stream(inputString.replace(" ", "").split(",")).collect(Collectors.toList());
    }

    private static void readFunctionFactor() {
        System.out.println("기능을 선택하세요.");
        System.out.printf("%s. %s%n", FunctionFactor.MATCH.getFactor(), FunctionFactor.MATCH.getName());
        System.out.printf("%s. %s%n", FunctionFactor.QUERY.getFactor(), FunctionFactor.QUERY.getName());
        System.out.printf("%s. %s%n", FunctionFactor.RESET.getFactor(), FunctionFactor.RESET.getName());
        System.out.printf("%s. %s%n", FunctionFactor.CLOSE.getFactor(), FunctionFactor.CLOSE.getName());
    }
}
