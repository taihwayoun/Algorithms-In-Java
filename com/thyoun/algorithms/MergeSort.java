package youn;

import java.util.*;

public class MergeSort {

	static List<Integer> mergeSort(int[] arr){
		List<Integer> list = new ArrayList<>();
		
		if (arr.length==0) return list;
		else if (arr.length==1) {
			list.add(Integer.valueOf(arr[0]));
			return list;
		}
		else{
			int pos = Math.floorDiv(arr.length, 2);
			int[] arrLeft = new int[pos];
			int[] arrRight= new int[arr.length-pos];
			int i;
			for (i=0; i<pos; i++){
				arrLeft[i]=arr[i];
			}
			for (i=0; i<arr.length-pos; i++){
				arrRight[i]=arr[i+pos];
			}
			return merge(mergeSort(arrLeft), mergeSort(arrRight));
		}
	}
	
	static List<Integer> merge(List<Integer> l, List<Integer> r){
		List<Integer> sorted = new ArrayList<>();
		while (l.size()>0 || r.size()>0){
			if (l.isEmpty() && !r.isEmpty()){
				sorted.add(r.get(0));
				r.remove(0);
			}
			else if (!l.isEmpty() && r.isEmpty()){
				sorted.add(l.get(0));
				l.remove(0);
			}
			else if (l.get(0)>r.get(0)){
				sorted.add(r.get(0));
				r.remove(0);
			}
			else if (l.get(0)<=r.get(0)){
				sorted.add(l.get(0));
				l.remove(0);
			} else{
				return sorted;
			}
		}
		return sorted;
	}
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for (int i=0; i<n; i++){
			a[i]=s.nextInt();
		}
		System.out.println(mergeSort(a).toString());

	}

}
