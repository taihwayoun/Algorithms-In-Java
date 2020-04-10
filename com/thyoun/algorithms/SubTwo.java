import java.util.ArrayList;
//import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
//import java.util.Map;
import java.util.Set;

public class SubTwo {

    List<Character> removeDup(String str){
        List<Character> list=new ArrayList<>();
        for (int i=0; i<str.length(); i++){
            if (!list.contains(str.charAt(i)))
                list.add(str.charAt(i)); 
        }
        return list;
    }

    Set<String> getSubTwo(String str){
        Set<String> set = new HashSet<>();
        List<Character> list = removeDup(str);
        
        for (int i=0; i<list.size(); i++){
                for (int j =i+1; j<list.size(); j++){
                    if (i != j)
                        set.add (String.valueOf(list.get(i)) + String.valueOf(list.get(j)));
                }
        }
        return set;
    }

    public static void main(String[] args){
        System.out.println(new SubTwo().getSubTwo("abdd"));
    }
}