package pairmatching.domain;

import java.util.*;

public class CrewPair {
    private final Set<Crew> pair = new LinkedHashSet<>();
    private final List<Crew> crews;

    public CrewPair(List<Crew> pair) {
        this.crews = pair;
        this.pair.addAll(pair);
    }

    public Set<Crew> getPair() {
        return pair;
    }

    public List<Crew> getCrews() {
        return crews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrewPair crewPair = (CrewPair) o;
        return Objects.equals(pair, crewPair.pair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pair);
    }
}
