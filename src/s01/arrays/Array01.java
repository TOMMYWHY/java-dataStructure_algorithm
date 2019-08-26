package s01.arrays;

public class Array01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**/
		int[] arr1 = new int[3];
		int[] nums = {2,3,31,52};
 		
//		System.out.print(arr1);
//		int[] nums = new int[20];
		
		int temp  = nums[0];
		for(int i = 0; i< nums.length; i++){
			
			if(nums[i] > temp){
				temp = nums[i];
			}
			
		}
		System.out.print(temp);
		System.out.println();
		for(int i : nums){
			System.out.print(i+";");
		}
	}
	

}
