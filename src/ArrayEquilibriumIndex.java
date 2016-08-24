
public class ArrayEquilibriumIndex {

	public int solution(int[] A) {
        // write your code in Java SE 8
       int length = A.length;
       if(length == 0)
    	   return -1;
       long sum =0;
       for(int i=0;i < A.length;i++){
    	   sum += A[i];
       }
       long sumLeft = 0;
       for(int i =0;i< length;i++){
    	   long sumRight = sum - sumLeft - A[i];
    	   if(sumLeft == sumRight)
    		   return i;
    	   sumLeft += A[i];    	  
       }
       
		return -1; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
