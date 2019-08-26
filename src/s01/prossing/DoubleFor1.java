package s01.prossing;

public class DoubleFor1 {

	public static void main(String[] args) {
		String[] str = { "A", "B", "C", "D" };
		for (int h = 0; h < 4; h++) {
			for (int l = 0; l <= 2 - h; l++) {
				System.out.print('*');
			}
			for (int l = 0; l <= 2 * h; l++) {
				System.out.print(str[h]);

			}
			System.out.println();
		}

		for (int h = 0; h < 3; h++) {
			for (int l = 0; l <= h; l++) {
				System.out.print('*');
			}
			for (int l = 0; l <= 4 - 2 * h; l++) {
				System.out.print(str[str.length - h - 2]);

			}
			System.out.println();
		}

	}

}
