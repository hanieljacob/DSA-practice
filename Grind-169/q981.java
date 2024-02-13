import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {
    class Pair{
        int timestamp;
        String value;
        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    Map<String, List<Pair>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair temp = new Pair(timestamp, value);
        List<Pair> arrayList = timeMap.getOrDefault(key, new ArrayList<>());
        arrayList.add(temp);
        timeMap.put(key, arrayList);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pair = timeMap.get(key);
        if(pair == null) return "";
        if(pair.size() == 0) return "";
        if(pair.size() == 1 && pair.get(0).timestamp > timestamp) return "";
        if(pair.size() == 1) return pair.get(0).value;
        int low = 0;
        int high = pair.size()-1;
        while(low<high){
            int mid = low + (high - low)/2;
            if(pair.get(mid).timestamp == timestamp){
                return pair.get(mid).value;
            }
            if(pair.get(mid).timestamp > timestamp){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        if(low == 0 && pair.get(low).timestamp > timestamp){
            return "";
        }
        if(pair.get(low).timestamp > timestamp){
            low--;
        }
        return pair.get(low).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */