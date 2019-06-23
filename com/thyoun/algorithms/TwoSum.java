import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class TwoSum{

    //Brute force method: O(n**2)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    //Optiomal: O(1)
    public static int[] twoSumFast(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        int complement;
        for (int i=0; i<nums.length; i++){
            complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[]{i,map.get(complement)};
            else
                map.put(nums[i],i);
        };

        throw new IllegalArgumentException("No two-sum solution");
    }

    public static void main(String[] args){

        int min=10000, max=100000;
        Random rnd = new Random();
        int arr_length = rnd.nextInt(max) + min;

        System.out.println(arr_length);

        int[] arr = new int[arr_length];
        for (int i=0; i<arr_length;i++)
            arr[i] = rnd.nextInt(max);

        int target = rnd.nextInt(200000);    

        //int target=9;
        //int[] arr= { 3,6, 8, 18,4};
        //twoSum(arr,target);
        
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(twoSum(arr, target )));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(twoSumFast(arr, target)));
        end = System.currentTimeMillis();
        System.out.println(end-start);
        
    }
}