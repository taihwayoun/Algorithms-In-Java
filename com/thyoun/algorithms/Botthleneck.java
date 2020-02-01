//import java.util.Scanner;

public class Bottleneck {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    public static void makeRed(int pos, int[] line){
        for (int i; i < line.length; i++)
           { if (i==pos)
                System.out.println("("+ line[pos] + ")");
            else
                System.out.println(line[i]);
           }
    }

    public static void bottleneck(int n){
        //int i=0, k=n;
    }

    public static void main(String[] args){
        int[] line = new int[]{1,3,5,7,9};
        makeRed(4,line);
    }

}