package array;
import java.util.Scanner;
import java.util.Arrays;
public class SortNumbericArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the element's number of array: ");
		int size = input.nextInt();
		int[] array = new int[size];
		System.out.println("Enter elements of array: ");
		for(int i = 0;i < size;i++) {
			System.out.println("Element " + (i + 1) + ": ");
			array[i] = input.nextInt();
		}
		bubbleSort(array);
		int sum = 0;
		for(int num : array) {
			sum += num;
		}
		double average = (double) sum / size;
		System.out.println("\nSorted Array: " + Arrays.toString(array));
		System.out.println("Sum of Elements: " + sum);
		System.out.println("Average Value of Array: " + average);
		input.close();
	}
	public static void bubbleSort(int[] array) {
		int n = array.length;
		boolean swapped;
		for(int i = 0;i < n - 1;i++) {
			swapped = false;
			for(int j = 0;j < n - 1 - i;j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
}
