package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    public static Level from(String levelName) {
        return Arrays.stream(values())
                .filter(level -> level.name.equals(levelName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다."));
    }

    public boolean hasEqualName(String levelName) {
        return this.name.equals(levelName);

    }
}
