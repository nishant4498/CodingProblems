package ArraysAndStrings;
/**
 * s1 = xy = waterbottle x = wat y = erbottle
 * s2 = yx = erbottlewat
 * 
 * regradles of where we break, xy will always be a substring of xyxy
 *
 */
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
