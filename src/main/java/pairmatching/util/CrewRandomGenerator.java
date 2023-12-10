package pairmatching.util;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrewRandomGenerator {
    private static final Map<String, String> nameClassifier = new HashMap<>();

    static {
        nameClassifier.put(Course.BACKEND.getName(), "backend-crew.md");
        nameClassifier.put(Course.FRONTEND.getName(), "frontend-crew.md");
    }

    public static List<String> createCrewNames(Course course) throws IOException {
        String fileName = nameClassifier.get(course.getName());
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\" + fileName));
        List<String> crewNames = new ArrayList<>();
        while (true) {
            String name = bufferedReader.readLine();
            if (name == null) break;
            crewNames.add(name);
        }
        bufferedReader.close();
        return crewNames;
    }

    public static List<String> createCrewNames1(Course course) throws IOException {
        String fileName = nameClassifier.get(course.getName());
        List<String> crewNames = new ArrayList<>();
        try (BufferedReader bufferedReader
                     = new BufferedReader(new FileReader("src\\main\\resources\\" + fileName))) {

            while (true) {
                String name = bufferedReader.readLine();
                if (name == null) break;
                crewNames.add(name);
            }
//        bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Randoms.shuffle(crewNames);
    }
}
