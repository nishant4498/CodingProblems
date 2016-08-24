
public class ListToNum {

	public static void ListToNumber(){
		int[] a = {2,4,6};
		int num =0;
		
		int length = a.length;
		for(int i = length-1 ; i>=0;i--){
			num += a[i]*Math.pow(10, i);
		}
		System.out.println(num);
	}
	
	public static void NumToDigits(){
		int num = 987;
		while(num !=0){
			System.out.println(num % 10);
			num = num/10;
		}
	}
	
	public static void main(String[] args) {
		ListToNumber();
		NumToDigits();
	}

}
