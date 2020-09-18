/**
 * @author CuiJunJie
 * @create 2020-09-18-11:31
 */
public class Solution {
    public static void main(String[] args) {
//        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // 返回  1
//        cache.put(3, 3);    // 该操作会使得关键字 2 作废
//        cache.get(2);       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得关键字 1 作废
//        cache.get(1);       // 返回 -1 (未找到)
//        cache.get(3);       // 返回  3
//        cache.get(4);       // 返回  4

//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));
//        cache.put(3, 3);    // 该操作会使得关键字 2 作废
//        System.out.println(cache.get(2));
//        cache.put(4, 4);    // 该操作会使得关键字 1 作废
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

//        ["LRUCache","put","get","put","get","get"]
//        [[1],[2,1],[2],[3,2],[2],[3]]
//        [null,null,1,null,-1,2]
//        LRUCache cache = new LRUCache( 1 /* 缓存容量 */ );
//        cache.put(2, 1);
//        System.out.println(cache.get(2));
//        cache.put(3, 2);
//        cache.get(2);
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));

//        ["LRUCache","put","put","get","put","put","get"]
//        [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
//        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//        cache.put(2, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(2));
//        cache.put(1, 1);
//        cache.put(4, 1);
//        System.out.println(cache.get(2));

//        ["LRUCache","get","put","get","put","put","get","get"]
//        [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}
