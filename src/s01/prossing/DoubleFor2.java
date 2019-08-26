package s01.prossing;

public class DoubleFor2 {

	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3 - i; j++) {
				System.out.print(' ');
			}
			for (int j = 0; j <= 2 * i; j++) {
				if (j == 0 || j == 2 * i) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}

			}

			System.out.println("");
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(' ');
			}
			for (int j = 0; j <= 4 - i * 2; j++) {
				if (j == 0 || j == 4 - 2 * i) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}
			}

			System.out.println("");
		}

	}

}
