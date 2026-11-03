import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "keen";
        String t = "knee";

        Map<Character, Integer> mp = new HashMap<>(); 

        if(s.length() != t.length()){
            System.out.println("Is not an Anagarm");
            return;
        }

        for (int i=0; i<s.length() ; i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0)+1);
        }
        
        for (int i=0; i<t.length() ; i++) {
            char ch = t.charAt(i);
            if(!mp.containsKey(ch)){
                System.out.println("is Not an Anagarm");
                return;
            }
            mp.put(ch, mp.get(ch)-1);
        }

        System.out.println("Map :"+ mp);
        for(char ch : mp.keySet()){
            if(mp.get(ch) != 0){
                System.out.println("is Not an Anagarm");
                return;
            }
        }
        System.out.println("is an Anagarm");   
    }
}
