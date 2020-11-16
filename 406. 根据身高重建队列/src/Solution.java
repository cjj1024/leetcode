import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2020-11-16-14:40
 */
public class Solution {
    public static void main(String[] args) {
        int[][] people = {
                {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        };
        int[][] newPeople = reconstructQueue(people);
        for (int[] p : newPeople) {
            System.out.printf("%d %d\n", p[0], p[1]);
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);

        List<int[]> list = new LinkedList<>();
        for (int [] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(people);
    }
}
