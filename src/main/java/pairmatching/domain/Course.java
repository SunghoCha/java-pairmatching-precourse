package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String courseName) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(courseName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바르지 않은 입력입니다."));
    }

    public boolean hasEqualName(String courseName) {
        return this.name.equals(courseName);
    }

    public String getName() {
        return name;
    }
}
