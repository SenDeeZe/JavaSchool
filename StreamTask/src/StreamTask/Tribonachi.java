package StreamTask;

import java.util.List;
import java.util.stream.*;

public class Tribonachi {
    public static List<Integer> tribonachi(int n) {
        return Stream.iterate(new int[]{1, 1, 1}, i -> new int[]{i[1], i[2], i[0] + i[1] + i[2]}).limit(n).map(i -> i[0]).collect(Collectors.toList());
    }
}
