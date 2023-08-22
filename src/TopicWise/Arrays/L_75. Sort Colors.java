class Solution {
    public void sortColors(int[] nums) {
        

// Approach 1 : we can use any of the sorting algorithm(bubble sort, selection sort, insertion sort etc) to sort the array.

        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length-i-1; j++){
                if(nums[j] >= nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }


    }

// Approach 2 : take a count of 0, 1 and 2 using variables and put them in the array
// Approach 3 : Dutch national flag algorithm can be used, in which three pointers are used

 public void sortColors(int[] nums) {
        // TC : O(n), SC : O(1)        
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

}