package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

public enum MissionTemplate {
    RACING_CAR_BACKEND(Level.LEVEL1, Course.BACKEND, "자동차경주"),
    RACING_CAR_FRONTEND(Level.LEVEL1, Course.FRONTEND, "자동차경주"),

    LOTTO_BACKEND(Level.LEVEL1, Course.BACKEND, "로또"),
    LOTTO_FRONTEND(Level.LEVEL1, Course.FRONTEND, "로또"),

    BASEBALL_BACKEND(Level.LEVEL1, Course.BACKEND, "숫자야구게임"),
    BASEBALL_FRONTEND(Level.LEVEL1, Course.FRONTEND, "숫자야구게임"),

    SHOPPING_BASKET_BACKEND(Level.LEVEL2, Course.BACKEND, "장바구니"),
    SHOPPING_BASKET_FRONTEND(Level.LEVEL2, Course.FRONTEND, "장바구니"),

    PAYMENT_BACKEND(Level.LEVEL2, Course.BACKEND, "결제"),
    PAYMENT_FRONTEND(Level.LEVEL2, Course.FRONTEND, "결제"),

    SUBWAY_LINE_BACKEND(Level.LEVEL2, Course.BACKEND, "지하철노선도"),
    SUBWAY_LINE_FRONTEND(Level.LEVEL2, Course.FRONTEND, "지하철노선도"),

    PERFORMANCE_IMPROVEMENT_BACKEND(Level.LEVEL4, Course.BACKEND, "성능개선"),
    PERFORMANCE_IMPROVEMENT_FRONTEND(Level.LEVEL4, Course.FRONTEND, "성능개선"),

    DISTRIBUTION_BACKEND(Level.LEVEL4, Course.BACKEND, "배포"),
    DISTRIBUTION_FRONTEND(Level.LEVEL4, Course.FRONTEND, "배포");

    private Level level;
    private Course course;
    private String name;

    MissionTemplate(Level level, Course course, String name) {
        this.level = level;
        this.course = course;
        this.name = name;
    }

    public static MissionTemplate from(List<String> factors) {
        if (factors.size() != 3) {
            throw new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다.");
        }
        return Arrays.stream(values())
                .filter(missionTemplate -> missionTemplate.course.hasEqualName(factors.get(0)))
                .filter(missionTemplate -> missionTemplate.level.hasEqualName(factors.get(1)))
                .filter(missionTemplate -> missionTemplate.name.equals(factors.get(2)))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 입력이 아닙니다."));
    }

    public Level getLevel() {
        return level;
    }

    public Course getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }
}
