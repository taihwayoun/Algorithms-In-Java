import java.util.*;
 
class GeneralizedGCD
{
    static int generalizedGCD(int[] arr)
    {
        int cz = caseZero(arr);
        if (cz>=0) return cz;
        
        int g = gcd(arr[0], arr[1]);
        
        for (int i=2; i < arr.length; i++){
            g = gcd(g,arr[i]);
            //System.out.println(g);
        }
        return g;
    }
    static int caseZero(int[] arr){
        for (int x : arr){
            if (x==0) return Arrays.stream(arr).max().getAsInt();
        }
        return -1;
    }
    static int gcd(int a, int b){
        int q=0,r=0;
        if (a==0) return b;
        if (b==0) return a;
        
        if (a >= b) {
            r=a%b;
            if (r==0) return b;
            else return gcd(b, r);
        }
        else {
            r=b%a;
            if (r==0) return a;
            else return gcd(a,r);            
        }
    }
    public static void main(String[] args){
        int num=4;
        int[] arr= { 3,6, 9, 18};
        System.out.println(generalizedGCD(arr ));
        System.out.println(gcd(1,6));
    }
    
}