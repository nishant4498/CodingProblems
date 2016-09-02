
public class NimGame {

	public static void main(String[] args) {
		System.out.println(canWinNim(4));
		System.out.println(canWinNim(5));
	}

	public static boolean canWinNim(int n) {
		return (n % 4 != 0);
	}
}


//https://leetcode.com/articles/nim-game/
