package triangle;
import java.util.Scanner;
public class TriangleFormStars {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What's the height of triangle ?");
		int n = input.nextInt();
		for(int i = 1;i <= n;i++) {
			int stars = 2 * i - 1;
			int space = n - i;
			for(int j = 0;j < space;j++) {
				System.out.print(" ");
			}
			for(int k = 0;k < stars;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		input.close();
	}
}
