package LevelSeven;
/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * Basically here we need to extract every number from end and substitute it with A-Z. 
 * Again this is a Decimal to Base 26 conversion.
 * 
 * The key here is decrementing by 1 before finding the next character.
 */
public class ExcelSheetNumberToTitle {
	public String convertNumberToTitle(int n){
		StringBuilder sb = new StringBuilder();
		
		while(n > 0){
			n--;
			char ch = (char)(n % 26 + 'A');
			sb.append(ch); //sb.insert(0, ch) to avoid reversing.
			n = n / 26;
		}
		return sb.reverse().toString();//We can also insert in the beginning to avoid reversing here.
	}
}
