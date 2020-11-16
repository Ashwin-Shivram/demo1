package interview;

import java.util.Arrays;
import java.util.Scanner;

public class Prog1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {10,20,30};
		int temp = 0;
		int second_largest = 0;
		Arrays.sort(arr);
		second_largest=arr[arr.length-2];
		System.out.println(second_largest);
	}
}
