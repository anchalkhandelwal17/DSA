class Solution {
    public void nextPermutation(int[] nums) {
       
        
        // step 1 : find nums[i] < nums[i+1]
        int idx = -1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        // if idx still -1 then simply reverse and array because we are actually given the last permutation as input

        if(idx == -1){
            reverse(nums, idx);
            return;
        }

        // step 2 : if idx != -1 , find first index > idx from reverse and swap it with idx
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] > nums[idx]){
                swap(nums, i, idx);
                break;
            }
        }

        // step 3 : reverse the array from (idx +1 till end), because we want just next permutation

        reverse(nums, idx+1); 
    }

    public void reverse(int[] arr, int start){
        if(start == -1) start = 0;
        int end = arr.length-1;

        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp; 
    }
}