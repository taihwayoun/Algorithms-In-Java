//package com.thyoun.algorithms;

public class RoundWord{

    public static String rotate(String input){
        char[] arr = input.toCharArray();
        char[] out = new char[arr.length];
        
        for (int i=arr.length-1, j=0; i >= 0; i--, j++){
            out[j] = arr[i];
        }
        
        return new String(out);
    }
    
    public static int isRoundWord(String x, String y){
        String rev = rotate(x);
        return y.equals(rev) && x.length()%2!=0? 1: -1;
    }

    public static void main(String args[]){
        String a = "abc";
        String b = "defg";
        String c= rotate(a);
        System.out.println(c);
        System.out.println(isRoundWord(a, "cba"));
        System.out.println(isRoundWord(b, "gfed"));

    }
}