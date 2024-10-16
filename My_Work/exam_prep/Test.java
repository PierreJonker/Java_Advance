package exam_prep;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> s1 = new ArrayList<>(); // 1
        s1.add("ann"); // 2
        if (s1.contains("ann")) // 3
            s1.add("ann"); // 4
        System.out.println(s1.size() + " " + s1.indexOf("ann")); // 5
    }
}























