/**
 * @author CuiJunJie
 * @create 2021/3/13-9:41
 */
public class Solution {
    public static void main(String[] args) {

         MyHashSet obj = new MyHashSet();
         obj.add(1);
        System.out.println(obj.contains(1));
         obj.remove(1);
        System.out.println(obj.contains(1));
    }
}
