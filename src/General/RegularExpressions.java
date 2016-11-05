package General;
/*
 * http://docs.oracle.com/javase/tutorial/essential/regex/quant.html
 * https://www.summet.com/dmsi/html/readingTheWeb.html
 * https://code.tutsplus.com/tutorials/8-regular-expressions-you-should-know--net-6149
 * http://www.regular-expressions.info/examples.html
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
	public static void main(String[] args) {
		digitPattern();
		characterPattern();
		wordBoundaries();
		phoneNumber();
		beginEnd();
		groups();
		groups1();
	}
	
	public static void digitPattern(){
		String pattern = "\\d"; // "[0-9]"
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher("ni12s3ha5n7t");
		
		while(m.find()){
			System.out.print(m.group() + "  ");
		}
		System.out.println();
	}
	
	public static void characterPattern(){
		String pattern = "[a-z]";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher("ni12s3haABCZ5n7t");
		
		while(m.find()){
			System.out.print(m.group() + "  ");
		}
		System.out.println();
	}
	
	public static void wordBoundaries(){
		/*
		 *\\b defines word boundaries.  \\bcat\\b will only find cat as a complete word.
		 *\\bcat\\B will be able to find cat where cat is a prefix(only considering first word boundry)
		 *\\Bcat\\B can find wherever cat is a substring(neither neginning nor ending)
		 *"(cat)" gives cat wherever it occurs.
		 */
		String pattern = "\\bcat\\b"; 
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher("cat is on the caty cat oncaty");
		
		while(m.find()){
			System.out.print(m.group() + " ");
			System.out.print(m.start()+ " ");
			System.out.print(m.end()+ " -- ");
		}
		System.out.println();
	}
	
	public static void phoneNumber(){
		/*
		 *[0-9]{3,3} - This tells that we can match any digit bw 0-3 min value is 3..max is also three.
		 *So  basically at most three. 
		 */
		String pattern = "[0-9]{3}-[0-9]{3}-[0-9]{4}";//"[0-9]{3,3}-[0-9]{3,3}-[0-9]{4,4}"; //"\\d+-\\d+-\\d+"
		Pattern p = Pattern.compile(pattern);
		String s1 = "My number is 123-456-7890 222-333-4444 2222-3332-44444 12345678";
		Matcher m = p.matcher(s1);
		
		while(m.find()){
			System.out.println("Phone Number " + m.group());
		}
	}
	
	public static void beginEnd(){
		/*
		 * ^dog& - matches only when dog is the only string.
		 * ^dog matches when the string starts with dog
		 * $dog matches when the string ends with the dog.
		 */
		String pattern = "^dog";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher("dog is in the house dog");
		
		while(m.find()){
			System.out.println(m.group());
		}
	}
	
	public static void groups(){
		/*
		 * "dog" matches dog word in the string.
		 * "[dog]" - Matches any of the chars d, o ,g
		 * "(dog)" - This groups the 'd', 'o', 'g' together. This returns complete words or substrings.
		 * "(dog){3}" - This  find were dog word appears three times.
		 *  dog{3} - This only gives where g appears three times.
		 */ 
		String pattern = "(dog){3}";
		Pattern p = Pattern.compile(pattern);
		//String s1 = "dog is in the house dog doggy hidoggy";
		String s2 = "dogdogdogdogdogdog";
		Matcher m = p.matcher(s2);
		
		while(m.find()){
			System.out.print(m.group() + " ");
		}
		System.out.println();
	}
	
	public static void groups1(){
		/*
		 * [abc]{3} - Basically this means any combination of a b or c ..occuring three times.	
		 */ 
		String pattern = "[abc]{3}";
		Pattern p = Pattern.compile(pattern);
		String s1 = "abccabaaaccbbbc";
		Matcher m = p.matcher(s1);
		
		while(m.find()){
			System.out.print(m.group() + " ");
		}
		System.out.println();
	}
}

/*
 *  1  2  3  5  7  
	cat 25 28 -- 
	Phone Number 123-456-7890
	Phone Number 222-333-4444
	dog
	dogdogdog dogdogdog 
	abc cab aaa ccb bbc 
 */
