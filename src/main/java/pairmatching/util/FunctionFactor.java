package pairmatching.util;

import java.util.Arrays;

public enum FunctionFactor {
    MATCH("1", "페어 매칭"),
    QUERY("2", "페어 조회"),
    RESET("3", "페어 초기화"),
    CLOSE("Q", "종료");

    private final String factor;
    private final String name;

    FunctionFactor(String factor, String name) {
        this.factor = factor;
        this.name = name;
    }

    public static boolean isValid(String factor) {
        return Arrays.stream(values()).anyMatch(functionFactor -> functionFactor.hasFactor(factor));
    }

    public boolean hasFactor(String functionFactor) {
        return this.factor.equals(functionFactor);
    }

    public String getFactor() {
        return factor;
    }

    public String getName() {
        return name;
    }
}

