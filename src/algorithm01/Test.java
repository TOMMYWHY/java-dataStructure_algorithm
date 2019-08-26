package algorithm01;

public class Test {
	public static void main (String[] args){
		RandomArr arr =  new RandomArr(100);
		int[] nums = arr.createArr();
		
		arr.printArr(nums);
	}
	
}
