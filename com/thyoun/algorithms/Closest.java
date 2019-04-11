/**
 * based on the frame from Cousera's course 'Alogrithms and Data Structures'
 * @author Taihwa Youn (taihwayoun@gmail.com)
 * 
 */
package com.thyoun.algorithms;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Closest {

    static class Point{
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public long getX() {
        	return x;
        }
        
        public long getY() {
        	return y;
        }

        @Override
        public String toString() {
        	return "[" + x +","+y+"]";
        }
    }

    static double getDistance (Point a, Point b) {
    	return Math.sqrt(Math.pow(a.getX()-b.getX(), 2)+Math.pow(a.getY()-b.getY(), 2));
    }
    
    static double getMidLine(Point[] ps) {
    	int mid = Math.floorDiv(ps.length, 2);
    	return (ps[mid].getX() - ps[mid-1].getX())/2; 
    }
    
    static double minimalDistance(int[] x, int y[]) {
        Point[] points=new Point[x.length];
        for (int i=0; i<x.length; i++) {
        	points[i]=new Point(x[i], y[i]);
        }
        Arrays.sort(points, (p1, p2)->Long.signum(p1.getX()- (p2.getX())));
        
        return minimalDistance(points);
        
    }

    static double minimalDistance(Point[] points) {

    	if (points.length<=3) return quadMinDis(points);
    	
    	int half = points.length/2;
        Point[] l = new Point[half];
        Point[] r = new Point[points.length - half];
        
        
        double delta = Math.min(minimalDistance(l), minimalDistance(r));
        
        System.out.println(Arrays.toString(points));
        //return 0;
        return closestSplit(l,r,delta);
    	
    }
    
    static double closestSplit(Point[] a, Point[] b, double dis) {
    	return 0;
    }

    static double quadMinDis(Point[] points) {
    	double min=0;
    	for (int i=0; i<points.length-1; i++) {
    		for (int j=1; i<points.length; j++) {
    			min = Math.min(min, getDistance(points[i],points[j]));
    		}
    	}
    	return min;
    }
    
    static int[] closest1D (int[] points1d) {
    	Arrays.sort(points1d);
    	int m=points1d[1]-points1d[0];
    	int ret[]=new int[2];
    	ret[0]=points1d[0];
    	ret[1]=points1d[1];
    	for (int i=1; i<points1d.length-1; i++) {
    		int tmp = points1d[i+1] - points1d[i];
    		if (tmp < m) {
    			m = tmp;
    			ret[0]=points1d[i]; ret[1]=points1d[i+1];
    		}
    		
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);

        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        //System.out.println(Arrays.toString(closest1D(x)));
        //System.out.println(Arrays.toString(closest1D(y)));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
