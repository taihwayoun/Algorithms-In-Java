import java.util.*;
import java.util.stream.Collectors;

public class Compete
{        
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days)
    {
        List<Integer> list = Arrays.stream(states).boxed().collect(Collectors.toList());
        List<Integer> ret = Arrays.asList(0,0,0,0,0,0,0,0);
        for (int d=1; d <= days; d++){
            if(list.get(1)==0) ret.set(0,0);
            else ret.set(0,1);
            for (int i=1; i<=states.length-2; i++){
                if (list.get(i-1)==list.get(i+1)) ret.set(i,0);
                else ret.set(i,1);
            }
            if (list.get(6)==0) ret.set(7,0);
            else ret.set(7,1);
            //ret.addAll(list); this one works OK as well
            list = new ArrayList<>(ret);
        }
        return ret;
    }
    

    
    public static void main(String[] args){
        int[] states = {1,1,1,0,1,1,1,1}; //{1,0,0,0,0,1,0,0}
        int d = 2;
        System.out.println(cellCompete(states, d));
        states = new int[]{1,0,0,0,0,1,0,0};
        d = 1;
        System.out.println(cellCompete(states, d));
        d=2;
        System.out.println(cellCompete(states, d));
    }
}