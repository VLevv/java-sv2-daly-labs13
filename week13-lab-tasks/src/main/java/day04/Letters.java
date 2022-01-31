package day04;

import java.util.HashMap;
import java.util.Map;

public class Letters {
    public Map<String,Integer> mapper(String string){
        Map<String,Integer> result = new HashMap<>();
        result.put("a",0);
        result.put("e",0);
        result.put("i",0);
        result.put("o",0);
        result.put("u",0);
        for(int i = 0;i<string.length();++i){
            if(result.containsKey(string.substring(i,i+1))){
                result.put(string.substring(i,i+1),result.get(string.substring(i,i+1))+1);
            }
        }
        return result;
    }
}
