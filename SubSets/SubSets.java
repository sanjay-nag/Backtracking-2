package SubSets;

import java.util.*;

//Time Complexity - 2^n		n=nums.length; number of elements in nums array
//Space Complexity - 2^n	as there are 2^n number of times the memory stack is pushed to

class SubSets {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	public List<List<Integer>> subsets(int[] nums) {
		helper(nums, new ArrayList<Integer>(), 0);
		return result;
	}
	private void helper(int[] nums, List<Integer> temp, int start) {
		//Add new created temp array to the result
		result.add(new ArrayList<>(temp));

		for(int i=start; i<nums.length; i++) {
			//Add each element to the temp array
			temp.add(nums[i]);
			//Recirsive call 
			helper(nums, temp, i+1);
			//Backtrack to the previous call and remove an  
			//element and iterate through other element, if any
			temp.remove(temp.size() - 1);
		}
	}
}

//Output - [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]