package main;

class BinarySearch {
	static int count = 0;

	// RECURSIVO
	public static int binarySearch(int[] arr, int left, int right, int target) {
		count++;
		if (left > right) {
			return -1;
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

	// ITERATIVO
	public static int binarySearch(int[] arr, int target) {
		int midIndex = 0, left = 0, right = arr.length;
		while (left <= right) {
			count++;
			midIndex = (left + right) / 2;
			if (target == arr[midIndex]) {
				return midIndex;
			}
			if (target < arr[midIndex]) {
				right = midIndex - 1;
			} else {
				left = midIndex + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 6, 8, 9, 10, 14, 22, 34 };
		int target = 23;

		int left = 0;
		int right = arr.length - 1;

		// int index = binarySearch(arr, left, right, target);
		int index = binarySearch(arr, target);
		if (index != -1) {
			System.out.println("Element found at index " + index);
		} else {
			System.out.println("Element not found in the array");
		}

		System.out.println("Chamou a função " + count + " vezes");
	}
}