class Solution {
    public int findDuplicate(int[] nums) {
        // Approach 1 using extra space(using map)
        /
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                return nums[i];
            }
            else{
                map.put(nums[i], 1);
            }
        }
        return -1;
    }


 public int findDuplicate(int[] nums) {

        // Approach 2 : using the linked list cycle detection concept by taking fast and slow pointers and returning the starting point of  cycle
        // TC : O(n), SC : O(1)
        int slow = nums[0];
        int fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast; 
    }
}