package homework;

public class TargetNum {
	public int[] findPair(int[] nums, int target)
	{
		for(int i = 0; i < nums.length; i++)
		{
			int currentOne = nums[i];
			int lowerBound = i + 1;
			int upperBound = nums.length - 1;
			while(lowerBound <= upperBound)
			{
				int mid = (upperBound + lowerBound) / 2;
				if(currentOne + nums[mid] == target)
				{
					int[] indices = {i, mid};
					return indices;
				}
				else if(currentOne + nums[mid] < target)
				{
					lowerBound = mid + 1;
				}
				else
				{
					upperBound = mid - 1;
				}
			}
		}
		
		return null;
	}
	
	public static void main(String[] args)
	{
		TargetNum tn = new TargetNum();
		int[] nums = {1, 2, 5, 10, 13, 20, 37};
		System.out.println("Start");
		int[] solution = tn.findPair(nums, 22);
		System.out.println("Start");
		System.out.println(solution[0] + " " + solution[1]);
	}
}
