package ArraysAndStrings;

public class IsStringRotation {
	public boolean isRotation(String s1, String s2){
		int len = s1.length();
		
		if(len ==0) return false;
		
		if(s2.length() == len){
			String s1s1 = s1 + s1;
			return s1s1.contains(s2);
		}
		
		return false;
	}
}
