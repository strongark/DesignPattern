package CodeFight;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/*
* Implement a integer least recently use cache
* */
public class LRUCache {
    LinkedHashMap<Integer, Integer> hm;
    LinkedList<Integer> list;
    int capacity;
    public LRUCache(int capacity){
        this.capacity = capacity;
        hm = new LinkedHashMap<>(capacity);
        list = new LinkedList<>();
    }

    public Integer get(Integer key){
        if(hm.containsKey(key)){
            Integer val = hm.get(key);
            list.remove(key); // update the most recent item
            list.add(key);
            return  val;
        }
        return -1;
    }

    public boolean set(Integer key, Integer val){
        if(hm.containsKey(key))
            return false;
        hm.put(key,val);
        if(list.size()==capacity){
            //remove the oldest member at the head of the list
            Integer oldestKey = list.removeFirst();
            hm.remove(oldestKey);
        }
        list.add(key);
        return true;
    }
}