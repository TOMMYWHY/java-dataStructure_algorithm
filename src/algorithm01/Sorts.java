package algorithm01;

public class Sorts {

	public static void main(String[] args) {
		RandomArr ra = new RandomArr(100);
		int[] nums = ra.createArr();
		ra.printArr(nums);

		/*
		 * bubble sort
		 */
		// System.out.println("bubble sort=>");
		// for (int i = 0; i < nums.length; i++) {
		// for (int j = 0; j < nums.length - i - 1; j++) {
		// if (nums[j] > nums[j + 1]) {
		// int temp = nums[j];
		// nums[j] = nums[j + 1];
		// nums[j + 1] = temp;
		// }
		// }
		// }

		/* selection sort */
		System.out.println("selection sort=>");
		for (int i = 0; i < nums.length; i++) {
			int min = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[min]) {
					min = j;
				}
			}
			int temp = nums[i];
			 nums[i] = nums[min];
			 nums[min] = temp;
		}
		/*insertion sort*/
		
		
		/* quick sort */


		ra.printArr(nums);

	}

}
