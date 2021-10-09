import java.util.ArrayList;
import java.util.List;

/**
 * @author CuiJunJie
 * @create 2021/9/6-16:39
 */
public class Main3 {
    public static void main(String[] args) {
        String t = "[[1,2,3],[3,4,5],[3,5,6]]";


        t = t.replaceAll("\\[", "");
        t = t.replaceAll("\\]", "");
        System.out.println(t.contains("1"));
        System.out.println(t.indexOf("i"));

        System.out.println(t.split(","));
        System.out.println(t);

    }
}
