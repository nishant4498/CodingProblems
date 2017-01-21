package LevelFour;

import java.util.HashMap;
import java.util.Map;

/*
 * Both in leetcode and CTCI. 16.8
 * https://leetcode.com/problems/integer-to-english-words/
 * 
 * Basically all the english representations can be broadly categorized into "Billions", Millions and "Thousands"
 * 
 * 1234567811 -> "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Eleven"
 *    1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *      12345 -> "Twelve Thousand Three Hundred Forty Five"
 *        123       -> "One Hundred Twenty Three"
 *        
 * Thus if we closely observe we need to handle two parts,
 * 1) Decide whether its "Billions", Millions or "Thousands"
 * 2) For each part convert the hundreds normally.
 */
public class IntegerToEnglishWords {
	Map<Integer, String> map = new HashMap<>();
	
	public  String numberToWords(int num) {
		populateIntToEnglishMap();
		StringBuilder result = new StringBuilder();
		
		if(num == 0){
			return map.get(0);
		}
		
		if(num >= 1000000000){
			int extra = num / 1000000000;
			result.append(convert(extra) + " Billion ");
			num = num % 1000000000;
		}
		
		if(num >= 1000000){
			int extra = num / 1000000;
			result.append(convert(extra) + " Million ");
			num = num % 1000000;
		}
		
		if(num >= 1000){
			int extra = num / 1000;
			result.append(convert(extra) + " Thousand ");
			num = num % 1000;
		}
		
		if(num > 0){
			result.append(convert(num));
		}
		
		return result.toString().trim();
	}
	
	private String convert(int num){
		StringBuilder sb = new StringBuilder();
		if(num >= 100){
			String value = (map.get(num/100));
			sb.append(value + " Hundred ");
			num = num % 100;
		}
		
		if(num > 20){
			String value = map.get(num - num % 10);
			sb.append(value + " ");
			num = num % 10;
		}
		
		if(num > 0){
			sb.append(map.get(num));
		}
		
		return sb.toString().trim();
	}
	
	private void populateIntToEnglishMap(){
		map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");
        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");
	}
	
	public static void main(String[] args) {
		IntegerToEnglishWords test = new IntegerToEnglishWords();
		System.out.println(test.numberToWords(1234567811));
		System.out.println(test.numberToWords(123456781));
		System.out.println(test.numberToWords(123456));
		System.out.println(test.numberToWords(456));
	}
}
