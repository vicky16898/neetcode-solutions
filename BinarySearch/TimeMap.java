package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    private Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair<>(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> list = map.get(key);
        if (list == null)
            return "";
        int left = 0;
        int right = list.size() - 1;
        String res = "";
        while (left <= right) {
            int mid = left - (left - right) / 2;
            Pair<String, Integer> p = list.get(mid);
            if (p.getValue() == timestamp) {
                return p.getKey();
            } else if (p.getValue() < timestamp) {
                res = p.getKey();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
