package ArraysAndStrings;

public class ZeroMatrix {
	/*
	 * Here we first store the rows and cols which have the the zero in the original matrix.
	 * We just need one flag for each row or col, since all of that row will be set to zero
	 * no matter where the zero is found in that row or col.
	 * 
	 * Check the in place solution in leetcode LevelFour.
	 */
	public void setZeroes(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];
		
		//matrix.length gives the number of rows.
		//matrix[0].length gives the number of cols.
		
		for(int i = 0; i < matrix.length; i++ ){
			for(int j=0; j< matrix[0].length;j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for(int i=0; i< row.length;i++){
			if(row[i]) nullifyRow(matrix , i);
		}
		
		for(int j=0; j< row.length;j++){
			if(col[j]) nullifyCol(matrix , j);
		}
	}
	
	public void nullifyRow(int[][] matrix, int row){
		for(int i  =0; i< matrix[0].length;i++ ){
			matrix[row][i] = 0;
		}
	}
	
	public void nullifyCol(int[][] matrix, int col){
		for(int j  =0; j< matrix.length;j++ ){
			matrix[j][col] = 0;
		}
	}
}
