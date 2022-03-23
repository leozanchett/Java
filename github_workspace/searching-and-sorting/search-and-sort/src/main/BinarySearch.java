package main;

class BinarySearch {
	static int count = 0;
	
	// RECURSIVO
	public static int binarySearch(int[] arr, int left, int right, int target) {
		count ++;
		if (left > right) {
			return - 1;
		}
		
		int midIndex = (left + right) / 2;
		if (target == arr[midIndex]) {
			return midIndex;
		}
		if (target < arr[midIndex]) {
			return binarySearch(arr, left, midIndex - 1, target);
		} else {
			return binarySearch(arr, midIndex + 1, right, target);
		}
		
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 6, 8, 9, 10 , 14, 34, 22};
		int target = 34;

		int left = 0;
		int right = arr.length - 1;

		int index = binarySearch(arr, left, right, target);
		if (index != -1) {
			System.out.println("Element found at index " + index);
		} else {
			System.out.println("Element not found in the array");
		}
		
		System.out.println("Chamou a função " + count + " vezes");
	}
}