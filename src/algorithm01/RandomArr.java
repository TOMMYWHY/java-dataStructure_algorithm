package algorithm01;

public class RandomArr {
	private int[] nums;
	private int N = 0;

	RandomArr() { 
	}

	RandomArr(int size) {
		this.N = size;
	}

	public int[] createArr() {
		nums = new int[N];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (int) (Math.random() * N);
		}
		return nums;
	}

	public void printArr(int[] arr) {
		System.out.println("arr : ");
		for (int item : arr) {
			System.out.print(item + "; ");
		}
		System.out.println();
	}
}
