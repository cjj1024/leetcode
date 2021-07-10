import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author CuiJunJie
 * @create 2021/7/10-11:23
 */
public class TimeMap {
    /** Initialize your data structure here. */
    public class ValueWithTime {
        public String value;
        public int timestamp;

        public ValueWithTime(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        public ValueWithTime() {

        }
    }
    public Map<String, PriorityQueue<ValueWithTime>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new PriorityQueue<>((v1, v2) -> v2.timestamp - v1.timestamp));
        }
        map.get(key).offer(new ValueWithTime(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        PriorityQueue<ValueWithTime> valueWithTimes = map.get(key);
        for (ValueWithTime valueWithTime : valueWithTimes) {
            if (valueWithTime.timestamp <= timestamp) {
                return valueWithTime.value;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);

        System.out.println(timeMap.get("love", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));
    }
}
