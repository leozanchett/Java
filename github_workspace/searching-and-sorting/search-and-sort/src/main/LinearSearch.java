package main;

public class LinearSearch {
	public static int linearSearch(int[] arr, int target) {
		for (int x: arr) {
			if(x == target) {
				return target;
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int target = 10;
		System.out.println(linearSearch(arr, target));
	}
}
