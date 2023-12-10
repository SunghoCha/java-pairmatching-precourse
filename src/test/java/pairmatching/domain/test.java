package pairmatching.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class test {

    @Test
    void asdf() {
        HashSet<Object> objects = new HashSet<>();
        HashSet<Object> objects2 = new HashSet<>();
        objects.add(1);
        objects.add(2);
        objects2.add(2);
        objects2.add(1);
        assertThat(objects).isEqualTo(objects2);
    }

    @Test
    void aassdf() {
        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<Object> objects2 = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects2.add(1);
        objects2.add(2);
        assertThat(objects).isEqualTo(objects2);
    }
}
