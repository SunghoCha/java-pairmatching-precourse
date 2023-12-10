package pairmatching.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void sdf() {
        String inputString = "프론트엔드, 레벨1, 자동차경주";
        List<String> collect = Arrays.stream(inputString.replace(" ","").split(",")).collect(Collectors.toList());
        System.out.println("collect = " + collect);
        System.out.println(collect.get(1));
    }

}