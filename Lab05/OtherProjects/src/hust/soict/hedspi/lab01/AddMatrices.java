package matrix;
import java.util.Scanner;
public class AddMatrices {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of matrix's rows: ");
		int rows = input.nextInt();
		System.out.println("Enter the number of matrix's columns: ");
		int columns = input.nextInt();
		int[][] matrix1 = new int[rows][columns];
		int[][] matrix2 = new int[rows][columns];
		int[][] sumMatrix = new int[rows][columns];
		System.out.println("Enter the elements of the first matrix: ");
		for(int i = 0;i < rows;i++) {
			for(int j = 0;j < columns;j++) {
				matrix1[i][j] = input.nextInt();
			}
		}
		System.out.println("Enter the elements of the second matrix: ");
		for(int i = 0;i < rows;i++) {
			for(int j = 0;j < columns;j++) {
				matrix2[i][j] = input.nextInt();
			}
		}
		for(int i = 0;i < rows;i++) {
			for(int j = 0;j < columns;j++) {
				sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		System.out.println("Sum of matrices: ");
		for(int i = 0;i < rows;i++) {
			for(int j = 0;j < columns;j++) {
				System.out.print(sumMatrix[i][j] + " ");
			}
			System.out.println();
		}
		input.close();
	}
}
