package LevelSeven;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * Excel Sheet Title is basically reprsentation from A-Z.
 * So we can consider this as a system with base 26.
 * 
 * e.g if we have to convert 475 to decimal we can do it like:
 * 
 * result = 0;
 * 1) result = 0 * 10 + 4 = 4
 * 2) result = 4 * 10 + 7 = 47
 * 3) result = 47 * 10 + 5 = 475
 *
 *  Same approach we are following here with base 26. 
 */
public class ExcelSheetTitleToNumber {
	public int convertTitleToNumber(String s){
		int result = 0;
		
		for(int i = 0; i < s.length(); i++){
			result = result * 26 + (s.charAt(i) - 'A' + 1);// Adding one is important here
		}
		return result;
	}
}
