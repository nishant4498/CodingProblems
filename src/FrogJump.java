// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int X, int D) {
        // write your code in Java SE 8
        int frogPosition=0;
        /*if(X <= D){
            return 0;
            }*/  
            
        int time = 0;
        if(X-frogPosition <= D){               
                return 0;
            }
            
        for(int i=0;i< A.length;i++){         
            
            //We will check if the next leaf
            if(A[i]- frogPosition < D && A[i] > frogPosition){
                frogPosition = A[i];
                time = i;
            }
            if(X-frogPosition <= D){
                return time;
                }
        }
        return time;
    }
    
    public static void main(String args[]){
    	
    }
}