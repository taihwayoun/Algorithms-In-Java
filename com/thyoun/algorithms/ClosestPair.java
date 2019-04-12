package com.thyoun.algorithms;

/******************************************************************************
 *  Compilation:  javac ClosestPair.java
 *  Execution:    java ClosestPair < input.txt
 *  Dependencies: Point2D.java
 *  Data files:   https://algs4.cs.princeton.edu/99hull/rs1423.txt
 *                https://algs4.cs.princeton.edu/99hull/kw1260.txt
 *  
 *  Given n points in the plane, find the closest pair in n log n time.
 *
 *  Note: could speed it up by comparing square of Euclidean distances
 *  instead of Euclidean distances.
 *  Original Copyright © 2000–2017, Robert Sedgewick and Kevin Wayne. 
 *  Last updated: Fri Oct 20 12:50:46 EDT 2017.
 *  Current version made by Taihwa Youn(taihwayoun@gmail.com) on 04/10/2019
 ******************************************************************************/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

/**
 *  The {@code ClosestPair} data type computes a closest pair of points
 *  in a set of <em>n</em> points in the plane and provides accessor methods 
 *  for getting the closest pair of points and the distance between them.
 *  The distance between two points is their Euclidean distance.
 *  <p>
 *  This implementation uses a divide-and-conquer algorithm. 
 *  It runs in O(<em>n</em> log <em>n</em>) time in the worst case and uses
 *  O(<em>n</em>) extra space.
 *  <p>
 *  See also {@link FarthestPair}.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/99hull">Section 9.9</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *  revised by Taihwa Youn (taihwayoun@gmail.com) on 04/10/2019
 */
public class ClosestPair {

    // closest pair of points and their Euclidean distance
    private Point2D best1, best2;
    private double bestDistance = Double.POSITIVE_INFINITY;
    
    public ClosestPair() {};

    /**
     * Computes the closest pair of points in the specified array of points.
     *
     * @param  points the array of points
     * @throws IllegalArgumentException if {@code points} is {@code null} or if any
     *         entry in {@code points[]} is {@code null}
     */
    public ClosestPair(Point2D[] points) {
        if (points == null) throw new IllegalArgumentException("constructor argument is null");
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException("array element " + i + " is null");
        }

        int n = points.length;
        if (n <= 1) return;

        // sort by x-coordinate (breaking ties by y-coordinate)
       
        Arrays.sort(points, (p1, p2)->(int)Math.signum(p1.getX()- (p2.getX())));

        // check for coincident points
        for (int i = 0; i < n-1; i++) {
            if (points[i].equals(points[i+1])) {
                bestDistance = 0.0;
                best1 = points[i];
                best2 = points[i+1];
                return;
            }
        }

        closest(points, 0, n-1);
    }

    // find closest pair of points in points[lo..hi]
    // postcondition: pointsByY[lo..hi] sorted by y-coordinate
    private double closest(Point2D[] pointsByY, int lo, int hi) {
        if (hi <= lo) return Double.POSITIVE_INFINITY;

        int mid = lo + (hi - lo) / 2;
        Point2D median = pointsByY[mid];

        // compute closest pair with both endpoints in left subarray or both in right subarray
        double delta = Math.min(closest(pointsByY, lo, mid), closest(pointsByY, mid+1, hi));

        Arrays.sort(pointsByY, (p1, p2)->(int)Math.signum(p1.getY()- (p2.getY())));
        
        // aux = sequence of points closer than delta, sorted by y-coordinate
        List<Point2D> aux = new ArrayList<>();
        
        for (int i = lo; i <= hi; i++) {
            if (Math.abs(pointsByY[i].getX() - median.getX()) < delta)
                aux.add(pointsByY[i]);
        }

        // compare each point to its neighbors with y-coordinate closer than delta
        int m=aux.size();
        for (int i = 0; i < m; i++) {
            // a geometric packing argument shows that this loop iterates at most 7 times
            for (int j = i+1; (j < m) && (aux.get(j).getY() - aux.get(i).getY() < delta); j++) {
                double distance = aux.get(i).distanceTo(aux.get(j));
                if (distance < delta) {
                    delta = distance;
                    if (distance < bestDistance) {
                        bestDistance = delta;
                        best1 = aux.get(i);
                        best2 = aux.get(j);
                    }
                }
            }
        }
        return delta;
    }

    /**
     * Returns one of the points in the closest pair of points.
     *
     * @return one of the two points in the closest pair of points;
     *         {@code null} if no such point (because there are fewer than 2 points)
     */
    public Point2D either() {
        return best1;
    }

    /**
     * Returns the other point in the closest pair of points.
     *
     * @return the other point in the closest pair of points
     *         {@code null} if no such point (because there are fewer than 2 points)
     */
    public Point2D other() {
        return best2;
    }

    /**
     * Returns the Eucliden distance between the closest pair of points.
     *
     * @return the Euclidean distance between the closest pair of points
     *         {@code Double.POSITIVE_INFINITY} if no such pair of points
     *         exist (because there are fewer than 2 points)
     */
    public double distance() {
        return bestDistance;
    }

   /**
     * Unit tests the {@code ClosestPair} data type.
     * Reads in an integer {@code n} and {@code n} points (specified by
     * their <em>x</em>- and <em>y</em>-coordinates) from standard input;
     * computes a closest pair of points; and prints the pair to standard
     * output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points[i] = new ClosestPair().new Point2D(x, y);
        }
        ClosestPair closest = new ClosestPair(points);
        System.out.println(closest.distance() + " from " + closest.either() + " to " + closest.other());
    }
    
    public class Point2D {
        double x, y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
        	return x;
        }
        
        public double getY() {
        	return y;
        }

        public double distanceTo (Point2D b) {
        	return Math.sqrt(Math.pow(x-b.getX(), 2)+Math.pow(y-b.getY(), 2));
        }
        
        @Override
        public String toString() {
        	return "[" + x +","+y+"]";
        }
    }

}

