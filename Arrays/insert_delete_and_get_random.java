class RandomizedSet {

    // ArrayList + HashMap..
    List<Integer> arrayList;
    Map<Integer, Integer> map;
    Random rand = new Random();
    
    public RandomizedSet() {
        arrayList = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        // insert O(1) - map, array
        arrayList.add(arrayList.size(), val);
        map.put(val, arrayList.size());
        return true;
    }
    
    public boolean remove(int val) {
        // remove O(1)
        // move last element to removal element's position..
        // now delete the last position element..
        if (map.get(val) == null) { 
            return false; 
        }
        int lastVal = arrayList.get(arrayList.size()-1);
        arrayList.add(map.get(val), lastVal);
        arrayList.remove(arrayList.size()-1);
        return true;
    }
    
    public int getRandom() {
        // getRandom - all having same probability - queue - queue.remove() and then add from behind..
        return arrayList.get(rand.nextInt(arrayList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
