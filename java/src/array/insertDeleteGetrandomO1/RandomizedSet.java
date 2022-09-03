package array.insertDeleteGetrandomO1;

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 */
class RandomizedSet {

    private List<Integer> list;

    private Map<Integer, Integer> map;

    private Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        // 不重复插入
        if (map.containsKey(val)) {
            return false;
        }
        // 记录 val 和 索引的映射
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        // 没有就不删除
        if (!map.containsKey(val)) {
            return false;
        }

        // 修改map中数组最后一个元素的索引（因为等下要修改它）
        Integer index = map.get(val);
        Integer last = list.get(list.size() - 1);
        map.put(last, index);

        // 交换 val 和 最后一个元素
        list.set(list.size() - 1, val);
        list.set(index, last);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */