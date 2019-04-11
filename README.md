# Algorithms-In-Java
Various algorithms expressed in Java

<h4>(1) Points and Segments</h4>

One of the questions in Coursera's Algorithms and Data Structures

Commandline input:
* first line: two numbers representing the numbers of segments and points on a line, e.g. 3 4
* second to (n-1)th: line segments, e.g. -2 4
* (n-2)th line: e.g. 0 6
* (n-1)th line: e.g. 9 11
* nth line: a series of numbers representing points on a line, e.g. -3 -1 5 10

Output:
a series of numbers representing how many times each of the points overlap in the given segments.

So for instance, continuing with the example
3 4
-2 4
0 6
9 11
-3 -1 5 10

the output comes to:
0 1 1 1

Running time: 
If you include the time for sorting the list of the input numbers, it should be O(n*logn). Otherwise, it is linear.

<h4>(2) Closet points on a 2D plane</h4>

One is a revised version of Sedgewick and Wayne's implementation, and another is my own based on the frame from Coursera's Algorithms and Data Structures.

Input: number of coordinates followed by the coordinates
Output: the smallest distance from two points
