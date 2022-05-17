Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
  
  
My solution (brute force O(n^2)): 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2]; 
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
                
            }
        }
        return answer;
    }
}

Faster Solution (HashMap O(n)): 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> twoSumSol = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            int secNum = target - nums[i];
            if(twoSumSol.containsKey(secNum)){
                int[] ans = {i, twoSumSol.get(secNum)};
                return ans;
            }
            twoSumSol.put(nums[i], i);        
        }
        return null;
    }
}
