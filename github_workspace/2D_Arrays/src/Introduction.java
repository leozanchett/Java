
public class Introduction {
	public static void main(String[] args) {
		// Given the provided 2d array
		int[][] intMatrix = { { 4, 6, 8, 10, 12, 14, 16 }, 
							  { 18, 20, 22, 24, 26, 28, 30 },
							  { 32, 34, 36, 38, 40, 42, 44 }, 
							  { 46, 48, 50, 52, 54, 56, 58 }, 
							  { 60, 62, 64, 66, 68, 70, 79 } };
		int numSubArrays = intMatrix.length;
		System.out.println(numSubArrays);
		int subArrayLength = intMatrix[0].length;
		System.out.println(subArrayLength);
		// Quantidade de colunas
		int columns = intMatrix[0].length; 
		System.out.println(columns); // 7
		// Quantidade de linhas
		int rows = intMatrix.length;
		System.out.println(rows); // 5
		// Replace the outer and inner for loop headers to iterate through the entire 2D
		// array. Use the iterators `i` for the outer loop and `j` for the inner loop.
		int sum = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				sum += intMatrix[i][j];

			}
		}
		System.out.println(sum);
	}
}
