package leetcodeanswer;

import java.util.LinkedHashMap;

public class _146LRU������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
	}

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class LRUCache  extends LinkedHashMap<Integer, Integer>{
	private int capacity;
    public LRUCache(int capacity) {
    	super(capacity, 0.75F, true);
        this.capacity = capacity;
    }


    /**
     * JDK8�������� getOrDefault �������û��key�����趨ֵ���˴��趨-1
     * default V getOrDefault(Object key, V defaultValue) {
        	V v;
        	return (((v = get(key)) != null) || containsKey(key))
        	? v
        	: defaultValue;
        }
     */    
    public int get(int key) {

    	return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
    	 super.put(key, value);
    }
}