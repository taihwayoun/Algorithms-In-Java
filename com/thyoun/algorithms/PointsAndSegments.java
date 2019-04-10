package com.thyoun.algorithms;

import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

	public class Pair implements Comparable<Pair>{
		private int seg;
		private int val;
		
		public Pair(int s, int v) {
			seg = s;
			val = v;
		}
		
		public int getSeg() {
			return seg;
		}
		public int getVal() {
			return val;
		}
		
		public int compareTo(Pair ex) {
			return seg <=ex.getSeg()? -1:1;
		}
	}
	
	private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
		int cnt[]=new int[points.length];
		Pair[] pairs = new Pair[starts.length*2 + points.length];
		int i=0;
		for (; i<pairs.length; i++) {
			if (i<starts.length)
				pairs[i]= new PointsAndSegments().new Pair(starts[i], 1);
			else if (i<starts.length*2)
				pairs[i]= new PointsAndSegments().new Pair(ends[i-starts.length], -1);
			else
				pairs[i]=new PointsAndSegments().new Pair(ends[i-starts.length-points.length], 0);
		}
		
		Arrays.sort(pairs);
		int val=0, j=0;
		for (i=0; i<pairs.length;i++)
			if (pairs[i].getVal()==0) {
				cnt[j]+= val;
				j++;
			}
			val += pairs[i].getVal();
		return cnt;
	}
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

