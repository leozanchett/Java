import java.util.Arrays;

public class LoopPractice {
	public static void main(String[] args) {

		String[][] wordData = { { "study", "consider", "examine", "learn" },
				{ "ponder", "read", "think", "cogitate" } };

		int characterCount = 0;

		/*
		 * int y = 0; for (int x = 0; x < wordData.length; x++) { while (y <
		 * wordData[x].length){ characterCount += wordData[x][y].length(); y++; } y = 0;
		 * } System.out.println(characterCount);
		 */

		for (String[] str : wordData) {
			for (String palavra : str) {
				characterCount += palavra.length();
			}
		}
		System.out.println(characterCount);

		int x = 0, y = 0;

		while (x < wordData.length) {
			while (y < wordData[x].length) {
				System.out.println(wordData[x][y] + ": [" + x + "]" + "[" + y + "] ");
				y++;
			}
			y = 0;
			x++;
		}
	}
}
