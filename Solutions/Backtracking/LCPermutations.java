import java.util.*;
// Question 46 on Leet Code Permutations.
// Backtracking
class LCPermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int[] used = new int[nums.length];
        List<Integer> track = new ArrayList<Integer>();
        helper(used, nums, 0, list, track);
        
        return list;
    }
    
    public void helper(int[] used, int[] nums, int pos, List<List<Integer>> list, List<Integer> track) {
        if (pos >= nums.length) {
            
            list.add(new ArrayList<>(track));
            return;
        }
        
        for (int i = 0 ; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            helper(used, nums, pos + 1, list, track);
            track.remove(track.size() -1);
            
        }
        
        return;
    }
}